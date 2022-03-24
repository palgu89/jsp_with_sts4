package service;

import java.time.LocalDateTime;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import repository.MemberDAO;
import repository.MemberDAOImple;

public class MemberServiceImple implements MemberService{
	private static Logger log = LoggerFactory.getLogger(MemberServiceImple.class);
	private MemberDAO mdao;
	
	public MemberServiceImple() {
		mdao = new MemberDAOImple();
	}

	@Override
	public int register(MemberVO mvo) {
		return mdao.insert(mvo);
	}

	@Override
	public List<MemberVO> getList() {
		return mdao.selectList();
	}

	@Override
	public MemberVO getDetail(String email) {
		return mdao.selectOne(email);
	}

	@Override
	public int modify(MemberVO mvo) {
		return mdao.update(mvo);
	}

	@Override
	public int remove(String email) {
		return mdao.delete(email);
	}

	@Override
	public MemberVO login(MemberVO mvo) {
		MemberVO loginMvo = mdao.selectOne(mvo);
		if(loginMvo != null) mdao.update(mvo.getEmail());
		loginMvo.setLastLogin(LocalDateTime.now().toString());
		return loginMvo;
	}
}
