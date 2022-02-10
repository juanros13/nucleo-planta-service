package gob.nucleo.plantaservice.dao;

import gob.nucleo.plantacommons.entity.AvanceNacionalTotalesVO;
import gob.nucleo.plantacommons.entity.AvanceNacionalVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReportePlantaNacionalAvanceTotalesDao extends JpaRepository<AvanceNacionalTotalesVO, Long> {
    @Query(value = " SELECT    " +
            " territorios.id as id, " +
            " territorios.nombre, " +
            " COALESCE( b.sobrevive,0) AS sobrevive, " +
            " COALESCE( c.meta, 0) as meta " +
            " FROM " +
            " territorios " +
            " LEFT JOIN ( " +
            "   SELECT estructuras.territorio_id, " +
            "   sum(cad_planta_parcela.cantidad_sobrevive) AS sobrevive " +
            "   FROM estructuras " +
            "    LEFT JOIN beneficiarios ON beneficiarios.estructura_id = estructuras.id " +
            "    LEFT JOIN cad_predio ON cad_predio.registro_id = beneficiarios.id " +
            "    LEFT JOIN cad_diseno_agroforestal ON cad_diseno_agroforestal.predio_id = cad_predio.id  " +
            "    LEFT JOIN cad_planta_parcela ON cad_planta_parcela.diseno_agroforestal_id = cad_diseno_agroforestal.id " +
            "    WHERE " +
            "    cad_diseno_agroforestal.ID IS NOT NULL " +
            "    AND estructuras.territorio_id = ?1 " +
            "  GROUP BY estructuras.territorio_id " +
            " ) b on b.territorio_id = territorios.id " +
            " LEFT JOIN ( " +
            "   SELECT estructuras.territorio_id, " +
            "   sum(cad_diseno_agroforestal.cantidad_meta) AS meta " +
            "   FROM estructuras " +
            "    LEFT JOIN beneficiarios ON beneficiarios.estructura_id = estructuras.id " +
            "    LEFT JOIN cad_predio ON cad_predio.registro_id = beneficiarios.id " +
            "    LEFT JOIN cad_diseno_agroforestal ON cad_diseno_agroforestal.predio_id = cad_predio.id " +
            "    WHERE " +
            "    cad_diseno_agroforestal.ID IS NOT NULL " +
            "    AND estructuras.territorio_id = ?2 " +
            "  GROUP BY estructuras.territorio_id " +
            " ) c on c.territorio_id = territorios.id " +
            " where territorios.id = ?3 ",
            nativeQuery = true)
    List<AvanceNacionalTotalesVO> findByAvancePlantaNacionalTotales(Long idFacilitadorUno, Long idFacilitadorDos, Long idFacilitadorTres);
}
