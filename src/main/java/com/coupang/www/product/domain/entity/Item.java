package com.coupang.www.product.domain.entity;

import com.coupang.www.code.AdultOnly;
import com.coupang.www.code.OverseasPurchased;
import com.coupang.www.code.ParallelImported;
import com.coupang.www.code.TaxType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Component
public class Item {

    @Id
    private long itemNo;

    @NotNull
    private String itemName;

    @NotNull
    private BigDecimal originalPrice;

    @NotNull
    private BigDecimal salePrice;

    @NotNull
    private int maximumBuyCount;

    @NotNull
    private int maximumBuyForPerson;

    @NotNull
    private int maximumBuyForPersonPeriod;

    @NotNull
    private int outboundShippingTimeDay;

    @NotNull
    private int unitCount;

    @NotNull
    private AdultOnly adultOnly;

    @NotNull
    private TaxType taxType;

    @NotNull
    private ParallelImported parallelImported;

    @NotNull
    private OverseasPurchased overseasPurchased;

    @NotNull
    private boolean pccNeeded;

    @NotNull
    private String externalVendorSku;

    @NotNull
    private String barcode;

    @NotNull
    private boolean emptyBarcode;

    @NotNull
    private String emptyBarcodeReason;

    @NotNull
    private String modelNo;

    @OneToMany
    private List<Property> extraProperties;

    @OneToMany
    private List<Certification> certifications;

    @OneToMany
    private List<Tag> searchTags;

    @OneToMany
    private List<Image> images;

    @OneToMany
    private List<Notice> notices;

    @OneToMany
    private List<Attribute> attributes;

    @OneToMany
    private List<Content> contents;
}