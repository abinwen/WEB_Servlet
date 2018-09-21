package login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import com.luoExpress.utils.DataSourceUtils;

import domain.User;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//1.获取用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//response.getWriter().write("hello dalLuo...");
		User user= null;
		//从数据库验证该用户名和密码
		QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
		String sql = "select * from user where username=? and password=?";
		try{
			user = runner.query(sql, new BeanHandler<User>(User.class),username,password);
			//System.out.println(user.toString());
		}
		catch (SQLException  e) {
			e.printStackTrace();
		}
		
		if(user!=null){
//			ServletContext context = this.getServletContext();
//			Integer count = (Integer) context.getAttribute("count");
//			count++;
			response.getWriter().write(username.toString()+"----you are success login person:");
//			context.setAttribute("count", count);
			
		}else{
			response.getWriter().write("sorry login fail");
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}