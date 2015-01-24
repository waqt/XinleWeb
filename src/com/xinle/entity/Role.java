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
	private long id;
	private String roleName;
	private String department;
	private Date createTime;
	private Set<UserRole> userRole;
//	private Set<RoleAuthorities> roleAuthorities;

	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Column(name = "ID", unique = true, nullable = false, length = 11)
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "role_name", length = 50)
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "department", length = 100)
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "create_time")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@OneToMany(cascade =CascadeType.ALL)
	@JoinColumn(name="ID", referencedColumnName="role_id")
	public Set<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<UserRole> userRole) {
		this.userRole = userRole;
	}

//	public Set<RoleAuthorities> getRoleAuthorities() {
//		return roleAuthorities;
//	}
//
//	public void setRoleAuthorities(Set<RoleAuthorities> roleAuthorities) {
//		this.roleAuthorities = roleAuthorities;
//	}

}
