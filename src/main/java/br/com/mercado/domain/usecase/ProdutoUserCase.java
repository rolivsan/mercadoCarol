package br.com.mercado.domain.usecase;

import br.com.mercado.domain.dto.request.CategoriaRequestDto;
import br.com.mercado.domain.dto.request.ProdutoRequestDto;
import br.com.mercado.domain.dto.response.CategoriaResponseDto;
import br.com.mercado.domain.dto.response.ProdutoResponseDto;
import br.com.mercado.domain.mapper.CategoriaMapper;
import br.com.mercado.domain.mapper.ProdutoMapper;
import br.com.mercado.domain.model.Categoria;
import br.com.mercado.domain.model.Produto;
import br.com.mercado.domain.repository.CategoriaRepository;
import br.com.mercado.domain.repository.ProdutoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class ProdutoUserCase {

    @Autowired
    ProdutoRepository produtoRepository;


    public List<ProdutoResponseDto> findAll() {
        List<ProdutoResponseDto> produtoResponse = new ArrayList<>();

        for(Produto produto : produtoRepository.findAll()){
            ProdutoResponseDto prod = ProdutoMapper.toRespone(produto);
            produtoResponse.add(prod);
        }

        return produtoResponse;
    }

    public ProdutoResponseDto findById(Long id) throws Exception {
        Optional<Produto> byId = produtoRepository.findById(id);

        Produto produto = byId.orElseThrow(() -> {
            log.error("produto nao encontrado");
            return new Exception("produto nao encontrado");
        });

        return ProdutoMapper.toRespone(produto);
    }

    public ProdutoResponseDto create(ProdutoRequestDto request) {
        Produto produto = ProdutoMapper.toEntity(request);
        Produto produtoSaved = produtoRepository.save(produto);
        return ProdutoMapper.toRespone(produtoSaved);
    }
}
