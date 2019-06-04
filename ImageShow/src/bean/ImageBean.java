package bean;

import java.io.InputStream;

public class ImageBean {

	private int id;
	private float groundtruth;
	private String name;
	private String src;
	private InputStream inStream;
	
	public ImageBean()
	{
		
	}
	
	public ImageBean(int id, float groundtruth, String name, String src) {
		super();
		this.id = id;
		this.groundtruth = groundtruth;
		this.name = name;
		this.src = src;
		
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public InputStream getInStream() {
		return inStream;
	}

	public void setInStream(InputStream inStream) {
		this.inStream = inStream;
	}

	public String getSrc() {
		return src;
	}
	 public void setGt(float groundtruth) {
		 this.groundtruth=groundtruth;
	 }
	public float getGroundtruth() {
		return groundtruth;
	}

	public void setSrc(String src) {
		this.src = src;
	}
	
	
}
