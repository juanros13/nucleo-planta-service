package gob.nucleo.plantaservice.Controller;

import gob.nucleo.plantaservice.services.IPlantaParcelaService;
import gob.nucleo.viverocommons.entity.PlantaParcela;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class PlantaParcelaRestController {

    @Autowired
    IPlantaParcelaService plantaParcelaService;

    @GetMapping("/plantaParcelaXdiseno/{idDiseno}")
    public ResponseEntity<?> encuentraCultivoPredio (@PathVariable Long idDiseno){
        Map<String, Object> response = new HashMap<>();
        try{
            response.put("plantaParcela", plantaParcelaService.findByDisenoAgroforestal(idDiseno));
            response.put("success", "true" );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK) ;
        }catch (DataAccessException e){
            response.put("mensaje", "Error al realizar la consulta a base de datos" );
            response.put("error",  e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            response.put("success", "false" );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/guardaPlantaParcela")
    public ResponseEntity<?> guardaPlantaParcela (@RequestBody PlantaParcela plantaParcela){
        Map<String, Object> response = new HashMap<>();
        try{
            plantaParcelaService.guardaPlantaParcela(plantaParcela);
            response.put("mensaje", "La planta se ha guardado  con éxito");
            response.put("success", "true" );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED) ;
        }catch (DataAccessException e){
            response.put("mensaje", "Error al realizar el insert a base de datos" );
            response.put("error",  e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            response.put("success", "false" );
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/actualizaPlantaParcela")
    public ResponseEntity<?> actualizaPlantaParcela (@RequestBody PlantaParcela plantaParcela){
        Map<String, Object> response = new HashMap<>();
        try{
            plantaParcelaService.actualizaPlantaParcela(plantaParcela);
            response.put("mensaje", "La planta se ha actualizado con éxito");
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
