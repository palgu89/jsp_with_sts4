package repository;

import java.util.List;

import domain.CommentVO;

public interface CommentDAO {
	public int insert(CommentVO cvo);
	public List<CommentVO> selectList(long pno);
	public int update(CommentVO cvo);
	public int delete(long cno);
	public int deleteAll(long pno);
}
