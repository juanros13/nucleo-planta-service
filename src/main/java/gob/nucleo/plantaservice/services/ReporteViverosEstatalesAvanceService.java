package gob.nucleo.plantaservice.services;

import gob.nucleo.plantacommons.entity.AvanceViverosEstatalesTerritorioVO;
import gob.nucleo.plantaservice.dao.IReporteViverosEstatalesAvanceTerritorioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteViverosEstatalesAvanceService implements IReporteViverosEstatalesAvanceService {

    @Autowired
    IReporteViverosEstatalesAvanceTerritorioDao reporteViverosEstatalesAvanceTerritorioDao;

    @Override
    public List<AvanceViverosEstatalesTerritorioVO> reporteViverosEstatalesXTerritorio(Long idTerritorio) {
        return reporteViverosEstatalesAvanceTerritorioDao.findByAvanceViverosEstatalesTerritorio(idTerritorio);
    }

    @Override
    public List<AvanceViverosEstatalesTerritorioVO> reporteViverosEstatales() {
        return reporteViverosEstatalesAvanceTerritorioDao.findByAvanceViverosEstatales();
    }

}

