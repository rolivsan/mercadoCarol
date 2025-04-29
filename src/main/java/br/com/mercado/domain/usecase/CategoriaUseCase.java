package br.com.mercado.domain.usecase;

import br.com.mercado.domain.dto.CategoriaDto;
import br.com.mercado.domain.mapper.CategoriaMapper;
import br.com.mercado.domain.model.Categoria;
import br.com.mercado.domain.repository.CategoriaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class CategoriaUseCase {

    @Autowired
    CategoriaRepository categoriaRepository;

    public List<CategoriaDto> findAll() {
        List<CategoriaDto> categoriasResponse = new ArrayList<>();

        for(Categoria categoria : categoriaRepository.findAll()){
            CategoriaDto cat = CategoriaMapper.toRespone(categoria);
            categoriasResponse.add(cat);
        }

        return categoriasResponse;
    }

    public CategoriaDto findById(Long id) throws Exception {
        Optional<Categoria> byId = categoriaRepository.findById(id);

        Categoria categoria = byId.orElseThrow(() -> {
            log.error("categoria nao encontrada");
            return new Exception("Categoria nao encontrada");
        });



        return CategoriaMapper.toRespone(categoria);
    }
}
