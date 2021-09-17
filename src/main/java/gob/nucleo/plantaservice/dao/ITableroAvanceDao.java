package gob.nucleo.plantaservice.dao;

import gob.nucleo.plantacommons.entity.TableroAvance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITableroAvanceDao extends JpaRepository<TableroAvance, Long> {
    List<TableroAvance> findByBeneficiarioId(Long beneficiarioId);

    @Query(
            value = "SELECT \n" +
                    "row_number() OVER (ORDER BY cad_predio.registro_id) AS id,\n" +
                    "cad_predio.registro_id AS beneficiario_id, " +
                    "cad_cat_especie_categoria.nombre as especie_categoria, " +
                    "count(*) as total_registros, \n" +
                    "sum(cad_diseno_agroforestal.cantidad_meta) as cantidad_meta, \n" +
                    "sum(cad_diseno_agroforestal.cantidad_avance) as cantidad_avance\n" +
                    "FROM  cad_predio\n" +
                    "left join cad_diseno_agroforestal on cad_predio.id = cad_diseno_agroforestal.predio_id \n" +
                    "left join cad_cat_especie_subcategoria on cad_cat_especie_subcategoria.id = cad_diseno_agroforestal.subcategoria_especie_id\n" +
                    "left join cad_cat_especie_categoria on cad_cat_especie_categoria.id = cad_cat_especie_subcategoria.categoria_id\n" +
                    "WHERE cad_predio.registro_id = ?1 \n" +
                    "group by cad_predio.registro_id, cad_cat_especie_categoria.nombre\n",
            nativeQuery = true)
    List<TableroAvance>findByBeneficiarioIdNative(Long idBeneficiario);
}
