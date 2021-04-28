package gob.nucleo.plantaservice.services;

import gob.nucleo.plantaservice.dao.IPlantaParcelaDao;
import gob.nucleo.viverocommons.entity.PlantaParcela;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MermaService implements IMermaService{

    private final Logger log = LoggerFactory.getLogger(MermaService.class);

    @Autowired
    IPlantaParcelaDao plantaParcelaDao;

    @Override
    public List<PlantaParcela> findMermaByPlantaParcela(Long idPlantaParcela){
        List<PlantaParcela> listaParcela = new ArrayList<>();
        listaParcela.add(plantaParcelaDao.findById(idPlantaParcela).get());
        return listaParcela;
    }

    @Override
    public  PlantaParcela guardaMerma (PlantaParcela merma) {
        return plantaParcelaDao.save(merma);
    }

    @Override
    public PlantaParcela actualizaMerma (PlantaParcela merma) {
        return plantaParcelaDao.save(merma);
    }
}
