package repository;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DBConnector {
	private static Logger log = LoggerFactory.getLogger(DBConnector.class);
	
	public static Connection getConnection() {
		Connection cn = null;
		
		// context.xml의 <context> 부분을 아예 가져와 버린다
		// 데이터베이스를 사용하기 위한 데이터정보들을 다 가지고 있으니 불러오는 것
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			DataSource ds = (DataSource) envContext.lookup("jdbc/mysql");
			
			try {
				cn = ds.getConnection();
			} catch (Exception e) {
				// 아이디나 비밀번호, 포트 번호 ...오류
				log.info(">>> DB 커넥션 오류");
				e.printStackTrace();
				return null;
			}
		} catch (Exception e) {
			// 태그나 타입 오류
			log.info(">>> DBCP 커넥션 오류");
			e.printStackTrace();
			return null;
		}
		
		return cn;
	}
}
