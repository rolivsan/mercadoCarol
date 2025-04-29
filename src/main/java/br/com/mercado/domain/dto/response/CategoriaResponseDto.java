package br.com.mercado.domain.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CategoriaResponseDto {
    private Long id;
    private String nome;
}
