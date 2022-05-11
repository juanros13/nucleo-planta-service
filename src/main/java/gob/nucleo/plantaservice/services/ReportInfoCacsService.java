package gob.nucleo.plantaservice.services;

import gob.nucleo.plantacommons.entity.InformacionCacsVO;
import gob.nucleo.plantaservice.dao.IReporteInfoCacsDao;
import gob.nucleo.plantaservice.dao.IReporteViverosComercialesAvanceTerritorioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportInfoCacsService implements IReporteInfoCacsService {

    @Autowired
    IReporteInfoCacsDao reporteInfoCacsDao;



    @Override
    public List<InformacionCacsVO> reporteInfoCacsXEstructuraId(Long idEstructura) {
        return reporteInfoCacsDao.findByInfoCacsXEstructuraId(idEstructura, idEstructura, idEstructura, idEstructura);
    }

    @Override
    public List<InformacionCacsVO> reporteInfoCacs() {
      return reporteInfoCacsDao.findByInfoCacs();
   }

}

