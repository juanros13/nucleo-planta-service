package gob.nucleo.plantaservice.dao;

import gob.nucleo.plantacommons.entity.AvanceFacilitadorTotalesVO;
import gob.nucleo.plantacommons.entity.AvanceTecnicoTotalesVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReportePlantaAvanceTecnicoTotalesDao extends JpaRepository<AvanceTecnicoTotalesVO, Long> {
    @Query(value = "SELECT " +
            "estructuras.id as id, " +
            "us_tec.territorio_id, " +
            "estructuras.id as tecnico_id, " +
            "us_tec.name AS tecnico, " +
            "us_tec.email AS tecnico_correo, " +
            "COALESCE( b.sobrevive,0) AS sobrevive, " +
            "COALESCE( c.meta, 0) as meta " +
            "FROM " +
            " estructuras " +
            " LEFT JOIN usuarios us_tec ON us_tec.estructura_id = estructuras.id AND us_tec.perfil_id IN ( 5,6) " +
            " LEFT JOIN ( " +
            "   SELECT estructuras.id as tecnico_id, " +
            "   sum(cad_planta_parcela.cantidad_sobrevive) AS sobrevive " +
            "   FROM estructuras " +
            "    LEFT JOIN beneficiarios ON beneficiarios.estructura_id = estructuras.id " +
            "    LEFT JOIN cad_predio ON cad_predio.registro_id = beneficiarios.id " +
            "    LEFT JOIN cad_diseno_agroforestal ON cad_diseno_agroforestal.predio_id = cad_predio.id " +
            "    LEFT JOIN cad_planta_parcela ON cad_planta_parcela.diseno_agroforestal_id = cad_diseno_agroforestal.id " +
            "    WHERE " +
            "    cad_diseno_agroforestal.ID IS NOT NULL  " +
            "    AND estructuras.id = ?1 " +
            "  GROUP BY estructuras.id " +
            " ) b on b.tecnico_id = estructuras.id " +
            " LEFT JOIN ( " +
            "   SELECT estructuras.id as tecnico_id, " +
            "   sum(cad_diseno_agroforestal.cantidad_meta) AS meta " +
            "   FROM estructuras " +
            "    LEFT JOIN beneficiarios ON beneficiarios.estructura_id = estructuras.id " +
            "    LEFT JOIN cad_predio ON cad_predio.registro_id = beneficiarios.id " +
            "    LEFT JOIN cad_diseno_agroforestal ON cad_diseno_agroforestal.predio_id = cad_predio.id " +
            "    WHERE " +
            "    cad_diseno_agroforestal.ID IS NOT NULL  " +
            "    AND estructuras.id = ?2 " +
            "  GROUP BY estructuras.id " +
            " ) c on c.tecnico_id = estructuras.id " +
            "WHERE us_tec.estructura_id = ?3 and estructuras.perfil_id in (5,6)",
            nativeQuery = true)
    List<AvanceTecnicoTotalesVO> findByAvancePlantaTecnicosTotales(Long idTecnicoUno, Long idTecnicoDos, Long idTecnicoTres);
}
