package br.com.mercado.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioRequestDto {

    private String nome;
    private String cargo;
    private Double salario;
}
