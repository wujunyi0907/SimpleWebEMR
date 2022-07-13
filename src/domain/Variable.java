package domain;

/**
 * @author wujunyi
 *
 */

public class Variable {
	private int varid;
	private String vartype;
	private String varcode;
	private String varname;
	private String showname;
	private String varoptions;
	private int vardefaults;
	private int enable;
	
	public int getVarid() {
		return varid;
	}
	public void setVarid(int varid) {
		this.varid = varid;
	}
	public String getVartype() {
		return vartype;
	}
	public void setVartype(String vartype) {
		this.vartype = vartype;
	}
	public String getVarcode() {
		return varcode;
	}
	public void setVarcode(String varcode) {
		this.varcode = varcode;
	}
	public String getVarname() {
		return varname;
	}
	public void setVarname(String varname) {
		this.varname = varname;
	}
	public String getShowname() {
		return showname;
	}
	public void setShowname(String showname) {
		this.showname = showname;
	}
	public String getVaroptions() {
		return varoptions;
	}
	public void setVaroptions(String varoptions) {
		this.varoptions = varoptions;
	}
	public int getVardefaults() {
		return vardefaults;
	}
	public void setVardefaults(int vardefaults) {
		this.vardefaults = vardefaults;
	}
	public int getEnable() {
		return enable;
	}
	public void setEnable(int enable) {
		this.enable = enable;
	}
	
	@Override
	public String toString() {
		return "Variable [varid=" + varid + ", vartype=" + vartype + ", varcode=" + varcode + ", varname=" + varname
				+ ", showname=" + showname + ", varoptions=" + varoptions + ", vardefaults=" + vardefaults + ", enable="
				+ enable + "]";
	}
	
}
