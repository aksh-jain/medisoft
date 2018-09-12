/**
 * 
 */
package com.akshay.medisoft.core.impl;

import java.util.List;

import javax.annotation.Resource;

import com.akshay.medisoft.core.IAppManager;
import com.akshay.medisoft.domain.MedicalRepresentative;
import com.akshay.medisoft.domain.UserDetails;
import com.akshay.medisoft.exception.ReportableException;
import com.akshay.medisoft.repository.IAppRepository;

/**
 * @author Akshay Jain
 *
 */
public class AppManager implements IAppManager {

	@Resource(name = "appRepository")
	IAppRepository appRepository;

	@Override
	public void enrollUser(MedicalRepresentative user) throws ReportableException {

		appRepository.enrollUser(user);
	}

	@Override
	public void deleteUser(Long employeeId) throws ReportableException {
		appRepository.deleteUser(employeeId);
	}

	@Override
	public MedicalRepresentative getUserDetails(Long employeeId) {
		return appRepository.getUserDetails(employeeId);
	}

	@Override
	public void updateUserDetails(MedicalRepresentative user) throws ReportableException {
		appRepository.updateUserDetails(user);
	}

	@Override
	public List<UserDetails> getAllUsers() {
		return appRepository.getAllUsers();
	}

}
