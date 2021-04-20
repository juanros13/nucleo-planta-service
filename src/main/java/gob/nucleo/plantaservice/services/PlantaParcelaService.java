package gob.nucleo.plantaservice.services;

import gob.nucleo.plantaservice.dao.IPlantaParcelaDao;
import gob.nucleo.viverocommons.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class PlantaParcelaService implements IPlantaParcelaService{

    private final Logger log = LoggerFactory.getLogger(PlantaParcelaService.class);

    @Autowired
    IPlantaParcelaDao plantaParcelaDao;

    @Override
    public List<PlantaParcela> findByDisenoAgroforestal(Long idDisenoAgroforestal) {
        DisenoAgroforestal diseno = new DisenoAgroforestal();
        diseno.setId(idDisenoAgroforestal);
        return plantaParcelaDao.findByDisenoAgroforestal(diseno);
    }

    @Override
    public PlantaParcela guardaPlantaParcela(PlantaParcela plantaParcela) {
        return plantaParcelaDao.save(plantaParcela);
    }

    @Override
    public PlantaParcela actualizaPlantaParcela(PlantaParcela plantaParcela) {
        return plantaParcelaDao.save(plantaParcela);
    }
}
