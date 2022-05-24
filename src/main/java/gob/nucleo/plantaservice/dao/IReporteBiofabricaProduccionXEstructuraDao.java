package gob.nucleo.plantaservice.dao;

import gob.nucleo.plantacommons.entity.BiofabricaProduccionXEstructuraVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReporteBiofabricaProduccionXEstructuraDao extends JpaRepository<BiofabricaProduccionXEstructuraVO, Long> {
    @Query(value = "SELECT row_number() OVER (ORDER BY cad_vivero.id) AS id, " +
            "territorios.nombre as territorio, " +
            "us_territorial.estructura_id AS territorial_estructura_id, " +
            "us_territorial.name AS territorial_nombre, " +
            "uf.estructura_id as facilitador_id, " +
            "uf.name as facilitador, " +
            "binomio.id as binomio_id, " +
            "tp.estructura_id as tecnico_productivo_id, " +
            "tp.name as tecnico_productivo, " +
            "ts.estructura_id as tecnico_social_id, " +
            "ts.name as tecnico_social, " +
            "entidades.nombre as entidad, " +
            "municipios.nom_mun as municipio, " +
            "cad_vivero.id as vivero_id, " +
            "cad_vivero.nombre AS vivero, " +
            "cac.id as cac_id, " +
            "cac.nombre as cac, " +
            "cad_cat_biofabrica_categoria_producto.nombre as categoria, " +
            "cad_cat_biofabrica_producto.nombre as producto, " +
            "sum(cad_biofabrica_produccion.cantidad) as cantidad, " +
            "cad_cat_biofabrica_medida.unidad_de_medida, " +
            "cad_cat_biofabrica_aplicacion.nombre as aplicacion, " +
            "cad_biofabrica_produccion.fecha_elaboracion " +
            "FROM cad_vivero " +
            "left join cad_biofabrica on cad_biofabrica.vivero_id = cad_vivero.id " +
            "LEFT JOIN cad_biofabrica_produccion on cad_biofabrica_produccion.biofabrica_id = cad_biofabrica.id " +
            "LEFT JOIN cad_cat_biofabrica_producto on cad_cat_biofabrica_producto.id = cad_biofabrica_produccion.producto_id " +
            "LEFT JOIN cad_cat_biofabrica_categoria_producto on cad_cat_biofabrica_categoria_producto.id = cad_cat_biofabrica_producto.categoria_producto_id " +
            "LEFT JOIN cad_cat_biofabrica_medida on cad_cat_biofabrica_medida.id = cad_biofabrica_produccion.unidad_medida_id " +
            "LEFT JOIN cad_cat_biofabrica_aplicacion on cad_cat_biofabrica_aplicacion.id = cad_biofabrica_produccion.aplicacion_id " +
            "left join cac on cac.id = cad_biofabrica_produccion.cac_id " +
            "left join entidades on entidades.id = cad_vivero.entidad_id " +
            "left join municipios on municipios.id = cad_vivero.municipio_id " +
            "left join binomio on binomio.id = cac.binomio_id " +
            " LEFT JOIN estructuras ON estructuras.id = binomio.facilitador_id " +
            "LEFT JOIN usuarios uf ON uf.estructura_id = binomio.facilitador_id AND uf.perfil_id = 8 " +
            "LEFT JOIN usuarios tp ON tp.estructura_id = binomio.tecnico_productivo_id AND tp.perfil_id = 5 " +
            "LEFT JOIN usuarios ts ON ts.estructura_id = binomio.tecnico_social_id AND ts.perfil_id = 6 " +
            "LEFT JOIN usuarios us_territorial ON us_territorial.estructura_id = estructuras.territorial_id AND us_territorial.perfil_id = 7 " +
            "LEFT JOIN estructuras est_territorial ON est_territorial.id = us_territorial.estructura_id " +
            "left join territorios on territorios.id = uf.territorio_id " +
            "where cad_biofabrica_produccion.cantidad is not null and territorios.nombre is not null " +
            "and (us_territorial.estructura_id = ?1 OR uf.estructura_id = ?2 OR tp.estructura_id = ?3 OR ts.estructura_id = ?4) " +
            "GROUP BY territorios.nombre, " +
            "us_territorial.estructura_id, " +
            "us_territorial.name, " +
            "cad_cat_biofabrica_categoria_producto.nombre, " +
            "cad_cat_biofabrica_producto.nombre, " +
            "cad_cat_biofabrica_medida.unidad_de_medida, municipios.nom_mun, " +
            "cad_biofabrica_produccion.fecha_elaboracion, " +
            "cad_cat_biofabrica_aplicacion.nombre, " +
            "uf.id, " +
            "uf.name, " +
            "cad_vivero.id, " +
            "cad_vivero.nombre, " +
            "cac.id , " +
            "cac.nombre, " +
            "entidades.nombre, " +
            "municipios.nom_mun, " +
            "cad_cat_biofabrica_producto.id, " +
            "cad_cat_biofabrica_medida.id, " +
            "binomio.id , " +
            "tp.estructura_id , " +
            "tp.name , " +
            "ts.estructura_id, " +
            "ts.name " +
            "ORDER BY " +
            "uf.id, " +
            "cad_vivero.id, " +
            "cad_vivero.nombre  " ,
            nativeQuery = true)
    List<BiofabricaProduccionXEstructuraVO> findByInfoBiofabricaProduccionXEstructura(
            Long idEstructura,
            Long idEstructura2,
            Long idEstructura3,
            Long idEstructura4);
}
