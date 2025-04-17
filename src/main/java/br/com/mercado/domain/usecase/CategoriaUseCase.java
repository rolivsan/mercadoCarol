package br.com.mercado.domain.usecase;

import br.com.mercado.domain.model.Categoria;
import br.com.mercado.domain.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaUseCase {

    @Autowired
    CategoriaRepository categoriaRepository;


    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }
}
