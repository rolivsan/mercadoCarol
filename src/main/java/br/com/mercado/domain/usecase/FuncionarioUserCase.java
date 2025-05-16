package br.com.mercado.domain.usecase;

import br.com.mercado.domain.dto.request.CategoriaRequestDto;
import br.com.mercado.domain.dto.request.FuncionarioRequestDto;
import br.com.mercado.domain.dto.response.CategoriaResponseDto;
import br.com.mercado.domain.dto.response.FornecedorResponseDto;
import br.com.mercado.domain.dto.response.FuncionarioResponseDto;
import br.com.mercado.domain.mapper.CategoriaMapper;
import br.com.mercado.domain.mapper.FuncionarioMapper;
import br.com.mercado.domain.model.Categoria;
import br.com.mercado.domain.model.Funcionario;
import br.com.mercado.domain.repository.CategoriaRepository;
import br.com.mercado.domain.repository.FuncionarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class FuncionarioUserCase {
    @Autowired
    FuncionarioRepository funcionarioRepository;

    public List<FuncionarioResponseDto> findAll() {
        List<FuncionarioResponseDto> funcionarioResponse = new ArrayList<>();

        for (Funcionario funcionario : funcionarioRepository.findAll()) {
            FuncionarioResponseDto fun = FuncionarioMapper.toRespone(funcionario);
            funcionarioResponse.add(fun);
        }

        return funcionarioResponse;
    }

    public FuncionarioResponseDto findById(Long id) throws Exception {
        Optional<Funcionario> byId = funcionarioRepository.findById(id);

        Funcionario funcionario = byId.orElseThrow(() -> {
            log.error("funcionario nao encontrado");
            return new Exception("funcionario nao encontrado");
        });

        return FuncionarioMapper.toRespone(funcionario);
    }

    public FuncionarioResponseDto create(FuncionarioRequestDto request) {
        Funcionario funcionario = FuncionarioMapper.toEntity(request);
        Funcionario funcionarioSaved = funcionarioRepository.save(funcionario);
        return FuncionarioMapper.toRespone(funcionarioSaved);
    }
}
