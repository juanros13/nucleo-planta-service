package gob.nucleo.plantaservice.services;

import gob.nucleo.plantacommons.entity.AvanceViverosComercialesTerritorioVO;
import gob.nucleo.plantaservice.dao.IReporteViverosComercialesAvanceTerritorioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteViverosComercialesAvanceService implements IReporteViverosComercialesAvanceService {

    @Autowired
    IReporteViverosComercialesAvanceTerritorioDao reporteViverosComercialesAvanceTerritorioDao;



    @Override
    public List<AvanceViverosComercialesTerritorioVO> reporteViverosComercialesXTerritorio(Long idTerritorio) {
        return reporteViverosComercialesAvanceTerritorioDao.findByAvanceViverosComercialesTerritorio(idTerritorio);
    }

    @Override
    public List<AvanceViverosComercialesTerritorioVO> reporteViverosComerciales() {
        return reporteViverosComercialesAvanceTerritorioDao.findByAvanceViverosComerciales();
    }

}

