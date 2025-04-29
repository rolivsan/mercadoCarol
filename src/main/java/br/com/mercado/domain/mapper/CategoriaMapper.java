package br.com.mercado.domain.mapper;

import br.com.mercado.domain.dto.CategoriaDto;
import br.com.mercado.domain.model.Categoria;

public class CategoriaMapper {

    public static CategoriaDto toRespone(Categoria categoria){
        return CategoriaDto.builder()
                .nome(categoria.getNome())
                .id(categoria.getId())
                .build();
    }
}
