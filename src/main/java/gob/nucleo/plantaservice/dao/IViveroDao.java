package gob.nucleo.plantaservice.dao;
import gob.nucleo.beneficiariocommons.entity.Beneficiario;
import gob.nucleo.plantacommons.entity.Vivero;
import gob.nucleo.usuariocommons.entity.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IViveroDao extends PagingAndSortingRepository<Vivero, Long> {
    public Page<Vivero> findByUsuarioCreo(Usuario usuario, Pageable pageable);
}
