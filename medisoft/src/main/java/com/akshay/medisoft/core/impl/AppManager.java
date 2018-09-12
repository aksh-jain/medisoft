/**
 * 
 */
package com.akshay.medisoft.core.impl;

import javax.annotation.Resource;

import com.akshay.medisoft.core.IAppManager;
import com.akshay.medisoft.domain.MedicalRepresentative;
import com.akshay.medisoft.repository.IAppRepository;

/**
 * @author Akshay Jain
 *
 */
public class AppManager implements IAppManager {

	@Resource(name = "appRepository")
	IAppRepository appRepository;

	@Override
	public void enrollUser(MedicalRepresentative user) {

		appRepository.enrollUser(user);
	}

	@Override
	public void deleteUser(Long employeeId) {
		appRepository.deleteUser(employeeId);
	}

	@Override
	public MedicalRepresentative getUserDetails(Long employeeId) {
		return appRepository.getUserDetails(employeeId);
	}

	@Override
	public void updateUserDetails(MedicalRepresentative user) {
		appRepository.updateUserDetails(user);
	}

}
