package gob.nucleo.plantaservice.services;

import gob.nucleo.plantacommons.entity.TableroAvance;
import gob.nucleo.viverocommons.entity.PlantaParcela;

import java.util.List;

public interface ITableroAvanceService {

    List<TableroAvance> findByBeneficiarioId(Long beneficiarioId);

}
