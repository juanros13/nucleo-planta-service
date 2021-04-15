package gob.nucleo.plantaservice.dao;

import gob.nucleo.viverocommons.entity.DisenoAgroforestal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IDisenoAgroforestalDao extends JpaRepository <DisenoAgroforestal, Long> {

}
