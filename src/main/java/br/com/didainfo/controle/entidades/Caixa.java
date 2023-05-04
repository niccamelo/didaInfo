package br.com.didainfo.controle.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat.Style;



@Entity
public class Caixa extends Entidade {


	@Column(nullable = false)
	    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	    private BigDecimal valor;

	    @Column(nullable = false, columnDefinition = "TEXT")
	    private String descricao;

	    @Column(name = "data_venda", nullable = true)
	    @DateTimeFormat(iso = ISO.DATE)
	    private LocalDate data_venda;

	    
		@Column(nullable = false)
	    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
	    private BigDecimal valorSaida;

		 @Column(name = "data_saida", nullable = true)
		    @DateTimeFormat(iso = ISO.DATE)
		    private LocalDate dataSaida;

		 @OneToMany(mappedBy = "caixa", fetch = FetchType.LAZY)
		    private List<Servicos> servicos;

	 

	public BigDecimal getValorSaida() {
		return valorSaida;
	}


	public void setValorSaida(BigDecimal valorSaida) {
		this.valorSaida = valorSaida;
	}


	


	
	 public List<Servicos> getServicos() {
		return servicos;
	}


	public void setServicos(List<Servicos> servicos) {
		this.servicos = servicos;
	}


	public LocalDate getDataSaida() {
		return dataSaida;
	}


	public void setDataSaida(LocalDate dataSaida) {
		this.dataSaida = dataSaida;
	}




	public BigDecimal getValor() {
		return valor;
	}


	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public LocalDate getData_venda() {
		return data_venda;
	}


	public void setData_venda(LocalDate data_venda) {
		this.data_venda = data_venda;
	}
}
