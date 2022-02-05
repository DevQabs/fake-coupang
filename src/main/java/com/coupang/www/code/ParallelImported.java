package com.coupang.www.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ParallelImported implements CommonCode<ParallelImported> {

	PARALLEL_IMPORTED("PARALLEL_IMPORTED", "Y", "병행수입", "병행수입의 경우, 상품 생성 시에 수입신고 필증 URL을 함께 등록해야 함.", 1),
	NOT_PARALLEL_IMPORTED("NOT_PARALLEL_IMPORTED", "N", "병행수입 아님(기본 값)", "병행 수입이 아닙니다.(기본 값)", 2);
	
	private String code;
	private String column;
	private String name;
	private String desc;
	private int order;
	
	private ParallelImported(String code, String column, String name, String desc, int order) {
		this.code = code;
		this.column = column;
		this.name = name;
		this.desc = desc;
		this.order = order;
	}
	
	@JsonCreator
	public static ParallelImported fromJson(Object code) {
		if (code instanceof String) {
			return CommonCode.fromJson(ParallelImported.class, code.toString());
		} else if (code instanceof OfferCondition) {
			return CommonCode.fromJson(ParallelImported.class, ((ParallelImported) code).getCode());
		}
		
		throw new IllegalArgumentException(String.format("%s is not found from %s", code.toString(), "ParallelImported"));
	}
	
}
