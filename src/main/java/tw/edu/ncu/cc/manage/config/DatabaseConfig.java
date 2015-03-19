package tw.edu.ncu.cc.manage.config;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

//@Configuration
//@PropertySource("classpath:database.properties")
public class DatabaseConfig {

	@Autowired
	private Environment env;
	
	@Bean
	public HikariDataSource datasource() {
	    HikariConfig hikariConfig = new HikariConfig();
	    hikariConfig.setDriverClassName("com.mysql.jdbc.Driver");
	    hikariConfig.setJdbcUrl("jdbc:mysql://localhost:3306/spring-test"); 
	    hikariConfig.setUsername(env.getRequiredProperty("username"));
	    hikariConfig.setPassword(env.getRequiredProperty("password"));

	    hikariConfig.setMaximumPoolSize(5);
	    hikariConfig.setConnectionTestQuery("SELECT 1");
	    hikariConfig.setPoolName("springHikariCP");

	    hikariConfig.addDataSourceProperty("dataSource.cachePrepStmts", "true");
	    hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSize", "250");
	    hikariConfig.addDataSourceProperty("dataSource.prepStmtCacheSqlLimit", "2048");
	    hikariConfig.addDataSourceProperty("dataSource.useServerPrepStmts", "true");

	    HikariDataSource dataSource = new HikariDataSource(hikariConfig);

	    return dataSource;
	}
	
}
