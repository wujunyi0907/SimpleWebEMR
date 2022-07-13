package domain;

import java.util.List;

/**
 * 
 * PageBean��װ���ݱ��в�ѯ���ķ�ҳ����
 * �κ�һ����ҳ��ѯ����Ҫ�߱���Щ����
 * @author wujunyi
 *
 */
public class PageBean<T> {
	private int totalCount;//�ܼ�¼��
	private int totalPage;//��ҳ��
	private List<?> list;//��ǰҳ���ݼ���
	private int currentPage;//��ǰҳ��
	private int rows;//ÿҳ��¼��
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
