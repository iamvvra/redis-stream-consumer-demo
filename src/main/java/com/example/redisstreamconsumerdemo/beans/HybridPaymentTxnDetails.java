package com.example.redisstreamconsumerdemo.beans;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ToString
@NoArgsConstructor
public class HybridPaymentTxnDetails implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -4417134933697604024L;

    @JsonProperty("hyTxnRefNo")
    private String hyTxnRefNo;
    @JsonProperty("hyserialNo")
    private Integer hyserialNo;
    @JsonProperty("hypaymentMode")
    private String hypaymentMode;
    @JsonProperty("hyinstrumentType")
    private String hyinstrumentType;
    @JsonProperty("hytxnType")
    private String hytxnType;
    @JsonProperty("hyamount")
    private BigDecimal hyamount;
    @JsonProperty("hychargesFrom")
    private Integer hychargesFrom;
    @JsonProperty("hypaymentRefNo")
    private String hypaymentRefNo;
    @JsonProperty("hychequeDate")
    private String hychequeDate;
    @JsonProperty("hyproviderName")
    private String hyproviderName;
    @JsonProperty("hyproviderAddress")
    private String hyproviderAddress;
    @JsonProperty("hycardCharges")
    private BigDecimal hycardCharges;
    @JsonProperty("hytotalAmount")
    private BigDecimal hytotalAmount;
    @JsonProperty("hycreatedOn")
    private String hycreatedOn;
    @JsonProperty("hycreatedBy")
    private String hycreatedBy;
    @JsonProperty("hymodifiedOn")
    private String hymodifiedOn;
    @JsonProperty("hymodifiedBy")
    private String hymodifiedBy;
    @JsonProperty("hyrecordStatus")
    private Integer hyrecordStatus;
    @JsonProperty("hytokenNo")
    private String hytokenNo;
    @JsonProperty("hyaddPaymentMode")
    private String hyaddPaymentMode;
    @JsonProperty("hyaddAmount")
    private BigDecimal hyaddAmount;
    @JsonProperty("hyaddPaymentRefNo")
    private String hyaddPaymentRefNo;
    @JsonProperty("hyaddChequeDate")
    private String hyaddChequeDate;
    @JsonProperty("hyaddProviderName")
    private String hyaddProviderName;
    @JsonProperty("hyaddProviderAddress")
    private String hyaddProviderAddress;
    @JsonProperty("hyaddCreatedOn")
    private String hyaddCreatedOn;
    @JsonProperty("hyaddCreatedBy")
    private String hyaddCreatedBy;

}