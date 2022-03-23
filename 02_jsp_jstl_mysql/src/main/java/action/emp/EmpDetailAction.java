package action.emp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import action.Action;
import domain.EmpVO;
import service.EmpService;
import service.EmpServiceImple;


public class EmpDetailAction implements Action {
	private static Logger log = LoggerFactory.getLogger(EmpDetailAction.class);

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		req.setAttribute("evo", new EmpServiceImple().getDetail(
											Integer.parseInt(req.getParameter("empno"))));
	}

}
