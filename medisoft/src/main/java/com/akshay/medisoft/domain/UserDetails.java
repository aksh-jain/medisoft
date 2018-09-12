/**
 * 
 */
package com.akshay.medisoft.domain;

import java.io.Serializable;

/**
 * @author Akshay Jain
 *
 */
public class UserDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long representativeEmployeeId;

	private String representativeFirstName;

	private String representativeLastName;

	private Long companyId;

	private String representativeAddress;

	private String representativeCountry;

	private String representativeState;

	private String representativeCity;

	private Long representativePinCode;

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

	@Override
	public String toString() {
		return "UserDetails [representativeEmployeeId=" + representativeEmployeeId + ", representativeFirstName="
				+ representativeFirstName + ", representativeLastName=" + representativeLastName + ", companyId="
				+ companyId + ", representativeAddress=" + representativeAddress + ", representativeCountry="
				+ representativeCountry + ", representativeState=" + representativeState + ", representativeCity="
				+ representativeCity + ", representativePinCode=" + representativePinCode + "]";
	}

}
