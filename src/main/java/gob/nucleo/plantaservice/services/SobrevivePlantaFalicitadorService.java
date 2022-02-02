package gob.nucleo.plantaservice.services;

import gob.nucleo.plantacommons.entity.AvanceFacilitadorVO;
import gob.nucleo.plantacommons.entity.SobreviveCategoriaFacilitadorVO;
import gob.nucleo.plantaservice.dao.IReportePlantaAvanceDao;
import gob.nucleo.plantaservice.dao.ISobrevivePlantaFalicitadorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SobrevivePlantaFalicitadorService implements ISobrevivePlantaFalicitadorService {

    @Autowired
    ISobrevivePlantaFalicitadorDao iSobrevivePlantaFalicitadorDao;

    @Override
    public List<SobreviveCategoriaFacilitadorVO> findBySobrevivePlantaFalicitador(Long idFacilitador) {
        return iSobrevivePlantaFalicitadorDao.findBySobrevivePlantaFalicitador(idFacilitador);
    }
}

