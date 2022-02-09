package gob.nucleo.plantaservice.services;

import gob.nucleo.plantacommons.entity.AvanceTecnicoCategoriaPlantaVO;
import gob.nucleo.plantacommons.entity.AvanceTecnicoTotalesVO;
import gob.nucleo.plantacommons.entity.AvanceTecnicoVO;
import gob.nucleo.plantaservice.dao.IReportePlantaAvanceTecnicoTotalesDao;
import gob.nucleo.plantaservice.dao.IReportePlantaTecnicoAvanceCategoriaDao;
import gob.nucleo.plantaservice.dao.IReportePlantaTecnicoAvanceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportePlantaTecnicoAvanceService implements IReportePlantaTecnicoAvanceService {

    @Autowired
    IReportePlantaTecnicoAvanceDao reportePlantaTecnicoAvanceDao;

    @Autowired
    IReportePlantaTecnicoAvanceCategoriaDao reportePlantaTecnicoAvanceCategoriaDao;
    @Autowired
    IReportePlantaAvanceTecnicoTotalesDao reportePlantaAvanceTecnicoTotalesDao;

    @Override
    public List<AvanceTecnicoVO> getReporteAvanceTecnicoXEspecie(Long idTecnico) {
        return reportePlantaTecnicoAvanceDao.findByAvancePlantaTecnicoXEspecie(idTecnico);
    }
    @Override
    public List<AvanceTecnicoCategoriaPlantaVO> getReporteAvanceTecnicoXCategoria(Long idTecnico) {
        return reportePlantaTecnicoAvanceCategoriaDao.findByAvancePlantaTecnicoXCategoria(idTecnico);
    }
    @Override
    public List<AvanceTecnicoTotalesVO> getReporteAvanceTecnicoTotales(Long idTecnico) {
        return reportePlantaAvanceTecnicoTotalesDao.findByAvancePlantaTecnicosTotales(idTecnico,idTecnico,idTecnico);
    }
}

