package br.com.mercado.domain.usecase;

import br.com.mercado.domain.dto.request.CategoriaRequestDto;
import br.com.mercado.domain.dto.request.MercadoRequestDto;
import br.com.mercado.domain.dto.response.CategoriaResponseDto;
import br.com.mercado.domain.dto.response.MercadoResponseDto;
import br.com.mercado.domain.mapper.CategoriaMapper;
import br.com.mercado.domain.mapper.MercadoMapper;
import br.com.mercado.domain.model.Categoria;
import br.com.mercado.domain.model.Mercado;
import br.com.mercado.domain.repository.CategoriaRepository;
import br.com.mercado.domain.repository.MercadoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class MercadoUserCase {
    @Autowired
    MercadoRepository mercadoRepository;

    public List<MercadoResponseDto> findAll() {
        List<MercadoResponseDto> mercadoResponse = new ArrayList<>();

        for( Mercado mercado : mercadoRepository.findAll()){
            MercadoResponseDto cat = MercadoMapper.toRespone(mercado);
            mercadoResponse.add(cat);
        }

        return mercadoResponse;
    }

    public MercadoResponseDto findById(Long id) throws Exception {
        Optional<Mercado> byId = mercadoRepository.findById(id);

        Mercado mercado = byId.orElseThrow(() -> {
            log.error("Mercado nao encontrado");
            return new Exception("mercado nao encontrado");
        });

        return MercadoMapper.toRespone(mercado);
    }

    public MercadoResponseDto create(MercadoRequestDto request) {
        Mercado mercado = MercadoMapper.toEntity(request);
        Mercado mercadoSaved = mercadoRepository.save(mercado);
        return MercadoMapper.toRespone(mercadoSaved);
    }

}
