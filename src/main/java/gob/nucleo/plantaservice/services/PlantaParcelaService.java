package gob.nucleo.plantaservice.services;

import gob.nucleo.plantaservice.dao.IPlantaParcelaDao;
import gob.nucleo.viverocommons.entity.DisenoAgroforestal;
import gob.nucleo.viverocommons.entity.PlantaParcela;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlantaParcelaService implements IPlantaParcelaService{

    private final Logger log = LoggerFactory.getLogger(PlantaParcelaService.class);

    @Autowired
    IPlantaParcelaDao plantaParcelaDao;

    @Override
    public PlantaParcela findByDisenoAgroforestal(Long idDisenoAgroforestal) {
        DisenoAgroforestal diseno = new DisenoAgroforestal();
        diseno.setId(idDisenoAgroforestal);
        return plantaParcelaDao.findByDisenoAgroforestal(diseno);
    }
}
