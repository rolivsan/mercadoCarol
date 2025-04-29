package br.com.mercado.domain.dto.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CategoriaRequestDto {
    private String nome;
}
