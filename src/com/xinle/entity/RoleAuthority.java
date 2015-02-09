package com.xinle.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "sys_role_authority")
public class RoleAuthority {

	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Column(name = "ID", unique = true, nullable = false, length = 11)
	private long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "id")
	private Authorities authorities;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ROLE_ID", referencedColumnName = "id")
	private Role role;

	@Type(type = "yes_no")
	@Column(name = "ENABLED")
	private Boolean enabled;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Authorities getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Authorities authorities) {
		this.authorities = authorities;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

}
