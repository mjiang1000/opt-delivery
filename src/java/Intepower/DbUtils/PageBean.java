package Intepower.DbUtils;



public class PageBean {
	/**
	 * 默认的每页条数
	 */
	private int pageSize = 10;
	/**
	 * 起始记录
	 */
	private int pageNum = 1;
	/**
	 * 记录总数
	 */
	private int total;

	/**
	 * 获取第一条记录开始处
	 * 
	 * @return
	 */
	public int getFirstResult() {
		return (pageNum - 1) * pageSize + 1;
	}

	public int getMaxResult() {
		return pageNum * pageSize;
	}

	/**
	 * 获取下一页的页码
	 * 
	 * @return
	 */
	public int getNext() {
		if (pageNum < this.getTotalPages()) {
			return pageNum + 1;
		} else {
			return pageNum;
		}
	}

	/**
	 * 获取上一页的页码
	 * 
	 * @return
	 */
	public int getPreview() {
		if (pageNum > 1) {
			return pageNum - 1;
		} else {
			return pageNum;
		}
	}

	/**
	 * 获取总页数
	 * 
	 * @return
	 */
	public int getTotalPages() {
		if (total % pageSize == 0) {
			return total / pageSize;
		} else {
			return total / pageSize + 1;
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
}
