package gob.nucleo.plantaservice.dao;

import gob.nucleo.plantacommons.entity.Biofabrica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBiofabricaDao extends JpaRepository<Biofabrica, Long> {
    @Query("select b from Biofabrica b where b.vivero_id = :id")
    public Biofabrica findByViveroId(@Param("id") Long id);
}
