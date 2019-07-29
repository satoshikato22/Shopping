package chapter25;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Item;
import tool.Action;

public class CartRemoveAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		HttpSession session = request.getSession();

		int id=Integer.parseInt(request.getParameter("id"));

		List<Item> cart = (List<Item>)session.getAttribute("cart");

		for(Item i:cart) {
			if(i.getProduct().getId()==id) {
				cart.remove(i);
				break;
			}
		}
		return "cart.jsp";
	}

}
