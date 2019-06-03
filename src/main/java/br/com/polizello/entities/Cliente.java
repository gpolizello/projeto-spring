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
@Table(name="cliente", uniqueConstraints={@UniqueConstraint(columnNames={"clienteCPF"})})
@SequenceGenerator(name="sequence", sequenceName="default_sequence", allocationSize=5)
@DynamicUpdate
public class Cliente extends AbstractEntity {
	private static final long serialVersionUID = -5328030858282144557L;
	
	@Id
	@GeneratedValue(generator="sequence")
	private Long clienteId;
	@NotNull
	@Size(max=100)
	private String clienteNome;
	@NotNull
	@Size(max=11)
	private String clienteCPF;
	@NotNull
	@Size(max=100)
	private String clienteLogradouro;
	@NotNull
	@Size(max=100)
	private String clienteBairro;
	@NotNull
	@Size(max=100)
	private String clienteCidade;
	@NotNull
	@Size(max=2)
	private String clienteUF;
	@NotNull
	@Size(max=50)
	private String clientePais;
	@NotNull
	@Size(max=9)
	private String clienteCep;
	
	public Cliente() {}
	
	public Cliente(Long id) {
		this();
		this.setId(id);
	}
	
	@javax.persistence.Transient
	@Override
	public Long getId() {
		return getClienteId();
	}

	@Override
	public void setId(Long id) {
		this.clienteId = id;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public String getClienteNome() {
		return clienteNome;
	}

	public void setClienteNome(String clienteNome) {
		this.clienteNome = clienteNome;
	}

	public String getClienteCPF() {
		return clienteCPF;
	}

	public void setClienteCPF(String clienteCPF) {
		this.clienteCPF = clienteCPF;
	}

	public String getClienteLogradouro() {
		return clienteLogradouro;
	}

	public void setClienteLogradouro(String clienteLogradouro) {
		this.clienteLogradouro = clienteLogradouro;
	}

	public String getClienteBairro() {
		return clienteBairro;
	}

	public void setClienteBairro(String clienteBairro) {
		this.clienteBairro = clienteBairro;
	}

	public String getClienteCidade() {
		return clienteCidade;
	}

	public void setClienteCidade(String clienteCidade) {
		this.clienteCidade = clienteCidade;
	}

	public String getClienteUF() {
		return clienteUF;
	}

	public void setClienteUF(String clienteUF) {
		this.clienteUF = clienteUF;
	}

	public String getClientePais() {
		return clientePais;
	}

	public void setClientePais(String clientePais) {
		this.clientePais = clientePais;
	}

	public String getClienteCep() {
		return clienteCep;
	}

	public void setClienteCep(String clienteCep) {
		this.clienteCep = clienteCep;
	}

}
