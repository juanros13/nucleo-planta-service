package gob.nucleo.plantaservice.services;

import gob.nucleo.plantaservice.dao.*;
import gob.nucleo.viverocommons.entity.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<CatObjetivo> findCatalogoObjetivo() {
        return catObjetivoDao.findAll();
    }

    @Override
    public List<CatFuenteAbastecimiento> findCatalogoFuenteAbastecimiento() {
        return catFuenteAbastesimientoDao.findAll();
    }

    @Override
    public List<ViveroPlanta> findViverosByEspecieAndOrigenSubcategoria(Long especie, Long origen, Long subCategoria) {
        CatEspecieCategoria  catEspecieCategoria = new CatEspecieCategoria();
        catEspecieCategoria.setId(especie);
        CatEspecieSubcategoria catEspecieSubcategoria = catEspecieSubcategoriaDao.findAllByCatEspecieCategoriaAndId(catEspecieCategoria, subCategoria);
        return catEspecieDao.findByCatEspecieSubcategoria(catEspecieSubcategoria).stream().map(catalogoEspecie -> {
          ViveroPlanta vivero = viveroPlantaDao.findByEspecieAndFuenteAbastecimiento(catalogoEspecie, catFuenteAbastesimientoDao.findById(origen).get());
            return vivero;
        }).collect(Collectors.toList());
    }

    @Override
    public List<CatEspecie> findEspecieSubcategoria(Long especie) {
        CatEspecieSubcategoria catEspecieSubcategoria = new CatEspecieSubcategoria();
        catEspecieSubcategoria.setId(especie);
        return catEspecieDao.findByCatEspecieSubcategoria(catEspecieSubcategoria);
    }


}
