/**
 * 
 */
package com.akshay.medisoft.service;

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

	private static final String USER_ENROLLED_SUCCESSFULLY = "User Enrolled Successfully";

	@Resource(name = "appManager")
	IAppManager appManager;

	@Resource(name = "objectMapper")
	ObjectMapper objectMapper;

	@RequestMapping(value = "user/create", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity<String> enrollUser(@RequestBody MedicalRepresentative user) throws JsonProcessingException {

		appManager.enrollUser(user);

		return new ResponseEntity<>(objectMapper.writeValueAsString(USER_ENROLLED_SUCCESSFULLY), HttpStatus.CREATED);
	}

	@RequestMapping(value = "user/delete/{employeeId}", method = RequestMethod.DELETE, consumes = "application/json")
	public ResponseEntity<String> deleteUser(@PathVariable("employeeId") @NotNull Long employeeId)
			throws JsonProcessingException {

		appManager.deleteUser(employeeId);

		return new ResponseEntity<>(objectMapper.writeValueAsString("User Deleted Successfully"), HttpStatus.OK);
	}

	@RequestMapping(value = "user/details/{employeeId}", method = RequestMethod.GET, consumes = "application/json")
	public ResponseEntity<String> getUserDetails(@PathVariable("employeeId") @NotNull Long employeeId)
			throws JsonProcessingException {

		MedicalRepresentative userDetails = appManager.getUserDetails(employeeId);

		HttpStatus httpStatus = HttpStatus.NOT_FOUND;
		String message = objectMapper.writeValueAsString("Record not present");
		if (null != userDetails) {
			httpStatus = HttpStatus.OK;
			message = objectMapper.writeValueAsString(userDetails);
		}
		return new ResponseEntity<>(message, httpStatus);
	}

	@RequestMapping(value = "user/update", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<String> updateUserDetails(@RequestBody MedicalRepresentative user)
			throws JsonProcessingException {

		appManager.updateUserDetails(user);

		return new ResponseEntity<>(objectMapper.writeValueAsString("User Updated Successfully"), HttpStatus.OK);
	}

}
