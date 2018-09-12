/**
 * 
 */
package com.akshay.medisoft.config;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.akshay.medisoft.core.IAppManager;
import com.akshay.medisoft.core.impl.AppManager;
import com.akshay.medisoft.repository.IAppRepository;
import com.akshay.medisoft.repository.impl.AppRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * Class containing basic configuration and bean declaration
 * 
 * @author Akshay Jain
 *
 */
@Configuration
public class AppConfig {

	@Bean
	public IAppRepository appRepository() {
		return new AppRepository();
	}

	@Bean
	public IAppManager appManager() {
		return new AppManager();
	}

	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}

	@Bean
	public DozerBeanMapper mapper() {
		List<String> mappingFiles = new ArrayList<String>();
		mappingFiles.add("META-INF/dozer-configration-mapping.xml");

		DozerBeanMapper mapper = new DozerBeanMapper();
		mapper.setMappingFiles(mappingFiles);
		return mapper;

	}

}
