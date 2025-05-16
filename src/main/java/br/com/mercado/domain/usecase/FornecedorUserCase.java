package br.com.mercado.domain.usecase;

import br.com.mercado.domain.dto.request.CategoriaRequestDto;
import br.com.mercado.domain.dto.request.FornecedorRequestDto;
import br.com.mercado.domain.dto.response.CategoriaResponseDto;
import br.com.mercado.domain.dto.response.FornecedorResponseDto;
import br.com.mercado.domain.mapper.CategoriaMapper;
import br.com.mercado.domain.mapper.FornecedorMapper;
import br.com.mercado.domain.model.Categoria;
import br.com.mercado.domain.model.Fornecedor;
import br.com.mercado.domain.repository.CategoriaRepository;
import br.com.mercado.domain.repository.FornecedorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class FornecedorUserCase {

    @Autowired
    FornecedorRepository fornecedorRepository;

    public List<FornecedorResponseDto> findAll() {
        List<FornecedorResponseDto> fornecedorResponse = new ArrayList<>();

        for(Fornecedor fornecedor : fornecedorRepository.findAll()){
            FornecedorResponseDto forne = FornecedorMapper.toRespone(fornecedor);
            fornecedorResponse.add(forne);
        }

        return fornecedorResponse;
    }

    public FornecedorResponseDto findById(Long id) throws Exception {
        Optional<Fornecedor> byId = fornecedorRepository.findById(id);

        Fornecedor fornecedor = byId.orElseThrow(() -> {
            log.error("Fornecedor nao encontrado");
            return new Exception("Fornecedor nao encontrado");
        });

        return FornecedorMapper.toRespone(fornecedor);
    }

    public FornecedorResponseDto create(FornecedorRequestDto request) {
        Fornecedor fornecedor = FornecedorMapper.toEntity(request);
        Fornecedor fornecedorSaved = fornecedorRepository.save(fornecedor);
        return FornecedorMapper.toRespone(fornecedorSaved);
    }
}
