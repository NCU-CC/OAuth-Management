package tw.edu.ncu.cc.manage.config;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.cache.CacheBuilder;

@Configuration
public class CacheConfig {
	@Bean
	public CacheManager cacheManager() {
	 GuavaCacheManager guavaCacheManager =  new GuavaCacheManager();
	 guavaCacheManager.setCacheBuilder(CacheBuilder.newBuilder().expireAfterAccess(30, TimeUnit.MINUTES));
	 return guavaCacheManager;
	}
}
