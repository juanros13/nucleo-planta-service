package gob.nucleo.plantaservice.dao;

import gob.nucleo.plantacommons.entity.AvanceFacilitadorVO;
import gob.nucleo.plantacommons.entity.AvanceTerritorioVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReportePlantaAvanceTerritorioDao extends JpaRepository<AvanceTerritorioVO, Long> {
    @Query(value = "   SELECT    " +
           " row_number() OVER (ORDER BY territorios.id) AS id, " +
           " rpt_territorio_planta_avance.territorio_id, " +
           " rpt_territorio_planta_avance.subcategoria_especie_id, " +
           " coalesce(rpt_territorio_planta_avance.meta,0) AS meta, " +
           " coalesce(rpt_territorio_planta_sobrevive.sobrevive,0) as sobrevive, " +
           " cad_cat_especie_categoria.nombre AS categoria, " +
           " CONCAT(cad_cat_especie_subcategoria.nombre_comun, ' - ', cad_cat_especie_subcategoria.nombre_cientifico) AS nombre_planta, " +
           " territorios.nombre as territorio " +
           " FROM rpt_territorio_planta_avance " +
           " LEFT JOIN territorios on territorios.id = rpt_territorio_planta_avance.territorio_id " +
           " LEFT JOIN cad_cat_especie_subcategoria on rpt_territorio_planta_avance.subcategoria_especie_id = cad_cat_especie_subcategoria.id " +
           " LEFT JOIN cad_cat_especie_categoria on cad_cat_especie_categoria.id = cad_cat_especie_subcategoria.categoria_id  " +
           " LEFT JOIN rpt_territorio_planta_sobrevive ON  " +
           "    rpt_territorio_planta_sobrevive.subcategoria_especie_id = cad_cat_especie_subcategoria.id AND " +
           "    rpt_territorio_planta_sobrevive.territorio_id  = rpt_territorio_planta_avance.territorio_id " +
           " WHERE rpt_territorio_planta_avance.territorio_id = ?1 " ,
            nativeQuery = true)
    List<AvanceTerritorioVO> findByAvancePlantaTerritorio(Long idTerritorio);
}
