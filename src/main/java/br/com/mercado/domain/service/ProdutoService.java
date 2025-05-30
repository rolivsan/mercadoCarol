package br.com.mercado.domain.service;

import br.com.mercado.domain.dto.request.CategoriaRequestDto;
import br.com.mercado.domain.dto.request.ProdutoRequestDto;
import br.com.mercado.domain.dto.response.CategoriaResponseDto;
import br.com.mercado.domain.dto.response.ProdutoResponseDto;
import br.com.mercado.domain.usecase.ProdutoUserCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    ProdutoUserCase produtoUserCase;

    public List<ProdutoResponseDto> findAll() {
        return produtoUserCase.findAll();
    }

    public ProdutoResponseDto findById(Long id) throws Exception {
        return produtoUserCase.findById(id);
    }

    public ProdutoResponseDto create(ProdutoRequestDto request) {
        return produtoUserCase.create(request);

    }

    public void delete(Long id) throws Exception {
        produtoUserCase.delete(id);
    }

    public ProdutoResponseDto updateAll(Long id, ProdutoRequestDto request) throws Exception {
        return produtoUserCase.updateAll(id, request);
    }
}
