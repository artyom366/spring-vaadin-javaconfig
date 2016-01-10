package lv.proq.ui;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * Created by Artyom on 1/10/2016.
 */

@Configuration
@PropertySource("classpath:application.properties")
public class DataSourceConfig {

    @Value("${spring.datasource.driverClassName}")
    private String databaseDriverClassName;

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${spring.datasource.username}")
    private String databaseUsername;

    @Value("${spring.datasource.password}")
    private String databasePassword;

//    @Bean
//    public DataSource dataSource() {
//        DataSource dataSource = new DataSource();
//        dataSource.setDriverClassName(databaseDriverClassName);
//        dataSource.setUrl(datasourceUrl);
//        dataSource.setUsername(databaseUsername);
//        dataSource.setPassword(databasePassword);
//        return dataSource;
//    }

    @Bean(name = "dataSource")
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/erp");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("qwertz");
        return driverManagerDataSource;
    }
}
