package com.jparelation.entity.org;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Organization {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="org_id")
	private int orgId;
	@Column(name="name")
	private String orgName;
	
	@OneToMany
	private List<Company> company;
	
//	@Column(name="company_id")
//	private Company com;


}
