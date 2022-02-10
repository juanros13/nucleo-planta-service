package gob.nucleo.plantaservice.dao;

import gob.nucleo.plantacommons.entity.AvanceNacionalCategoriaPlantaVO;
import gob.nucleo.plantacommons.entity.AvanceTecnicoCategoriaPlantaVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReportePlantaNacionalAvanceCategoriaDao extends JpaRepository<AvanceNacionalCategoriaPlantaVO, Long> {
    @Query(value = 
            "SELECT  " +
            "rpt_nacional_planta_sobrevive_x_categoria.categoria_id AS id, " +
            "cad_cat_especie_categoria.nombre, " +
            "rpt_nacional_planta_sobrevive_x_categoria.sobrevive " +
            "FROM rpt_nacional_planta_sobrevive_x_categoria " +
            "LEFT JOIN cad_cat_especie_categoria ON cad_cat_especie_categoria.id = rpt_nacional_planta_sobrevive_x_categoria.categoria_id " ,
            nativeQuery = true)
    List<AvanceNacionalCategoriaPlantaVO> findByAvancePlantaNacionalXCategoria();
}
