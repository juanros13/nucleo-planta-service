package gob.nucleo.plantaservice.dao;


import gob.nucleo.viverocommons.entity.CatMerma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICatMermaDao extends JpaRepository<CatMerma, Long> {

}
