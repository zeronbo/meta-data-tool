package me.coolcoder.metadata.exception;

/**
 * 自定义异常处理类
 * @author Zero
 *
 */
@SuppressWarnings("serial")
public class MetaDataToolException extends Throwable {
	public MetaDataToolException(String msg) {
		super(msg);
	}

	public MetaDataToolException(String msg, Throwable e) {
		super(msg, e);
	}
}
