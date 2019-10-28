package com.urfu.sod;

import com.urfu.sod.entity.ClientSystem;
import com.urfu.sod.repository.ClientSystemRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SodApplication.class)
class SodApplicationTests {

	@Autowired
	private ClientSystemRepository clientSystemRepository;

	@Test
	void contextLoads() {
		ClientSystem qwe = new ClientSystem();
		qwe.setClientId("1");
		qwe.setIncomeQueue("1");
		qwe.setOutcomeQueue("1");
		clientSystemRepository.save(qwe);
	}

}
