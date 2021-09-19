package gob.nucleo.plantaservice.dao;

import gob.nucleo.viverocommons.entity.DisenoAgroforestal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IDisenoAgroforestalDao extends CrudRepository<DisenoAgroforestal, Long> {
    List<DisenoAgroforestal> findByIdPredioIn(List<Long> idsPredio);
}
