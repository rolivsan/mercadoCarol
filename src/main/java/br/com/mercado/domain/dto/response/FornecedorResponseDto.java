package br.com.mercado.domain.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FornecedorResponseDto {

    private Long id;
    private String nome;
    private String cnpj;
}
