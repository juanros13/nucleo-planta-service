package gob.nucleo.plantaservice.services;

import gob.nucleo.plantacommons.entity.AvanceViverosComercialesTerritorioVO;

import java.util.List;

public interface IReporteViverosComercialesAvanceService {

    List<AvanceViverosComercialesTerritorioVO> reporteViverosComercialesXTerritorio(Long idTerritorio);

    List<AvanceViverosComercialesTerritorioVO> reporteViverosComerciales();

}
