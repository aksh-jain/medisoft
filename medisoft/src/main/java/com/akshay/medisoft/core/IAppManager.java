/**
 * 
 */
package com.akshay.medisoft.core;

import java.util.List;

import com.akshay.medisoft.domain.MedicalRepresentative;
import com.akshay.medisoft.domain.UserDetails;
import com.akshay.medisoft.exception.ReportableException;

/**
 * @author Akshay Jain
 *
 */
public interface IAppManager {

	public void enrollUser(MedicalRepresentative user) throws ReportableException;

	public void deleteUser(Long employeeId) throws ReportableException;

	public MedicalRepresentative getUserDetails(Long employeeId);

	public void updateUserDetails(MedicalRepresentative user) throws ReportableException;

	public List<UserDetails> getAllUsers();

}
