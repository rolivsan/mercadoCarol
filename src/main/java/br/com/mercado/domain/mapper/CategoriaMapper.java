package br.com.mercado.domain.mapper;

import br.com.mercado.domain.dto.request.CategoriaRequestDto;
import br.com.mercado.domain.dto.response.CategoriaResponseDto;
import br.com.mercado.domain.model.Categoria;

public class CategoriaMapper {

    public static CategoriaResponseDto toRespone(Categoria categoria){
        return CategoriaResponseDto.builder()
                .nome(categoria.getNome())
                .id(categoria.getId())
                .build();
    }

    public static Categoria toEntity(CategoriaRequestDto request) {
        return Categoria.builder()
                .nome(request.getNome())
                .build();
    }
}
