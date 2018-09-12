package com.akshay.medisoft.repository.impl;

import javax.annotation.Resource;

import org.dozer.Mapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.akshay.medisoft.domain.MedicalRepresentative;
import com.akshay.medisoft.entity.MedicalRepresentativeEntity;
import com.akshay.medisoft.repository.AbstractDao;
import com.akshay.medisoft.repository.IAppRepository;

/**
 * @author Akshay Jain
 *
 */
public class AppRepository extends AbstractDao implements IAppRepository {

	@Resource(name = "mapper")
	Mapper mapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void enrollUser(MedicalRepresentative user) {

		MedicalRepresentativeEntity entity = mapper.map(user, MedicalRepresentativeEntity.class);

		getEm().persist(entity);
		getEm().flush();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteUser(Long employeeId) {

		MedicalRepresentativeEntity user = getEm().find(MedicalRepresentativeEntity.class, employeeId);
		getEm().remove(user);
		getEm().flush();
	}

	@Override
	public MedicalRepresentative getUserDetails(Long employeeId) {

		MedicalRepresentativeEntity user = getEm().find(MedicalRepresentativeEntity.class, employeeId);

		return null != user ? mapper.map(user, MedicalRepresentative.class) : null;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateUserDetails(MedicalRepresentative user) {

		MedicalRepresentativeEntity entity = mapper.map(user, MedicalRepresentativeEntity.class);

		getEm().merge(entity);
		getEm().flush();
	}

}
