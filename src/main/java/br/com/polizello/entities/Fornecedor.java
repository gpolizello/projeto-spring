package br.com.polizello.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="fornecedor", uniqueConstraints={@UniqueConstraint(columnNames={"fornecedorCNPJ"})})
@SequenceGenerator(name="sequence", sequenceName="default_sequence", allocationSize=5)
@DynamicUpdate
public class Fornecedor extends AbstractEntity {
	private static final long serialVersionUID = -1502851667741232467L;
	
	@Id
	@GeneratedValue(generator="sequence")
	private Long fornecedorId;
	@NotNull
	@Size(max=100)
	private String fornecedorNome;
	@NotNull
	@Size(max=14)
	private String fornecedorCNPJ;
	@NotNull
	@Size(max=100)
	private String fornecedorLogradouro;
	@NotNull
	@Size(max=100)
	private String fornecedorBairro;
	@NotNull
	@Size(max=100)
	private String fornecedorCidade;
	@NotNull
	@Size(max=2)
	private String fornecedorUF;
	@NotNull
	@Size(max=50)
	private String fornecedorPais;
	@NotNull
	@Size(max=9)
	private String fornecedorCep;
	
	public Fornecedor() {}
	
	public Fornecedor(Long id) {
		this();
		this.setId(id);
	}

	@javax.persistence.Transient
	@Override
	public Long getId() {
		return null;
	}

	@Override
	public void setId(Long id) {
		
	}

	public Long getFornecedorId() {
		return fornecedorId;
	}

	public void setFornecedorId(Long fornecedorId) {
		this.fornecedorId = fornecedorId;
	}

	public String getFornecedorNome() {
		return fornecedorNome;
	}

	public void setFornecedorNome(String fornecedorNome) {
		this.fornecedorNome = fornecedorNome;
	}

	public String getFornecedorCNPJ() {
		return fornecedorCNPJ;
	}

	public void setFornecedorCNPJ(String fornecedorCNPJ) {
		this.fornecedorCNPJ = fornecedorCNPJ;
	}

	public String getFornecedorLogradouro() {
		return fornecedorLogradouro;
	}

	public void setFornecedorLogradouro(String fornecedorLogradouro) {
		this.fornecedorLogradouro = fornecedorLogradouro;
	}

	public String getFornecedorBairro() {
		return fornecedorBairro;
	}

	public void setFornecedorBairro(String fornecedorBairro) {
		this.fornecedorBairro = fornecedorBairro;
	}

	public String getFornecedorCidade() {
		return fornecedorCidade;
	}

	public void setFornecedorCidade(String fornecedorCidade) {
		this.fornecedorCidade = fornecedorCidade;
	}

	public String getFornecedorUF() {
		return fornecedorUF;
	}

	public void setFornecedorUF(String fornecedorUF) {
		this.fornecedorUF = fornecedorUF;
	}

	public String getFornecedorPais() {
		return fornecedorPais;
	}

	public void setFornecedorPais(String fornecedorPais) {
		this.fornecedorPais = fornecedorPais;
	}

	public String getFornecedorCep() {
		return fornecedorCep;
	}

	public void setFornecedorCep(String fornecedorCep) {
		this.fornecedorCep = fornecedorCep;
	}

}
