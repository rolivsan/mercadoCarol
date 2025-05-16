package br.com.mercado.domain.dto.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class FuncionarioResponseDto {

    private Long id;
    private String nome;
    private String cargo;
    private Double salario;
}
