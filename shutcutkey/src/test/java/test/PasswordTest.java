package test;

import com.zxa.shortcut.controller.starter.ApplicationWeb;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName: PasswordTest
 * @Description: //TODO
 * @Author: zhangxin_an
 * @CreateDate: 2018/11/27 10:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationWeb.class)
public class PasswordTest {
	@Autowired
	StringEncryptor stringEncryptor;

	@Value("${spring.datasource.password}")
	private String password1;


	@Test
	public void encryptPwd(){
		String result = stringEncryptor.encrypt("Shortcut!@#123");
		System.out.println(result);
		String password = stringEncryptor.decrypt(result);
		System.out.println(password);
		System.out.println(password1);
	}

}
