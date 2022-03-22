package action.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import action.Action;
import domain.ProductVO;
import service.ProductService;
import service.ProductServiceImple;


public class ProductModifyAction implements Action {
	private static Logger log = LoggerFactory.getLogger(ProductModifyAction.class);

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		String pname  = req.getParameter("pname");
		int price = Integer.parseInt(req.getParameter("price"));
		String madeBy = req.getParameter("madeBy");
		int pno = Integer.parseInt(req.getParameter("pno"));
		
		ProductService psv = new ProductServiceImple();
		
		int isUp = psv.modify(new ProductVO(pno, pname, price, madeBy));
		log.info(">>> Product Modify > {}", isUp > 0 ? "Success" : "Fail");
	}

}
