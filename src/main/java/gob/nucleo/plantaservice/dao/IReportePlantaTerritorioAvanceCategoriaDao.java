package gob.nucleo.plantaservice.dao;

import gob.nucleo.plantacommons.entity.AvanceTecnicoCategoriaPlantaVO;
import gob.nucleo.plantacommons.entity.AvanceTerritorioCategoriaPlantaVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReportePlantaTerritorioAvanceCategoriaDao extends JpaRepository<AvanceTerritorioCategoriaPlantaVO, Long> {
    @Query(value = 
            "  SELECT  " +
            " row_number() OVER (ORDER BY rpt_territorio_planta_sobrevive_x_categoria.territorio_id) AS id, " +
            " rpt_territorio_planta_sobrevive_x_categoria.territorio_id, " +
            " cad_cat_especie_categoria.nombre, " +
            " rpt_territorio_planta_sobrevive_x_categoria.sobrevive " +
            " FROM rpt_territorio_planta_sobrevive_x_categoria  " +
            "  LEFT JOIN cad_cat_especie_categoria on cad_cat_especie_categoria.id = rpt_territorio_planta_sobrevive_x_categoria.categoria_id " +
            " where rpt_territorio_planta_sobrevive_x_categoria.territorio_id = ?1",
            nativeQuery = true)
    List<AvanceTerritorioCategoriaPlantaVO> findByAvancePlantaTerritorioXCategoria(Long idTerritorio);
}
