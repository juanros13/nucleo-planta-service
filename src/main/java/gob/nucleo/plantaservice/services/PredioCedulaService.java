package gob.nucleo.plantaservice.services;

import gob.nucleo.beneficiariocommons.entity.Predio;
import gob.nucleo.plantaservice.dao.IPredioCedulaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PredioCedulaService implements IPredioCedulaService {
    private final Logger log = LoggerFactory.getLogger(PredioCedulaService.class);

    @Autowired
    IPredioCedulaDao predioDao;

    @Override
    public List<Predio> findByRegistro(Long idRegistro) {
        return predioDao.findByIdRegistro(idRegistro);
    }

    @Override
    public Optional<Predio>  findByPredio(Long idPredio) {
        Optional<Predio> opt = Optional.ofNullable(predioDao.findById(idPredio).get());
        return opt;
    }

    @Override
    public Predio guardaPredio(Predio predio) {
        return predioDao.save(predio);
    }

    @Override
    public Predio actualizaPredio(Predio predio) {

        if (predio.getValidacionFacilitador() == 2)
            predio.setValidacionFacilitador(0);

        return predioDao.save(predio);
    }

    @Transactional
    public void deletePredio(Long id) {
        predioDao.deleteById(id);
    }

    @Override
    public Predio validaPredio(Long id, Integer status) {
        Predio predio = predioDao.findById(id).get();
        predio.setValidacionFacilitador(status);
        return predioDao.save(predio);
    }

}
