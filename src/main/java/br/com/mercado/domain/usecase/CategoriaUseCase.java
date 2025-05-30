package br.com.mercado.domain.usecase;

import br.com.mercado.domain.dto.request.CategoriaRequestDto;
import br.com.mercado.domain.dto.response.CategoriaResponseDto;
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

    public List<CategoriaResponseDto> findAll() {
        List<CategoriaResponseDto> categoriasResponse = new ArrayList<>();

        for(Categoria categoria : categoriaRepository.findAll()){
            CategoriaResponseDto cat = CategoriaMapper.toRespone(categoria);
            categoriasResponse.add(cat);
        }

        return categoriasResponse;
    }

    public CategoriaResponseDto findById(Long id) throws Exception {
        Optional<Categoria> byId = categoriaRepository.findById(id);

        Categoria categoria = byId.orElseThrow(() -> {
            log.error("categoria nao encontrada");
            return new Exception("Categoria nao encontrada");
        });

        return CategoriaMapper.toRespone(categoria);
    }

    public CategoriaResponseDto create(CategoriaRequestDto request) {
        Categoria categoria = CategoriaMapper.toEntity(request);
        Categoria categoriaSaved = categoriaRepository.save(categoria);
        return CategoriaMapper.toRespone(categoriaSaved);
    }

    public void delete(Long id) throws Exception {
        Optional<Categoria> byId = categoriaRepository.findById(id);

        Categoria categoria = byId.orElseThrow(() -> {
            log.error("categoria nao encontrada");
            return new Exception("Categoria nao encontrada");
        });

        categoriaRepository.delete(categoria);

        log.info("categoria apagada com sucesso");
    }

    public CategoriaResponseDto updateAll(Long id, CategoriaRequestDto request) throws Exception {
        Optional<Categoria> byId = categoriaRepository.findById(id);

        Categoria categoria = byId.orElseThrow(() -> {
            log.error("categoria nao encontrada");
            return new Exception("Categoria nao encontrada");
        });

        categoria.setNome(request.getNome());

        Categoria categoriaSaved = categoriaRepository.save(categoria);
        return CategoriaMapper.toRespone(categoriaSaved);
    }
}
