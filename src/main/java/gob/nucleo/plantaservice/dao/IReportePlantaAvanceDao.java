package gob.nucleo.plantaservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import gob.nucleo.plantacommons.entity.AvanceFacilitadorVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IReportePlantaAvanceDao extends JpaRepository<AvanceFacilitadorVO, Long> {
    @Query(value = "SELECT " +
            "row_number() OVER (ORDER BY uf_main.facilitador_id) AS id, " +
            "rpt_facilitador_planta_avance.facilitador_id," +
            "rpt_facilitador_planta_avance.subcategoria_especie_id," +
            "coalesce(rpt_facilitador_planta_avance.meta,0)AS meta," +
            "coalesce(rpt_facilitador_planta_sobrevive.sobrevive,0)AS sobrevive," +
            "CONCAT(cad_cat_especie_subcategoria.nombre_comun, ' - ', cad_cat_especie_subcategoria.nombre_cientifico) AS nombre_planta," +
            "uf_main.name as nombre_facilitador " +
            "FROM rpt_facilitador_planta_avance " +
            "LEFT JOIN usuarios uf_main on uf_main.estructura_id =  rpt_facilitador_planta_avance.facilitador_id and uf_main.perfil_id in (8) " +
            "LEFT JOIN cad_cat_especie_subcategoria on rpt_facilitador_planta_avance.subcategoria_especie_id = cad_cat_especie_subcategoria.id " +
            "LEFT JOIN rpt_facilitador_planta_sobrevive ON " +
            "rpt_facilitador_planta_sobrevive.subcategoria_especie_id = cad_cat_especie_subcategoria.id AND " +
            "rpt_facilitador_planta_sobrevive.facilitador_id  = rpt_facilitador_planta_avance.facilitador_id " +
            "WHERE rpt_facilitador_planta_avance.facilitador_id =?1",
            nativeQuery = true)
    List<AvanceFacilitadorVO> findByAvancePlantaFacilitador(Long idFacilitador);
}
