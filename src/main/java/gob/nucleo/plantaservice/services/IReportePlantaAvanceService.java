package gob.nucleo.plantaservice.services;

import gob.nucleo.plantacommons.entity.AvanceFacilitadorVO;

import java.util.List;

public interface IReportePlantaAvanceService {

    List<AvanceFacilitadorVO> findByAvancePlantaFacilitador(Long idFacilitador);
}
