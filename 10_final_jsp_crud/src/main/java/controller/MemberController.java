package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import service.MemberService;
import service.MemberServiceImple;

@WebServlet("/memCtrl/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	private final MemberService msv;
	private RequestDispatcher rdp;
	private int isUp;
	
	public MemberController() {
		msv = new MemberServiceImple();		
	}
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setCharacterEncoding("utf-8");
		res.setContentType("text/html; charset=utf-8");
		
		String uri = req.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/")+1);
		 
		switch (path) {
		case "register":
			rdp = req.getRequestDispatcher("/member/register.jsp");
			rdp.forward(req, res);
			break;
		case "insert":
			isUp = msv.register(new MemberVO(
					req.getParameter("email"),
					req.getParameter("pwd"),
					req.getParameter("nickName")));
			log.info(">>> JOIN > {}", isUp > 0 ? "Success":"Fail");
			req.setAttribute("msg_reg", isUp);
			
			rdp = req.getRequestDispatcher("/index.jsp");
			rdp.forward(req, res);
			break;
		case "list":
			req.setAttribute("list", msv.getList());
			rdp = req.getRequestDispatcher("/member/list.jsp");
			rdp.forward(req, res);
			break;
		case "detail":
			req.setAttribute("mvo", msv.getDetail(req.getParameter("email")));
			rdp = req.getRequestDispatcher("/member/detail.jsp");
			rdp.forward(req, res);
			break;
		case "modify":
			isUp = msv.modify(new MemberVO(req.getParameter("email"),
											req.getParameter("pwd"),
											req.getParameter("nickName")));
			log.info(">>> MODIFY > {}", (isUp > 0 ? "Success" : "Fail"));
			rdp = req.getRequestDispatcher("/memCtrl/detail?email="+req.getParameter("email"));
			rdp.forward(req, res);
			break;
		case "remove":
			isUp = msv.remove(req.getParameter("email"));
			log.info(">>> REMOVE > {}", (isUp > 0 ? "Success" : "Fail"));
			
			HttpSession currSES = req.getSession();
			currSES.invalidate();
			req.setAttribute("msg_resign", 1);
			rdp = req.getRequestDispatcher("/index.jsp");
			rdp.forward(req, res);
			break;
		case "login":
			MemberVO mvo = msv.login(new MemberVO(req.getParameter("email"),
									req.getParameter("pwd")));
			log.info(">>> mvo > {}", mvo);
			if(mvo != null) {
				HttpSession ses = req.getSession();
				ses.setAttribute("ses", mvo);
				ses.setMaxInactiveInterval(60 * 10); // 초단위				
			} else {
				req.setAttribute("msg_login", 0);
			}
			
			rdp = req.getRequestDispatcher("/index.jsp");
			rdp.forward(req, res);
			break;
		case "logout":
			HttpSession currSes = req.getSession();
			currSes.invalidate();
			req.setAttribute("msg_logout", 1);
			rdp = req.getRequestDispatcher("/index.jsp");
			rdp.forward(req, res);
			break;
		default:
			break;
		}
	}
}









