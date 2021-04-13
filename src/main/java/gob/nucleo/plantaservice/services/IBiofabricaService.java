package gob.nucleo.plantaservice.services;

import gob.nucleo.plantacommons.entity.Biofabrica;

public interface IBiofabricaService {
    public Biofabrica findByVivero(Long id);
}
