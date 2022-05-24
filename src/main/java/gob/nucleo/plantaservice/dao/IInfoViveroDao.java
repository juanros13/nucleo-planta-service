package gob.nucleo.plantaservice.dao;

import gob.nucleo.plantacommons.entity.ViveroVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IInfoViveroDao extends JpaRepository<ViveroVO, Long> {
    @Query(value = "SELECT row_number() OVER (ORDER BY cad_biofabrica.id) AS id, " +
            "cad_biofabrica.id as biofabrica_id, " +
            "cad_vivero.nombre AS vivero, " +
            "cac.id as cac_id, " +
            "cac.nombre as cac, " +
            "cad_cat_biofabrica_categoria_producto.nombre as categoria, " +
            "cad_cat_biofabrica_producto.nombre as producto, " +
            "sum(cad_biofabrica_produccion.cantidad) as cantidad, " +
            "cad_cat_biofabrica_medida.unidad_de_medida, " +
            "cad_cat_biofabrica_aplicacion.nombre as aplicacion, " +
            "cad_biofabrica_produccion.fecha_elaboracion " +
            "FROM cad_biofabrica " +
            "LEFT JOIN cad_vivero on cad_vivero.id = cad_biofabrica.vivero_id " +
            "LEFT JOIN cad_biofabrica_produccion on cad_biofabrica_produccion.biofabrica_id = cad_biofabrica.id " +
            "LEFT JOIN cad_cat_biofabrica_producto on cad_cat_biofabrica_producto.id = cad_biofabrica_produccion.producto_id " +
            "LEFT JOIN cad_cat_biofabrica_categoria_producto on cad_cat_biofabrica_categoria_producto.id = cad_cat_biofabrica_producto.categoria_producto_id " +
            "LEFT JOIN cad_cat_biofabrica_medida on cad_cat_biofabrica_medida.id = cad_biofabrica_produccion.unidad_medida_id " +
            "LEFT JOIN cad_cat_biofabrica_aplicacion on cad_cat_biofabrica_aplicacion.id = cad_biofabrica_produccion.aplicacion_id " +
            "left join cac on cac.id = cad_biofabrica_produccion.cac_id " +
            "where cad_biofabrica_produccion.cantidad is not null  and cad_biofabrica.id = ?1 " +
            "GROUP BY " +
            "cad_biofabrica.id, " +
            "cad_vivero.nombre, " +
            "cac.id, " +
            "cac.nombre, " +
            "cad_cat_biofabrica_categoria_producto.nombre , " +
            "cad_cat_biofabrica_producto.nombre , " +
            "cad_cat_biofabrica_medida.unidad_de_medida, " +
            "cad_cat_biofabrica_aplicacion.nombre, " +
            "cad_biofabrica_produccion.fecha_elaboracion " +
            "ORDER BY " +
            "cac.id, " +
            "cad_cat_biofabrica_categoria_producto.nombre" ,
            nativeQuery = true)
    List<ViveroVO> findByIdBiofabrica(Long idBiofabrica);

}
