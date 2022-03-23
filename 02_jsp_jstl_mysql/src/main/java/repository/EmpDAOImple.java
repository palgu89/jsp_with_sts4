package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.EmpVO;


public class EmpDAOImple implements EmpDAO {
	private static Logger log = LoggerFactory.getLogger(EmpDAOImple.class);
	private Connection cn;
	private PreparedStatement pst;
	private ResultSet rs;
	private String sql;
	
	public EmpDAOImple() {
		cn = DBConnector.getConnection();
	}
	
	@Override
	public int insert(EmpVO evo) {
		sql = "insert into emp (empno, ename, sal) values (?, ?, ?)";
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, evo.getEmpno());
			pst.setString(2, evo.getEname());
			pst.setInt(3, evo.getSal());
			return pst.executeUpdate();
		} catch (SQLException e) {
			log.info(">>> EmpDAO > insert() error" + evo);
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<EmpVO> selectList() {
		List<EmpVO> list = new ArrayList<>();
		sql = "select empno, ename, hiredate, deptno from emp order by empno desc";
		try {
			pst = cn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new EmpVO(
						rs.getInt("empno"), 
						rs.getString("ename"), 
						rs.getString("hiredate"),
						// rs.getDate("hiredate").toString() 도 가능
						rs.getInt("deptno")));
			}
			return list;
		} catch (SQLException e) {
			log.info(">>> EmpDAO > selectList() error");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public EmpVO selectOne(int empno) {
		sql = "select * from emp where empno = ?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, empno);
			rs = pst.executeQuery();
			if (rs.next()) {
				return new EmpVO(
						empno, rs.getString("ename"), 
						rs.getString("job"), rs.getInt("mgr"), 
						rs.getString("hiredate"), rs.getInt("sal"),
						rs.getInt("comm"), rs.getInt("deptno"));
			}
		} catch (SQLException e) {
			log.info(">>> EmpDAO > selectOne() error" + empno);
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int update(EmpVO evo) {
		sql = "update emp set job = ?, mgr = ?, sal = ?, comm = ?, deptno = ? where empno = ?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, evo.getJob());
			pst.setInt(2, evo.getMgr());
			pst.setInt(3, evo.getSal());
			pst.setInt(4, evo.getComm());
			pst.setInt(5, evo.getDeptno());
			pst.setInt(6, evo.getEmpno());
			return pst.executeUpdate();
		} catch (SQLException e) {
			log.info(">>> EmpDAO > update() error" + evo);
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int empno) {
		sql = "delete from emp where empno = ?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, empno);
			return pst.executeUpdate();
		} catch (SQLException e) {
			log.info(">>> EmpDAO > delete() error" + empno);
			e.printStackTrace();
		}
		return 0;
	}

}
