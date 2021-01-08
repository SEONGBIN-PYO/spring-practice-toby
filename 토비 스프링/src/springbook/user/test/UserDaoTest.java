package springbook.user.test;

import java.sql.SQLException;

import springbook.user.dao.ConnectionMaker;
import springbook.user.dao.DConnectionMaker;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;

public class UserDaoTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		/*
		 * UserDaoTest는 UserDao와 ConnectionMaker 구현 클래스와의 런타임 오브젝트 의존 관계를 설정하는 책임을 담당.
		 * UserDao는 SQL를 생성하고 실행하는 데만 집중할 수 있게 되어, 높은 응집도를 가짐.
		 * 또 ConnectionMaker의 구현 클래스가 바뀌어도 DAO 클래스를 수정할 필요가 없어짐으로 낮은 결합도가 형성됨.
		*/
		ConnectionMaker connectionMaker = new DConnectionMaker();
		
		UserDao dao = new UserDao(connectionMaker);
		
		User user = new User();
		user.setId("hukmong");
		user.setName("흑멍이");
		user.setPassword("123456");
		
		//dao.add(user);
		
		//System.out.println(user.getId() + " 등록 성공");
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		
		System.out.println(user2.getId() + " 조회 성공");
	}

}
