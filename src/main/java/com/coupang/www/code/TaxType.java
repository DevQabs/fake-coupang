package com.coupang.www.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum TaxType implements CommonCode<TaxType> {

	TAX("TAX", "TAX", "과세(기본값)", "과세 상품입니다.", 1),
	FREE("FREE", "FREE", "비과세", "비과세 상품입니다.", 2);
	
	private String code;
	private String column;
	private String name;
	private String desc;
	private int order;
	
	private TaxType(String code, String column, String name, String desc, int order) {
		this.code = code;
		this.column = column;
		this.name = name;
		this.desc = desc;
		this.order = order;
	}
	
	@JsonCreator
	public static TaxType fromJson(Object code) {
		if (code instanceof String) {
			return CommonCode.fromJson(TaxType.class, code.toString());
		} else if (code instanceof TaxType) {
			return CommonCode.fromJson(TaxType.class, ((TaxType) code).getCode());
		}
		
		throw new IllegalArgumentException(String.format("%s is not found from %s", code.toString(), "TaxType"));
	}
	
}
