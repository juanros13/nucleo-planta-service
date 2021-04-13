package gob.nucleo.plantaservice.Controller;

import gob.nucleo.plantacommons.entity.Biofabrica;
import gob.nucleo.plantacommons.entity.Vivero;
import gob.nucleo.plantaservice.dao.IBiofabricaDao;
import gob.nucleo.plantaservice.dao.IViveroDao;
import gob.nucleo.plantaservice.services.IBiofabricaService;
import gob.nucleo.plantaservice.services.IViveroService;
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
public class BiofabricaRestController {

    @Autowired
    private IBiofabricaDao biofabricaService;

    @Autowired
    private IViveroDao viveroService;

    @GetMapping("/biofabrica/{idVivero}")
    public Biofabrica encuentraBiofabrica(
        @PathVariable Long idVivero
    ){
        Vivero vivero = viveroService.findById(idVivero).get();
        return biofabricaService.findByVivero(vivero);
    }

}
