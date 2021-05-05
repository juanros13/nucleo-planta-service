package gob.nucleo.plantaservice.dao;

import gob.nucleo.viverocommons.entity.Territorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ITerritorioDao extends JpaRepository<Territorio, Long> {


}
