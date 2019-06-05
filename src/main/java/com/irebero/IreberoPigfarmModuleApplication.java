package com.irebero;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import com.irebero.Dao.RoleDao;
//import com.irebero.Security.Role;

@SpringBootApplication
public class IreberoPigfarmModuleApplication implements CommandLineRunner {
//	@Autowired
//	private RoleDao roleDao;
	public static void main(String[] args) {
		SpringApplication.run(IreberoPigfarmModuleApplication.class, args);
	}
	// here we use to insert at runtime cz of the commandlinerunner
		@Override
		public void run(String... args) throws Exception {
//			Role role = new Role();
//			role.setRoleId(0);
//			role.setName("ADMIN");
//			roleDao.save(role);
		}
}
