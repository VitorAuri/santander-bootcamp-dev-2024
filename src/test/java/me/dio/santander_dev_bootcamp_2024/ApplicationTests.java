package me.dio.santander_dev_bootcamp_2024;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
class ApplicationTests {

	@Value("${spring.datasource.url}")
	private String dbUrl;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;

	@Test
	void whenConnectionIsValid_thenDatabaseIsPostgreSQL() throws Exception {
		try (Connection connection = DriverManager.getConnection(dbUrl, username, password)) {
			DatabaseMetaData metaData = connection.getMetaData();
			String dbProductName = metaData.getDatabaseProductName();
			Assertions.assertThat(dbProductName).isEqualTo("PostgreSQL");
		}
	}

}
