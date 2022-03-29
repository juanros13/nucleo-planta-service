package gob.nucleo.plantaservice.dao;

import gob.nucleo.plantacommons.entity.BeneficiariosAvanceVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IBeneficiarioAvanceVODao extends JpaRepository<BeneficiariosAvanceVO, Long> {

    @Query(value = "SELECT  " +
            " beneficiarios.*,  " +
            " COALESCE(meta.meta,0) as meta, " +
            " COALESCE(sobrevive.sobrevive,0) as sobrevive " +
            " FROM beneficiarios " +
            " LEFT JOIN ( " +
            "  SELECT beneficiarios.id, SUM(cad_diseno_agroforestal.cantidad_meta)as meta FROM beneficiarios " +
            "  LEFT JOIN cad_predio on cad_predio.registro_id = beneficiarios.id " +
            "  LEFT JOIN cad_diseno_agroforestal on cad_diseno_agroforestal.predio_id = cad_predio.id " +
            "  where beneficiarios.estructura_id = ?1 " +
            "  GROUP BY beneficiarios.id " +
            " ) meta on meta.id = beneficiarios.id " +
            " LEFT JOIN ( " +
            "  SELECT beneficiarios.id, SUM(cad_planta_parcela.cantidad_sobrevive)as sobrevive FROM beneficiarios " +
            "  LEFT JOIN cad_predio on cad_predio.registro_id = beneficiarios.id " +
            "  LEFT JOIN cad_diseno_agroforestal on cad_diseno_agroforestal.predio_id = cad_predio.id " +
            "  LEFT JOIN cad_planta_parcela on cad_planta_parcela.diseno_agroforestal_id = cad_diseno_agroforestal.id " +
            "  where beneficiarios.estructura_id = ?2 " +
            "  GROUP BY beneficiarios.id " +
            ") sobrevive on sobrevive.id = beneficiarios.id " +
            "where beneficiarios.estructura_id = ?3",
            nativeQuery = true)
    List<BeneficiariosAvanceVO> findByAvancePlantaFacilitadorTotales(
            Long idEstructuraUno,
            Long idEstructuraDos,
            Long idEstructuraTres
    );
}
