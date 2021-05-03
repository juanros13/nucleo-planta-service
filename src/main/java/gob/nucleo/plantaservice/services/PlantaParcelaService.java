package gob.nucleo.plantaservice.services;

import gob.nucleo.plantaservice.dao.IDisenoAgroforestalDao;
import gob.nucleo.plantaservice.dao.IPlantaParcelaDao;
import gob.nucleo.plantaservice.dao.IViveroDao;
import gob.nucleo.plantaservice.dao.IViveroPlantaDao;
import gob.nucleo.viverocommons.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class PlantaParcelaService implements IPlantaParcelaService{

    private final Logger log = LoggerFactory.getLogger(PlantaParcelaService.class);

    @Autowired
    IPlantaParcelaDao plantaParcelaDao;

    @Autowired
    IDisenoAgroforestalDao disenoAgroforestalDao;

    @Autowired
    IViveroDao viveroDao;

    @Override
    public List<PlantaParcela> findByDisenoAgroforestal(Long idDisenoAgroforestal) {
        DisenoAgroforestal diseno = new DisenoAgroforestal();
        diseno.setId(idDisenoAgroforestal);
        return plantaParcelaDao.findByDisenoAgroforestal(diseno);
    }

    @Override
    public PlantaParcela guardaPlantaParcela(PlantaParcela plantaParcela) {
      //  Vivero viv = viveroDao.findById(plantaParcela.getVivero().getId()).get();
       // plantaParcela.setVivero(viv);
        return plantaParcelaDao.save(plantaParcela);
    }

    @Override
    public PlantaParcela actualizaPlantaParcela(PlantaParcela plantaParcela) {
        return plantaParcelaDao.save(plantaParcela);
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
