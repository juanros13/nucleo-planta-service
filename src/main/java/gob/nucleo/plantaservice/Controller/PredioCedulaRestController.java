package gob.nucleo.plantaservice.Controller;

import gob.nucleo.beneficiariocommons.entity.Predio;

import gob.nucleo.plantaservice.services.IPredioCedulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PredioCedulaRestController {

    @Autowired
    private IPredioCedulaService predioService;

    @GetMapping("/cedula/predioXregistro/{idRegistro}")
    public ResponseEntity<?> encuentraPredioRegistro (@PathVariable Long idRegistro){
        Map<String, Object> response = new HashMap<>();
        try{
            response.put("predio", predioService.findByRegistro(idRegistro));
            response.put("success", "true" );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK) ;
        }catch (DataAccessException e){
            response.put("mensaje", "Error al realizar la consulta a base de datos" );
            response.put("error",  e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            response.put("success", "false" );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/cedula/busquedaXIdPredio/{idPredio}")
    public ResponseEntity<?> encuentraById (@PathVariable Long idPredio){
        Map<String, Object> response = new HashMap<>();

        try{
            if (!predioService.findByPredio(idPredio).isEmpty()){
                response.put("predio", predioService.findByPredio(idPredio).get() );
                response.put("success", "true" );
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
            }else{  
                response.put("mensaje", "No se encontraron predios con los parámetros ingresados" );
                response.put("success", "false" );
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.SEE_OTHER);
            }
        }catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta a base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            response.put("success", "false");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/cedula/guardaPredio")
    public ResponseEntity<?> guardaPredio (@RequestBody Predio predio){
        Map<String, Object> response = new HashMap<>();
        try{
            predioService.guardaPredio(predio);
            response.put("mensaje", "El predio se ha guardado  con éxito");
            response.put("success", "true" );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED) ;
        }catch (DataAccessException e){
            response.put("mensaje", "Error al realizar el insert a base de datos" );
            response.put("error",  e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            response.put("success", "false" );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/cedula/actualizaPredio")
    public ResponseEntity<?> actualizaPredio (@RequestBody Predio predio){
        Map<String, Object> response = new HashMap<>();
        try{
            predioService.actualizaPredio(predio);
            response.put("mensaje", "El predio se ha actualizado  con éxito");
            response.put("success", "true" );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED) ;
        }catch (DataAccessException e){
            response.put("mensaje", "Error al realizar el insert a base de datos" );
            response.put("error",  e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            response.put("success", "false" );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/cedula/deletePredio/{idPredio}")
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?>  deletePredio(@PathVariable Long idPredio){
        Map<String, Object> response = new HashMap<>();
        try{
            predioService.deletePredio(idPredio);
        }catch (DataAccessException e){
            response.put("success", "false" );
            response.put("mensaje", "Error al eliminar predio en la DB");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("success", "true" );
        response.put("mensaje", "el predio ha sido eliminada con exito");
        return new ResponseEntity<Map>(response, HttpStatus.OK);

    }
    @PutMapping("/cedula/validaPredio/{idPredio}/{status}")
    public ResponseEntity<?> validaPredio (@PathVariable Long idPredio,
                                        @PathVariable Integer status) {
        Map<String, Object> response = new HashMap<>();
        try {
            predioService.validaPredio(idPredio, status);
            response.put("mensaje", "La validación se ha actualizado  con éxito");
            response.put("success", "true");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED) ;
        }catch (DataAccessException e){
            response.put("mensaje", "Error al realizar el insert a base de datos" );
            response.put("error",  e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            response.put("success", "false" );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
