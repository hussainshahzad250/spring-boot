package com.sas.cache.config;

import com.hazelcast.config.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {

	@Bean
	public Config configure() {
		return new Config().setInstanceName("hazel-instance")
				.addMapConfig(new MapConfig().setName("userCache").setTimeToLiveSeconds(3000)
						.setEvictionConfig(new EvictionConfig().setSize(200)
								.setMaxSizePolicy(MaxSizePolicy.FREE_HEAP_SIZE).setEvictionPolicy(EvictionPolicy.LRU)));
	}

}
