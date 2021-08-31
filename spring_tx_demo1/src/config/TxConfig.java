package config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * Created by Intellij IDEA.
 *
 * @author ZhuZhaoMing
 * @Description
 * @date 2021/8/31-10:46 上午
 * @motto: Never say die Never give up
 */
@Configuration//配置类
@ComponentScan(basePackages = {"service","dao"})//组件扫描
@EnableTransactionManagement//开启事务
public class TxConfig {
    //    创建数据库连接池
    @Bean
    public DruidDataSource getDruidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/user_db");
        dataSource.setUsername("root");
        dataSource.setPassword("z19941110!");
        return dataSource;
    }

    //    创建JDBCTemplate对象
    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
//        到ioc容器中找到datasouce
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//        注入datasource
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    //    创建事务管理器
    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
        transactionManager.setDataSource(dataSource);
        return transactionManager;
    }
}
