package gob.nucleo.plantaservice.services;

import gob.nucleo.plantacommons.entity.AvanceTecnicoCategoriaPlantaVO;
import gob.nucleo.plantacommons.entity.AvanceTecnicoTotalesVO;
import gob.nucleo.plantacommons.entity.AvanceTecnicoVO;
import gob.nucleo.plantaservice.dao.IReportePlantaTecnicoAvanceCategoriaDao;
import gob.nucleo.viverocommons.entity.PlantaParcela;

import java.util.List;

public interface IReportePlantaTecnicoAvanceService {

    List<AvanceTecnicoVO> getReporteAvanceTecnicoXEspecie (Long idTecnico);
    List<AvanceTecnicoCategoriaPlantaVO> getReporteAvanceTecnicoXCategoria(Long idTecnico);
    List<AvanceTecnicoTotalesVO> getReporteAvanceTecnicoTotales(Long idTecnico);

}
