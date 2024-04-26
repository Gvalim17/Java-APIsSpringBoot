package br.com.projeto.api.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.projeto.api.modelo.Pessoa;

public interface Repositorio extends CrudRepository<Pessoa, Integer>{

    List<Pessoa> findAll();

    Pessoa findByCodigo(int codigo);

    //Para utilizar Crescente ou descrescente. Adicionar (Asc) para crescente e (Desc) para descrecente no final do nome do metodo.
    List<Pessoa> findByOrderByNome();

    List<Pessoa> findByNomeOrderByIdadeDesc(String nome);

    List<Pessoa> findByNomeContaining(String termo);

    List<Pessoa> findByNomeStartsWith(String termo);

    List<Pessoa> findByNomeEndsWith(String termo);

    @Query(value = "Select Sum(idade) from pessoas", nativeQuery = true)
    int somaidades();

    @Query(value = "Select * from pessoas where idade >= :idade", nativeQuery = true)
    List<Pessoa> idadeMaiorIgual(int idade);

    int countByCodigo(int codigo);
}
