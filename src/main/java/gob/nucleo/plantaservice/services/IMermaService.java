package gob.nucleo.plantaservice.services;


import gob.nucleo.viverocommons.entity.PlantaParcela;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IMermaService {

    List<PlantaParcela> findMermaByPlantaParcela(Long idPlantaParcela);

    PlantaParcela guardaMerma (PlantaParcela merma);

    PlantaParcela actualizaMerma (PlantaParcela merma);

}
