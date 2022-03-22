package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.ProductVO;


public class ProductDAOImple implements ProductDAO {
	private static Logger log = LoggerFactory.getLogger(ProductDAOImple.class);
	private Connection cn;
	private PreparedStatement pst;
	private ResultSet rs;
	private String sql;
	
	public ProductDAOImple() {
		cn = DBConnector.getConnection();
	}
	
	@Override
	public int insert(ProductVO pvo) {
		sql = "insert into product (pname, price, madeby) values (?, ?, ?)";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, pvo.getPname());
			pst.setInt(2, pvo.getPrice());
			pst.setString(3, pvo.getMadeBy());
			return pst.executeUpdate();
		} catch (SQLException e) {
			// 이런 확인용 로그들은 테스트용, 출시할 땐 다 지운다
			log.info(">>> DAO > insert() Error");
			e.printStackTrace();
		} // finally를 써주는게 정석이지만 풀링이 알아서 해주기 때문에 안써도 무방 -> 나중되면 더 편리해짐
		return 0;
	}

	@Override
	public List<ProductVO> selectList() {
		sql = "select pno, pname, price from product order by pno desc";
		List<ProductVO> list = new ArrayList<>();
		try {
			pst = cn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				list.add(new ProductVO(rs.getInt("pno"), rs.getString("pname"), rs.getInt("price")));
			}
			return list;
		} catch (SQLException e) {
			log.info(">>> DAO > selectList() Error");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ProductVO selectOne(int pno) {
		sql = "select * from product where pno = ?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, pno);
			rs = pst.executeQuery();
			if (rs.next()) {
				return new ProductVO(
						rs.getInt("pno"), 
						rs.getString("pname"), 
						rs.getInt("price"), 
						rs.getString("regdate"), 
						rs.getString("madeby"));
			}
		} catch (SQLException e) {
			log.info(">>> Dao > selectOne() Error");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int update(ProductVO pvo) {
		sql = "update product set pname = ?, price = ?, madeby = ?,"
				+ "regdate = now() where pno = ?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setString(1, pvo.getPname());
			pst.setInt(2, pvo.getPrice());
			pst.setString(3, pvo.getMadeBy());
			pst.setInt(4, pvo.getPno());
			return pst.executeUpdate();
		} catch (SQLException e) {
			log.info(">>> DAO > update() Error");
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int delete(int pno) {
		sql = "delete from product where pno = ?";
		try {
			pst = cn.prepareStatement(sql);
			pst.setInt(1, pno);
			return pst.executeUpdate();
		} catch (SQLException e) {
			log.info(">>> DAO > delete() Error");
			e.printStackTrace();
		}
		return 0;
	}

}
