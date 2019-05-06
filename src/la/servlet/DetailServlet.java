package la.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.ItemBean;
import la.dao.DAOException;
import la.dao.ItemDAO;

@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet{

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			    int itemCode = Integer.parseInt(request.getParameter("item_code"));
				ItemDAO dao = new ItemDAO();
				ItemBean selectedItem = dao.findOne(itemCode);
				// Listをリクエストスコープに入れてJSPへフォーワードする
				request.setAttribute("item", selectedItem);
				gotoPage(request, response, "/detail.jsp");

		} catch (DAOException e) {
			e.printStackTrace();
			request.setAttribute("message", "内部エラーが発生しました。");
			gotoPage(request, response, "/errInternal.jsp");
		}
	}

	private void gotoPage(HttpServletRequest request,
			HttpServletResponse response, String page) throws ServletException,
			IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

//	public void getItem() throws ServletException {
//		try {
//		    int itemCode = Integer.parseInt(request.getParameter("code"));
//			// カテゴリ一覧は最初にアプリケーションスコープへ入れる
//			ItemDAO dao = new ItemDAO();
//			ItemBean list = dao.findOne(itemCode);
//			request.setAttribute("categories", list);
//		} catch (DAOException e) {
//			e.printStackTrace();
//			throw new ServletException();
//		}
//	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
