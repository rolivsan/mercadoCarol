package br.com.mercado.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MercadoRequestDto {

    private String nome;
    private String endereco;
    private String cnpj;


}
