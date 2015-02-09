package com.xinle.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table (name="sys_roles")
public class Role {
	
	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Column(name = "ID", unique = true, nullable = false, length = 11)
	private long id;
	
	
	@Column(name = "role_name", length = 50)
	private String roleName;
	
	@Column(name = "department", length = 100)
	private String department;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time")
	private Date createTime;
	
	
	@OneToMany(mappedBy = "role")
	private Set<UserRole> userRole;
	
	
//	private Set<RoleAuthorities> roleAuthorities;

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public Set<UserRole> getUserRole() {
		return this.userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

//	public Set<RoleAuthority> getRoleAuthority() {
//		return roleAuthority;
//	}
//
//	public void setRoleAuthority(Set<RoleAuthority> roleAuthority) {
//		this.roleAuthority = roleAuthority;
//	}

}
