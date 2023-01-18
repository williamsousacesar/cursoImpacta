package cadastroProfessor.cadastroProfessor.data;

import java.sql.DriverManager;

import javax.sql.DataSource;

import org.hibernate.Hibernate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataConfiguration {
	
	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource driveBanco = new DriverManagerDataSource();
		driveBanco.setDriverClassName("com.mysql.cj.jdbc.Driver");
		driveBanco.setUrl("jdbc:mysql://localhost:3306/db_professor");
		driveBanco.setUsername("root");
		driveBanco.setPassword("root");
		
		return driveBanco;
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQL8Dialect");
		
		adapter.setPrepareConnection(true);
		
		return adapter;
	}
}
