package gob.nucleo.plantaservice.dao;

import gob.nucleo.viverocommons.entity.CatFuenteAbastecimiento;
import gob.nucleo.viverocommons.entity.CatObjetivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICatFuenteAbastesimientoDao extends JpaRepository<CatFuenteAbastecimiento, Long> {

}
