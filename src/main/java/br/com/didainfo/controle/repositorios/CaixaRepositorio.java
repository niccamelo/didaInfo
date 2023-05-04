package br.com.didainfo.controle.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.didainfo.controle.entidades.Caixa;
import br.com.didainfo.controle.entidades.Cliente;

public interface CaixaRepositorio  extends JpaRepository<Caixa, Long> {

	  List<Caixa> findAll();
    
}
