package gob.nucleo.plantaservice.services;

import gob.nucleo.plantacommons.entity.AvanceFacilitadorTotalesVO;
import gob.nucleo.plantacommons.entity.AvanceFacilitadorVO;
import gob.nucleo.plantaservice.dao.IReportePlantaAvanceDao;
import gob.nucleo.plantaservice.dao.IReportePlantaAvanceFacilitadorTotalesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportePlantaAvanceService implements IReportePlantaAvanceService {

    @Autowired
    IReportePlantaAvanceDao iReportePlantaAvanceDao;
    @Autowired
    IReportePlantaAvanceFacilitadorTotalesDao reportePlantaAvanceFacilitadorTotalesDao;

    @Override
    public List<AvanceFacilitadorVO> findByAvancePlantaFacilitador(Long idFacilitador) {
        return iReportePlantaAvanceDao.findByAvancePlantaFacilitador(idFacilitador);
    }

    @Override
    public List<AvanceFacilitadorTotalesVO> findByAvancePlantaFacilitadorTotales(Long idFacilitador) {
        return reportePlantaAvanceFacilitadorTotalesDao.findByAvancePlantaFacilitadorTotales(idFacilitador,idFacilitador,idFacilitador);
    }
}

