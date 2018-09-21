package context;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//���ServletContext����
		ServletContext context = this.getServletContext();
		//1.��ó�ʼ������
		//String realPath_A = context.getRealPath("WEB-INF/a.txt");
		context.setAttribute("name", "abinwen");
		
		//response.getWriter().write(realPath_A);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}