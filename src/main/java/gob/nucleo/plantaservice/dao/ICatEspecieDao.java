package gob.nucleo.plantaservice.dao;

import gob.nucleo.viverocommons.entity.CatEspecie;

import gob.nucleo.viverocommons.entity.CatEspecieSubcategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICatEspecieDao extends JpaRepository  <CatEspecie, Long> {
      List <CatEspecie> findByCatEspecieSubcategoria (CatEspecieSubcategoria catEspecieSubcategoria);
}
