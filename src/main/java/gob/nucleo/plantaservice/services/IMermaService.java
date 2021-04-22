package gob.nucleo.plantaservice.services;

import gob.nucleo.viverocommons.entity.Merma;

import java.util.List;

public interface IMermaService {

    List<Merma> findMermaByPlantaParcela(Long idPlantaParcela);

    Merma guardaMerma (Merma merma);

    Merma actualizaMerma (Merma merma);

}
