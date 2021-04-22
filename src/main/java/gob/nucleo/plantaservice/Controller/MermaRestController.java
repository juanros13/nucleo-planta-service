package gob.nucleo.plantaservice.Controller;

import gob.nucleo.plantaservice.services.IMermaService;
import gob.nucleo.viverocommons.entity.Merma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MermaRestController {

    @Autowired
    IMermaService mermaService;

    @GetMapping("/findMermaByPlantaParcela/{idPlantaParcela}")
    public ResponseEntity<?> findMermaByPlantaParcela (@PathVariable Long idPlantaParcela){
        Map<String, Object> response = new HashMap<>();
        try{
            response.put("merma", mermaService.findMermaByPlantaParcela(idPlantaParcela));
            response.put("success", "true" );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK) ;
        }catch (DataAccessException e){
            response.put("mensaje", "Error al realizar la consulta a base de datos" );
            response.put("error",  e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            response.put("success", "false" );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/guardaMerma")
    public ResponseEntity<?> guardaMerma (@RequestBody Merma merma){
        Map<String, Object> response = new HashMap<>();
        try{
            mermaService.guardaMerma(merma);
            response.put("mensaje", "La Merma se ha guardado  con éxito");
            response.put("success", "true" );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED) ;
        }catch (DataAccessException e){
            response.put("mensaje", "Error al realizar el insert a base de datos" );
            response.put("error",  e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            response.put("success", "false" );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/actualizaMerma")
    public ResponseEntity<?> actualizaMerma (@RequestBody Merma merma){
        Map<String, Object> response = new HashMap<>();
        try{
            mermaService.actualizaMerma(merma);
            response.put("mensaje", "La merma se ha actualizado con éxito");
            response.put("success", "true" );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK) ;
        }catch (DataAccessException e){
            response.put("mensaje", "Error al realizar el insert a base de datos" );
            response.put("error",  e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            response.put("success", "false" );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
