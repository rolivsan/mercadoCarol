package br.com.mercado.domain.mapper;

import br.com.mercado.domain.dto.request.FornecedorRequestDto;;
import br.com.mercado.domain.dto.response.FornecedorResponseDto;
import br.com.mercado.domain.model.Fornecedor;

public class FornecedorMapper {

    public static FornecedorResponseDto toRespone(Fornecedor fornecedor){
        return FornecedorResponseDto.builder()
                .nome(fornecedor.getNome())
                .cnpj(fornecedor.getCnpj())
                .id(fornecedor.getId())
                .build();
    }

    public static Fornecedor toEntity(FornecedorRequestDto request) {
        return Fornecedor.builder()
                .nome(request.getNome())
                .cnpj(request.getCnpj())
                .build();
    }
}
