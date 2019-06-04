package servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.GeneralDao;

public class ImageUploadServlet extends HttpServlet {

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		// 获取上传的文件名  enctype="multipart/form-data"
		String fileName = request.getParameter("uploadFile");
		System.out.println("uploadFile: " + fileName);
		// 获取文件输入流
		InputStream inputStream = new FileInputStream(fileName);
		// 插入数据库语句
		String sql = "insert into imgtest(name,image) values('上传',?)";
		Object[] values = new Object[] {inputStream};
		int ok = GeneralDao.update(sql, values);
		if (ok == 1) {
			System.out.println("插入成功 ！");
			// 转向显示页面
			// 如果密码匹配，则转向信息显示页面
			//RequestDispatcher rDispatcher = request.getRequestDispatcher("/ShowImg.jsp");
			//rDispatcher.forward(request, response);
			response.sendRedirect("ShowImg.jsp");
		} else {
			System.out.println("插入失败 ！");
		}
	}

}
