package br.com.didainfo.controle.repositorios;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.didainfo.controle.entidades.Fornecedor;


public interface FornecedorRepositorio extends JpaRepository <Fornecedor, Long> {

	    List<Fornecedor> findAll();
	    
}
