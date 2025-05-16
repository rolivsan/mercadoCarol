package br.com.mercado;


import br.com.mercado.domain.model.*;
import br.com.mercado.domain.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
@Slf4j
public class MercadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MercadoApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(@Autowired CategoriaRepository categoriaRepository,
								   @Autowired ProdutoRepository produtoRepository,
								   @Autowired MercadoRepository mercadoRepository,
								   @Autowired FuncionarioRepository funcionarioRepository,
								   @Autowired FornecedorRepository fornecedorRepository) {
		return args -> {
			Mercado mercado1 = Mercado.builder()
					.nome("Mercado do João")
					.endereco("Rua Silva")
					.cnpj("12345678901234")
					.build();

			mercadoRepository.save(mercado1);

			log.info("Salvando mercado");

			Funcionario funcionario1 = Funcionario.builder()
					.nome("Maria")
					.cargo("Ajudante")
					.salario(1000.0)
					.mercado(mercado1) // Associa o mercado
					.build();
			Funcionario funcionario2 = Funcionario.builder()
					.nome("João")
					.cargo("Gerente")
					.salario(2000.0)
					.mercado(mercado1) // Associa o mercado
					.build();
			Funcionario funcionario3 = Funcionario.builder()
					.nome("José")
					.cargo("Caixa")
					.salario(1500.0)
					.mercado(mercado1) // Associa o mercado
					.build();
			funcionarioRepository.saveAll(Arrays.asList(funcionario1, funcionario2, funcionario3));
			log.info("salvando funcionarios");

			Fornecedor fornecedor1 = Fornecedor.builder()
					.nome("Fornecedor 1")
					.cnpj("12345678901234")
					.mercado(mercado1)
					.build();
			Fornecedor fornecedor2 = Fornecedor.builder()
					.nome("Fornecedor 2")
					.cnpj("12345678901235")
					.mercado(mercado1)
					.build();
			Fornecedor fornecedor3 = Fornecedor.builder()
					.nome("Fornecedor 3")
					.cnpj("12345678901236")
					.mercado(mercado1)
					.build();

			Fornecedor fornecedor4 = Fornecedor.builder()
					.nome("Fornecedor 4")
					.cnpj("12345678901237")
					.mercado(mercado1)
					.build();
			fornecedorRepository.saveAll(Arrays.asList(fornecedor1, fornecedor2, fornecedor3, fornecedor4));
			log.info("Fornecedores salvos com sucesso!");

			// Criando três categorias
			Categoria alimentos = Categoria.builder()
					.nome("Alimentos")
					.build();

			Categoria bebidas = Categoria.builder()
					.nome("Bebidas")
					.build();

			Categoria tecnologia = Categoria.builder()
					.nome("Tecnologia")
					.build();

			Categoria limpeza = Categoria.builder()
					.nome("Limpeza")
					.build();

			// Salvando as categorias no banco
			categoriaRepository.saveAll(Arrays.asList(alimentos, bebidas, limpeza, tecnologia));

			log.info("Categorias salvas com sucesso!");

			Produto produto1 = Produto.builder()
					.nome("Coca cola")
					.preco(10.00)
					.categoria(bebidas)
					.fornecedor(fornecedor1)
					.build();
			Produto produto2 = Produto.builder()
					.nome("Feijão")
					.preco(8.00)
					.categoria(alimentos)
					.fornecedor(fornecedor2)
					.build();
			Produto produto3 = Produto.builder()
					.nome("TV")
					.categoria(tecnologia)
					.fornecedor(fornecedor3)
					.preco(3000.0)
					.build();

			Produto produto4 = Produto.builder()
					.nome("candida")
					.categoria(limpeza)
					.fornecedor(fornecedor4)
					.preco(3000.0)
					.build();


			produtoRepository.saveAll(Arrays.asList(produto1, produto2, produto3, produto4));
			log.info("Produtos salvos com sucesso!");

		};
	}
}
