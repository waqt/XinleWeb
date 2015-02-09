package com.xinle.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "sys_resources")
public class Resources {
	
	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@GeneratedValue(generator = "generator")
	@Column(name = "RESOURCE_ID", unique = true, nullable = false, length = 11)
	private String resourceId;

	@Column(name = "RESOURCE_NAME", length = 100)
	private String resourceName;
	
	@Column(name = "RESOURCE_DESC", length = 100)
	private String resourceDesc;
	
	@Column(name = "RESOURCE_TYPE", length = 40)
	private String resourceType;
	
	@Column(name = "RESOURCE_STRING", length = 200)
	private String resourceString;
	
    @Type(type = "yes_no")
    @Column(name = "PRIORITY")
	private Boolean priority;
    
    @Type(type = "yes_no")
    @Column(name = "ENABLED")
	private Integer enabled;
    
    @Type(type = "yes_no")
    @Column(name = "ISSYS")
	private Integer issys;

	@Column(name = "MODULE", length = 4)
	private String module;
	
	@OneToMany(mappedBy = "resources")
	private Set<AuthorityResource> sysAuthoritiesResourceses;
}
