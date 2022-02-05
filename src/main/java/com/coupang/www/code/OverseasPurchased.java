package com.coupang.www.code;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum OverseasPurchased implements CommonCode<OverseasPurchased> {
	
	OVERSEAS_PURCHASED("OVERSEAS_PURCHASED", "Y", "구매 대행", "구매 대행 서비스입니다.", 1),
	NOT_OVERSEAS_PURCHASED("NOT_OVERSEAS_PURCHASED", "N", "구매 대행 아님(기본 값)", "기본 값인 비구매 대행 서비스입니다.", 2);

	private String code;
	private String column;
	private String name;
	private String desc;
	private int order;
	
	private OverseasPurchased(String code, String column, String name, String desc, int order) {
		this.code = code;
		this.column = column;
		this.name = name;
		this.desc = desc;
		this.order = order;
	}
	
	@JsonCreator
	public static OverseasPurchased fromJson(Object code) {
		if (code instanceof String) {
			return CommonCode.fromJson(OverseasPurchased.class, code.toString());
		} else if (code instanceof OverseasPurchased) {
			return CommonCode.fromJson(OverseasPurchased.class, ((OverseasPurchased) code).getCode());
		}
		
		throw new IllegalArgumentException(String.format("%s is not found from %s", code.toString(), "OverseasPurchased"));
	}
	
}
