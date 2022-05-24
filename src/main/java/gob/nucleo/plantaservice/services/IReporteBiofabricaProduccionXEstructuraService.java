package gob.nucleo.plantaservice.services;

import gob.nucleo.plantacommons.entity.BiofabricaProduccionXEstructuraVO;

import java.util.List;

public interface IReporteBiofabricaProduccionXEstructuraService {

    List<BiofabricaProduccionXEstructuraVO> reporteBioProdXEstructura(Long idEstructura);

}
