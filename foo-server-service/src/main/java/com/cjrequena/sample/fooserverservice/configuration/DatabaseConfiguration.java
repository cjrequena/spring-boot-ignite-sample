package com.cjrequena.sample.fooserverservice.configuration;//package com.cjrequena.sample.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.annotation.Validated;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

/**
 * <p>
 * <p>
 * <p>
 * <p>
 *
 * @author cjrequena
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  entityManagerFactoryRef = "entityManagerFactory",
  transactionManagerRef = "transactionManager",
  basePackages = {"com.cjrequena.sample.fooserverservice.db.repository"}
)
public class DatabaseConfiguration {

  @Primary
  @Bean(name = "dataSource", destroyMethod = "")
  @Validated
  @ConfigurationProperties(prefix = "spring.datasource")
  @ConditionalOnClass({HikariDataSource.class})
  public HikariDataSource dataSource() {
    return new HikariDataSource();
  }

  /**
   *
   * @param builder
   * @param dataSource
   * @return
   */
  @Primary
  @Bean("entityManagerFactory")
  public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("dataSource") DataSource dataSource) {
    return builder
      .dataSource(dataSource)
      .packages("com.cjrequena.sample.fooserverservice.db.entity")
      .persistenceUnit("chinook")
      .build();
  }

  /**
   *
   * @param entityManagerFactory
   * @return
   */
  @Primary
  @Bean("transactionManager")
  public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactory") EntityManagerFactory entityManagerFactory) {
    return new JpaTransactionManager(entityManagerFactory);
  }
}

