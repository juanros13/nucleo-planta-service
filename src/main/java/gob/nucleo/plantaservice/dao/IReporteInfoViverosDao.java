package gob.nucleo.plantaservice.dao;

import gob.nucleo.plantacommons.entity.InformacionViverosVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReporteInfoViverosDao extends JpaRepository<InformacionViverosVO, Long> {
    @Query(value = "SELECT row_number() OVER (ORDER BY territorios.id) AS id, " +
            "territorios.nombre as territorio, " +
            "us_territorial.estructura_id AS territorial_estructura_id, " +
            "us_territorial.name AS territorial_nombre, " +
            "uf.estructura_id as facilitador_id, " +
            "uf.name as facilitador, " +
            "up.estructura_id as tecnico_productivo_id, " +
            "up.name as tecnico_productivo, " +
            "us.estructura_id as tecnico_social_id, " +
            "us.name as tecnico_social, " +
            "TRIM(to_char(entidades.id,'00')) AS entidad_cve, " +
            "entidades.nombre as entidad, " +
            "TRIM(to_char(municipios.cve_mun,'000')) as municipio_cve, " +
            "municipios.nom_mun as municipio,   " +
            "TRIM(to_char(localidades.cve_loc,'0000')) as localidad_cve,  " +
            "localidades.nom_loc as localidad, " +
            "cad_vivero.id as vivero_id, " +
            "cad_vivero.nombre as vivero, " +
            "cad_vivero.superficie, " +
            "cad_vivero.numero, " +
            "cad_vivero.cp, " +
            "cad_vivero.calle, " +
            "cad_vivero.latitud, " +
            "cad_vivero.longitud, " +
            "cad_cat_vivero_status.status as estatus_vivero, " +
            "cad_cat_vivero_construccion.nombre as vivero_construido, " +
            "CASE " +
            "           WHEN cad_vivero.bitacora = '1' " +
            "                 THEN 'SI' " +
            "           WHEN cad_vivero.bitacora != '1'  " +
            " THEN 'NO' " +
            "       END bitacora, " +
            "CASE " +
            "           WHEN cad_vivero.bodega = '1' " +
            "                 THEN 'SI' " +
            "           WHEN cad_vivero.bodega != '1'  " +
            " THEN 'NO'  " +
            "       END bodega, " +
            "CASE " +
            "           WHEN cad_vivero.energia_e = '1' " +
            "                 THEN 'SI' " +
            "           WHEN cad_vivero.energia_e != '1'  " +
            " THEN 'NO' " +
            "       END energia_electrica, " +
            "cad_cat_vivero_acceso.nombre as acceso_vivero, " +
            "fueaguapri.nombre as fuente_agua_primario, " +
            "fueaguasec.nombre as fuente_agua_secundario, " +
            "fueaguater.nombre as fuente_agua_terciario, " +
            "cad_cat_vivero_riego_status.status as estatus_sistema_riego, " +
            "cad_vivero.porcentaje_avance as porcentaje_avance_establecimiento_riego, " +
            "cad_cat_vivero_riego_tipo.nombre as tipo_riego " +
            "FROM  cad_vivero " +
            "left join ( " +
            "select " +
            "vivero_cac.vivero_id, " +
            "binomio.facilitador_id, " +
            "binomio.tecnico_productivo_id, " +
            "binomio.tecnico_social_id " +
            "from cac " +
            "LEFT JOIN vivero_cac on vivero_cac.cac_id = cac.id " +
            "left join binomio on binomio.id = cac.binomio_id " +
            "WHERE cac.entidad_id is not null " +
            "GROUP BY vivero_cac.vivero_id, binomio.facilitador_id, binomio.tecnico_productivo_id, binomio.tecnico_social_id " +
            ") AS b on b.vivero_id = cad_vivero.id " +
            "LEFT JOIN usuarios uf on uf.estructura_id = b.facilitador_id and uf.perfil_id = 8 " +
            "LEFT JOIN usuarios us on us.estructura_id = b.tecnico_social_id  and us.perfil_id = 6 " +
            "LEFT JOIN usuarios up on up.estructura_id = b.tecnico_productivo_id and up.perfil_id = 5 " +
            "LEFT JOIN estructuras ON estructuras.id = b.facilitador_id " +
            "LEFT JOIN usuarios us_territorial ON us_territorial.estructura_id = estructuras.territorial_id AND us_territorial.perfil_id = 7 " +
            "LEFT JOIN estructuras est_territorial ON est_territorial.id = us_territorial.estructura_id " +
            "LEFT JOIN usuarios us_super ON us_super.estructura_id = est_territorial.supervisor_id AND us_super.perfil_id = 14 " +
            "left join entidades on entidades.id = cad_vivero.entidad_id " +
            "left join municipios on municipios.id = cad_vivero.municipio_id " +
            "LEFT JOIN localidades on localidades.id = cad_vivero.localidad_id " +
            "LEFT JOIN territorios on territorios.id = uf.territorio_id " +
            "LEFT JOIN cad_cat_vivero_status on cad_cat_vivero_status.id = cad_vivero.status_vivero_id " +
            "LEFT JOIN cad_cat_vivero_construccion on cad_cat_vivero_construccion.id = cad_vivero.construccion_vivero_id " +
            "LEFT JOIN cad_cat_vivero_acceso on cad_cat_vivero_acceso.id = cad_vivero.acceso_vivero_id " +
            "LEFT JOIN cad_cat_vivero_fuente_agua fueaguapri on fueaguapri.id = cad_vivero.fuente_agua1_id " +
            "LEFT JOIN cad_cat_vivero_fuente_agua fueaguasec on fueaguasec.id = cad_vivero.fuente_agua2_id " +
            "LEFT JOIN cad_cat_vivero_fuente_agua fueaguater on fueaguater.id = cad_vivero.fuente_agua3_id " +
            "LEFT JOIN cad_cat_vivero_riego_status on cad_cat_vivero_riego_status.id = cad_vivero.riego_status_id " +
            "LEFT JOIN cad_cat_vivero_riego_tipo on cad_cat_vivero_riego_tipo.id = cad_vivero.riego_tipo_id " +
            "where (cad_vivero.fuente_abast_id = 3) and (us_territorial.estructura_id = ?1 OR uf.estructura_id = ?2 OR up.estructura_id = ?3 OR us.estructura_id = ?4) " +
            "ORDER BY " +
            "us_territorial, " +
            "uf.estructura_id, " +
            "up.estructura_id, " +
            "cad_vivero.id " ,
            nativeQuery = true)
    List<InformacionViverosVO> findByInfoViverosXEstructuraId(Long idEstructura, Long idEstructura2, Long idEstructura3, Long idEstructura4);

    @Query(value = "SELECT row_number() OVER (ORDER BY territorios.id) AS id, " +
            "territorios.nombre as territorio, " +
            "us_territorial.estructura_id AS territorial_estructura_id, " +
            "us_territorial.name AS territorial_nombre, " +
            "uf.estructura_id as facilitador_id, " +
            "uf.name as facilitador, " +
            "up.estructura_id as tecnico_productivo_id, " +
            "up.name as tecnico_productivo, " +
            "us.estructura_id as tecnico_social_id, " +
            "us.name as tecnico_social, " +
            "TRIM(to_char(entidades.id,'00')) AS entidad_cve, " +
            "entidades.nombre as entidad, " +
            "TRIM(to_char(municipios.cve_mun,'000')) as municipio_cve, " +
            "municipios.nom_mun as municipio,   " +
            "TRIM(to_char(localidades.cve_loc,'0000')) as localidad_cve,  " +
            "localidades.nom_loc as localidad, " +
            "cad_vivero.id as vivero_id, " +
            "cad_vivero.nombre as vivero, " +
            "cad_vivero.superficie, " +
            "cad_vivero.numero, " +
            "cad_vivero.cp, " +
            "cad_vivero.calle, " +
            "cad_vivero.latitud, " +
            "cad_vivero.longitud, " +
            "cad_cat_vivero_status.status as estatus_vivero, " +
            "cad_cat_vivero_construccion.nombre as vivero_construido, " +
            "CASE " +
            "           WHEN cad_vivero.bitacora = '1' " +
            "                 THEN 'SI' " +
            "           WHEN cad_vivero.bitacora != '1'  " +
            " THEN 'NO' " +
            "       END bitacora, " +
            "CASE " +
            "           WHEN cad_vivero.bodega = '1' " +
            "                 THEN 'SI' " +
            "           WHEN cad_vivero.bodega != '1'  " +
            " THEN 'NO'  " +
            "       END bodega, " +
            "CASE " +
            "           WHEN cad_vivero.energia_e = '1' " +
            "                 THEN 'SI' " +
            "           WHEN cad_vivero.energia_e != '1'  " +
            " THEN 'NO' " +
            "       END energia_electrica, " +
            "cad_cat_vivero_acceso.nombre as acceso_vivero, " +
            "fueaguapri.nombre as fuente_agua_primario, " +
            "fueaguasec.nombre as fuente_agua_secundario, " +
            "fueaguater.nombre as fuente_agua_terciario, " +
            "cad_cat_vivero_riego_status.status as estatus_sistema_riego, " +
            "cad_vivero.porcentaje_avance as porcentaje_avance_establecimiento_riego, " +
            "cad_cat_vivero_riego_tipo.nombre as tipo_riego " +
            "FROM  cad_vivero " +
            "left join ( " +
            "select " +
            "vivero_cac.vivero_id, " +
            "binomio.facilitador_id, " +
            "binomio.tecnico_productivo_id, " +
            "binomio.tecnico_social_id " +
            "from cac " +
            "LEFT JOIN vivero_cac on vivero_cac.cac_id = cac.id " +
            "left join binomio on binomio.id = cac.binomio_id " +
            "WHERE cac.entidad_id is not null " +
            "GROUP BY vivero_cac.vivero_id, binomio.facilitador_id, binomio.tecnico_productivo_id, binomio.tecnico_social_id " +
            ") AS b on b.vivero_id = cad_vivero.id " +
            "LEFT JOIN usuarios uf on uf.estructura_id = b.facilitador_id and uf.perfil_id = 8 " +
            "LEFT JOIN usuarios us on us.estructura_id = b.tecnico_social_id  and us.perfil_id = 6 " +
            "LEFT JOIN usuarios up on up.estructura_id = b.tecnico_productivo_id and up.perfil_id = 5 " +
            "LEFT JOIN estructuras ON estructuras.id = b.facilitador_id " +
            "LEFT JOIN usuarios us_territorial ON us_territorial.estructura_id = estructuras.territorial_id AND us_territorial.perfil_id = 7 " +
            "LEFT JOIN estructuras est_territorial ON est_territorial.id = us_territorial.estructura_id " +
            "LEFT JOIN usuarios us_super ON us_super.estructura_id = est_territorial.supervisor_id AND us_super.perfil_id = 14 " +
            "left join entidades on entidades.id = cad_vivero.entidad_id " +
            "left join municipios on municipios.id = cad_vivero.municipio_id " +
            "LEFT JOIN localidades on localidades.id = cad_vivero.localidad_id " +
            "LEFT JOIN territorios on territorios.id = uf.territorio_id " +
            "LEFT JOIN cad_cat_vivero_status on cad_cat_vivero_status.id = cad_vivero.status_vivero_id " +
            "LEFT JOIN cad_cat_vivero_construccion on cad_cat_vivero_construccion.id = cad_vivero.construccion_vivero_id " +
            "LEFT JOIN cad_cat_vivero_acceso on cad_cat_vivero_acceso.id = cad_vivero.acceso_vivero_id " +
            "LEFT JOIN cad_cat_vivero_fuente_agua fueaguapri on fueaguapri.id = cad_vivero.fuente_agua1_id " +
            "LEFT JOIN cad_cat_vivero_fuente_agua fueaguasec on fueaguasec.id = cad_vivero.fuente_agua2_id " +
            "LEFT JOIN cad_cat_vivero_fuente_agua fueaguater on fueaguater.id = cad_vivero.fuente_agua3_id " +
            "LEFT JOIN cad_cat_vivero_riego_status on cad_cat_vivero_riego_status.id = cad_vivero.riego_status_id " +
            "LEFT JOIN cad_cat_vivero_riego_tipo on cad_cat_vivero_riego_tipo.id = cad_vivero.riego_tipo_id " +
            "WHERE cad_vivero.fuente_abast_id = 3 ORDER BY " +
            "us_territorial, " +
            "uf.estructura_id, " +
            "up.estructura_id, " +
            "cad_vivero.id ",
            nativeQuery = true)
    List<InformacionViverosVO> findByInfoViveros();
}
