package gob.nucleo.plantaservice.dao;

import gob.nucleo.viverocommons.entity.CatEspecieCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICatEspecieCategoriaDao extends JpaRepository  <CatEspecieCategoria, Long> {

}
