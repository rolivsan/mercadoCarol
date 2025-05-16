package br.com.mercado.domain.controller;

import br.com.mercado.domain.dto.request.CategoriaRequestDto;
import br.com.mercado.domain.dto.request.MercadoRequestDto;
import br.com.mercado.domain.dto.response.CategoriaResponseDto;
import br.com.mercado.domain.dto.response.MercadoResponseDto;
import br.com.mercado.domain.service.MercadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mercado")
public class MercadoController {

    @Autowired
    MercadoService mercadoService;

    @GetMapping
    public ResponseEntity<List<MercadoResponseDto>> findAll(){
        return ResponseEntity.ok(mercadoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MercadoResponseDto> findById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(mercadoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<MercadoResponseDto> create(@RequestBody MercadoRequestDto request){
        return  ResponseEntity.status(201).body(mercadoService.create(request));
    }
}
