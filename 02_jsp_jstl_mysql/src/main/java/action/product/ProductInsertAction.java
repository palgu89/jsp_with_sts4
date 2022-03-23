package action.product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import action.Action;
import domain.ProductVO;
import service.ProductService;
import service.ProductServiceImple;


public class ProductInsertAction implements Action {
	private static Logger log = LoggerFactory.getLogger(ProductInsertAction.class);

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) {
		String pname  = req.getParameter("pname");
		int price = Integer.parseInt(req.getParameter("price"));
		String madeBy = req.getParameter("madeBy");
		
		ProductService psv = new ProductServiceImple();
		
		int isUp = psv.register(new ProductVO(pname, price, madeBy));
		log.info(">>> Product Register > {}", isUp > 0 ? "Success" : "Fail");
	}

}
