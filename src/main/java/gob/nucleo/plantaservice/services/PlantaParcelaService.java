package gob.nucleo.plantaservice.services;

import gob.nucleo.beneficiariocommons.entity.Predio;
import gob.nucleo.plantaservice.dao.*;
import gob.nucleo.viverocommons.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlantaParcelaService implements IPlantaParcelaService{

    private final Logger log = LoggerFactory.getLogger(PlantaParcelaService.class);

    @Autowired
    IPlantaParcelaDao plantaParcelaDao;

    @Autowired
    IPredioDao predioDao;

    @Autowired
    IDisenoAgroforestalDao disenoAgroforestalDao;

    @Autowired
    IViveroDao viveroDao;

    @Autowired
    ICatEspecieDao catEspecieDao;

    @Autowired
    ICatEspecieCategoriaDao catEspecieCategoriaDao;

    @Override
    public List<PlantaParcela> findByDisenoAgroforestal(Long idDisenoAgroforestal) {
        DisenoAgroforestal diseno = new DisenoAgroforestal();
        diseno.setId(idDisenoAgroforestal);
        return plantaParcelaDao.findByDisenoAgroforestal(diseno);
    }

    @Override
    public PlantaParcela guardaPlantaParcela(PlantaParcela plantaParcela) {
        CatEspecie catEspecie = catEspecieDao.findById(plantaParcela.getCatEspecie().getId()).get();

        DisenoAgroforestal disenoAgroforestal = disenoAgroforestalDao.findById(plantaParcela.getDisenoAgroforestal().getId()).get();

       if (disenoAgroforestal.getCatEspecieSubcategoria().getId().equals(catEspecie.getCatEspecieSubcategoria().getId())){
           return plantaParcelaDao.save(plantaParcela);
       }else{
           return null;
       }
    }

    @Override
    public PlantaParcela actualizaPlantaParcela(PlantaParcela plantaParcela) {
        return plantaParcelaDao.save(plantaParcela);
    }

    @Override
    public List<DisenoAgroforestal> actualizaAvancePlanta(Long idBeneficiario) {
        List <Predio> predios = predioDao.findByIdRegistro(idBeneficiario);
        List <DisenoAgroforestal> diseniosAll = new ArrayList<>();
        List <Long> idsPredios= new ArrayList<>();

        if(!predios.isEmpty()){
            predios.stream().map( predio -> {
                idsPredios.add(predio.getId());
                return predio;
            }).collect(Collectors.toList());
        }
        if(!idsPredios.isEmpty()) {
            List<DisenoAgroforestal> disenios = disenoAgroforestalDao.findByIdPredioIn(idsPredios);
            if(!disenios.isEmpty()) {

                disenios.forEach(disenio -> {
                    List<PlantaParcela> plantas = plantaParcelaDao.findByDisenoAgroforestal(disenio);
                    int[] totalAvance = { 0 };
                    if(!plantas.isEmpty()) {
                        plantas.stream().map(planta -> {
                            if(planta.getCantidadSobrevive() != null){
                                totalAvance[0] += planta.getCantidadSobrevive().intValue();
                            }

                            return planta;
                        }).collect(Collectors.toList());
                        disenio.setCantidadAvance(Long.valueOf(totalAvance[0]));
                        if(totalAvance[0]== 0){
                            disenio.setHa(0D);
                        }else{
                            if(disenio.getDensidad()==0){
                                disenio.setHa(0D);
                            }else{
                                disenio.setHa(Double.valueOf((totalAvance[0]*disenio.getDensidad())) / 10000D);
                            }
                        }
                        disenoAgroforestalDao.save(disenio);
                    }else{
                        disenio.setCantidadAvance(0L);
                        disenoAgroforestalDao.save(disenio);
                    }
                    diseniosAll.add(disenio);
                });
            }
        }
        return diseniosAll;
    }


    @Transactional
    public void deletePlantaParcela(Long id) {
        plantaParcelaDao.deleteById(id);
    }

    @Transactional
    public void deleteDisenoAgroforestal(Long id) {
        disenoAgroforestalDao.deleteById(id);
    }
}
