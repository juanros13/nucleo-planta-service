package gob.nucleo.plantaservice.services;

import gob.nucleo.viverocommons.entity.CatFuenteAbastecimiento;
import gob.nucleo.viverocommons.entity.CatObjetivo;

import java.util.List;

public interface ICatPlantaParcelaService {

    List<CatObjetivo> findCatalogoObjetivo();

    List<CatFuenteAbastecimiento> findCatalogoFuenteAbastecimiento();
}
