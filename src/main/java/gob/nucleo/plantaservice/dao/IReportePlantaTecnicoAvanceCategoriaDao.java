package gob.nucleo.plantaservice.dao;

import gob.nucleo.plantacommons.entity.AvanceTecnicoCategoriaPlantaVO;
import gob.nucleo.plantacommons.entity.AvanceTecnicoVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReportePlantaTecnicoAvanceCategoriaDao extends JpaRepository<AvanceTecnicoCategoriaPlantaVO, Long> {
    @Query(value = 
            "   SELECT   " +
                    "  row_number() OVER (ORDER BY rpt_tecnico_planta_sobrevive_x_categoria.tecnico_id) AS id,  " +
                    "  rpt_tecnico_planta_sobrevive_x_categoria.tecnico_id,  " +
                    "  cad_cat_especie_categoria.nombre,  " +
                    "  rpt_tecnico_planta_sobrevive_x_categoria.sobrevive  " +
                    "  FROM rpt_tecnico_planta_sobrevive_x_categoria   " +
                    "  LEFT JOIN cad_cat_especie_categoria on cad_cat_especie_categoria.id = rpt_tecnico_planta_sobrevive_x_categoria.categoria_id  " +
                    "  where tecnico_id = ?1",
            nativeQuery = true)
    List<AvanceTecnicoCategoriaPlantaVO> findByAvancePlantaTecnicoXCategoria(Long idTecnico);
}
