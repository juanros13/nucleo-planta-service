package gob.nucleo.plantaservice.services;

import gob.nucleo.plantacommons.entity.AvanceViverosEstatalesTerritorioVO;

import java.util.List;

public interface IReporteViverosEstatalesAvanceService {

    List<AvanceViverosEstatalesTerritorioVO> reporteViverosEstatalesXTerritorio(Long idTerritorio);

    List<AvanceViverosEstatalesTerritorioVO> reporteViverosEstatales();

}
