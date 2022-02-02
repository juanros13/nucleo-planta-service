package gob.nucleo.plantaservice.services;

import gob.nucleo.plantacommons.entity.SobreviveCategoriaFacilitadorVO;

import java.util.List;

public interface ISobrevivePlantaFalicitadorService {

    List<SobreviveCategoriaFacilitadorVO> findBySobrevivePlantaFalicitador(Long idFacilitador);
}
