package moneymanager.backend.configuation;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(
    basePackages = "moneymanager.backend.repository",
    entityManagerFactoryRef = "entityManager",
    transactionManagerRef = "transactionManager"
)
class DatasourceProducer {

  @Autowired
  private Logger logger;


  @Value("${datasource.url}")
  private String url;

  @Value("${datasource.driver}")
  private String driver;

  @Bean
  @Primary
  public LocalContainerEntityManagerFactoryBean entityManager() {
    LocalContainerEntityManagerFactoryBean em
        = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(datasource());
    em.setPackagesToScan(
        new String[]{"moneymanager.backend.model"});

    HibernateJpaVendorAdapter vendorAdapter
        = new HibernateJpaVendorAdapter();
    em.setJpaVendorAdapter(vendorAdapter);

    return em;
  }

  @Bean
  @Primary
  public DataSource datasource() {
    logger.log(Level.INFO, "Using url {0} and driver {1} to connect to datasource.",
        new Object[]{url, driver});
    System.out.println("Using url "+url);
    DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
    dataSourceBuilder.driverClassName(driver);
    dataSourceBuilder.url(url);
    return dataSourceBuilder.build();
  }

  @Primary
  @Bean
  public PlatformTransactionManager transactionManager() {

    JpaTransactionManager transactionManager
        = new JpaTransactionManager();
    transactionManager.setEntityManagerFactory(
        entityManager().getObject());
    return transactionManager;
  }


}
