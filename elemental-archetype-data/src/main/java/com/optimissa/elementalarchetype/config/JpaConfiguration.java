package com.optimissa.elementalarchetype.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by pedro.uceda on 08/03/2017.
 */
@Configuration
@PropertySource("file:${ELEMENTAL_ARCHETYPE_HOME}/Development/database.properties")
public class JpaConfiguration {


    @Value("${db.driver.class.name}")
    private String driverClassNameDb;

    @Value("${db.url}")
    private String urlDb;

    @Value("${db.username}")
    private String usernameDb;

    @Value("${db.password}")
    private String passwordDb;

    @Value("${persistence.unit.name}")
    private String persistenceUnitName;

    @Value("${db.dialect}")
    private String dialectDb;

    @Value("${db.schema}")
    private String schemaDb;

    @Value("${jndi.name}")
    private String jndiName;

    @Value("${persistence.packages.to.scan}")
    private String packagesToScan;

    public String getDriverClassNameDb() {
        return driverClassNameDb;
    }

    public void setDriverClassNameDb(String driverClassNameDb) {
        this.driverClassNameDb = driverClassNameDb;
    }

    public String getUrlDb() {
        return urlDb;
    }

    public void setUrlDb(String urlDb) {
        this.urlDb = urlDb;
    }

    public String getUsernameDb() {
        return usernameDb;
    }

    public void setUsernameDb(String usernameDb) {
        this.usernameDb = usernameDb;
    }

    public String getPasswordDb() {
        return passwordDb;
    }

    public void setPasswordDb(String passwordDb) {
        this.passwordDb = passwordDb;
    }

    public String getPersistenceUnitName() {
        return persistenceUnitName;
    }

    public void setPersistenceUnitName(String persistenceUnitName) {
        this.persistenceUnitName = persistenceUnitName;
    }

    public String getJndiName() {
        return jndiName;
    }

    public void setJndiName(String jndiName) {
        this.jndiName = jndiName;
    }

    public String getDialectDb() {
        return dialectDb;
    }

    public void setDialectDb(String dialectDb) {
        this.dialectDb = dialectDb;
    }

    public String getSchemaDb() {
        return schemaDb;
    }

    public void setSchemaDb(String schemaDb) {
        this.schemaDb = schemaDb;
    }

    public String getPackagesToScan() {
        return packagesToScan;
    }

    public void setPackagesToScan(String packagesToScan) {
        this.packagesToScan = packagesToScan;
    }
}
