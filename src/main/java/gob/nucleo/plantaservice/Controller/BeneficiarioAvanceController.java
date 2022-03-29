package gob.nucleo.plantaservice.Controller;

import gob.nucleo.plantaservice.services.IBeneficiarioAvanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BeneficiarioAvanceController {

    @Autowired
    IBeneficiarioAvanceService beneficiarioAvanceService;


    @GetMapping("/beneficiariosAvanceXtecnico/{idEstructura}")
    public ResponseEntity<?> encuentraByTecnico(
            @PathVariable Long idEstructura
    ) {
        Map<String, Object> response = new HashMap<>();
        try {
            response.put("beneficiario", beneficiarioAvanceService.findBeneficiarioAvanceXEstructuraId(idEstructura));
            response.put("success", "true");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta a base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            response.put("success", "false");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
