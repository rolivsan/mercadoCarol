package br.com.mercado.domain.service;

import br.com.mercado.domain.dto.request.CategoriaRequestDto;
import br.com.mercado.domain.dto.response.CategoriaResponseDto;
import br.com.mercado.domain.usecase.CategoriaUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    CategoriaUseCase categoriaUseCase;

    public List<CategoriaResponseDto> findAll() {
        return categoriaUseCase.findAll();
    }

    public CategoriaResponseDto findById(Long id) throws Exception {
        return categoriaUseCase.findById(id);
    }

    public CategoriaResponseDto create(CategoriaRequestDto request) {
        return categoriaUseCase.create(request);

    }

    public void delete(Long id) throws Exception {
        categoriaUseCase.delete(id);
    }
}
