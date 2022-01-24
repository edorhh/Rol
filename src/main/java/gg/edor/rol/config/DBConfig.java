package gg.edor.rol.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;

@EnableTransactionManagement
@Configuration
public class DBConfig {

    @Value("${mybatis.mapper-locations}")
    private Resource[] mapperLocations;

    /**
     * get application.properties & set hikariConfig
     * */
    @Bean
    @ConfigurationProperties(prefix = "hikari.datasource")
    public HikariConfig hikariConfig() {
        return new HikariConfig();
    }

    /**
     * get DataSource through hikari DBCP
     * */
    @Bean
    public DataSource dataSource() {
        return new HikariDataSource(hikariConfig());
    }

    /**
     * get sqlSession through mybatis SqlSessionFactory
     * */
    @Bean(name = "getSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setMapperLocations(mapperLocations);
        return factoryBean.getObject();
    }

    /**
     * get sqlSession through mybatis SqlSessionTemplate(thread-safe)
     * */
    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }

    /**
     * get transaction
     * */
    @Bean
    public PlatformTransactionManager transactionManager() throws Exception {
        return new DataSourceTransactionManager(dataSource());
    }
}
