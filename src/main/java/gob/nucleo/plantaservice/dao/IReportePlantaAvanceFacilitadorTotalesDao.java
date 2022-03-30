package gob.nucleo.plantaservice.dao;

import gob.nucleo.plantacommons.entity.AvanceFacilitadorTotalesVO;
import gob.nucleo.plantacommons.entity.AvanceFacilitadorVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReportePlantaAvanceFacilitadorTotalesDao extends JpaRepository<AvanceFacilitadorTotalesVO, Long> {
    @Query(value = "SELECT " +
            "estructuras.id as id, " +
            "us_fac.territorio_id, " +
            "estructuras.id as facilitador_id, " +
            "us_fac.name AS facilitador, " +
            "us_fac.email AS facilitador_correo, " +
            "COALESCE( b.sobrevive,0) AS sobrevive, " +
            "COALESCE( c.meta, 0) as meta " +
            "FROM " +
            " estructuras " +
            " LEFT JOIN usuarios us_fac ON us_fac.estructura_id = estructuras.id AND us_fac.perfil_id IN ( 8 ) " +
            " LEFT JOIN ( " +
            "   SELECT estructuras.facilitador_id, " +
            "   sum(cad_planta_parcela.cantidad_sobrevive) AS sobrevive " +
            "   FROM estructuras " +
            "    LEFT JOIN beneficiarios ON beneficiarios.estructura_id = estructuras.id " +
            "    LEFT JOIN cad_predio ON cad_predio.registro_id = beneficiarios.id " +
            "    LEFT JOIN cad_diseno_agroforestal ON cad_diseno_agroforestal.predio_id = cad_predio.id " +
            "    LEFT JOIN cad_planta_parcela ON cad_planta_parcela.diseno_agroforestal_id = cad_diseno_agroforestal.id " +
            "    WHERE " +
            "    cad_diseno_agroforestal.ID IS NOT NULL  " +
            "    AND beneficiarios.status =1 " +
            "    AND estructuras.facilitador_id = ?1 " +
            "  GROUP BY estructuras.facilitador_id " +
            " ) b on b.facilitador_id = estructuras.id " +
            " LEFT JOIN ( " +
            "   SELECT estructuras.facilitador_id, " +
            "   sum(cad_diseno_agroforestal.cantidad_meta) AS meta " +
            "   FROM estructuras " +
            "    LEFT JOIN beneficiarios ON beneficiarios.estructura_id = estructuras.id " +
            "    LEFT JOIN cad_predio ON cad_predio.registro_id = beneficiarios.id " +
            "    LEFT JOIN cad_diseno_agroforestal ON cad_diseno_agroforestal.predio_id = cad_predio.id " +
            "    WHERE " +
            "    cad_diseno_agroforestal.ID IS NOT NULL  " +
            "    AND beneficiarios.status =1 " +
            "    AND estructuras.facilitador_id = ?2 " +
            "  GROUP BY estructuras.facilitador_id " +
            " ) c on c.facilitador_id = estructuras.id " +
            "WHERE us_fac.estructura_id = ?3 and estructuras.perfil_id = 8",
            nativeQuery = true)
    List<AvanceFacilitadorTotalesVO> findByAvancePlantaFacilitadorTotales(Long idFacilitadorUno, Long idFacilitadorDos, Long idFacilitadorTres);
}
