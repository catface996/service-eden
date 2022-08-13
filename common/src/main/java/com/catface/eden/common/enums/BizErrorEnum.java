package com.catface.eden.common.enums;

import com.catface.common.exception.BaseErrorEnum;

/**
 * @author by catface
 * @date 2020/12/17
 */
public enum BizErrorEnum implements BaseErrorEnum {

	/**
	 * 业务异常枚举值
	 */
	UN_READY_JOURNAL("非就绪状态的流水"),
	TOKEN_HAS_EXPIRED("token已过期"),
	;

	private final String message;

	BizErrorEnum(String message) {
		this.message = message;
	}

	@Override
	public String getCode() {
		return name();
	}

	@Override
	public String getMessage() {
		return message;
	}
}