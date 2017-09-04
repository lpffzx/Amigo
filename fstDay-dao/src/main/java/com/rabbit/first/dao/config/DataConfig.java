//package com.rabbit.first.dao.config;
//
//
//import com.alibaba.druid.pool.DruidDataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.JpaVendorAdapter;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.Database;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableTransactionManagement
//@PropertySource("classpath:META-INF/config/spring/datasource.properties")
//public class DataConfig {
//
//    @Autowired
//    Environment env;
//
//    @Bean
//    public DruidDataSource dataSource() {
//        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setDriverClassName(env.getProperty("jdbc.driver"));
//        druidDataSource.setUrl(env.getProperty("jdbc.url"));
//        druidDataSource.setUsername(env.getProperty("jdbc.user"));
//        druidDataSource.setPassword(env.getProperty("jdbc.password"));
//        return druidDataSource;
//    }
//
//    @Bean
//    public JpaVendorAdapter jpaVendorAdapter() {
//        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
//        adapter.setDatabase(Database.MYSQL);
//        adapter.setShowSql(true);
//        adapter.setGenerateDdl(false);
//        adapter.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
//        return adapter;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean emf(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
//        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
//        emf.setDataSource(dataSource);
//        emf.setJpaVendorAdapter(jpaVendorAdapter);
//        emf.setPackagesToScan("com.rabbit.first.model");
//        return emf;
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager(DataSource dataSource, JpaVendorAdapter jpaVendorAdapter) {
//        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
//        jpaTransactionManager.setEntityManagerFactory(emf(dataSource, jpaVendorAdapter).getObject());
//        return jpaTransactionManager;
//    }
//
//
////    @Configuration
////    @EnableTransactionManagement
////    public static class TransactionConfig implements TransactionManagementConfigurer {
////        @Inject
////        private EntityManagerFactory emf;
////
////        public PlatformTransactionManager annotationDrivenTransactionManager() {
////            JpaTransactionManager transactionManager = new JpaTransactionManager();
////            transactionManager.setEntityManagerFactory(emf);
////            return transactionManager;
////        }
////    }
//
//
//}
