package servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ImageBean;
import util.ImageDao;



public class Get_imgById_Servlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Integer id = Integer.parseInt(request.getParameter("s"));
        System.out.println(id);
        float pd =Float.parseFloat(request.getParameter("pd"));
        List<ImageBean> lists=ImageDao.get_image_by_id(id);
        //List<ImageBean> lists= ImageDao.query(id); 
        System.out.println("判读："+pd);
        for(ImageBean bean:lists)
        {
        	
        	System.out.println(bean.getGroundtruth());
        	//System.out.println(bean.getName());
        	
        }
        float gt=lists.get(0).getGroundtruth();
        BigDecimal pd1= new BigDecimal(String.valueOf(pd));
        BigDecimal gts= new BigDecimal(String.valueOf(gt));
        //float wc=(pd1>gts)? pd1-gts:gts-pd1;
        float wc=0;
        if(pd1.compareTo(gts)==1 )  
        {
        	wc=pd1.subtract(gts).floatValue();
        }
        else
        	wc=gts.subtract(pd1).floatValue();
        System.out.println(wc);
        request.setAttribute("lists", lists);
        request.setAttribute("pd",pd);
        request.setAttribute("wc",wc);
		request.getRequestDispatcher("show_img_src-all.jsp").forward(request, response);
//	
//	public void getImage(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setCharacterEncoding("utf-8");
//		Integer id = Integer.parseInt(request.getParameter("s"));
//        System.out.println(id);
		
		

		

		
		
	}

}
