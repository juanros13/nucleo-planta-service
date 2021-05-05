package gob.nucleo.plantaservice.dao;

import gob.nucleo.viverocommons.entity.CatEspecie;
import gob.nucleo.viverocommons.entity.CatFuenteAbastecimiento;
import gob.nucleo.viverocommons.entity.Territorio;
import gob.nucleo.viverocommons.entity.ViveroPlanta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IViveroPlantaDao extends JpaRepository <ViveroPlanta, Long> {

   List <ViveroPlanta> findByEspecieAndFuenteAbastecimiento(CatEspecie especie, CatFuenteAbastecimiento fuenteAbastecimiento);

   List <ViveroPlanta> findByEspecieAndFuenteAbastecimientoAndTerritorio(CatEspecie especie, CatFuenteAbastecimiento fuenteAbastecimiento, Territorio territorio);
}
