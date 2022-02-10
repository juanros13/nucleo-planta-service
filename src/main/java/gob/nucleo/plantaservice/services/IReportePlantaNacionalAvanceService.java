package gob.nucleo.plantaservice.services;

import gob.nucleo.plantacommons.entity.*;

import java.util.List;

public interface IReportePlantaNacionalAvanceService {

    List<AvanceNacionalVO> getReporteAvanceNacionalXEspecie ();
    List<AvanceNacionalCategoriaPlantaVO> getReporteAvanceNacionalXCategoria();
    List<AvanceNacionalTotalesVO> getReporteAvanceNacionalTotales(Long idTerritorio);

}
