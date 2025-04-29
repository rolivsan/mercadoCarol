package br.com.mercado.domain.service;

import br.com.mercado.domain.dto.CategoriaDto;
import br.com.mercado.domain.model.Categoria;
import br.com.mercado.domain.usecase.CategoriaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    CategoriaUseCase categoriaUseCase;

    public List<CategoriaDto> findAll() {
        return categoriaUseCase.findAll();
    }

    public CategoriaDto findById(Long id) throws Exception {
        return categoriaUseCase.findById(id);
    }
}
