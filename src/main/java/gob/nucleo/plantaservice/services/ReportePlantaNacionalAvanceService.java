package gob.nucleo.plantaservice.services;

import gob.nucleo.plantacommons.entity.*;
import gob.nucleo.plantaservice.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportePlantaNacionalAvanceService implements IReportePlantaNacionalAvanceService {

    @Autowired
    IReportePlantaNacionalAvanceDao reportePlantaNacionalAvanceDao;

    @Autowired
    IReportePlantaNacionalAvanceCategoriaDao reportePlantaNacionalAvanceCategoriaDao;

    @Autowired
    IReportePlantaNacionalAvanceTotalesDao reportePlantaNacionalAvanceTotalesDao;

    @Override
    public List<AvanceNacionalVO> getReporteAvanceNacionalXEspecie() {
        return reportePlantaNacionalAvanceDao.findByAvancePlantaNacionalXEspecie();
    }
    @Override
    public List<AvanceNacionalCategoriaPlantaVO> getReporteAvanceNacionalXCategoria() {
        return reportePlantaNacionalAvanceCategoriaDao.findByAvancePlantaNacionalXCategoria();
    }

    @Override
    public List<AvanceNacionalTotalesVO> getReporteAvanceNacionalTotales(Long idTerritorio) {
        return reportePlantaNacionalAvanceTotalesDao.findByAvancePlantaNacionalTotales(idTerritorio,idTerritorio,idTerritorio);
    }
}

