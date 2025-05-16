package br.com.mercado.domain.dto.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FuncionarioRequestDto {

    private String nome;
    private String cargo;
    private Double salario;
}
