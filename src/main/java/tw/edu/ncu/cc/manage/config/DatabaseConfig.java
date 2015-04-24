package tw.edu.ncu.cc.manage.config;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
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
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[] { "tw.edu.ncu.cc.manage.entity" });
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
     }
	
	private Properties hibernateProperties() {
		Properties properties = new Properties();

		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.SQLServer2008Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.ejb.naming_strategy", "org.hibernate.cfg.ImprovedNamingStrategy");
		properties.setProperty("hibernate.cache.provider_class", "org.hibernate.cache.EhCacheProvider");
		
		return properties;
	}

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory s) {
       HibernateTransactionManager txManager = new HibernateTransactionManager();
       txManager.setSessionFactory(s);
       return txManager;
    }

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
}
