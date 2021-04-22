package gob.nucleo.plantaservice.dao;


import gob.nucleo.viverocommons.entity.Merma;
import gob.nucleo.viverocommons.entity.PlantaParcela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IMermaDao extends JpaRepository <Merma, Long> {
    List<Merma> findAllByPlantaParcela(PlantaParcela plantaParcela);
}
