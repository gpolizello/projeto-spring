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
@Table(name="usuario", uniqueConstraints={@UniqueConstraint(columnNames={"usrlogin"})})
@SequenceGenerator(name="sequence", sequenceName="default_sequence", allocationSize=5)
@DynamicUpdate
public class Usuario extends AbstractEntity {
	private static final long serialVersionUID = 1883056410666438213L;
	
	@Id
	@GeneratedValue(generator="sequence")
	private Long usrId;
	@NotNull
	@Size(max=10)
	private String usrLogin;
	@NotNull
	@Size(max=20)
	private String usrPass;
	@NotNull
	@Size(max=100)
	private String usrEmail;
	private Integer usrEnabled;
	
	public Usuario() {}
	
	public Usuario(Long id) {
		this();
		this.setId(id);
	}

	public Long getUsrid() {
		return usrId;
	}

	public void setUsrid(Long usrId) {
		this.usrId = usrId;
	}

	public String getUsrlogin() {
		return usrLogin;
	}

	public void setUsrlogin(String usrLogin) {
		this.usrLogin = usrLogin;
	}

	public String getUsrpass() {
		return usrPass;
	}

	public void setUsrpass(String usrPass) {
		this.usrPass = usrPass;
	}

	public String getUsremail() {
		return usrEmail;
	}

	public void setUsremail(String usrEmail) {
		this.usrEmail = usrEmail;
	}

	public Integer isUsrenabled() {
		return usrEnabled;
	}

	public void setUsrenabled(Integer usrEnabled) {
		this.usrEnabled = usrEnabled;
	}

	@javax.persistence.Transient
	@Override
	public Long getId() {
		return getUsrid();
	}

	@Override
	public void setId(Long id) {
		this.usrId = id;
	}
	
}
