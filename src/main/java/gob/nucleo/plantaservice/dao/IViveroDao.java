package gob.nucleo.plantaservice.dao;

import gob.nucleo.plantacommons.entity.Vivero;
import gob.nucleo.usuariocommons.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IViveroDao extends PagingAndSortingRepository<Vivero, Long> {
    public Page<Vivero> findByUsuario(Usuario usuario, Pageable pageable);
}
