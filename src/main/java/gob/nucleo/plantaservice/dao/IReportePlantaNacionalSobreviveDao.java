package gob.nucleo.plantaservice.dao;

import gob.nucleo.plantacommons.entity.AvanceNacionalMetaVO;
import gob.nucleo.plantacommons.entity.AvanceNacionalSobreviveVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IReportePlantaNacionalSobreviveDao extends JpaRepository<AvanceNacionalSobreviveVO, Long> {
    @Query(value = 
                    " SELECT   " +
                    " estructuras.territorio_id as id,  " +
                    " estructuras.territorio_id,  " +
                    " sum(cad_planta_parcela.cantidad_sobrevive) as sobrevive  " +
                    "FROM estructuras   " +
                    " LEFT JOIN beneficiarios on beneficiarios.estructura_id = estructuras.id  " +
                    " LEFT JOIN cad_predio ON cad_predio.registro_id = beneficiarios.id  " +
                    " LEFT JOIN cad_diseno_agroforestal ON cad_diseno_agroforestal.predio_id = cad_predio.id   " +
                    "  LEFT JOIN cad_planta_parcela ON cad_planta_parcela.diseno_agroforestal_id = cad_diseno_agroforestal.id   " +
                    " WHERE cad_diseno_agroforestal.id is not null   " +
                    " group by   " +
                    "  estructuras.territorio_id   ",
            nativeQuery = true)
    List<AvanceNacionalSobreviveVO> findByAvancePlantaNacionalSobrevive();
}
