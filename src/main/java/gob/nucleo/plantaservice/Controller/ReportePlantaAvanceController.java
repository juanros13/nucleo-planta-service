package gob.nucleo.plantaservice.Controller;

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
public class ReportePlantaAvanceController {

    @Autowired
    ReportePlantaAvanceService reportePlantaAvanceService;

    @GetMapping("/avancePlantaFacilitador/{idFacilitador}")
    public ResponseEntity<?> avancePlantaFacilitador (@PathVariable Long idFacilitador){
        Map<String, Object> response = new HashMap<>();
        try{
            response.put("avancePlantaFaciciltador", reportePlantaAvanceService.findByAvancePlantaFacilitador(idFacilitador));
            response.put("success", "true" );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK) ;
        }catch (DataAccessException e){
            response.put("mensaje", "Error al realizar la consulta a base de datos" );
            response.put("error",  e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            response.put("success", "false" );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/avancePlantaFacilitadorTotales/{idFacilitador}")
    public ResponseEntity<?> avancePlantaFacilitadorTotales (@PathVariable Long idFacilitador){
        Map<String, Object> response = new HashMap<>();
        try{
            response.put("avancePlantaFaciciltador", reportePlantaAvanceService.findByAvancePlantaFacilitadorTotales(idFacilitador));
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

