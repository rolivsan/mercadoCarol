package br.com.mercado.domain.dto.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProdutoRequestDto {

    private String nome;
    private Double preco;
}
