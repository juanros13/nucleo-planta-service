package gob.nucleo.plantaservice.Controller;

import gob.nucleo.plantaservice.services.IReportePlantaTecnicoAvanceService;
import gob.nucleo.plantaservice.services.IReportePlantaTerritorioAvanceService;
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
public class ReportePlantaTerritorioAvanceController {

    @Autowired
    IReportePlantaTerritorioAvanceService reportePlantaTerritorioAvanceService;

    @GetMapping("/reportePlantaTerritorio/especies/{idTerritorio}")
    public ResponseEntity<?> reportePlantaTerritorioEspecies (@PathVariable Long idTerritorio){
        Map<String, Object> response = new HashMap<>();
        try{
            response.put("reportePlanta", reportePlantaTerritorioAvanceService.getReporteAvanceTerritorioXEspecie(idTerritorio));
            response.put("success", "true" );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK) ;
        }catch (DataAccessException e){
            response.put("mensaje", "Error al realizar la consulta a base de datos" );
            response.put("error",  e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            response.put("success", "false" );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
    @GetMapping("/reportePlantaTerritorio/categorias/{idTerritorio}")
    public ResponseEntity<?> reportePlantaTerritorioCategorias (@PathVariable Long idTerritorio){
        Map<String, Object> response = new HashMap<>();
        try{
            response.put("reportePlanta", reportePlantaTerritorioAvanceService.getReporteAvanceTerritorioXCategoria(idTerritorio));
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

