package gob.nucleo.plantaservice.Controller;

import gob.nucleo.plantacommons.entity.Vivero;
import gob.nucleo.plantaservice.services.IViveroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

public class ViveroRestController {

    @Autowired
    private IViveroService viveroService;

    @GetMapping("/busquedaXtecnico/{idTecnico}")
    public ResponseEntity<?> encuentraVivero(
        @RequestParam(defaultValue = "0") Integer pageNo,
        @RequestParam(defaultValue = "100") Integer pageSize,
        @RequestParam(defaultValue = "id") String sortBy,
        @RequestParam(defaultValue = "desc") String orderBy,
        @PathVariable Long idTecnico
    ){
        Map<String, Object> response = new HashMap<>();
        try{
            response.put("beneficiario", viveroService.findByUsuarioCreo(pageNo, pageSize, sortBy, orderBy,idTecnico));
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
