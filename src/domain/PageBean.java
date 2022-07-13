package domain;

import java.util.List;

/**
 * 
 * PageBean封装数据表中查询到的分页集合
 * 任何一个分页查询都需要具备这些属性
 * @author wujunyi
 *
 */
public class PageBean<T> {
	private int totalCount;//总记录数
	private int totalPage;//总页数
	private List<?> list;//当前页数据集合
	private int currentPage;//当前页码
	private int rows;//每页记录数
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<?> getList() {
		return list;
	}
	public void setList(List<?> list) {
		this.list = list;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	@Override
	public String toString() {
		return "PageBean [totalCount=" + totalCount + ", totalPage=" + totalPage + ", list=" + list + ", currentPage="
				+ currentPage + ", rows=" + rows + "]";
	}
}
