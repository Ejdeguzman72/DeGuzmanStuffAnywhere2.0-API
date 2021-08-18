package com.DeGuzmanFamilyAPI.DeGuzmanFamilyAPIBackend.util;

import java.util.Arrays;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

	private String USER_LIST = "userList";
	private String AUTO_TRANSACTION_LIST = "autoTransactionList";
	private String BOOK_PAGINATION_LIST = "bookPaginationList";
	private String CAR_LIST = "carList";
	private String EXERCISE_LIST = "exerciseList";
	private String FACILITY_LIST = "facilityList";
	private String MEDICAL_TRANSACTION_LIST = "medicalTrasactionList";
	private String PERSON_LIST = "personList";
	private String RESTAURANT_LIST = "restaurantList";
	private String RUN_LIST = "runList";
	private String SONG_LIST = "songList";
	private String TRANSACTION_LIST = "transactionList";
	private String UTILITY_LIST = "utilityList";
	
	private String AUTO_TRANSACTION_BY_ID = "autoTrasactionById";
	private String BOOK_BY_ID = "bookById";
	private String RESTAURANT_BY_ID = "restaurantById";
	private String RUN_TRACKER_BY_ID = "runById";
	private String SONG_BY_ID = "songById";
	private String TRANSACTION_BY_ID = "generalTrasactionById";
	private String USER_BY_ID = "userById";
	private String UTILITY_BY_ID = "utilityById";
	private String CAR_BY_ID = "carById";
	private String MEDICAL_TRANSACTION_BY_ID = "medicaTrasactionById";
	private String EXERCISE_BY_ID = "exerciseById";
	
	private String BOOK_BY_NAME = "bookName";

	@Bean
	public CacheManager dsaCacheManager() {
		SimpleCacheManager dsaCacheManager = new SimpleCacheManager();
		dsaCacheManager.setCaches(Arrays.asList(
				new ConcurrentMapCache(AUTO_TRANSACTION_BY_ID),
				new ConcurrentMapCache(BOOK_BY_ID),
				new ConcurrentMapCache(RESTAURANT_BY_ID),
				new ConcurrentMapCache(RUN_TRACKER_BY_ID),
				new ConcurrentMapCache(SONG_BY_ID),
				new ConcurrentMapCache(TRANSACTION_BY_ID),
				new ConcurrentMapCache(USER_BY_ID),
				new ConcurrentMapCache(UTILITY_BY_ID),
				new ConcurrentMapCache(CAR_BY_ID),
				new ConcurrentMapCache(MEDICAL_TRANSACTION_BY_ID),
				new ConcurrentMapCache(EXERCISE_BY_ID),
				new ConcurrentMapCache(AUTO_TRANSACTION_LIST),
				new ConcurrentMapCache(BOOK_PAGINATION_LIST),
				new ConcurrentMapCache(USER_LIST),
				new ConcurrentMapCache(BOOK_BY_NAME),
				new ConcurrentMapCache(CAR_LIST),
				new ConcurrentMapCache(EXERCISE_LIST),
				new ConcurrentMapCache(FACILITY_LIST),
				new ConcurrentMapCache(MEDICAL_TRANSACTION_LIST),
				new ConcurrentMapCache(PERSON_LIST),
				new ConcurrentMapCache(RESTAURANT_LIST),
				new ConcurrentMapCache(RUN_LIST),
				new ConcurrentMapCache(SONG_LIST),
				new ConcurrentMapCache(TRANSACTION_LIST),
				new ConcurrentMapCache(UTILITY_LIST)
				));
		
		return dsaCacheManager;
	}
}
