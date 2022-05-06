package gob.nucleo.plantaservice.services;

import gob.nucleo.plantacommons.entity.AvanceViverosMilitaresTerritorioVO;
import java.util.List;

public interface IReporteViverosMilitaresAvanceService {

    List<AvanceViverosMilitaresTerritorioVO> reporteViverosMilitaresXTerritorio(Long idTerritorio);

    List<AvanceViverosMilitaresTerritorioVO> reporteViverosMilitares();

}
