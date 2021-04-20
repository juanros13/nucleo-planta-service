package gob.nucleo.plantaservice.Controller;

import gob.nucleo.plantaservice.services.ICatPlantaParcelaService;
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
public class CatalogosPlantaParcelaRestController {

    @Autowired
    ICatPlantaParcelaService catPlantaParcelaService;

    @GetMapping("/catalogoObjetivo")
    public ResponseEntity<?> catalogoObjetivo (){
        Map<String, Object> response = new HashMap<>();
        try{
            response.put("catalogoObjetivo", catPlantaParcelaService.findCatalogoObjetivo());
            response.put("success", "true" );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK) ;
        }catch (DataAccessException e){
            response.put("mensaje", "Error al realizar la consulta a base de datos" );
            response.put("error",  e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            response.put("success", "false" );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/catalogoFuenteAbastecimiento")
    public ResponseEntity<?> catalogoFuenteAbastecimiento (){
        Map<String, Object> response = new HashMap<>();
        try{
            response.put("catalogoFuenteAbastecimiento", catPlantaParcelaService.findCatalogoFuenteAbastecimiento());
            response.put("success", "true" );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK) ;
        }catch (DataAccessException e){
            response.put("mensaje", "Error al realizar la consulta a base de datos" );
            response.put("error",  e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            response.put("success", "false" );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/catalogoViveroXEspecieXOrigen/{idEspecie}/{idOrigen}")
    public ResponseEntity<?> catalogoViveroXEspecieXOrigen (@PathVariable Long idEspecie, @PathVariable Long idOrigen ){
        Map<String, Object> response = new HashMap<>();
        try{
            response.put("catalogoViveroXEspecieXOrigen", catPlantaParcelaService.findViverosByEspecieAndOrigen(idEspecie, idOrigen));
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
