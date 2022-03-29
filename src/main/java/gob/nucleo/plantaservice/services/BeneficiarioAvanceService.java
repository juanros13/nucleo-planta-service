package gob.nucleo.plantaservice.services;

import gob.nucleo.plantacommons.entity.BeneficiariosAvanceVO;
import gob.nucleo.plantaservice.dao.IBeneficiarioAvanceVODao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeneficiarioAvanceService implements IBeneficiarioAvanceService{

    @Autowired
    IBeneficiarioAvanceVODao beneficiarioAvanceVODao;

    public List<BeneficiariosAvanceVO> findBeneficiarioAvanceXEstructuraId(Long idEstructrura){
        return beneficiarioAvanceVODao.findByAvancePlantaFacilitadorTotales(idEstructrura,idEstructrura,idEstructrura);
    }
}
