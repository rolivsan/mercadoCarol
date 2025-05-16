package br.com.mercado.domain.service;

import br.com.mercado.domain.dto.request.FuncionarioRequestDto;
import br.com.mercado.domain.dto.response.FuncionarioResponseDto;
import br.com.mercado.domain.usecase.FuncionarioUserCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    FuncionarioUserCase funcionarioUserCase;

    public List<FuncionarioResponseDto> findAll() {
        return funcionarioUserCase.findAll();
    }

    public FuncionarioResponseDto findById(Long id) throws Exception {
        return funcionarioUserCase.findById(id);
    }

    public FuncionarioResponseDto create(FuncionarioRequestDto request) {
        return  funcionarioUserCase.create(request);

    }
}
