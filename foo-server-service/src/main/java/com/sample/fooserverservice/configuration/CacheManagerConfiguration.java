package com.sample.fooserverservice.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.support.CompositeCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * <p>
 * <p>
 * <p>
 * <p>
 * @author cjrequena
 *
 */
@Configuration
@EnableCaching
public class CacheManagerConfiguration {

    /**
     *
     */
    @Autowired
    private CacheManager igniteCacheManager;


    /**
     * Cache manager.
     *
     * @return the cache manager
     */
    @Bean
    @Primary
    public CacheManager cacheManager() {
        return new CompositeCacheManager(igniteCacheManager);
    }
}
