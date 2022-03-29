package gob.nucleo.plantaservice.services;

import gob.nucleo.plantacommons.entity.BeneficiariosAvanceVO;
import gob.nucleo.viverocommons.entity.CatObjetivo;

import java.util.List;

public interface IBeneficiarioAvanceService {

    List<BeneficiariosAvanceVO> findBeneficiarioAvanceXEstructuraId(Long idEstructrura);

}
