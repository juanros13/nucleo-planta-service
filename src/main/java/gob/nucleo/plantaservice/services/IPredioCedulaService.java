package gob.nucleo.plantaservice.services;


import gob.nucleo.beneficiariocommons.entity.Predio;

import java.util.List;
import java.util.Optional;

public interface IPredioCedulaService {
     List<Predio> findByRegistro(Long idRegistro);

     Optional<Predio>  findByPredio(Long idPredio);

     Predio guardaPredio (Predio predio);

     Predio actualizaPredio (Predio predio);

     void deletePredio(Long id);

     Predio validaPredio(Long idPredio, Integer status);

}
