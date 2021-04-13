package gob.nucleo.plantaservice.services;

import gob.nucleo.plantacommons.entity.Vivero;
import gob.nucleo.plantaservice.dao.IViveroDao;
import gob.nucleo.usuariocommons.entity.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class ViveroService implements IViveroService{
    private final Logger log = LoggerFactory.getLogger(ViveroService.class);

    @Autowired
    private IViveroDao viveroDao;

    @Override
    @Transactional(readOnly = true)
    public Page<Vivero> findByUsuarioCreo(Integer pageNo, Integer pageSize, String sortBy, String orderBy, Long idTecnico) {
        Usuario tecnico = new Usuario();
        tecnico.setId(idTecnico);
        Pageable paging =  paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
        return viveroDao.findByUsuario(tecnico, paging);
    }
    @Override
    public Optional<Vivero> findById(Long id) {

        return viveroDao.findById(id);
    }

}
