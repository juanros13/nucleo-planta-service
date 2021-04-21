package gob.nucleo.plantaservice.dao;

import gob.nucleo.viverocommons.entity.CatEspecieCategoria;
import gob.nucleo.viverocommons.entity.CatEspecieSubcategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICatEspecieSubcategoriaDao extends JpaRepository  <CatEspecieSubcategoria, Long> {

        CatEspecieSubcategoria findTopByCatEspecieCategoria(CatEspecieCategoria catEspecieCategoria);

        CatEspecieSubcategoria findAllByCatEspecieCategoriaAndId(CatEspecieCategoria catEspecieCategoria, Long id);
}
