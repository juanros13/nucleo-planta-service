package gob.nucleo.plantaservice.services;

import gob.nucleo.plantacommons.entity.InformacionViverosVO;

import java.util.List;

public interface IReporteInfoViverosService {

    List<InformacionViverosVO> reporteInfoViverosXEstructuraId(Long idEstructura);

    List<InformacionViverosVO> reporteInfoViveros();

}
