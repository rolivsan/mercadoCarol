package br.com.mercado.domain.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MercadoResponseDto {

    private Long id;
    private String nome;
    private String endereco;
    private String cnpj;


}
