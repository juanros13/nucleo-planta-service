package gob.nucleo.plantaservice.services;

import gob.nucleo.plantacommons.entity.InformacionCacsVO;

import java.util.List;

public interface IReporteInfoCacsService {

    List<InformacionCacsVO> reporteInfoCacsXEstructuraId(Long idTerritorio);

    List<InformacionCacsVO> reporteInfoCacs();

}
