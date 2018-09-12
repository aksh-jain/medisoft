/**
 * 
 */
package com.akshay.medisoft.service;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.akshay.medisoft.core.IAppManager;
import com.akshay.medisoft.domain.MedicalRepresentative;
import com.akshay.medisoft.domain.UserDetails;
import com.akshay.medisoft.exception.ReportableException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Class containing REST calls
 * 
 * @author Akshay Jain
 *
 */
@RestController
@RequestMapping(value = "/medisoft", produces = "application/json;charset=UTF-8")
public class AppService {

	private static final String NO_SUCH_USER_IS_PRESENT = "No such user is present";

	private static final String USER_ALREADY_ENROLLED = "User already enrolled";

	private static final String RECORD_NOT_PRESENT = "Record not present";

	private static final String NO_USER_FOUND = "No User Found";

	private static final String USER_UPDATED_SUCCESSFULLY = "User Updated Successfully";

	private static final String USER_DELETED_SUCCESSFULLY = "User Deleted Successfully";

	private static final String USER_ENROLLED_SUCCESSFULLY = "User Enrolled Successfully";

	@Resource(name = "appManager")
	IAppManager appManager;

	@Resource(name = "objectMapper")
	ObjectMapper objectMapper;

	@RequestMapping(value = "user/create", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<String> enrollUser(@RequestBody MedicalRepresentative user) throws JsonProcessingException {

		String message;
		HttpStatus httpStatus;

		try {
			
			appManager.enrollUser(user);

			message = objectMapper.writeValueAsString(USER_ENROLLED_SUCCESSFULLY);
			httpStatus = HttpStatus.CREATED;


		} catch (ReportableException re) {
			message = objectMapper.writeValueAsString(USER_ALREADY_ENROLLED);
			httpStatus = HttpStatus.OK;
		}
		return new ResponseEntity<>(message, httpStatus);
	}

	@RequestMapping(value = "user/delete/{employeeId}", method = RequestMethod.DELETE, consumes = "application/json")
	public ResponseEntity<String> deleteUser(@PathVariable("employeeId") @NotNull Long employeeId)
			throws JsonProcessingException {

		String message;

		try {
			appManager.deleteUser(employeeId);
			message = objectMapper.writeValueAsString(USER_DELETED_SUCCESSFULLY);

		} catch (ReportableException re) {
			message = objectMapper.writeValueAsString(NO_SUCH_USER_IS_PRESENT);
		}
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@RequestMapping(value = "user/details/{employeeId}", method = RequestMethod.GET, consumes = "application/json")
	public ResponseEntity<String> getUserDetails(@PathVariable("employeeId") @NotNull Long employeeId)
			throws JsonProcessingException {

		MedicalRepresentative userDetails = appManager.getUserDetails(employeeId);

		String message;
		if (null != userDetails) {
			message = objectMapper.writeValueAsString(userDetails);
		} else {
			message = objectMapper.writeValueAsString(RECORD_NOT_PRESENT);
		}
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@RequestMapping(value = "user/update", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> updateUserDetails(@RequestBody MedicalRepresentative user)
			throws JsonProcessingException {
		String message;

		try {
			appManager.updateUserDetails(user);
			message = objectMapper.writeValueAsString(USER_UPDATED_SUCCESSFULLY);

		} catch (ReportableException re) {
			message = objectMapper.writeValueAsString(NO_SUCH_USER_IS_PRESENT);
		}
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

	@RequestMapping(value = "users", method = RequestMethod.GET, consumes = "application/json")
	public ResponseEntity<String> getAllUsers() throws JsonProcessingException {

		String message;

		List<UserDetails> userList = appManager.getAllUsers();

		if (null == userList || userList.isEmpty()) {
			message = objectMapper.writeValueAsString(NO_USER_FOUND);
		} else {
			message = objectMapper.writeValueAsString(userList);
		}

		return new ResponseEntity<>(message, HttpStatus.OK);
	}

}
