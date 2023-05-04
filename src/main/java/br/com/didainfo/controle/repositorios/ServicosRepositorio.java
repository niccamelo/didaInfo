package br.com.didainfo.controle.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.didainfo.controle.entidades.Servicos;

public interface ServicosRepositorio extends JpaRepository<Servicos, Long> {


    @EntityGraph(attributePaths = {"cliente", "caixa"})
    List<Servicos> findAll();
    
}

