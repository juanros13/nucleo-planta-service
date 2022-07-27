package gob.nucleo.plantaservice.dao;

import gob.nucleo.plantacommons.entity.InformacionCacsVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReporteInfoCacsDao extends JpaRepository<InformacionCacsVO, Long> {
    @Query(value = "SELECT row_number() OVER (ORDER BY cac.id) AS id, " +
            "  us_fac.estructura_id AS facicilitador_estructura_id, " +
            "us_fac.name AS facilitador_nombre,  " +
            "us_tp.estructura_id AS tecnico_productivo_estructura_id, " +
            "us_tp.name AS tecnico_productivo_estructura_nombre, " +
            "binomio.id AS binomio_id, " +
            "us_ts.estructura_id AS tecnico_social_id, " +
            "us_ts.name AS tecnico_social_nombre, " +
            "us_territorial.estructura_id AS territorial_estructura_id, " +
            "us_territorial.name AS territorial_nombre, " +
            "  TRIM(to_char(entidades.id,'00')) AS entidad_cve, " +
            "  entidades.nombre as entidad, " +
            "  TRIM(to_char(municipios.cve_mun,'000')) as municipio_cve, " +
            "  municipios.nom_mun as municipio,   " +
            "  TRIM(to_char(localidades.cve_loc,'0000')) as localidad_cve,  " +
            "  localidades.nom_loc as localidad,  " +
            "  concat('Calle ',cac.calle,', No. Ext. ',cac.exterior,',No. Int. ',cac.interior,', Colonia ',cac.colonia,' CP.',cac.cp) as direccion, " +
            "  cac.id as cac_id, " +
            "  cac.nombre as cac," +
            "  cac.clave as cac_clave, " +
            "  cac.latitud_reunion_cac, " +
            "  cac.longitud_reunion_cac,   " +
            "  concat(bco.nombres,' ',bco.apellido_paterno,' ',bco.apellido_materno) as coordinador, " +
            "  concat(bse.nombres,' ',bse.apellido_paterno,' ',bse.apellido_materno) as secretario,  " +
            "  concat(bcv.nombres,' ',bcv.apellido_paterno,' ',bcv.apellido_materno) as comisionado_viveros,   " +
            "  concat(bte.nombres,' ',bte.apellido_paterno,' ',bte.apellido_materno) as tesorero, " +
            "  concat(bpt.nombres,' ',bpt.apellido_paterno,' ',bpt.apellido_materno) as planes_trabajo, " +
            "  concat(bbio.nombres,' ',bbio.apellido_paterno,' ',bbio.apellido_materno) as biofabrica, " +
            "  concat(baho.nombres,' ',baho.apellido_paterno,' ',baho.apellido_materno) as ahorro,   " +
            "  concat(bsus.nombres,' ',bsus.apellido_paterno,' ',bsus.apellido_materno) as sustentabilidad, " +
            "  concat(bedu.nombres,' ',bedu.apellido_paterno,' ',bedu.apellido_materno) as educacion, " +
            "  concat(btra.nombres,' ',btra.apellido_paterno,' ',btra.apellido_materno) as transparencia,  " +
            "  concat(bctr.nombres,' ',bctr.apellido_paterno,' ',bctr.apellido_materno) as contraloria_social, " +
            "  cac.comision_otro_uno_nombre as comision1, " +
            "  concat(botu.nombres,' ',botu.apellido_paterno,' ',botu.apellido_materno) as comisionado_euno, " +
            "  cac.comision_otro_uno_nombre as comision2, " +
            "  concat(botd.nombres,' ',botd.apellido_paterno,' ',botd.apellido_materno) as comisionado_edos,   " +
            "  cac.comision_otro_uno_nombre as comision3, " +
            "  concat(bott.nombres,' ',bott.apellido_paterno,' ',bott.apellido_materno) as comisionado_etres   " +
            "   FROM ((((((((cac   " +
            " LEFT JOIN binomio ON ((binomio.id = cac.binomio_id))) " +
            " LEFT JOIN estructuras ON ((estructuras.id = binomio.facilitador_id))) " +
            " LEFT JOIN usuarios us_fac ON (((us_fac.estructura_id = binomio.facilitador_id) AND (us_fac.perfil_id = 8))))  " +
            " LEFT JOIN usuarios us_tp ON (((us_tp.estructura_id = binomio.tecnico_productivo_id) AND (us_tp.perfil_id = 5)))) " +
            " LEFT JOIN usuarios us_ts ON (((us_ts.estructura_id = binomio.tecnico_social_id) AND (us_ts.perfil_id = 6))))  " +
            " LEFT JOIN usuarios us_territorial ON (((us_territorial.estructura_id = estructuras.territorial_id) AND (us_territorial.perfil_id = 7)))) " +
            " LEFT JOIN estructuras est_territorial ON ((est_territorial.id = us_territorial.estructura_id))) " +
            " LEFT JOIN usuarios us_super ON (((us_super.estructura_id = est_territorial.supervisor_id) AND (us_super.perfil_id = 14))))  " +
            " left join entidades on entidades.\"id\" = cac.entidad_id   " +
            " left join municipios on municipios.id = cac.municipio_id " +
            " LEFT JOIN localidades on localidades.id = cac.localidad_id " +
            " left join beneficiarios bco on bco.id = cac.coordinador_id " +
            "   left join beneficiarios bse on bse.id = cac.secretario_actas_id " +
            "   left join beneficiarios bcv on bcv.id = cac.comisionado_viveros_id " +
            "   LEFT JOIN beneficiarios bte on   bte.id   =  cac.tesorero_id   " +
            "   LEFT JOIN beneficiarios bpt  on   bpt.id   =  cac.planes_trabajo_id " +
            "   LEFT JOIN beneficiarios  bbio on   bbio.id   =  cac.biofabrica_id  " +
            "   LEFT JOIN beneficiarios  baho on   baho.id   =  cac.ahorro_id " +
            "   LEFT JOIN beneficiarios bsus on   bsus.id   =  cac.sustentabilidad_id " +
            "   LEFT JOIN beneficiarios bedu  on  bedu.id=  cac.educacion_id   " +
            "   LEFT JOIN beneficiarios  btra on  btra.id=  cac.transparencia_id " +
            "   LEFT JOIN beneficiarios bctr on  bctr.id=  cac.contraloria_social_id " +
            "   LEFT JOIN beneficiarios botu on  botu.id=  cac.comision_otro_uno_id  " +
            "   LEFT JOIN beneficiarios botd on  botd.id=  cac.comision_otro_dos_id  " +
            "   LEFT JOIN beneficiarios bott on  bott.id=  cac.comision_otro_tres_id " +
            "where us_fac.estructura_id = ?1 or us_tp.estructura_id = ?2 or us_ts.estructura_id = ?3 or us_territorial.estructura_id = ?4 " +
            "  ORDER BY cac.id " ,
            nativeQuery = true)
    List<InformacionCacsVO> findByInfoCacsXEstructuraId(Long idEstructura, Long idEstructura2, Long idEstructura3, Long idEstructura4);

    @Query(value = "SELECT row_number() OVER (ORDER BY cac.id) AS id,  " +
            "              us_fac.estructura_id AS facicilitador_estructura_id,  " +
            "            us_fac.name AS facilitador_nombre,   " +
            "            us_tp.estructura_id AS tecnico_productivo_estructura_id,  " +
            "            us_tp.name AS tecnico_productivo_estructura_nombre,  " +
            "            us_ts.estructura_id AS tecnico_productivo_social_id,  " +
            "            us_ts.name AS tecnico_productivo_social_nombre,  " +
            "            us_territorial.estructura_id AS territorial_estructura_id,  " +
            "            us_territorial.name AS territorial_nombre,  " +
            "              TRIM(to_char(entidades.id,'00')) AS entidad_cve,  " +
            "              entidades.nombre as entidad,  " +
            "              TRIM(to_char(municipios.cve_mun,'000')) as municipio_cve,  " +
            "              municipios.nom_mun as municipio,    " +
            "              TRIM(to_char(localidades.cve_loc,'0000')) as localidad_cve,   " +
            "              localidades.nom_loc as localidad,   " +
            "              concat('Calle ',cac.calle,', No. Ext. ',cac.exterior,',No. Int. ',cac.interior,', Colonia ',cac.colonia,' CP.',cac.cp) as direccion,  " +
            "              cac.id as cac_id,  " +
            "              cac.nombre as cac, " +
            "              cac.clave as cac_clave,  " +
            "              cac.latitud_reunion_cac,  " +
            "              cac.longitud_reunion_cac,    " +
            "              concat(bco.nombres,' ',bco.apellido_paterno,' ',bco.apellido_materno) as coordinador,  " +
            "              concat(bse.nombres,' ',bse.apellido_paterno,' ',bse.apellido_materno) as secretario,   " +
            "              concat(bcv.nombres,' ',bcv.apellido_paterno,' ',bcv.apellido_materno) as comisionado_viveros,    " +
            "              concat(bte.nombres,' ',bte.apellido_paterno,' ',bte.apellido_materno) as tesorero,  " +
            "              concat(bpt.nombres,' ',bpt.apellido_paterno,' ',bpt.apellido_materno) as planes_trabajo,  " +
            "              concat(bbio.nombres,' ',bbio.apellido_paterno,' ',bbio.apellido_materno) as biofabrica,  " +
            "              concat(baho.nombres,' ',baho.apellido_paterno,' ',baho.apellido_materno) as ahorro,    " +
            "              concat(bsus.nombres,' ',bsus.apellido_paterno,' ',bsus.apellido_materno) as sustentabilidad,  " +
            "              concat(bedu.nombres,' ',bedu.apellido_paterno,' ',bedu.apellido_materno) as educacion,  " +
            "              concat(btra.nombres,' ',btra.apellido_paterno,' ',btra.apellido_materno) as transparencia,   " +
            "              concat(bctr.nombres,' ',bctr.apellido_paterno,' ',bctr.apellido_materno) as contraloria_social,  " +
            "              cac.comision_otro_uno_nombre as comision1,  " +
            "              concat(botu.nombres,' ',botu.apellido_paterno,' ',botu.apellido_materno) as comisionado_euno,  " +
            "              cac.comision_otro_uno_nombre as comision2,  " +
            "              concat(botd.nombres,' ',botd.apellido_paterno,' ',botd.apellido_materno) as comisionado_edos,    " +
            "              cac.comision_otro_uno_nombre as comision3,  " +
            "              concat(bott.nombres,' ',bott.apellido_paterno,' ',bott.apellido_materno) as comisionado_etres    " +
            "               FROM ((((((((cac    " +
            "             LEFT JOIN binomio ON ((binomio.id = cac.binomio_id)))  " +
            "             LEFT JOIN estructuras ON ((estructuras.id = binomio.facilitador_id)))  " +
            "             LEFT JOIN usuarios us_fac ON (((us_fac.estructura_id = binomio.facilitador_id) AND (us_fac.perfil_id = 8))))   " +
            "             LEFT JOIN usuarios us_tp ON (((us_tp.estructura_id = binomio.tecnico_productivo_id) AND (us_tp.perfil_id = 5))))  " +
            "             LEFT JOIN usuarios us_ts ON (((us_ts.estructura_id = binomio.tecnico_social_id) AND (us_ts.perfil_id = 6))))   " +
            "             LEFT JOIN usuarios us_territorial ON (((us_territorial.estructura_id = estructuras.territorial_id) AND (us_territorial.perfil_id = 7))))  " +
            "             LEFT JOIN estructuras est_territorial ON ((est_territorial.id = us_territorial.estructura_id)))  " +
            "             LEFT JOIN usuarios us_super ON (((us_super.estructura_id = est_territorial.supervisor_id) AND (us_super.perfil_id = 14))))   " +
            "             left join entidades on entidades.\\id\\ = cac.entidad_id    " +
            "             left join municipios on municipios.id = cac.municipio_id  " +
            "             LEFT JOIN localidades on localidades.id = cac.localidad_id  " +
            "             left join beneficiarios bco on bco.id = cac.coordinador_id  " +
            "               left join beneficiarios bse on bse.id = cac.secretario_actas_id  " +
            "               left join beneficiarios bcv on bcv.id = cac.comisionado_viveros_id  " +
            "               LEFT JOIN beneficiarios bte on   bte.id   =  cac.tesorero_id    " +
            "               LEFT JOIN beneficiarios bpt  on   bpt.id   =  cac.planes_trabajo_id  " +
            "               LEFT JOIN beneficiarios  bbio on   bbio.id   =  cac.biofabrica_id   " +
            "               LEFT JOIN beneficiarios  baho on   baho.id   =  cac.ahorro_id  " +
            "               LEFT JOIN beneficiarios bsus on   bsus.id   =  cac.sustentabilidad_id  " +
            "               LEFT JOIN beneficiarios bedu  on  bedu.id=  cac.educacion_id    " +
            "               LEFT JOIN beneficiarios  btra on  btra.id=  cac.transparencia_id  " +
            "               LEFT JOIN beneficiarios bctr on  bctr.id=  cac.contraloria_social_id  " +
            "               LEFT JOIN beneficiarios botu on  botu.id=  cac.comision_otro_uno_id   " +
            "               LEFT JOIN beneficiarios botd on  botd.id=  cac.comision_otro_dos_id   " +
            "               LEFT JOIN beneficiarios bott on  bott.id=  cac.comision_otro_tres_id  " +
            "              ORDER BY cac.id " ,
            nativeQuery = true)
    List<InformacionCacsVO> findByInfoCacs();
}
