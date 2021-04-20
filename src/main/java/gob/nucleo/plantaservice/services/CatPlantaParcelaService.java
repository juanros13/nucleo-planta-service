package gob.nucleo.plantaservice.services;

import gob.nucleo.plantaservice.dao.ICatFuenteAbastesimientoDao;
import gob.nucleo.plantaservice.dao.ICatObjetivoDao;
import gob.nucleo.plantaservice.dao.IViveroPlantaDao;
import gob.nucleo.viverocommons.entity.CatEspecie;
import gob.nucleo.viverocommons.entity.CatFuenteAbastecimiento;
import gob.nucleo.viverocommons.entity.CatObjetivo;

import gob.nucleo.viverocommons.entity.ViveroPlanta;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatPlantaParcelaService implements ICatPlantaParcelaService{

    private final Logger log = LoggerFactory.getLogger(CatPlantaParcelaService.class);

    @Autowired
    ICatObjetivoDao catObjetivoDao;

    @Autowired
    ICatFuenteAbastesimientoDao catFuenteAbastesimientoDao;

    @Autowired
    IViveroPlantaDao viveroPlantaDao;


    @Override
    public List<CatObjetivo> findCatalogoObjetivo() {
        return catObjetivoDao.findAll();
    }

    @Override
    public List<CatFuenteAbastecimiento> findCatalogoFuenteAbastecimiento() {
        return catFuenteAbastesimientoDao.findAll();
    }

    @Override
    public List<ViveroPlanta> findViverosByEspecieAndOrigen(Long especie, Long origen) {
        CatEspecie catEspecie = new CatEspecie();
        catEspecie.setId(especie);
        CatFuenteAbastecimiento fuente = new CatFuenteAbastecimiento();
        fuente.setId(origen);


        return viveroPlantaDao.findByEspecieAndFuenteAbastecimiento(catEspecie, fuente ) ;
    }
}
