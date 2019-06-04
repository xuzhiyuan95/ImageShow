package servlet;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ImageDao;

public class ImageOutServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取请求传过来的id，对应的就是图片的id
		String temp = request.getParameter("id");
		int id = Integer.parseInt(temp);
		// 获取图片字节流
		InputStream inStream = ImageDao.queryImgStream(id);
		// 建立图片输出的输出流
		ServletOutputStream soutStream = response.getOutputStream();
		if (inStream.equals(null)) {
			soutStream.println("图片无法显示 ！<br>");
		} else {
			// 定义字节流缓冲数组
			byte[] buffer = new byte[1024];
			 
			// 循环输出字节流, 为空时，read()返回 -1
			while (inStream.read(buffer) != -1) {
				soutStream.write(buffer);
			}
			// 输入完毕，清楚缓冲
			soutStream.flush();
			soutStream.close();
		}
	}
}
