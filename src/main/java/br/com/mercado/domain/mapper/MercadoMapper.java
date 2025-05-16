package br.com.mercado.domain.mapper;
import br.com.mercado.domain.dto.request.MercadoRequestDto;
import br.com.mercado.domain.dto.response.MercadoResponseDto;
import br.com.mercado.domain.model.Mercado;

public class MercadoMapper {

    public static MercadoResponseDto toRespone(Mercado mercado){
        return MercadoResponseDto.builder()
                .nome(mercado.getNome())
                .endereco(mercado.getEndereco())
                .cnpj(mercado.getCnpj())
                .id(mercado.getId())
                .build();
    }

    public static Mercado toEntity(MercadoRequestDto request) {
        return Mercado.builder()
                .nome(request.getNome())
                .build();
    }
}
