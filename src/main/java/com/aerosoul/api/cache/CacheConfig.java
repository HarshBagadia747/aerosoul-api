package com.aerosoul.api.cache;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;

@Configuration
@EnableCaching
public class CacheConfig {

	@Bean
	public Caffeine<Object, Object> caffeineConfig() {
		return Caffeine.newBuilder().expireAfterWrite(1, TimeUnit.DAYS) // Cache expiry after 1 day
				.maximumSize(100); // Maximum 100 entries in the cache
	}

	@Bean
	public CacheManager cacheManager(Caffeine<Object, Object> caffeine) {
		CaffeineCacheManager cacheManager = new CaffeineCacheManager();
		cacheManager.setCaffeine(caffeine);
		return cacheManager;
	}
}
