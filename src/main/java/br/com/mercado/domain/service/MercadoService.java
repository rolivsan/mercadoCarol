package br.com.mercado.domain.service;

import br.com.mercado.domain.dto.request.MercadoRequestDto;
import br.com.mercado.domain.dto.response.MercadoResponseDto;
import br.com.mercado.domain.usecase.MercadoUserCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MercadoService {

    @Autowired
    MercadoUserCase mercadoUserCase;


    public List<MercadoResponseDto> findAll() {
        return mercadoUserCase.findAll();
    }

    public MercadoResponseDto findById(Long id) throws Exception {
        return mercadoUserCase.findById(id);
    }

    public MercadoResponseDto create(MercadoRequestDto request) {
        return  mercadoUserCase.create(request);

    }
}
