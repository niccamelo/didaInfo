package br.com.didainfo.controle.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Cliente extends Pessoa {

	
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<Servicos> servicos;

    @Column(nullable = true)
    private String senha;
    
    public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setServicos(List<Servicos> servicos) {
		this.servicos = servicos;
	}

	public List<Servicos> getServicos() {
        return servicos;
    }

    public void setProjetos(List<Servicos> servicos) {
        this.servicos = servicos;
    }
    
}
