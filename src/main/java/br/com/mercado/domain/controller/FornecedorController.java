package br.com.mercado.domain.controller;

import br.com.mercado.domain.dto.request.CategoriaRequestDto;
import br.com.mercado.domain.dto.request.FornecedorRequestDto;
import br.com.mercado.domain.dto.response.CategoriaResponseDto;
import br.com.mercado.domain.dto.response.FornecedorResponseDto;
import br.com.mercado.domain.service.FornecedoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedor")
public class FornecedorController {

    @Autowired
    FornecedoresService fornecedoresService;

    @GetMapping
    public ResponseEntity<List<FornecedorResponseDto>> findAll(){
        return ResponseEntity.ok(fornecedoresService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FornecedorResponseDto> findById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(fornecedoresService.findById(id));
    }

    @PostMapping
    public ResponseEntity<FornecedorResponseDto> create(@RequestBody FornecedorRequestDto request){
        return  ResponseEntity.status(201).body(fornecedoresService.create(request));
    }
}
