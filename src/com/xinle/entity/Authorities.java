package com.xinle.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "sys_authorities")
public class Authorities {
	private String authorityId;
	private String authorityName;
	private String authorityDesc;
	private Boolean enabled;
	private Boolean issys;
	private String module;
	
	@OneToMany(mappedBy = "Authorities")
	private Set<RoleAuthority> roleAuthority;
	private Set<AuthorityResource> authorityResource;

	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Column(name = "ID",unique = true, nullable = false, length = 11)
	public String getAuthorityId() {
		return authorityId;
	}

	public void setAuthorityId(String authorityId) {
		this.authorityId = authorityId;
	}
	
	@Column(name = "AUTHORITY_NAME", length = 40)
	public String getAuthorityName() {
		return authorityName;
	}

	public void setAuthorityName(String authorityName) {
		this.authorityName = authorityName;
	}

	@Column(name = "AUTHORITY_DESC", length = 100)
	public String getAuthorityDesc() {
		return authorityDesc;
	}

	public void setAuthorityDesc(String authorityDesc) {
		this.authorityDesc = authorityDesc;
	}

    @Type(type = "yes_no")
    @Column(name = "ENABLED")
	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

    @Type(type = "yes_no")
    @Column(name = "ISSYS")
	public Boolean getIssys() {
		return issys;
	}

	public void setIssys(Boolean issys) {
		this.issys = issys;
	}

	@Column(name = "MODULE", length = 4)
	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	@OneToMany(mappedBy = "authorities")
	public Set<RoleAuthority> getRoleAuthority() {
		return roleAuthority;
	}
	
	
	public void setRoleAuthority(Set<RoleAuthority> roleAuthority) {
		this.roleAuthority = roleAuthority;
	}

	
//	public Set<AuthorityResource> getAuthorityResource() {
//		return authorityResource;
//	}
//
//	public void setAuthorityResource(Set<AuthorityResource> authorityResource) {
//		this.authorityResource = authorityResource;
//	}

}
