package br.com.didainfo.controle.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;




@Entity
public class Servicos extends Entidade {

    @Column(nullable = false)
    private String marca;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;
    
    @Column(nullable = false)
    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal orcamento;

    public BigDecimal getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(BigDecimal orcamento) {
		this.orcamento = orcamento;
	}

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id_fk", nullable = true)
    private Cliente cliente;
    
   
	 @ManyToOne(cascade =CascadeType.ALL)
	    @JoinColumn(name = "caixa_id_fk", nullable = true)
	    private Caixa caixa;
    
   
	@ManyToMany
    @JoinTable(
        name = "servicos_adms",
        joinColumns = @JoinColumn(name = "servicos_id_fk"),
        inverseJoinColumns = @JoinColumn(name = "adms_id_fk")
    )
    private List<Servicos> adms;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

   
    public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

    

	public List<Servicos> getAdms() {
		return adms;
	}

	public void setAdms(List<Servicos> adms) {
		this.adms = adms;
	}

	public Caixa getCaixa() {
		return caixa;
	}

	public void setCaixa(Caixa caixa) {
		this.caixa = caixa;
	}

	

	
	

	



}