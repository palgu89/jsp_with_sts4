package action.emp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import action.Action;
import domain.EmpVO;
import service.EmpService;
import service.EmpServiceImple;


public class EmpInsertAction implements Action {
	private static Logger log = LoggerFactory.getLogger(EmpInsertAction.class);

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		EmpService esv = new EmpServiceImple();
		int isUp = esv.register(new EmpVO(
				Integer.parseInt(req.getParameter("empno")), 
				req.getParameter("ename"), 
				Integer.parseInt(req.getParameter("sal"))));
		log.info(">>> Register {}", isUp > 0 ? "Success" : "Fail");
	}

}
