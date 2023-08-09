package kr.bit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import kr.bit.entity.Member;
import kr.bit.entity.Role;
import kr.bit.repository.MemberRepository;

@SpringBootTest
class SpringMvc11ApplicationTests {

	@Autowired
	private MemberRepository memberReposiotry;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Test
	void createMember() {
		
		Member m=new Member();
		m.setUsername("kk");
		m.setPassword(encoder.encode("kk")); // 암호화
		m.setName("김성욱");
		m.setRole(Role.ADMIN);
		m.setEnabled(true);
		memberReposiotry.save(m); //회원가입 처리
	}

}
