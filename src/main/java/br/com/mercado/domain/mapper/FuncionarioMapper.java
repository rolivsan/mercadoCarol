package br.com.mercado.domain.mapper;

import br.com.mercado.domain.dto.request.FuncionarioRequestDto;
import br.com.mercado.domain.dto.response.FuncionarioResponseDto;
import br.com.mercado.domain.model.Funcionario;

public class FuncionarioMapper {

    public static FuncionarioResponseDto toRespone(Funcionario funcionario){
        return FuncionarioResponseDto.builder()
                .nome(funcionario.getNome())
                .cargo(funcionario.getCargo())
                .salario(funcionario.getSalario())
                .id(funcionario.getId())
                .build();
    }

    public static Funcionario toEntity(FuncionarioRequestDto request) {
        return Funcionario.builder()
                .nome(request.getNome())
                .cargo(request.getCargo())
                .salario(request.getSalario())
                .build();
    }
}
