package com.sample.fooserverservice.configuration;

import org.apache.ignite.cache.CacheAtomicityMode;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.cache.spring.SpringCacheManager;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.multicast.TcpDiscoveryMulticastIpFinder;
import org.apache.ignite.springdata.repository.config.EnableIgniteRepositories;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * <p>
 * <p>
 * <p>
 *
 * @author cjrequena
 */
@Configuration
@EnableIgniteRepositories
public class CustomIgniteConfiguration {

  /**
   * @return
   */
  @Bean(name = "igniteCacheManager")
  public CacheManager igniteCacheManager() {
    SpringCacheManager cacheManager = new SpringCacheManager();
    cacheManager.setConfiguration(igniteConfiguration());
    return cacheManager;
  }

  /**
   * @return
   */
  @Bean(name = "igniteConfiguration")
  public IgniteConfiguration igniteConfiguration() {
    IgniteConfiguration igniteConfiguration = new IgniteConfiguration();
    igniteConfiguration.setClientMode(false);
    igniteConfiguration.setPeerClassLoadingEnabled(false);

    TcpDiscoverySpi tcpDiscoverySpi = new TcpDiscoverySpi();
    TcpDiscoveryMulticastIpFinder ipFinder = new TcpDiscoveryMulticastIpFinder();
    ipFinder.setAddresses(Collections.singletonList("127.0.0.1:47500..47509"));
    tcpDiscoverySpi.setIpFinder(ipFinder);
    igniteConfiguration.setDiscoverySpi(tcpDiscoverySpi);
    igniteConfiguration.setCacheConfiguration(igniteCacheConfiguration());
    return igniteConfiguration;

  }

  /**
   * @return
   */
  @Bean(name = "igniteCacheConfiguration")
  public CacheConfiguration[] igniteCacheConfiguration() {
    List<CacheConfiguration> cacheConfigurations = new ArrayList<>();
    //CacheConfiguration[] cacheConfigurations = new CacheConfiguration[10];

    CacheConfiguration cacheConfiguration = new CacheConfiguration();
    cacheConfiguration.setAtomicityMode(CacheAtomicityMode.ATOMIC);
    cacheConfiguration.setCacheMode(CacheMode.REPLICATED);
    cacheConfiguration.setName("foo-cache");

    //igniteCacheConfiguration.setWriteSynchronizationMode(CacheWriteSynchronizationMode.FULL_SYNC);
    cacheConfiguration.setWriteThrough(false);
    cacheConfiguration.setReadThrough(false);
    cacheConfiguration.setWriteBehindEnabled(false);

    cacheConfiguration.setBackups(1);
    cacheConfiguration.setStatisticsEnabled(true);
    cacheConfigurations.add(cacheConfiguration);

    return cacheConfigurations.stream().toArray(CacheConfiguration[]::new);
  }

}
