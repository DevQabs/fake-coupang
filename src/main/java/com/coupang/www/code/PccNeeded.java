package com.coupang.www.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PccNeeded implements CommonCode<PccNeeded> {

	TRUE("TRUE", "Y", "PCC(개인통관부호) 필수", "고객이 PCC 입력 후 구매 가능(PCC는 발주서에 포함됨)", 1),
	FALSE("FALES", "N", "PCC 비필수", "고객이 PCC를 입력하지 않고 상품 구매 가능", 2);
	
	private String code;
	private String column;
	private String name;
	private String desc;
	private int order;
	
	private PccNeeded(String code, String column, String name, String desc, int order) {
		this.code = code;
		this.column = column;
		this.name = name;
		this.desc = desc;
		this.order = order;
	}
	
	@JsonCreator
	public static PccNeeded fromJson(Object code) {
		if (code instanceof String) {
			return CommonCode.fromJson(PccNeeded.class, code.toString());
		} else if (code instanceof OfferCondition) {
			return CommonCode.fromJson(PccNeeded.class, ((PccNeeded) code).getCode());
		}
		
		throw new IllegalArgumentException(String.format("%s is not found from %s", code.toString(), "PccNeeded"));
	}
	
}
