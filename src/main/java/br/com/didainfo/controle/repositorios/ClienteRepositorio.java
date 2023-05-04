package br.com.didainfo.controle.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.didainfo.controle.entidades.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

    @EntityGraph(attributePaths = "endereco")
    List<Cliente> findAll();
    
}
