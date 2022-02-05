package gob.nucleo.plantaservice.dao;

import gob.nucleo.plantacommons.entity.AvanceTecnicoVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReportePlantaTecnicoAvanceDao extends JpaRepository<AvanceTecnicoVO, Long> {
    @Query(value = 
            " SELECT   " +
            " row_number() OVER (ORDER BY ut_main.facilitador_id) AS id, " +
            " rpt_tecnico_planta_avance.tecnico_id, " +
            " rpt_tecnico_planta_avance.subcategoria_especie_id, " +
            " coalesce(rpt_tecnico_planta_avance.meta,0) AS meta, " +
            " coalesce(rpt_tecnico_planta_sobrevive.sobrevive,0) as sobrevive, " +
            " cad_cat_especie_categoria.nombre AS categoria, " +
            " CONCAT(cad_cat_especie_subcategoria.nombre_comun, ' - ', cad_cat_especie_subcategoria.nombre_cientifico) AS nombre_planta, " +
            " ut_main.name as nombre_tecnico " +
            " FROM rpt_tecnico_planta_avance " +
            "LEFT JOIN usuarios ut_main on ut_main.estructura_id =  rpt_tecnico_planta_avance.tecnico_id and ut_main.perfil_id in (5,6) " +
            " LEFT JOIN cad_cat_especie_subcategoria on rpt_tecnico_planta_avance.subcategoria_especie_id = cad_cat_especie_subcategoria.id " +
            " LEFT JOIN cad_cat_especie_categoria on cad_cat_especie_categoria.id = cad_cat_especie_subcategoria.categoria_id  " +
            " LEFT JOIN rpt_tecnico_planta_sobrevive ON  " +
            " rpt_tecnico_planta_sobrevive.subcategoria_especie_id = cad_cat_especie_subcategoria.id AND " +
            " rpt_tecnico_planta_sobrevive.tecnico_id  = rpt_tecnico_planta_avance.tecnico_id " +
            " WHERE rpt_tecnico_planta_avance.tecnico_id = ?1 ",
            nativeQuery = true)
    List<AvanceTecnicoVO> findByAvancePlantaTecnicoXEspecie(Long idTecnico);
}
