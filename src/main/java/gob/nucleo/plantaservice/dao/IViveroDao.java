package gob.nucleo.plantaservice.dao;

import gob.nucleo.usuariocommons.entity.Usuario;
import gob.nucleo.viverocommons.entity.Vivero;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IViveroDao extends PagingAndSortingRepository<Vivero, Long>{

    Page<Vivero> findByUsuario(Usuario usuario, Pageable pageable);

}
