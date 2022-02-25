package com.coupang.www.product.domain.entity;

import com.coupang.www.code.*;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Aggregate Root Entity
 */
@Entity
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = {"productNo"})
@AllArgsConstructor
@Component
public class Product {

	@Id
	private long productNo;

	private Long displayCategoryCode;

	@NotNull
	@Max(100)
	@Column(nullable = false, length = 100)
	private String sellerProductName;

	@NotNull
	private String vendorId;

	@NotNull
	private LocalDateTime saleStartedAt;

	@NotNull
	private LocalDateTime saleEndedAt;

	private String displayProductName;

	private String brand;

	private String generalProductName;

	private String productGroup;

	@NotNull
	private DeliveryMethod deliveryMethod;

	@NotNull
	private String deliveryCompanyCode;

	@NotNull
	private DeliveryChargeType deliveryChargeType;

	@NotNull
	private BigDecimal deliveryCharge;

	@NotNull
	private BigDecimal freeShipOverAmount;

	@NotNull
	private BigDecimal deliveryChargeOnReturn;

	@NotNull
	private String remoteAreaDeliverable;

	@NotNull
	private UnionDeliveryType unionDeliveryType;

	@NotNull
	private String returnCenterCode;

	@NotNull
	private String returnChargeName;

	@NotNull
	private String companyContactNumber;

	@NotNull
	private String returnZipCode;

	@NotNull
	private String returnAddress;

	@NotNull
	private String returnAddressDetail;

	@NotNull
	private BigDecimal returnCharge;

	@NotNull
	private int outboundShippingPlaceCode;

	@NotNull
	private String vendorUserId;

	@NotNull
	private boolean requested;

	@NotNull
	@OneToMany
	private List<Item> items;

	@OneToMany
	private List<Document> requireDocuments;

	private String extraInfoMessage;

	private String manufacture;
}