package com.faceye.feature.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Page<T> implements Serializable {
	/**
     * 
     */
	private static final long serialVersionUID = 1L;
	// 每页默认数据总数
	public final static Integer PAGESIZE = 15;
	// 每页数据总数
	private Integer pageSize = PAGESIZE;
	// 数据集合
	private List<T> items;
	// 总记录数
	private Integer totalCount;
	// 计算索引数组
	private Integer[] indexes = new Integer[0];
	// 起始索引
	private Integer startIndex = 0;
	// 页码数组
	private Integer[] pageNums = new Integer[0];
	private Integer pageNum = 1;

	public Page(List<T> items) {
		if (items==null) {
			items = new ArrayList();
		}
		setItems(items);
		setPageSize(items.size());
		setTotalCount(items.size());
		setStartIndex(0);
	}

	public Page(List<T> items, Integer totalCount) {
		setPageSize(PAGESIZE);
		setTotalCount(totalCount);
		setItems(items);
		setStartIndex(0);
	}

	public Page(List<T> items, Integer totalCount, Integer startIndex) {
		setPageSize(PAGESIZE);
		setTotalCount(totalCount);
		setItems(items);
		setStartIndex(startIndex);
	}

	public Page(List<T> items, Integer totalCount, Integer pageSize, Integer startIndex) {
		if (null == startIndex) {
			startIndex = 0;
		}
		if (null == pageSize) {
			if (items==null) {
				pageSize = 0;
			} else {
				pageSize = items.size();
			}
		}
		setPageSize(pageSize);
		setTotalCount(totalCount);
		setItems(items);
		setStartIndex(startIndex);
	}

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	/**
	 * 计算总记录数
	 * 
	 * @param totalCount
	 */
	public void setTotalCount(Integer totalCount) {
		if (totalCount > 0) {
			this.totalCount = totalCount;
			if (pageSize == 0) {
				pageSize = PAGESIZE;
			}
			Integer count = totalCount / pageSize;
			if (totalCount % pageSize > 0) {
				count++;
			}
			indexes = new Integer[count];
			for (Integer i = 0; i < count; i++) {
				indexes[i] = pageSize * i;
			}
			pageNums = new Integer[count];
			for (int i = 0; i < count; i++) {
				pageNums[i] = i + 1;
			}
		} else {
			this.totalCount = 0;
		}
	}

	public Integer[] getIndexes() {
		return indexes;
	}

	public void setIndexes(Integer[] indexes) {
		this.indexes = indexes;
	}

	public Integer getStartIndex() {
		return startIndex;
	}

	/**
	 * 设置起始索引
	 * 
	 * @param startIndex
	 */
	public void setStartIndex(Integer startIndex) {
		if (totalCount <= 0) {
			this.startIndex = 0;
		} else if (startIndex >= totalCount) {
			this.startIndex = indexes[indexes.length - 1];
		} else if (startIndex < 0) {
			this.startIndex = 0;
		} else {
			this.startIndex = indexes[startIndex / pageSize];
		}
	}

	/**
	 * 取得下一个分页索引
	 * 
	 * @return
	 */
	public Integer getNextIndex() {
		Integer nextIndex = getStartIndex() + pageSize;
		if (nextIndex >= totalCount) {
			return getStartIndex();
		} else {
			return nextIndex;
		}
	}

	public Integer getPageNum(int startIndex, int pageSize) {
		int pageNum = 1;
		if (startIndex != 0) {
			if (pageSize != 0) {
				pageNum = startIndex / pageSize;
			}
			pageNum+=1;
		}
		if(pageNum==0){
			pageNum=1;
		}
		return pageNum;
	}

	public Integer getPageNum() {
		return getPageNum(startIndex,pageSize);
	}
	public Integer getNextPageNum(){
		return this.getPageNum(this.getNextIndex(),pageSize);
	}
	public Integer getPreviousPageNum(){
		return this.getPageNum(this.getPreviousIndex(),pageSize);
	}

	/**
	 * 取得前一个分页索引
	 * 
	 * @return
	 */
	public Integer getPreviousIndex() {
		Integer previousIndex = getStartIndex() - pageSize;
		if (previousIndex < 0) {
			return 0;
		} else {
			return previousIndex;
		}
	}


}
