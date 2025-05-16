package br.com.mercado.domain.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProdutoResponseDto {

    private Long id;
    private String nome;
    private Double preco;
}
