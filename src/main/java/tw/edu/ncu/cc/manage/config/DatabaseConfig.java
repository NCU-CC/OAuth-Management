package tw.edu.ncu.cc.manage.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableTransactionManagement(mode = AdviceMode.PROXY)
@PropertySource("classpath:database.properties")
public class DatabaseConfig {

	@Autowired
	private Environment env;
	
	@Bean(destroyMethod = "close")
	public HikariDataSource dataSource() {
	    
	    HikariDataSource dataSource = new HikariDataSource(hikariConfig());

	    return dataSource;
	}
	
	@Bean HikariConfig hikariConfig() {
		HikariConfig hikariConfig = new HikariConfig();
		
	    hikariConfig.setPoolName("springHikariCP");
	    hikariConfig.setConnectionTestQuery("SELECT 1");
	    hikariConfig.setMaximumPoolSize(100);
	    hikariConfig.setMinimumIdle(10);
	    hikariConfig.setIdleTimeout(600000);
	    hikariConfig.setDataSourceClassName(env.getRequiredProperty("jdbc.driver"));

	    hikariConfig.addDataSourceProperty("url", env.getRequiredProperty("jdbc.url"));
	    hikariConfig.addDataSourceProperty("user", env.getRequiredProperty("jdbc.username"));
	    hikariConfig.addDataSourceProperty("password", env.getRequiredProperty("jdbc.password"));
	    
	    hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
	    hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
	    hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
	    hikariConfig.addDataSourceProperty("useServerPrepStmts", "true");
	    hikariConfig.addDataSourceProperty("useUnicode", "true");
	    hikariConfig.addDataSourceProperty("characterEncoding", "utf8");
	    
	    return hikariConfig;
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {

		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setPackagesToScan(new String[] { "tw.edu.ncu.edu.manage.entity"});
		
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		emf.setJpaVendorAdapter(vendorAdapter);
		emf.setJpaProperties(jpaProperties());

		return emf;
	}
	
	private Properties jpaProperties() {
		Properties properties = new Properties();

		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServer2008Dialect");
		properties.setProperty("hibernate.show_sql", "false");
		properties.setProperty("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
		
		return properties;
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

	
}
