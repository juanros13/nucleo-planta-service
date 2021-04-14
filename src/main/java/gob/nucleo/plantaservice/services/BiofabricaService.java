package gob.nucleo.plantaservice.services;

import gob.nucleo.viverocommons.entity.Biofabrica;
import gob.nucleo.viverocommons.entity.Vivero;
import gob.nucleo.plantaservice.dao.IBiofabricaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BiofabricaService implements IBiofabricaService{
    @Autowired
    private IBiofabricaDao biofabricaDao;

    @Autowired
    private ViveroService viveroServiceDao;



}
