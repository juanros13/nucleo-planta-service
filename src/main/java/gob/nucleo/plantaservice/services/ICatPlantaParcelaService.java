package gob.nucleo.plantaservice.services;

import gob.nucleo.viverocommons.entity.*;

import java.util.List;

public interface ICatPlantaParcelaService {

    List<CatObjetivo> findCatalogoObjetivo();

    List<CatFuenteAbastecimiento> findCatalogoFuenteAbastecimiento();

    List <ViveroPlanta> findViverosByEspecieAndOrigenSubcategoria(Long especie, Long origen, Long subCategoria, Long territorio);

    List <CatEspecie> findEspecieSubcategoria(Long especie);

    List <CatMerma>  findCatalogoMerma();

    List <ViveroPlanta> findViverosByOrigenEspecieTerritorio(Long origen, Long especie, Long territorio);

}
