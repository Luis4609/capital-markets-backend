package com.optimissa.elementalarchetype.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.ejb.HibernatePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Database connection configuration
 *
 * @author pedro.uceda
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.optimissa.elementalarchetype.dao")
public class JpaLoader {

    private Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private JpaConfiguration jpaConfiguration;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setPersistenceProviderClass(HibernatePersistence.class);
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());
        em.setPersistenceUnitName(jpaConfiguration.getPersistenceUnitName());
        em.setPackagesToScan(jpaConfiguration.getPackagesToScan());
        em.afterPropertiesSet();
        return em;
    }

    @Bean
    @Profile(value = "dev")
    @Qualifier("dataSource")
    public DataSource dataSourceDev() {
        logger.debug("Setting up the development datasource");
        DataSource dataSource = DataSourceBuilder.create(DriverManagerDataSource.class.getClassLoader())
                .driverClassName(jpaConfiguration.getDriverClassNameDb())
                .url(jpaConfiguration.getUrlDb())
                .username(jpaConfiguration.getUsernameDb())
                .password(jpaConfiguration.getPasswordDb())
                .build();
        return dataSource;
    }

    @Bean
    @Profile(value = "!dev")
    @Qualifier("dataSource")
    public DataSource dataSourceJndi() {
        logger.debug("Setting up the jndi datasource");
        DataSource dataSource = null;
        JndiObjectFactoryBean jndiObjectFactoryBean = null;

        try {
            jndiObjectFactoryBean = new JndiObjectFactoryBean();
            jndiObjectFactoryBean.setJndiName(jpaConfiguration.getJndiName());
            jndiObjectFactoryBean.setExpectedType(DataSource.class);
            jndiObjectFactoryBean.afterPropertiesSet();
        } catch (NamingException e) {
            logger.error("Error while retrieving datasource ", e);
        }

        dataSource = DataSource.class.cast(jndiObjectFactoryBean.getObject());
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "none");
        properties.setProperty("hibernate.dialect", jpaConfiguration.getDialectDb());
        properties.setProperty("hibernate.show_sql", "false");
        properties.setProperty("hibernate.cache.use_second_level_cache", "false");
        if(jpaConfiguration.getSchemaDb() != null) {
            properties.setProperty("hibernate.default_schema", jpaConfiguration.getSchemaDb());
        }
        return properties;
    }

}
