package gob.nucleo.plantaservice.services;

import gob.nucleo.plantacommons.entity.AvanceTerritorioCategoriaPlantaVO;
import gob.nucleo.plantacommons.entity.AvanceTerritorioVO;
import gob.nucleo.plantacommons.entity.AvanceViverosMilitaresTerritorioVO;
import gob.nucleo.plantaservice.dao.IReportePlantaAvanceTerritorioDao;
import gob.nucleo.plantaservice.dao.IReportePlantaTerritorioAvanceCategoriaDao;
import gob.nucleo.plantaservice.dao.IReporteViverosMilitaresAvanceTerritorioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteViverosMilitaresAvanceService implements IReporteViverosMilitaresAvanceService {

    @Autowired
    IReporteViverosMilitaresAvanceTerritorioDao reporteViverosMilitaresAvanceTerritorioDao;

    @Override
    public List<AvanceViverosMilitaresTerritorioVO> reporteViverosMilitaresXTerritorio(Long idTerritorio) {
        return reporteViverosMilitaresAvanceTerritorioDao.findByAvanceViverosMilitaresTerritorio(idTerritorio);
    }

    @Override
    public List<AvanceViverosMilitaresTerritorioVO> reporteViverosMilitares() {
        return reporteViverosMilitaresAvanceTerritorioDao.findByAvanceViverosMilitares();
    }
}

