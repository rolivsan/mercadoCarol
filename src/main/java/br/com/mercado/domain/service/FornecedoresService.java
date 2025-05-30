package br.com.mercado.domain.service;

import br.com.mercado.domain.dto.request.CategoriaRequestDto;
import br.com.mercado.domain.dto.request.FornecedorRequestDto;
import br.com.mercado.domain.dto.response.CategoriaResponseDto;
import br.com.mercado.domain.dto.response.FornecedorResponseDto;
import br.com.mercado.domain.usecase.FornecedorUserCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedoresService {

    @Autowired
    FornecedorUserCase fornecedorUserCase;

    public List<FornecedorResponseDto> findAll() {
        return fornecedorUserCase.findAll();
    }

    public FornecedorResponseDto findById(Long id) throws Exception {
        return fornecedorUserCase.findById(id);
    }

    public FornecedorResponseDto create(FornecedorRequestDto request) {
        return fornecedorUserCase.create(request);

    }

    public void delete(Long id) throws Exception {
        fornecedorUserCase.delete(id);
    }

    public FornecedorResponseDto updateAll(Long id, FornecedorRequestDto request) throws Exception {
        return fornecedorUserCase.updateAll(id, request);
    }
}
