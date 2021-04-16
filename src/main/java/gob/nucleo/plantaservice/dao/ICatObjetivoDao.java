package gob.nucleo.plantaservice.dao;

import gob.nucleo.viverocommons.entity.CatObjetivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICatObjetivoDao extends JpaRepository<CatObjetivo, Long> {

}
