package gob.nucleo.plantaservice.services;

import gob.nucleo.plantacommons.entity.TableroAvance;
import gob.nucleo.plantaservice.dao.ITableroAvanceDao;
import gob.nucleo.viverocommons.entity.DisenoAgroforestal;
import gob.nucleo.viverocommons.entity.PlantaParcela;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableroAvanceService  implements ITableroAvanceService{

    @Autowired
    ITableroAvanceDao tableroAvanceDao;

    @Override
    public List<TableroAvance> findByBeneficiarioId(Long beneficiarioId) {
        return tableroAvanceDao.findByBeneficiarioId(beneficiarioId);
    }
}
