package gob.nucleo.plantaservice.dao;

import gob.nucleo.beneficiariocommons.entity.Predio;
import gob.nucleo.viverocommons.entity.DisenoAgroforestal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IPredioDao extends JpaRepository <Predio, Long> {
    List<Predio> findByIdRegistro(Long idBeneficiario);

}
