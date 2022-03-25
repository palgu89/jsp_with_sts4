package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import orm.DataBaseBuilder;

public class MemberDAOImple implements MemberDAO {
	private static Logger log = LoggerFactory.getLogger(MemberDAOImple.class);
	private SqlSession sql;
	private final String ns = "MemberMapper.";
	
	public MemberDAOImple() {
		new DataBaseBuilder();
		sql = DataBaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(MemberVO mvo) {
		int isUp = sql.insert(ns+"reg", mvo);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public List<MemberVO> selectList() {
		return sql.selectList(ns+"list");
	}

	@Override
	public MemberVO selectOne(String email) {
		return sql.selectOne(ns+"detail", email);
	}

	@Override
	public int update(MemberVO mvo) {
		int isUp = sql.update(ns+"mod", mvo);
		if(isUp>0) {
			sql.commit();
		}
		return isUp; 
	}

	@Override
	public int delete(String email) {
		int isUp = sql.delete(ns+"del", email);
		if(isUp>0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public MemberVO selectOne(MemberVO mvo) {
		return sql.selectOne(ns+"login", mvo);
	}

	@Override
	public void update(String email) {
		int isUp = sql.update(ns+"lastLogin", email);
		if(isUp>0) sql.commit();
	}
}
