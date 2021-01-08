package springbook.user.test;

import java.sql.SQLException;

import springbook.user.dao.ConnectionMaker;
import springbook.user.dao.DConnectionMaker;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;

public class UserDaoTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		/*
		 * UserDaoTest�� UserDao�� ConnectionMaker ���� Ŭ�������� ��Ÿ�� ������Ʈ ���� ���踦 �����ϴ� å���� ���.
		 * UserDao�� SQL�� �����ϰ� �����ϴ� ���� ������ �� �ְ� �Ǿ�, ���� �������� ����.
		 * �� ConnectionMaker�� ���� Ŭ������ �ٲ� DAO Ŭ������ ������ �ʿ䰡 ���������� ���� ���յ��� ������.
		*/
		ConnectionMaker connectionMaker = new DConnectionMaker();
		
		UserDao dao = new UserDao(connectionMaker);
		
		User user = new User();
		user.setId("hukmong");
		user.setName("�����");
		user.setPassword("123456");
		
		//dao.add(user);
		
		//System.out.println(user.getId() + " ��� ����");
		
		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		
		System.out.println(user2.getId() + " ��ȸ ����");
	}

}
