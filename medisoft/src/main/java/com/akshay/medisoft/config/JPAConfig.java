package com.akshay.medisoft.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Class containing configuration for hibernate.
 * 
 * @author Akshay Jain
 *
 */

@Configuration
@EnableTransactionManagement
public class JPAConfig {

	private static final String ENTITY_PACKAGE = "com.akshay.medisoft.entity";

	@Value("${dbDriver}")
	private String driverClassName;

	@Value("${dbUrl}")
	private String url;

	@Value("${dbUser}")
	private String username;

	@Value("${dbPassword}")
	private String password;

	@Value("${hibernate.dialect}")
	private String hibernateDialect;

	@Value("${hibernate.showSql}")
	private String hibernateShowSql;

	@Value("${hibernate.formatSql}")
	private String hibernateFormatSql;

	@Value("${javax.persistence.query.timeout}")
	private String queryTimeout;

	@Value("${hibernate.hbm2ddl.auto}")
	private String hibernateHbm2ddlAuto;

	@Value("${loadTestData}")
	private Boolean loadTestData;

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource());
		em.setPackagesToScan(new String[] { ENTITY_PACKAGE });

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(hibernateProperties());

		return em;
	}

	@Bean()
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		return ds;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);

		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	@Bean
	public Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", hibernateDialect);
		properties.put("hibernate.show_sql", hibernateShowSql);
		properties.put("hibernate.hbm2ddl.auto", hibernateHbm2ddlAuto);
		properties.put("hibernate.format_sql", hibernateFormatSql);
		properties.put("javax.persistence.query.timeout", queryTimeout);

		List<String> importFileList = new ArrayList<>();

		if (loadTestData) {

			importFileList.add("test_data/MS_MR_DTL.sql");

			String importFileString = "";
			int iterationCounter = 0;
			for (String s : importFileList) {
				iterationCounter++;
				if (iterationCounter == 1) {
					importFileString += s;
				} else {
					importFileString += "," + s;
				}
			}

			properties.setProperty("hibernate.hbm2ddl.import_files", importFileString);

		}

		return properties;
	}

}
