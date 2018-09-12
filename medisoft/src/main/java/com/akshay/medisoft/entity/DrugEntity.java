/**
 * 
 */
package com.akshay.medisoft.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Akshay Jain
 *
 */
@Entity
@Table(name = "MS_DRUG_DTL")
public class DrugEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DRUG_ID", length = 10)
	private Long drugId;

	@Column(name = "DRUG_NAME", nullable = false, length = 50)
	private String name;

	@Column(name = "DRUG_DESCRIPTION", nullable = false, length = 50)
	private String description;

	@Column(name = "DRUG_ABOUT", nullable = false, length = 50)
	private String about;

	@Column(name = "SYMPTOMS", nullable = false, length = 50)
	private String symptoms;

	@Column(name = "MOLECULE_NAME", nullable = false, length = 50)
	private String moleculeName;

	@Column(name = "PRODUCT_CODE", nullable = false, length = 50)
	private String productCode;

	@ManyToMany(mappedBy = "drugList")
	private List<MedicalRepresentativeEntity> employees;

	public Long getDrugId() {
		return drugId;
	}

	public void setDrugId(Long drugId) {
		this.drugId = drugId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getMoleculeName() {
		return moleculeName;
	}

	public void setMoleculeName(String moleculeName) {
		this.moleculeName = moleculeName;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public List<MedicalRepresentativeEntity> getEmployees() {
		return employees;
	}

	public void setEmployees(List<MedicalRepresentativeEntity> employees) {
		this.employees = employees;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((drugId == null) ? 0 : drugId.hashCode());
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
		DrugEntity other = (DrugEntity) obj;
		if (drugId == null) {
			if (other.drugId != null)
				return false;
		} else if (!drugId.equals(other.drugId))
			return false;
		return true;
	}

}
