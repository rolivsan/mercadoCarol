package br.com.mercado.domain.mapper;

import br.com.mercado.domain.dto.request.ProdutoRequestDto;
import br.com.mercado.domain.dto.response.ProdutoResponseDto;
import br.com.mercado.domain.model.Produto;
public class ProdutoMapper {

    public static ProdutoResponseDto toRespone(Produto produto){
        return ProdutoResponseDto.builder()
                .nome(produto.getNome())
                .preco(produto.getPreco())
                .id(produto.getId())
                .build();
    }

    public static Produto toEntity(ProdutoRequestDto request) {
        return Produto.builder()
                .nome(request.getNome())
                .preco(request.getPreco())
                .build();
    }
}
