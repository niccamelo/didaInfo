package br.com.didainfo.controle.entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat.Style;

@Entity
public class Fornecedor extends Entidade {
	
	@Column(nullable = false)
    private String produto;
 
    public String getProduto() {
		return produto;
	}



	@Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "data_compra", nullable = false)
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataInicio;

    @Column(nullable = false)
    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal valorItem;
    
    @Column(nullable = false)
    private int quantidade;
    	       
    @Column(nullable = false)
    @NumberFormat(style = Style.CURRENCY, pattern = "#,##0.00")
    private BigDecimal valorTotal;


	

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public BigDecimal getValorItem() {
		return valorItem;
	}

	public void setValorItem(BigDecimal valorItem) {
		this.valorItem = valorItem;
	}
 
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	} 

	public BigDecimal getValorTotal() {
		return valorTotal;
	}
 
	 

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
}

	
