package br.com.didainfo.controle.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.didainfo.controle.entidades.Adms;

public interface AdmsRepositorio extends JpaRepository<Adms, Long> {

    @EntityGraph(attributePaths = "endereco")
    List<Adms> findAll();
    Optional<Adms> findByEmail(String email);
  
    
}
