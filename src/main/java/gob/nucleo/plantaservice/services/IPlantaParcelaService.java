package gob.nucleo.plantaservice.services;

import gob.nucleo.viverocommons.entity.PlantaParcela;

import java.util.List;

public interface IPlantaParcelaService {

    List<PlantaParcela> findByDisenoAgroforestal(Long idDisenoAgroforestal);
}
