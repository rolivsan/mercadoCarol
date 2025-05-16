package br.com.mercado.domain.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MercadoRequestDto {

    private String nome;
    private String endereco;
    private String cnpj;


}
