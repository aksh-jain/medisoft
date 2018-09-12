package com.akshay.medisoft.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.TypedQuery;

import org.dozer.Mapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.akshay.medisoft.domain.MedicalRepresentative;
import com.akshay.medisoft.domain.UserDetails;
import com.akshay.medisoft.entity.MedicalRepresentativeEntity;
import com.akshay.medisoft.exception.ReportableException;
import com.akshay.medisoft.repository.AbstractDao;
import com.akshay.medisoft.repository.IAppRepository;

/**
 * @author Akshay Jain
 *
 */
public class AppRepository extends AbstractDao implements IAppRepository {

	private static final String GET_ALL_USERS = "mrDetails.getAllUsers";
	private static final String NO_SUCH_USER_IS_AVAILABLE = "No such user is available";
	private static final String USER_IS_ALREADY_ENROLLED = "User is already enrolled";

	@Resource(name = "mapper")
	Mapper mapper;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void enrollUser(MedicalRepresentative user) throws ReportableException {

		MedicalRepresentativeEntity savedUser = getEm().find(MedicalRepresentativeEntity.class,
				user.getRepresentativeEmployeeId());

		if (null != savedUser) {
			throw new ReportableException(USER_IS_ALREADY_ENROLLED);
		}

		MedicalRepresentativeEntity entity = mapper.map(user, MedicalRepresentativeEntity.class);

		getEm().persist(entity);
		getEm().flush();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteUser(Long employeeId) throws ReportableException {

		MedicalRepresentativeEntity user = getEm().find(MedicalRepresentativeEntity.class, employeeId);
		if (null == user) {
			throw new ReportableException(NO_SUCH_USER_IS_AVAILABLE);
		}
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
	public void updateUserDetails(MedicalRepresentative user) throws ReportableException {

		MedicalRepresentativeEntity savedUser = getEm().find(MedicalRepresentativeEntity.class,
				user.getRepresentativeEmployeeId());
		if (null == savedUser) {
			throw new ReportableException(NO_SUCH_USER_IS_AVAILABLE);
		}

		MedicalRepresentativeEntity entity = mapper.map(user, MedicalRepresentativeEntity.class);

		getEm().merge(entity);
		getEm().flush();
	}

	@Override
	public List<UserDetails> getAllUsers() {

		List<UserDetails> allUsers = null;

		TypedQuery<MedicalRepresentativeEntity> query = getEm().createNamedQuery(GET_ALL_USERS,
				MedicalRepresentativeEntity.class);

		List<MedicalRepresentativeEntity> userList = query.getResultList();
		if (!userList.isEmpty()) {
			allUsers = new ArrayList<>(userList.size());
			for (MedicalRepresentativeEntity entity : userList) {
				allUsers.add(mapper.map(entity, UserDetails.class));
			}
		}
		return allUsers;
	}

}
