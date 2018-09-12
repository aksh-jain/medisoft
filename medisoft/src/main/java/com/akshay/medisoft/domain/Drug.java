/**
 * 
 */
package com.akshay.medisoft.domain;

import java.io.Serializable;

/**
 * @author Akshay Jain
 *
 */
public class Drug implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private String description;

	private String about;

	private String symptoms;

	private String moleculeName;

	private String productCode;

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

	@Override
	public String toString() {
		return "Drug [name=" + name + ", description=" + description + ", about=" + about + ", symptoms=" + symptoms
				+ ", moleculeName=" + moleculeName + ", productCode=" + productCode + "]";
	}

}
