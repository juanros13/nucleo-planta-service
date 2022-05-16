package gob.nucleo.plantaservice.services;

import gob.nucleo.plantacommons.entity.InformacionViverosVO;
import gob.nucleo.plantaservice.dao.IReporteInfoViverosDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportInfoViverosService implements IReporteInfoViverosService {

    @Autowired
    IReporteInfoViverosDao reporteInfoViverosDao;



    @Override
    public List<InformacionViverosVO> reporteInfoViverosXEstructuraId(Long idEstructura) {
        return reporteInfoViverosDao.findByInfoViverosXEstructuraId(idEstructura, idEstructura, idEstructura, idEstructura);
    }

    @Override
    public List<InformacionViverosVO> reporteInfoViveros() {
      return reporteInfoViverosDao.findByInfoViveros();
   }

}

