package gob.nucleo.plantaservice.dao;

import gob.nucleo.plantacommons.entity.SobreviveCategoriaFacilitadorVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISobrevivePlantaFalicitadorDao extends JpaRepository<SobreviveCategoriaFacilitadorVO, Long> {
    @Query(value = "SELECT " +
            "row_number() OVER (ORDER BY rpt_facilitador_planta_sobrevive_x_categoria.facilitador_id) AS id, " +
            "rpt_facilitador_planta_sobrevive_x_categoria.facilitador_id," +
            "cad_cat_especie_categoria.nombre," +
            "rpt_facilitador_planta_sobrevive_x_categoria.sobrevive " +
            "FROM rpt_facilitador_planta_sobrevive_x_categoria " +
            "LEFT JOIN cad_cat_especie_categoria on cad_cat_especie_categoria.id = rpt_facilitador_planta_sobrevive_x_categoria.categoria_id " +
            "where facilitador_id =?1",
            nativeQuery = true)
    List<SobreviveCategoriaFacilitadorVO> findBySobrevivePlantaFalicitador(Long idFacilitador);
}
