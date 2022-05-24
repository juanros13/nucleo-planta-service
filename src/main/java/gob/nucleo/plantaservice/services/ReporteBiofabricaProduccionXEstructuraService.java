package gob.nucleo.plantaservice.services;

import gob.nucleo.plantacommons.entity.BiofabricaProduccionXEstructuraVO;
import gob.nucleo.plantacommons.entity.InformacionViverosVO;
import gob.nucleo.plantacommons.entity.ViveroVO;
import gob.nucleo.plantaservice.dao.IInfoViveroDao;
import gob.nucleo.plantaservice.dao.IReporteBiofabricaProduccionXEstructuraDao;
import gob.nucleo.plantaservice.dao.IReporteInfoViverosDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReporteBiofabricaProduccionXEstructuraService implements IReporteBiofabricaProduccionXEstructuraService {

    @Autowired
    IReporteBiofabricaProduccionXEstructuraDao reporteBiofabricaProduccionXEstructuraDao;

    @Autowired
    IInfoViveroDao infoViveroDao;

    @Override
    public List<BiofabricaProduccionXEstructuraVO> reporteBioProdXEstructura(Long idEstructura) {
        return reporteBiofabricaProduccionXEstructuraDao.findByInfoBiofabricaProduccionXEstructura(idEstructura, idEstructura, idEstructura, idEstructura);
    }

}

