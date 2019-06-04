package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import bean.ImageBean;

public class ImageDao {

	public static List<ImageBean> get_image_by_id(Integer id) {
		  Connection conn = JDBCUtil.getConn();
		  String sql = "select * from img_src where id=?";
		  PreparedStatement ps = null;
		  ResultSet rs = null;
		  List<ImageBean> list = new ArrayList<ImageBean>();
		  ImageBean imageBean = null;
		  try {
		   ps = conn.prepareStatement(sql);
		   ps.setInt(1, id);
		   rs = ps.executeQuery();
		   while (rs.next()) {
			   imageBean = new ImageBean(rs.getInt(1), rs.getFloat(3), rs.getString(4),rs.getString(2));
		    list.add(imageBean);
		   }
		   return list;
		  } catch (SQLException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  } finally {
		   JDBCUtil.closeConn(rs, ps, conn);
		  }
		  return null;
		 }
	// 查询所有记录
	public static List<ImageBean> query(int id) {
		String sql = "select * from img_src where id = ?";
		Object[] values = new Object[] {id};
		
		ImageRML rowMapperList = new ImageRML();
		List<ImageBean> list = GeneralDao.query(sql, values, rowMapperList);
		for(ImageBean a:list)
		{
			System.out.print(a.getSrc());
		}
		return list;
	}
	
	// 查询所有记录
	public static List<ImageBean> querySrc(String sql) {
		Object[] values = new Object[] {};
		ImageSrcRML rowMapperList = new ImageSrcRML();
		List<ImageBean> list = GeneralDao.query(sql, values, rowMapperList);
		return list;
	}
	
	// 根据id，查询图片字节流
	public static InputStream queryImgStream(int id) {
		String sql = "select image from imgtest where id = ?";
		Object[] values = new Object[] {id};
		ImageRM rowMapper = new ImageRM();
		ImageBean imageBean = (ImageBean)GeneralDao.query(sql, values, rowMapper);
		// 如果查询结果为空
		if (imageBean.equals(null)) {
			return null;
		}
		return imageBean.getInStream();
	}
}

// 一条记录映射
class ImageRM implements RowMapper {

	@Override
	public Object rowMapping(ResultSet rs) throws SQLException {
		if (rs.next()) {
			ImageBean imageBean = new ImageBean();
			// 获取图片字节
			imageBean.setInStream(rs.getBinaryStream("image"));
			return imageBean;
		}
		
		return null;
	}
	
}

// 一组记录映射
class ImageRML implements RowMapperList {
	
	@Override
	public List<ImageBean> rowMapping(ResultSet rs) throws SQLException 
	{
		List<ImageBean> list = new ArrayList<ImageBean>();
		// 如果rs有数据
		if (rs.next()) {
			do {
				ImageBean imageBean = new ImageBean();
				imageBean.setId(rs.getInt("id"));
				imageBean.setName(rs.getString("name"));	
				list.add(imageBean);
			} while (rs.next());
		}
		else {
			return null;
		}
		return list;
	}
}

//一组记录映射
class ImageSrcRML implements RowMapperList {
	
	@Override
	public List<ImageBean> rowMapping(ResultSet rs) throws SQLException 
	{
		List<ImageBean> list = new ArrayList<ImageBean>();
		// 如果rs有数据
		if (rs.next()) {
			do {
				ImageBean imageBean = new ImageBean();
				imageBean.setId(rs.getInt("id"));
				imageBean.setName(rs.getString("name"));
				imageBean.setGt(rs.getFloat("groundtruth"));
				imageBean.setSrc(rs.getString("src"));
				list.add(imageBean);
			} while (rs.next());
		}
		else {
			return null;
		}
		return list;
	}
}

