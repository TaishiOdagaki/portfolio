package la.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import la.bean.ItemBean;
import la.dao.DAOException;
import la.dao.ItemDAO;

@WebServlet("/ItemServlet3")
public class ItemServlet3 extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			String action = request.getParameter("action");
			String level =request.getParameter("level");
			ItemDAO dao = new ItemDAO();
			ItemBean lucky = dao.findLucky();
			request.setAttribute("luckyitem", lucky);
			List<ItemBean>list;
			if(level.equals("level_asc")) {
				 list = dao.sortLevel(true);
			} else {
				 list = dao.sortLevel(false);
			}

			request.setAttribute("items", list);
			gotoPage(request, response, "/list.jsp");
			return;
		}catch(DAOException e) {
			e.printStackTrace();
			request.setAttribute("message","内部エラーが発生しました");
			gotoPage(request,response,"/errInternal.jsp");
		}
	}

	private void gotoPage(HttpServletRequest request,
			HttpServletResponse response, String page) throws ServletException,
			IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
