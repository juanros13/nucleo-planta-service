package gob.nucleo.plantaservice.services;

import gob.nucleo.plantacommons.entity.AvanceTecnicoCategoriaPlantaVO;
import gob.nucleo.plantacommons.entity.AvanceTecnicoVO;
import gob.nucleo.plantacommons.entity.AvanceTerritorioCategoriaPlantaVO;
import gob.nucleo.plantacommons.entity.AvanceTerritorioVO;

import java.util.List;

public interface IReportePlantaTerritorioAvanceService {

    List<AvanceTerritorioVO> getReporteAvanceTerritorioXEspecie(Long idTerritorio);

    List<AvanceTerritorioCategoriaPlantaVO> getReporteAvanceTerritorioXCategoria(Long idTerritorio);

}
