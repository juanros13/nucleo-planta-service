package gob.nucleo.plantaservice.services;

import gob.nucleo.plantaservice.dao.*;
import gob.nucleo.viverocommons.entity.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CatPlantaParcelaService implements ICatPlantaParcelaService{

    private final Logger log = LoggerFactory.getLogger(CatPlantaParcelaService.class);

    @Autowired
    ICatObjetivoDao catObjetivoDao;

    @Autowired
    ICatFuenteAbastesimientoDao catFuenteAbastesimientoDao;

    @Autowired
    IViveroPlantaDao viveroPlantaDao;

    @Autowired
    ICatEspecieCategoriaDao catEspecieCategoriaDao;

    @Autowired
    ICatEspecieSubcategoriaDao catEspecieSubcategoriaDao;

    @Autowired
    ICatEspecieDao catEspecieDao;

    @Autowired
    ICatMermaDao catMermaDao;

    @Autowired
    ITerritorioDao territorioDao;

    @Override
    public List<CatObjetivo> findCatalogoObjetivo() {
        return catObjetivoDao.findAll();
    }

    @Override
    public List<CatFuenteAbastecimiento> findCatalogoFuenteAbastecimiento() {
        return catFuenteAbastesimientoDao.findAll();
    }

    @Override
    public List<ViveroPlanta> findViverosByEspecieAndOrigenSubcategoria(Long especie, Long origen, Long subCategoria, Long territorio) {
        CatEspecieCategoria  catEspecieCategoria = new CatEspecieCategoria();
        catEspecieCategoria.setId(especie);
        List<ViveroPlanta> plantaList = new ArrayList<>();
        CatEspecieSubcategoria catEspecieSubcategoria = catEspecieSubcategoriaDao.findAllByCatEspecieCategoriaAndId(catEspecieCategoria, subCategoria);
         catEspecieDao.findByCatEspecieSubcategoria(catEspecieSubcategoria).stream().map(catalogoEspecie -> {
            ViveroPlanta viveroPlanta = new ViveroPlanta();
            Territorio terri= territorioDao.findById(territorio).get();
            List <ViveroPlanta> lista = viveroPlantaDao.findByEspecieAndFuenteAbastecimientoAndTerritorio(catalogoEspecie,
                    catFuenteAbastesimientoDao.findById(origen).get(), terri);
             for (ViveroPlanta planta: lista) {
                 plantaList.add(planta);
             }
            return viveroPlanta;
        }).collect(Collectors.toList());
        return plantaList;
    }

    @Override
    public List<CatEspecie> findEspecieSubcategoria(Long especie) {
        CatEspecieSubcategoria catEspecieSubcategoria = new CatEspecieSubcategoria();
        catEspecieSubcategoria.setId(especie);
        return catEspecieDao.findByCatEspecieSubcategoria(catEspecieSubcategoria);
    }

    @Override
    public List<CatMerma> findCatalogoMerma() {
        return catMermaDao.findAll();
    }

    @Override
    public List<ViveroPlanta> findViverosByOrigenEspecieTerritorio(Long origen, Long especie, Long territorio) {
        List<ViveroPlanta> plantaList = new ArrayList<>();
        CatEspecie catEspecie = catEspecieDao.getOne(especie);
            ViveroPlanta viveroPlanta = new ViveroPlanta();
            Territorio terri= territorioDao.findById(territorio).get();
            List <ViveroPlanta> lista = viveroPlantaDao.findByEspecieAndFuenteAbastecimientoAndTerritorio(catEspecie,
                    catFuenteAbastesimientoDao.findById(origen).get(), terri);
            for (ViveroPlanta planta: lista) {
                plantaList.add(planta);
            }
        return plantaList;
    }


}
