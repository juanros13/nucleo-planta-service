package gob.nucleo.plantaservice.dao;

import gob.nucleo.plantacommons.entity.AvanceNacionalVO;
import gob.nucleo.plantacommons.entity.AvanceTecnicoVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReportePlantaNacionalAvanceDao extends JpaRepository<AvanceNacionalVO, Long> {
    @Query(value = 
            " SELECT " +
            " row_number() OVER (ORDER BY rpt_nacional_planta_avance.subcategoria_especie_id) AS id, " +
            " rpt_nacional_planta_avance.subcategoria_especie_id,  " +
            " coalesce(rpt_nacional_planta_avance.meta,0) AS meta,  " +
            " coalesce(rpt_nacional_planta_sobrevive.sobrevive,0) as sobrevive,  " +
            " cad_cat_especie_categoria.nombre AS categoria,  " +
            " CONCAT(cad_cat_especie_subcategoria.nombre_comun, ' - ', cad_cat_especie_subcategoria.nombre_cientifico) AS nombre_planta   " +
            " FROM rpt_nacional_planta_avance  " +
            " LEFT JOIN cad_cat_especie_subcategoria on rpt_nacional_planta_avance.subcategoria_especie_id = cad_cat_especie_subcategoria.id  " +
            " LEFT JOIN cad_cat_especie_categoria on cad_cat_especie_categoria.id = cad_cat_especie_subcategoria.categoria_id  " +
            " LEFT JOIN rpt_nacional_planta_sobrevive ON rpt_nacional_planta_sobrevive.subcategoria_especie_id = cad_cat_especie_subcategoria.id  ",
            nativeQuery = true)
    List<AvanceNacionalVO> findByAvancePlantaNacionalXEspecie();
}
