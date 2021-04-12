package gob.nucleo.plantaservice.dao;

import gob.nucleo.plantacommons.entity.Biofabrica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IBiofabricaDao extends JpaRepository<Biofabrica, Long> {
    @Query("from Biofabrica b where b.vivero_id = :id")
    public Biofabrica findBiofabricaByVivero(Long id);
}
