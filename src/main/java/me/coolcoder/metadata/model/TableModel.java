package me.coolcoder.metadata.model;

import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
public class TableModel implements Serializable {
	//表名
	private String tableName;
	//数据文件名
	private String xlsDataName;
	//列集合
	private List<ColumnModel> listCol;
	
	public TableModel(){}
	
	public TableModel(String tableName, List<ColumnModel> listCol) {
		super();
		this.tableName = tableName;
		this.listCol = listCol;
	}

	public TableModel(String tableName, String xlsDataName,
			List<ColumnModel> listCol) {
		this.tableName = tableName;
		this.xlsDataName = xlsDataName;
		this.listCol = listCol;
	}

	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getXlsDataName() {
		return xlsDataName;
	}
	public void setXlsDataName(String xlsDataName) {
		this.xlsDataName = xlsDataName;
	}

	public List<ColumnModel> getListCol() {
		return listCol;
	}
	public void setListCol(List<ColumnModel> listCol) {
		this.listCol = listCol;
	}
	
}
