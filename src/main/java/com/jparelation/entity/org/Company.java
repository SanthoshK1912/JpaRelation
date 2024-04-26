package com.jparelation.entity.org;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Company {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="company_id")
	private int id;
	@Column(name="company_name")
	private String companyName;
	@Column(name="type")
	private String companyType;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="org_id")
	private Organization org;

}
