package com.urfu.sod;

import com.urfu.sod.entity.AdminProfile;
import com.urfu.sod.entity.CommonInfo;
import com.urfu.sod.entity.Role;
import com.urfu.sod.repository.AdminProfileRepository;
import com.urfu.sod.repository.CommonInfoRepository;
import com.urfu.sod.repository.RoleRepository;
import org.junit.Assert;
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
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SodApplication.class)
class SodApplicationTests {

	@Autowired
	private EntityManager em;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private AdminProfileRepository adminProfileRepository;

	@Autowired
	private CommonInfoRepository commonInfoRepository;

	@Test
	void roleTest() {
		List<Role> forEqualsList = roleRepository.findAll();
		Role role = new Role();
		role.setTitle("Admin");
		role.setDescription("Admin");
		roleRepository.save(role);
		List<Role> resultList = roleRepository.findAll();
		assertThat(resultList.size() - 1).isEqualTo(forEqualsList.size());
	}

	@Test
	@Transactional
	void commonTest() {
		Role role;
		List<Role> resultList = roleRepository.findAll();
		if(resultList.size() != 0)
			role = resultList.get(0);
		else{
			role = new Role();
			role.setTitle("User");
			role.setDescription("Desc");
			em.persist(role);
		}

		AdminProfile adminProfile;
		List<AdminProfile> resultAdminList = adminProfileRepository.findAll();
		if(resultAdminList.size() != 0)
			adminProfile = resultAdminList.get(0);
		else{
			adminProfile = new AdminProfile();
			em.persist(adminProfile);
		}

		List<CommonInfo> forEqualsList = commonInfoRepository.findAll();

		CommonInfo common = new CommonInfo();
		common.setRoleId(role);
		common.setFio("Test");
		common.setBirthday(LocalDateTime.now());
		common.setEntryDate(LocalDateTime.now());
		common.setPhone("123");
		common.setLogin("Login");
		common.setPassword("Password");
		common.setAdminProfile(adminProfile);

		em.merge(common);

		List<Role> resultListForEq = roleRepository.findAll();
		if(forEqualsList.size() != 0)
			assertThat(forEqualsList.size() - 1).isEqualTo(resultListForEq.size());
		else
			assertThat(1).isEqualTo(resultListForEq.size());
	}

}
