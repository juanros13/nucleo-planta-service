package gob.nucleo.plantaservice.services;

import gob.nucleo.plantacommons.entity.Vivero;
import org.springframework.data.domain.Page;

public interface IViveroService {
    public Page<Vivero> findByUsuarioCreo(Integer pageNo, Integer pageSize, String sortBy, String orderBy, Long idTecnico);
    public Vivero findById(Long id);
}
