package gob.nucleo.plantaservice.dao;

import gob.nucleo.beneficiariocommons.entity.Predio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPredioCedulaDao extends JpaRepository <Predio, Long> {
    public List <Predio> findByIdRegistro(Long idRegistro);

}
