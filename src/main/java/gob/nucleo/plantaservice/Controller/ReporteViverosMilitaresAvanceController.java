package gob.nucleo.plantaservice.Controller;

import gob.nucleo.plantaservice.services.IReportePlantaTerritorioAvanceService;
import gob.nucleo.plantaservice.services.IReporteViverosMilitaresAvanceService;
import gob.nucleo.plantaservice.services.ReportePlantaAvanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ReporteViverosMilitaresAvanceController {

    @Autowired
    IReporteViverosMilitaresAvanceService reporteViverosMilitaresAvanceService;

    @GetMapping("/reporteViverosMilitaresXTerritorio/{idTerritorio}")
    public ResponseEntity<?> reporteViverosMilitaresXTerritorio (@PathVariable Long idTerritorio){
        Map<String, Object> response = new HashMap<>();
        try{
            response.put("reporteViverosMilitaresXTerritorio", reporteViverosMilitaresAvanceService.reporteViverosMilitaresXTerritorio(idTerritorio));
            response.put("success", "true" );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK) ;
        }catch (DataAccessException e){
            response.put("mensaje", "Error al realizar la consulta a base de datos" );
            response.put("error",  e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            response.put("success", "false" );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/reporteViverosMilitares")
    public ResponseEntity<?> reporteViverosMilitares (){
        Map<String, Object> response = new HashMap<>();
        try{
            response.put("reporteViverosMilitaresXTerritorio", reporteViverosMilitaresAvanceService.reporteViverosMilitares());
            response.put("success", "true" );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK) ;
        }catch (DataAccessException e){
            response.put("mensaje", "Error al realizar la consulta a base de datos" );
            response.put("error",  e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            response.put("success", "false" );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

