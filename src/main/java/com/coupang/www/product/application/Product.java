package com.coupang.www.product.application;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Component
public class Product {

	private String displayCategoryCode;
	
	private String sellerProductName;
	
	private String vendorId;
	
	private String saleStartedAt;
	
	private String saleEndedAt;
	
	private String displayProductName;
	
	private String brand;
	
	private String generalProductName;
	
	private String productGroup;
	
	private String deliveryMethod;
	
	private String deliveryCompanyCode;
	
	private String deliveryChargeType;
	
	private BigDecimal deliveryCharge;
	
	private BigDecimal freeShipOverAmount;
	
	private BigDecimal deliveryChargeOnReturn;
	
	private String remoteAreaDeliverable;
	
	private String unionDeliveryType;
	
	private String returnCenterCode;
	
	private String returnChargeName;
	
	private String companyContactNumber;
	
	private String returnZipCode;
	
	private String returnAddress;
	
	private String returnAddressDetail;
	
	private BigDecimal returnCharge;
	
	private int outboundShippingPlaceCode;
	
	private String vendorUserId;
	
	private boolean requested;
	
	private List<Item> items;
	
	public class Item {
		
		private String itemName;
		
		private BigDecimal originalPrice;
		
		private BigDecimal salePrice;
		
		private int maximumBuyCount;
		
		private int maximumBuyForPerson;
		
		private int maximumBuyForPersonPeriod;
		
		private int outboundShippingTimeDay;
		
		private int unitCount;
	}
	
	private String adultOnly;
	
	private String taxType;
	
	private String parallelImported;
	
	private String overseasPurchased;
	
	private boolean pccNeeded;
	
	private String externalVendorSku;
	
	private String barcode;
	
	private boolean emptyBarcode;
	
	private String emptyBarcodeReason;
	
	private String modelNo;
	
	private List<ExtraProperty> extraProperties;
	
	public class ExtraProperty {
		
		private String key;
	}
	
	private List<Certification> certifications;
	
	public class Certification {
		
		private String certificationType;
		
		private String certificationCode;
		
	}
	
	private List<String> searchTags;
	
	private List<Image> images;
	
	public class Image {
		
		private Integer imageOrder;
		
		private String imageType;
		
		private String cdnPath;
		
		private String vendorPath;
		
	}
	
	private List<Notice> notices;
	
	public class Notice {
		
		private String noticeCategoryName;
		
		private String noticeCategoryDetailName;
		
		private String content;
		
	}
	
	private List<Attribute> attributes;
	
	public class Attribute {
		
		private String attributeTypeName;
		
		private String attributeValueName;
		
		private String exposed;
		
	}
	
	private List<Content> contents;
	
	public class Content {
		
		private String contentsType;
		
		private List<ContentDetail> contentDetails;
		
		public class ContentDetail {
			
			private String content;
			
			private String detailType;
			
		}
		
		private String offerCondition;
		
		private String offerDescription;
		
	}
	
	private List<RequireDocument> requireDocuments;
	
	public class RequireDocument {
		
		private String templateName;
		
		private String documentPath;
		
		private String vendorDocumentPath;
		
	}
	
	private String extraInfoMessage;
	
	private String manufacture;
	
	public Product insert() {
		return null;
	}
}
