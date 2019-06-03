package br.com.polizello.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="role", uniqueConstraints={@UniqueConstraint(columnNames={"rolelogin"})})
@SequenceGenerator(name="sequence", sequenceName="default_sequence", allocationSize=5)
@DynamicUpdate
public class Role extends AbstractEntity {
	private static final long serialVersionUID = 1706206606151346251L;
	
	@Id
	@GeneratedValue(generator="sequence")
	private Long roleid;
	@NotNull
	private String rolelogin;
	@NotNull
	private String rolecred;
	
	public Role() {}
	
	public Role(Long id) {
		this();
		this.setId(id);
	}

	public Long getRoleid() {
		return roleid;
	}

	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}

	public String getRolelogin() {
		return rolelogin;
	}

	public void setRolelogin(String rolelogin) {
		this.rolelogin = rolelogin;
	}

	public String getRolecred() {
		return rolecred;
	}

	public void setRolecred(String rolecred) {
		this.rolecred = rolecred;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rolelogin == null) ? 0 : rolelogin.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		if (rolelogin == null) {
			if (other.rolelogin != null)
				return false;
		} else if (!rolelogin.equals(other.rolelogin))
			return false;
		return true;
	}

	@javax.persistence.Transient
	@Override
	public Long getId() {
		return getRoleid();
	}

	@Override
	public void setId(Long id) {
		this.roleid = id;
	}
}