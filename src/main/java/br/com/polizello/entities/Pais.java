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
@Table(name="pais", uniqueConstraints={@UniqueConstraint(columnNames={"paisCodigo"})})
@SequenceGenerator(name="sequence", sequenceName="default_sequence", allocationSize=5)
@DynamicUpdate
public class Pais extends AbstractEntity {
	private static final long serialVersionUID = 1207283064939419139L;
	
	@Id
	@GeneratedValue(generator="sequence")
	private Long paisId;
	@NotNull
	@Size(max=10)
	private String paisCodigo;
	@NotNull
	@Size(max=50)
	private String paisNome;
	@NotNull
	@Size(max=3)
	private String paisIBGE;

	public Pais() {}
	
	public Pais(Long id) {
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

	public Long getPaisId() {
		return paisId;
	}

	public void setPaisId(Long paisId) {
		this.paisId = paisId;
	}

	public String getPaisCodigo() {
		return paisCodigo;
	}

	public void setPaisCodigo(String paisCodigo) {
		this.paisCodigo = paisCodigo;
	}

	public String getPaisNome() {
		return paisNome;
	}

	public void setPaisNome(String paisNome) {
		this.paisNome = paisNome;
	}

	public String getPaisIBGE() {
		return paisIBGE;
	}

	public void setPaisIBGE(String paisIBGE) {
		this.paisIBGE = paisIBGE;
	}
}
