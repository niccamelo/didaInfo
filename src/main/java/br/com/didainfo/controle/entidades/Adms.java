package br.com.didainfo.controle.entidades;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;


@Entity
public class Adms extends Pessoa {

	 @Column(nullable = false)
	    private String email;
	 
    @ManyToMany(mappedBy = "adms", fetch = FetchType.LAZY)
    private List<Servicos> servicos;

    @Column(nullable = false)
    private String senha;

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public List<Servicos> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servicos> servicos) {
        this.servicos= servicos;
    }
    
}