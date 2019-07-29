package chapter23;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;
import tool.Action;

public class SerchAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		String keyword=request.getParameter("keyword");

		ProductDAO dao = new ProductDAO();
		List<Product> list = dao.search(keyword);

		request.setAttribute("list",list);

		return "list.jsp";
	}

}
