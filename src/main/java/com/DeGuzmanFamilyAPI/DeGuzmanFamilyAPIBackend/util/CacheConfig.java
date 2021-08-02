package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.util;


import java.util.Arrays;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

	@Bean
	public CacheManager dsaCacheManager() {
		SimpleCacheManager dsaCacheManager = new SimpleCacheManager();
		dsaCacheManager.setCaches(Arrays.asList(
				
				));
		
		return dsaCacheManager;
	}
}
