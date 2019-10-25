
package com.example.sportsbetting.config;

import com.example.sportsbetting.dao.IOutComeOddDao;
import com.example.sportsbetting.dao.IPlayerDao;
import com.example.sportsbetting.dao.ISportEventDao;
import com.example.sportsbetting.dao.IWagerDao;
import com.example.sportsbetting.dao.OutComeOddDao;
import com.example.sportsbetting.dao.PlayerDao;
import com.example.sportsbetting.dao.SportEventDao;
import com.example.sportsbetting.dao.WagerDao;

import java.util.Properties;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.sportsbetting.view.View;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.example.sportsbetting.repository")
public class AppConfig {

    private static final String dbUrl = "jdbc:mysql://127.0.0.1:3306/sportsbetting_valicsek_david_?serverTimezone=Europe/Budapest";
    private static final String username = "root";
    private static final String password = "(`;]Ue{k)vn/8VXG";

    @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource(dbUrl, username, password);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan(new String[]{"com.example.sportsbetting.domain"});

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());

        return em;
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "create");
        properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        return properties;
    }

    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

    @Bean
    public IPlayerDao getPlayerDao() {
        return new PlayerDao();
    }

    @Bean
    public ISportEventDao getSportEventDao() {
        return new SportEventDao();
    }

    @Bean
    public IWagerDao getWagerDao() {
        return new WagerDao();
    }

    @Bean
    public IOutComeOddDao getOutcomeOddDao() {
        return new OutComeOddDao();
    }

    @Bean
    public View getView() {
        return new View();
    }
}
