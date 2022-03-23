package action.emp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import action.Action;
import domain.EmpVO;
import service.EmpService;
import service.EmpServiceImple;


public class EmpListAction implements Action {
	private static Logger log = LoggerFactory.getLogger(EmpListAction.class);

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		EmpService esv = new EmpServiceImple();
		req.setAttribute("list", esv.getList());
	}

}
