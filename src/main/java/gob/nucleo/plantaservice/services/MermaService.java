package gob.nucleo.plantaservice.services;

import gob.nucleo.plantaservice.dao.IMermaDao;
import gob.nucleo.viverocommons.entity.Merma;
import gob.nucleo.viverocommons.entity.PlantaParcela;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MermaService implements IMermaService{

    private final Logger log = LoggerFactory.getLogger(MermaService.class);

    @Autowired
    IMermaDao mermaDao;

    @Override
    public List<Merma> findMermaByPlantaParcela(Long idPlantaParcela) {
        PlantaParcela parcela = new PlantaParcela();
        parcela.setId(idPlantaParcela);
        return mermaDao.findAllByPlantaParcela(parcela);
    }

    @Override
    public Merma guardaMerma(Merma merma) {
        return mermaDao.save(merma);
    }

    @Override
    public Merma actualizaMerma(Merma merma) {
        return mermaDao.save(merma);
    }
}
