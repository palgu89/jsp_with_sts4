package repository;

import java.util.List;

import domain.MemberVO;

public interface MemberDAO {
	public int insert(MemberVO mvo);
	public List<MemberVO> selectList();
	public MemberVO selectOne(String email);
	public int update(MemberVO mvo);
	public int delete(String email);
	public MemberVO selectOne(MemberVO mvo);
	public void update(String email);
}
