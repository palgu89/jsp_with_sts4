package repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.ProductVO;
import orm.DataBaseBuilder;

public class ProductDAOImple implements ProductDAO {
	private static Logger log = LoggerFactory.getLogger(ProductDAOImple.class);
	private SqlSession sql;
	private final String ns = "ProductMapper.";
	
	public ProductDAOImple() {
		new DataBaseBuilder();
		sql = DataBaseBuilder.getFactory().openSession();
	}

	@Override
	public int insert(ProductVO pvo) {
		int isUp = sql.insert(ns + "reg", pvo);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public List<ProductVO> selectList() {
		return sql.selectList(ns + "list");
	}

	@Override
	public ProductVO selectOne(long pno) {
		return sql.selectOne(ns+"detail", pno);
	}

	@Override
	public int update(ProductVO pvo) {
		int isUp = sql.update(ns + "mod", pvo);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public int delete(long pno) {		
		int isUp = sql.delete(ns + "del", pno);
		if (isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

	@Override
	public int updateReadCount(long pno) {
		int isUp = sql.update(ns+"rc", pno);
		if(isUp > 0) {
			sql.commit();
		}
		return isUp;
	}

}
