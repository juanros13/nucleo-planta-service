package gob.nucleo.plantaservice.dao;

import gob.nucleo.plantacommons.entity.AvanceViverosMilitaresTerritorioVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReporteViverosMilitaresAvanceTerritorioDao extends JpaRepository<AvanceViverosMilitaresTerritorioVO, Long> {
    @Query(value = "SELECT row_number() OVER (ORDER BY cad_cat_especie.id) AS id, " +
            "territorios.nombre as territorio, cad_cat_fuente_abast.nombre as origen, cad_vivero.id as vivero_id, " +
            "cad_vivero.nombre as vivero, cad_cat_especie.id as especie_id, " +
            "concat(cad_cat_especie.nombre_comun,' - ',cad_cat_especie.variedad,' (', cad_cat_especie.nombre_cientifico,') ') as especie, " +
            "coalesce(cad_vivero_planta.cantidad_total,0) as cantidad_convenida,  " +
            "coalesce(b.total_entregada,0) as total_entregada " +
            "FROM cad_vivero_planta " +
            "left join cad_vivero on cad_vivero.id = cad_vivero_planta.vivero_id " +
            "left join cad_cat_fuente_abast on cad_cat_fuente_abast.id = cad_vivero_planta.fuente_abast_id " +
            "left join territorios on territorios.id = cad_vivero_planta.territorio_id " +
            "left join cad_cat_especie on cad_cat_especie.id = cad_vivero_planta.especie_id " +
            "left join cad_cat_especie_subcategoria on cad_cat_especie_subcategoria.id = cad_cat_especie.subcategoria_especie_id " +
            "left join cad_cat_especie_categoria on cad_cat_especie_categoria.id = cad_cat_especie_subcategoria.categoria_id " +
            "left join (" +
            "select territorios.id as territorio_id, cad_planta_parcela.vivero_id, cad_planta_parcela.especie_id, " +
            "sum(cad_planta_parcela.cantidad_entregada) as total_entregada from cad_planta_parcela " +
            "left join beneficiarios on beneficiarios.id = cad_planta_parcela.beneficiario_id " +
            "left join usuarios on usuarios.id = beneficiarios.tecnico_id " +
            "left join territorios on territorios.id = usuarios.territorio_id " +
            "GROUP BY territorios.id, cad_planta_parcela.vivero_id, cad_planta_parcela.especie_id" +
            ") b on b.territorio_id = territorios.id and b.vivero_id = cad_vivero.id and b.especie_id = cad_cat_especie.id " +
            "where cad_vivero_planta.fuente_abast_id = 2 " +
            "and territorios.id = ?1 " +
            "order by territorios.nombre, cad_vivero.nombre " ,
            nativeQuery = true)
    List<AvanceViverosMilitaresTerritorioVO> findByAvanceViverosMilitaresTerritorio(Long idTerritorio);

    @Query(value = "SELECT row_number() OVER (ORDER BY cad_cat_especie.id) AS id, " +
            "territorios.nombre as territorio, cad_cat_fuente_abast.nombre as origen, cad_vivero.id as vivero_id, " +
            "cad_vivero.nombre as vivero, cad_cat_especie.id as especie_id, " +
            "concat(cad_cat_especie.nombre_comun,' - ',cad_cat_especie.variedad,' (', cad_cat_especie.nombre_cientifico,') ') as especie, " +
            "coalesce(cad_vivero_planta.cantidad_total,0) as cantidad_convenida,  " +
            "coalesce(b.total_entregada,0) as total_entregada " +
            "FROM cad_vivero_planta " +
            "left join cad_vivero on cad_vivero.id = cad_vivero_planta.vivero_id " +
            "left join cad_cat_fuente_abast on cad_cat_fuente_abast.id = cad_vivero_planta.fuente_abast_id " +
            "left join territorios on territorios.id = cad_vivero_planta.territorio_id " +
            "left join cad_cat_especie on cad_cat_especie.id = cad_vivero_planta.especie_id " +
            "left join cad_cat_especie_subcategoria on cad_cat_especie_subcategoria.id = cad_cat_especie.subcategoria_especie_id " +
            "left join cad_cat_especie_categoria on cad_cat_especie_categoria.id = cad_cat_especie_subcategoria.categoria_id " +
            "left join (" +
            "select territorios.id as territorio_id, cad_planta_parcela.vivero_id, cad_planta_parcela.especie_id, " +
            "sum(cad_planta_parcela.cantidad_entregada) as total_entregada from cad_planta_parcela " +
            "left join beneficiarios on beneficiarios.id = cad_planta_parcela.beneficiario_id " +
            "left join usuarios on usuarios.id = beneficiarios.tecnico_id " +
            "left join territorios on territorios.id = usuarios.territorio_id " +
            "GROUP BY territorios.id, cad_planta_parcela.vivero_id, cad_planta_parcela.especie_id" +
            ") b on b.territorio_id = territorios.id and b.vivero_id = cad_vivero.id and b.especie_id = cad_cat_especie.id " +
            "where cad_vivero_planta.fuente_abast_id = 2 " +
            "order by territorios.nombre, cad_vivero.nombre " ,
            nativeQuery = true)
    List<AvanceViverosMilitaresTerritorioVO> findByAvanceViverosMilitares();
}
