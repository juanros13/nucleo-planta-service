package gob.nucleo.plantaservice.dao;

import gob.nucleo.viverocommons.entity.DisenoAgroforestal;
import gob.nucleo.viverocommons.entity.PlantaParcela;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IPlantaParcelaDao extends JpaRepository<PlantaParcela, Long> {
   List <PlantaParcela>  findByDisenoAgroforestal(DisenoAgroforestal disenoAgroforestal );
}
