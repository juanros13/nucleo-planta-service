package gob.nucleo.plantaservice.services;

import gob.nucleo.viverocommons.entity.PlantaParcela;

public interface IPlantaParcelaService {

    PlantaParcela findByDisenoAgroforestal(Long idDisenoAgroforestal);
}
