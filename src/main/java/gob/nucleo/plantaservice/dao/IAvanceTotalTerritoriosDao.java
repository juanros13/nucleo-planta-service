package gob.nucleo.plantaservice.dao;

import gob.nucleo.plantacommons.entity.AvanceFacilitadorVO;
import gob.nucleo.plantacommons.entity.AvanceTotalTerritoriosVO;
import gob.nucleo.viverocommons.entity.CatEspecieCategoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IAvanceTotalTerritoriosDao extends JpaRepository<AvanceTotalTerritoriosVO, Long> {

    @Query(value = "SELECT  " +
            " territorios.id,  " +
            " territorios.nombre as territorio,  " +
            " territorios.meta_planta as meta_planta_calculada,  " +
            " d.cantidad_meta_disenio as meta_planta_disenio_beneficiario, " +
            " b.cantidad_sobrevive as planta_sobrevive ,  " +
            " c.planta_en_vivero as planta_en_vivero,  " +
            " c.planta_en_vivero + b.cantidad_sobrevive AS total_territorio, " +
            "  territorios.meta_planta -(c.planta_en_vivero + b.cantidad_sobrevive) AS faltante " +
            "FROM territorios " +
            "LEFT JOIN ( " +
            " SELECT territorios.id,  sum(cad_planta_parcela.cantidad_sobrevive) as cantidad_sobrevive " +
            " from cad_planta_parcela " +
            " LEFT JOIN cad_diseno_agroforestal ON cad_diseno_agroforestal.id = cad_planta_parcela.diseno_agroforestal_id " +
            " LEFT JOIN cad_predio ON cad_predio.id = cad_diseno_agroforestal.predio_id " +
            " LEFT JOIN cad_cat_especie ON cad_cat_especie.id = cad_planta_parcela.especie_id " +
            " LEFT JOIN cad_cat_especie_subcategoria ON cad_cat_especie_subcategoria.id = cad_cat_especie.subcategoria_especie_id " +
            " LEFT JOIN beneficiarios ON beneficiarios.id = cad_predio.registro_id " +
            " LEFT JOIN usuarios ut ON ut.estructura_id = beneficiarios.estructura_id  " +
            " LEFT JOIN usuarios uf ON uf.id = ut.facilitador_id " +
            " LEFT JOIN territorios ON territorios.id = ut.territorio_id " +
            "GROUP BY  " +
            "territorios.id " +
            ")b ON b.id = territorios.id " +
            " " +
            "LEFT JOIN ( " +
            " SELECT  " +
            " territorios.id, " +
            " SUM(cad_vivero_planta.cantidad_semillero) + SUM(cad_vivero_planta.cantidad_desarrollo) + SUM(cad_vivero_planta.cantidad_lista_extraer) AS planta_en_vivero " +
            " from cad_vivero " +
            " LEFT JOIN cad_vivero_planta ON cad_vivero_planta.vivero_id = cad_vivero.id " +
            " LEFT JOIN cad_cat_especie ON cad_cat_especie.id = cad_vivero_planta.especie_id " +
            " LEFT JOIN cad_cat_especie_subcategoria ON cad_cat_especie_subcategoria.id = cad_cat_especie.subcategoria_especie_id " +
            " LEFT JOIN cac ON cad_vivero_planta.cac_id = cac.id " +
            " LEFT JOIN binomio ON binomio.id = cac.binomio_id " +
            " LEFT JOIN usuarios uf ON uf.estructura_id = binomio.facilitador_id AND uf.perfil_id =8 " +
            " LEFT JOIN usuarios up ON up.estructura_id = binomio.tecnico_productivo_id  AND up.perfil_id =5 " +
            " LEFT JOIN usuarios us ON us.estructura_id = binomio.tecnico_social_id  AND us.perfil_id =6 " +
            " LEFT JOIN territorios ON territorios.id = uf.territorio_id " +
            " WHERE cad_vivero_planta.fuente_abast_id = 3  " +
            " GROUP BY " +
            " territorios.id " +
            ")c ON c.id = territorios.id " +
            "LEFT JOIN ( " +
            " SELECT territorios.id,  sum(cad_diseno_agroforestal.cantidad_meta) as cantidad_meta_disenio " +
            "  from cad_diseno_agroforestal " +
            "  LEFT JOIN cad_predio ON cad_predio.id = cad_diseno_agroforestal.predio_id " +
            "  LEFT JOIN cad_cat_especie_subcategoria ON cad_cat_especie_subcategoria.id = cad_diseno_agroforestal.subcategoria_especie_id " +
            "  LEFT JOIN beneficiarios ON beneficiarios.id = cad_predio.registro_id " +
            "  LEFT JOIN usuarios ut ON ut.estructura_id = beneficiarios.estructura_id AND ut.perfil_id in(5,6) " +
            "  LEFT JOIN territorios ON territorios.id = ut.territorio_id " +

            " GROUP BY  " +
            " territorios.id " +
            ")d ON d.id = territorios.id " +
            "ORDER BY territorios.nombre",
            nativeQuery = true)
    List<AvanceTotalTerritoriosVO> findByAvanceTotalTerritorio();
}
