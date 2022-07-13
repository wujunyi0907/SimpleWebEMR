package domain;

/**
 * @author wujunyi
 *
 */

public class Administrator {
	private int adid;
	private String adname;
	private String adpasswd;
	
	public Administrator() {
		super();
	}
	
	public int getAdid() {
		return adid;
	}
	public void setAdid(int adid) {
		this.adid = adid;
	}
	public String getAdname() {
		return adname;
	}
	public void setAdname(String adname) {
		this.adname = adname;
	}
	public String getAdpasswd() {
		return adpasswd;
	}
	public void setAdpasswd(String adpasswd) {
		this.adpasswd = adpasswd;
	}
	
	@Override
	public String toString() {
		return "User [adid=" + adid + ", adname=" + adname + ", adpasswd=" + adpasswd + "]";
	}		
}
