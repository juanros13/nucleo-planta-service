package gob.nucleo.plantaservice.dao;

import gob.nucleo.plantacommons.entity.TableroAvance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITableroAvanceDao extends JpaRepository<TableroAvance, Long> {
    List<TableroAvance> findByBeneficiarioId(Long beneficiarioId);
}
