package gob.nucleo.plantaservice.services;

import gob.nucleo.viverocommons.entity.DisenoAgroforestal;
import gob.nucleo.viverocommons.entity.PlantaParcela;

import java.util.List;

public interface IPlantaParcelaService {

    List<PlantaParcela> findByDisenoAgroforestal(Long idDisenoAgroforestal);

    PlantaParcela guardaPlantaParcela (PlantaParcela plantaParcela);

    PlantaParcela actualizaPlantaParcela (PlantaParcela plantaParcela);

    void deletePlantaParcela(Long id);

    void deleteDisenoAgroforestal(Long id);

    List<DisenoAgroforestal> actualizaAvancePlanta(Long idBeneficiario);
}
