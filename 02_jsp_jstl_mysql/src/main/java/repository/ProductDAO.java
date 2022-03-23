package repository;

import java.util.List;

import domain.ProductVO;

public interface ProductDAO {
	public int insert(ProductVO pvo);
	public List<ProductVO> selectList();
	public ProductVO selectOne(int pno);
	public int update(ProductVO pvo);
	public int delete(int pno);
}
