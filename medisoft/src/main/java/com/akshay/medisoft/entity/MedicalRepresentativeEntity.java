/**
 * 
 */
package com.akshay.medisoft.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Akshay Jain
 *
 */
@Entity
@Table(name = "MS_MR_DTL")
public class MedicalRepresentativeEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "MR_ID", length = 10)
	private Long representativeEmployeeId;

	@Column(name = "FIRST_NAME", nullable = false, length = 50)
	private String representativeFirstName;

	@Column(name = "LAST_NAME", nullable = false, length = 50)
	private String representativeLastName;

	@Column(name = "CMPNY_ID", nullable = false, length = 10)
	private Long companyId;

	@Column(name = "MR_ADDRESS", nullable = false, length = 100)
	private String representativeAddress;

	@Column(name = "MR_COUNTRY", nullable = false, length = 20)
	private String representativeCountry;

	@Column(name = "MR_STATE", nullable = false, length = 20)
	private String representativeState;

	@Column(name = "MR_CITY", nullable = false, length = 0)
	private String representativeCity;

	@Column(name = "MR_PINCODE", nullable = false, length = 6)
	private Long representativePinCode;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinTable(name = "MS_REPRESENTATIVE_DRUG", joinColumns = { @JoinColumn(name = "MR_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "PRODUCT_CODE") })
	private List<DrugEntity> drugList;

	public Long getRepresentativeEmployeeId() {
		return representativeEmployeeId;
	}

	public void setRepresentativeEmployeeId(Long representativeEmployeeId) {
		this.representativeEmployeeId = representativeEmployeeId;
	}

	public String getRepresentativeFirstName() {
		return representativeFirstName;
	}

	public void setRepresentativeFirstName(String representativeFirstName) {
		this.representativeFirstName = representativeFirstName;
	}

	public String getRepresentativeLastName() {
		return representativeLastName;
	}

	public void setRepresentativeLastName(String representativeLastName) {
		this.representativeLastName = representativeLastName;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public String getRepresentativeAddress() {
		return representativeAddress;
	}

	public void setRepresentativeAddress(String representativeAddress) {
		this.representativeAddress = representativeAddress;
	}

	public String getRepresentativeCountry() {
		return representativeCountry;
	}

	public void setRepresentativeCountry(String representativeCountry) {
		this.representativeCountry = representativeCountry;
	}

	public String getRepresentativeState() {
		return representativeState;
	}

	public void setRepresentativeState(String representativeState) {
		this.representativeState = representativeState;
	}

	public String getRepresentativeCity() {
		return representativeCity;
	}

	public void setRepresentativeCity(String representativeCity) {
		this.representativeCity = representativeCity;
	}

	public Long getRepresentativePinCode() {
		return representativePinCode;
	}

	public void setRepresentativePinCode(Long representativePinCode) {
		this.representativePinCode = representativePinCode;
	}

	public List<DrugEntity> getDrugList() {
		return drugList;
	}

	public void setDrugList(List<DrugEntity> drugList) {
		this.drugList = drugList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((representativeEmployeeId == null) ? 0 : representativeEmployeeId.hashCode());
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
		MedicalRepresentativeEntity other = (MedicalRepresentativeEntity) obj;
		if (representativeEmployeeId == null) {
			if (other.representativeEmployeeId != null)
				return false;
		} else if (!representativeEmployeeId.equals(other.representativeEmployeeId))
			return false;
		return true;
	}

}
