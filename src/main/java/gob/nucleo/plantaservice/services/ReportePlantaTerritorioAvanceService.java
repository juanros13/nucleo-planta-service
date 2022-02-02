package gob.nucleo.plantaservice.services;

import gob.nucleo.plantacommons.entity.AvanceTecnicoCategoriaPlantaVO;
import gob.nucleo.plantacommons.entity.AvanceTecnicoVO;
import gob.nucleo.plantacommons.entity.AvanceTerritorioCategoriaPlantaVO;
import gob.nucleo.plantacommons.entity.AvanceTerritorioVO;
import gob.nucleo.plantaservice.dao.IReportePlantaAvanceTerritorioDao;
import gob.nucleo.plantaservice.dao.IReportePlantaTecnicoAvanceCategoriaDao;
import gob.nucleo.plantaservice.dao.IReportePlantaTecnicoAvanceDao;
import gob.nucleo.plantaservice.dao.IReportePlantaTerritorioAvanceCategoriaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportePlantaTerritorioAvanceService implements IReportePlantaTerritorioAvanceService {

    @Autowired
    IReportePlantaAvanceTerritorioDao reportePlantaAvanceTerritorioDao;

    @Autowired
    IReportePlantaTerritorioAvanceCategoriaDao reportePlantaTerritorioAvanceCategoriaDao;


    @Override
    public List<AvanceTerritorioVO> getReporteAvanceTerritorioXEspecie(Long idTecnico) {
        return reportePlantaAvanceTerritorioDao.findByAvancePlantaTerritorio(idTecnico);
    }

    @Override
    public List<AvanceTerritorioCategoriaPlantaVO> getReporteAvanceTerritorioXCategoria(Long idTerritorio) {
        return reportePlantaTerritorioAvanceCategoriaDao.findByAvancePlantaTerritorioXCategoria(idTerritorio);
    }

}

