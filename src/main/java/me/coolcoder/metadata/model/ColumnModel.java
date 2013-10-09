package me.coolcoder.metadata.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ColumnModel implements Serializable {
	//列名
	private String colName;
	//默认值
	private String defValue;
	
	public ColumnModel() {}

	public ColumnModel(String colName, String defValue) {
		super();
		this.colName = colName;
		this.defValue = defValue;
	}

	public ColumnModel(String colName) {
		super();
		this.colName = colName;
	}

	public String getColName() {
		return colName;
	}
	public void setColName(String colName) {
		this.colName = colName;
	}

	public String getDefValue() {
		return defValue;
	}
	public void setDefValue(String defValue) {
		this.defValue = defValue;
	}
	
}
