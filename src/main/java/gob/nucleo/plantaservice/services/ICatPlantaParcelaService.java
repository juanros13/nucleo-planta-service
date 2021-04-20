package gob.nucleo.plantaservice.services;

import gob.nucleo.viverocommons.entity.CatFuenteAbastecimiento;
import gob.nucleo.viverocommons.entity.CatObjetivo;
import gob.nucleo.viverocommons.entity.ViveroPlanta;

import java.util.List;

public interface ICatPlantaParcelaService {

    List<CatObjetivo> findCatalogoObjetivo();

    List<CatFuenteAbastecimiento> findCatalogoFuenteAbastecimiento();

    List <ViveroPlanta> findViverosByEspecieAndOrigen(Long especie, Long origen);

}
