package com.urfu.sod;

import com.urfu.sod.entity.Training;
import com.urfu.sod.entity.UserProfile;
import com.urfu.sod.entity.Role;
import com.urfu.sod.repository.TrainingRepository;
import com.urfu.sod.repository.UserProfileRepository;
import com.urfu.sod.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SodApplication.class)
class SodApplicationTests {

	@Autowired
	private EntityManager em;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserProfileRepository userProfileRepository;
	
	@Autowired
	private TrainingRepository trainingRepository;

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
	void commonTest() {
		Role role;
		List<Role> resultList = roleRepository.findAll();
		if(resultList.size() != 0)
			role = resultList.get(0);
		else{
			role = new Role();
			role.setTitle("User");
			role.setDescription("Desc");
			roleRepository.save(role);
		}

		List<UserProfile> forEqualsList = userProfileRepository.findAll();

		UserProfile common = new UserProfile();
		common.setRoleId(role);
		common.setFio("Test");
		common.setBirthday(LocalDateTime.now());
		common.setEntryDate(LocalDateTime.now());
		common.setPhone("123");
		common.setLogin("Login");
		common.setPassword("Password");

		userProfileRepository.save(common);

		List<Role> resultListForEq = roleRepository.findAll();
		if(forEqualsList.size() != 0)
			assertThat(forEqualsList.size() - 1).isEqualTo(resultListForEq.size());
		else
			assertThat(1).isEqualTo(resultListForEq.size());
	}

	@Transactional
	void appendUser(Training training, UserProfile user){
		List<UserProfile> asd = training.getClients();
		asd.add(user);
		training.setClients(asd);
	}

	@Test
	void trainingTest() {
		List<UserProfile> userList = userProfileRepository.findAll();
		if(userList.size() == 0)
			return;
		
		UserProfile user = userList.get(0);

		Training training = new Training();
		trainingRepository.save(training);

		user.getClientTrainings().add(training);
		userProfileRepository.save(user);
	}

}
