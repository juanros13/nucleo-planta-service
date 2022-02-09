package gob.nucleo.plantaservice.services;

import gob.nucleo.plantacommons.entity.AvanceFacilitadorTotalesVO;
import gob.nucleo.plantacommons.entity.AvanceFacilitadorVO;

import java.util.List;

public interface IReportePlantaAvanceService {

    List<AvanceFacilitadorVO> findByAvancePlantaFacilitador(Long idFacilitador);
    List<AvanceFacilitadorTotalesVO> findByAvancePlantaFacilitadorTotales(Long idFacilitador);
}
