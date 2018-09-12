/**
 * 
 */
package com.akshay.medisoft.core;

import com.akshay.medisoft.domain.MedicalRepresentative;

/**
 * @author Akshay Jain
 *
 */
public interface IAppManager {

	public void enrollUser(MedicalRepresentative user);

	public void deleteUser(Long employeeId);

	public MedicalRepresentative getUserDetails(Long employeeId);

	public void updateUserDetails(MedicalRepresentative user);

}
