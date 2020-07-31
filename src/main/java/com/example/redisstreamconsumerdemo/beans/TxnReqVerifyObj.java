
package com.example.redisstreamconsumerdemo.beans;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TxnReqVerifyObj implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("txnRefNo")
    private String txnRefNo;
    @JsonProperty("instrumentType")
    private String instrumentType;
    @JsonProperty("deliveryChannel")
    private String deliveryChannel;
    @JsonProperty("source")
    private String source;
    @JsonProperty("sendingAgentCode")
    private String sendingAgentCode;
    @JsonProperty("agentTxnRefNo")
    private String agentTxnRefNo;
    @JsonProperty("deliveryOption")
    private String deliveryOption;
    @JsonProperty("payinDate")
    private String payinDate;
    @JsonProperty("valueDate")
    private String valueDate;
    @JsonProperty("serviceProviderCode")
    private String serviceProviderCode;
    @JsonProperty("draweeBankCode")
    private String draweeBankCode;
    @JsonProperty("draweeBankBranchCode")
    private String draweeBankBranchCode;
    @JsonProperty("payinCcyCode")
    private String payinCcyCode;
    @JsonProperty("payoutCcyCode")
    private String payoutCcyCode;
    @JsonProperty("settlementCcyCode")
    private String settlementCcyCode;
    @JsonProperty("paymentMode")
    private String paymentMode;
    @JsonProperty("agentXchgRatePayintoPayoutO")
    private BigDecimal agentXchgRatePayintoPayoutO;
    @JsonProperty("agentXchgRatePayintoPayout")
    private BigDecimal agentXchgRatePayintoPayout;
    @JsonProperty("xchgRatePayinToPayout")
    private BigDecimal xchgRatePayinToPayout;
    @JsonProperty("payoutAmount")
    private BigDecimal payoutAmount;
    @JsonProperty("payinAmount")
    private BigDecimal payinAmount;
    @JsonProperty("commission")
    private BigDecimal commission;
    @JsonProperty("tax")
    private BigDecimal tax;
    @JsonProperty("otherCharges")
    private BigDecimal otherCharges;
    @JsonProperty("cardCharges")
    private BigDecimal cardCharges;
    @JsonProperty("additionalCharges")
    private BigDecimal additionalCharges;
    @JsonProperty("totalPayinAmount")
    private BigDecimal totalPayinAmount;
    @JsonProperty("additionalServices")
    private int additionalServices;
    @JsonProperty("txnAgentStatus")
    private int txnAgentStatus;
    @JsonProperty("txnAgentStatus2")
    private int txnAgentStatus2;
    @JsonProperty("txnGMTDate")
    private String txnGMTDate;
    @JsonProperty("createdOn")
    private String createdOn;
    @JsonProperty("createdBy")
    private String createdBy;
    @JsonProperty("modifiedOn")
    private String modifiedOn;
    @JsonProperty("modifiedBy")
    private String modifiedBy;
    @JsonProperty("baseCcyCode")
    private String baseCcyCode;
    @JsonProperty("xchgRateUSDToPayin")
    private BigDecimal xchgRateUSDToPayin;
    @JsonProperty("xchgRateUSDToPayout")
    private BigDecimal xchgRateUSDToPayout;
    @JsonProperty("xchgRateUSDToSettlement")
    private BigDecimal xchgRateUSDToSettlement;
    @JsonProperty("xchgRateUSDToSettlementSell")
    private BigDecimal xchgRateUSDToSettlementSell;
    @JsonProperty("xchgRateSettlementToPayin")
    private BigDecimal xchgRateSettlementToPayin;
    @JsonProperty("xchgRateSettlementToPayout")
    private BigDecimal xchgRateSettlementToPayout;
    @JsonProperty("xchgRateCountryPayinToPayout")
    private BigDecimal xchgRateCountryPayinToPayout;
    @JsonProperty("xchgBaseRateUSDToPayout")
    private BigDecimal xchgBaseRateUSDToPayout;
    @JsonProperty("xchgRateSettlementToSPCcy")
    private BigDecimal xchgRateSettlementToSPCcy;
    @JsonProperty("xchgRateSettlementToPayoutO")
    private BigDecimal xchgRateSettlementToPayoutO;
    @JsonProperty("xchgRateCountryPayinToPayoutO")
    private BigDecimal xchgRateCountryPayinToPayoutO;
    @JsonProperty("xmCommissionInLC")
    private BigDecimal xmCommissionInLC;
    @JsonProperty("xmTaxInLC")
    private BigDecimal xmTaxInLC;
    @JsonProperty("xmOtherChargesInLC")
    private BigDecimal xmOtherChargesInLC;
    @JsonProperty("xmCardChargesInLC")
    private BigDecimal xmCardChargesInLC;
    @JsonProperty("xmAdditionalChargesInLC")
    private BigDecimal xmAdditionalChargesInLC;
    @JsonProperty("xmPayoutAmtInSettlementCcy")
    private BigDecimal xmPayoutAmtInSettlementCcy;
    @JsonProperty("xmCommissionInSettlementCcy")
    private BigDecimal xmCommissionInSettlementCcy;
    @JsonProperty("xmTaxInSettlementCcy")
    private BigDecimal xmTaxInSettlementCcy;
    @JsonProperty("xmOtherChgsInSettlementCcy")
    private BigDecimal xmOtherChgsInSettlementCcy;
    @JsonProperty("xmCardChgsInSettlementCcy")
    private BigDecimal xmCardChgsInSettlementCcy;
    @JsonProperty("xmAdditionalChgsInSCcy")
    private BigDecimal xmAdditionalChgsInSCcy;
    @JsonProperty("xmPayoutAmtInCCcy")
    private BigDecimal xmPayoutAmtInCCcy;
    @JsonProperty("xmCommissionInCCcy")
    private BigDecimal xmCommissionInCCcy;
    @JsonProperty("xmTaxInCCcy")
    private BigDecimal xmTaxInCCcy;
    @JsonProperty("xmOtherChargesInCCcy")
    private BigDecimal xmOtherChargesInCCcy;
    @JsonProperty("xmCardChargesInCCcy")
    private BigDecimal xmCardChargesInCCcy;
    @JsonProperty("xmAdditionalChargesInCCcy")
    private BigDecimal xmAdditionalChargesInCCcy;
    @JsonProperty("xmPayoutAmount")
    private BigDecimal xmPayoutAmount;
    @JsonProperty("xmCommission")
    private BigDecimal xmCommission;
    @JsonProperty("xmTax")
    private BigDecimal xmTax;
    @JsonProperty("xmOtherCharges")
    private BigDecimal xmOtherCharges;
    @JsonProperty("xmCardCharges")
    private BigDecimal xmCardCharges;
    @JsonProperty("xmAdditionalCharges")
    private BigDecimal xmAdditionalCharges;
    @JsonProperty("payin2BaseCcyRate")
    private BigDecimal payin2BaseCcyRate;
    @JsonProperty("payoutAmountInBaseCcy")
    private BigDecimal payoutAmountInBaseCcy;
    @JsonProperty("payoutAmountInSPCcy")
    private BigDecimal payoutAmountInSPCcy;
    @JsonProperty("commissionInSPCcy")
    private BigDecimal commissionInSPCcy;
    @JsonProperty("taxInSPCcy")
    private BigDecimal taxInSPCcy;
    @JsonProperty("otherChargesInSPCcy")
    private BigDecimal otherChargesInSPCcy;
    @JsonProperty("cardChargesInSPCcy")
    private BigDecimal cardChargesInSPCcy;
    @JsonProperty("additionalChargesInSPCcy")
    private BigDecimal additionalChargesInSPCcy;
    @JsonProperty("sPCcyCode")
    private String sPCcyCode;
    @JsonProperty("customerNo")
    private String customerNo;
    @JsonProperty("customerFirstName")
    private String customerFirstName;
    @JsonProperty("customerMiddleName")
    private String customerMiddleName;
    @JsonProperty("customerLastName")
    private String customerLastName;
    @JsonProperty("customerPOBox")
    private String customerPOBox;
    @JsonProperty("customerAddress1")
    private String customerAddress1;
    @JsonProperty("customerAddress2")
    private String customerAddress2;
    @JsonProperty("customerAddressCity")
    private String customerAddressCity;
    @JsonProperty("customerAddressDistrict")
    private String customerAddressDistrict;
    @JsonProperty("customerAddressState")
    private String customerAddressState;
    @JsonProperty("customerAddressCountryCode")
    private String customerAddressCountryCode;
    @JsonProperty("customerAddressZip")
    private String customerAddressZip;
    @JsonProperty("customerPhone")
    private String customerPhone;
    @JsonProperty("customerMobile")
    private String customerMobile;
    @JsonProperty("customerFax")
    private String customerFax;
    @JsonProperty("customerEmail")
    private String customerEmail;
    @JsonProperty("customerOtherInfo")
    private String customerOtherInfo;
    @JsonProperty("customerDescription")
    private String customerDescription;
    @JsonProperty("customerStatus")
    private int customerStatus;
    @JsonProperty("customerStatus2")
    private int customerStatus2;
    @JsonProperty("customerIDType")
    private String customerIDType;
    @JsonProperty("customerIDOtherType")
    private String customerIDOtherType;
    @JsonProperty("customerID")
    private String customerID;
    @JsonProperty("customerIDOtherInfo")
    private String customerIDOtherInfo;
    @JsonProperty("customerIDIssuedBy")
    private String customerIDIssuedBy;
    @JsonProperty("customerIDIssuedAt")
    private String customerIDIssuedAt;
    @JsonProperty("customerIDIssueDate")
    private String customerIDIssueDate;
    @JsonProperty("customerIDValidThru")
    private String customerIDValidThru;
    @JsonProperty("customerGender")
    private String customerGender;
    @JsonProperty("customerDateOfBirth")
    private String customerDateOfBirth;
    @JsonProperty("customerNationalityCode")
    private String customerNationalityCode;
    @JsonProperty("customerOccupation")
    private String customerOccupation;
    @JsonProperty("customerEmployerName")
    private String customerEmployerName;
    @JsonProperty("customerEmployerAddress")
    private String customerEmployerAddress;
    @JsonProperty("customerEmployerPhone")
    private String customerEmployerPhone;
    @JsonProperty("customerSourceOfIncome")
    private String customerSourceOfIncome;
    @JsonProperty("purposeOfTxn")
    private String purposeOfTxn;
    @JsonProperty("purposeDetails")
    private String purposeDetails;
    @JsonProperty("remittanceRemarks")
    private String remittanceRemarks;
    @JsonProperty("customerReferenceNumber")
    private String customerReferenceNumber;
    @JsonProperty("customerOtherName")
    private String customerOtherName;
    @JsonProperty("beneficiaryNo")
    private int beneficiaryNo;
    @JsonProperty("beneficiaryAccountName")
    private String beneficiaryAccountName;
    @JsonProperty("beneficiaryBankCode")
    private String beneficiaryBankCode;
    @JsonProperty("beneficiaryBankName")
    private String beneficiaryBankName;
    @JsonProperty("beneficiaryBankBranchCode")
    private String beneficiaryBankBranchCode;
    @JsonProperty("beneficiaryBankBranchName")
    private String beneficiaryBankBranchName;
    @JsonProperty("beneficiaryBankAccountNo")
    private String beneficiaryBankAccountNo;
    @JsonProperty("beneficiaryAccountConvertible")
    private int beneficiaryAccountConvertible;
    @JsonProperty("beneficiaryAccountCcyCode")
    private String beneficiaryAccountCcyCode;
    @JsonProperty("beneficiaryFirstName")
    private String beneficiaryFirstName;
    @JsonProperty("beneficiaryMiddleName")
    private String beneficiaryMiddleName;
    @JsonProperty("beneficiaryLastName")
    private String beneficiaryLastName;
    @JsonProperty("beneficiaryDlyPOBox")
    private String beneficiaryDlyPOBox;
    @JsonProperty("beneficiaryDlyAddress1")
    private String beneficiaryDlyAddress1;
    @JsonProperty("beneficiaryDlyAddress2")
    private String beneficiaryDlyAddress2;
    @JsonProperty("beneficiaryDlyAddressCity")
    private String beneficiaryDlyAddressCity;
    @JsonProperty("beneficiaryDlyAddressDistrict")
    private String beneficiaryDlyAddressDistrict;
    @JsonProperty("beneficiaryDlyAddressState")
    private String beneficiaryDlyAddressState;
    @JsonProperty("beneficiaryDlyNationalityCode")
    private String beneficiaryDlyNationalityCode;
    @JsonProperty("beneficiaryDlyAddressCCode")
    private String beneficiaryDlyAddressCCode;
    @JsonProperty("beneficiaryDlyAddressZip")
    private String beneficiaryDlyAddressZip;
    @JsonProperty("beneficiaryPhone")
    private String beneficiaryPhone;
    @JsonProperty("beneficiaryMobile")
    private String beneficiaryMobile;
    @JsonProperty("beneficiaryStatus")
    private int beneficiaryStatus;
    @JsonProperty("beneficiaryBkBranchSwiftCode1")
    private String beneficiaryBkBranchSwiftCode1;
    @JsonProperty("beneficiaryBkBranchSwiftCode2")
    private String beneficiaryBkBranchSwiftCode2;
    @JsonProperty("beneficiaryBkBranchSortCode")
    private String beneficiaryBkBranchSortCode;
    @JsonProperty("beneficiaryDraweeBankCode")
    private String beneficiaryDraweeBankCode;
    @JsonProperty("beneficiaryDraweeBkBranchCode")
    private String beneficiaryDraweeBkBranchCode;
    @JsonProperty("beneficiaryGender")
    private String beneficiaryGender;
    @JsonProperty("beneficiaryDateOfBirth")
    private String beneficiaryDateOfBirth;
    @JsonProperty("beneficiaryRefNo")
    private String beneficiaryRefNo;
    @JsonProperty("beneficiaryOtherInfo")
    private String beneficiaryOtherInfo;
    @JsonProperty("beneficiaryDescription")
    private String beneficiaryDescription;
    @JsonProperty("messageToBeneficiary")
    private String messageToBeneficiary;
    @JsonProperty("beneficiaryOtherName")
    private String beneficiaryOtherName;
    @JsonProperty("visaNo")
    private String visaNo;
    @JsonProperty("visaIssueDate")
    private String visaIssueDate;
    @JsonProperty("visaValidThru")
    private String visaValidThru;
    @JsonProperty("visaType")
    private String visaType;
    @JsonProperty("visaRemarks")
    private String visaRemarks;
    @JsonProperty("customerAnnualIncome")
    private BigDecimal customerAnnualIncome;
    @JsonProperty("annualIncomeCcyCode")
    private String annualIncomeCcyCode;
    @JsonProperty("customerAnticipatedBusiness")
    private BigDecimal customerAnticipatedBusiness;
    @JsonProperty("otherInfoRemarks1")
    private String otherInfoRemarks1;
    @JsonProperty("otherInfoRemarks2")
    private String otherInfoRemarks2;
    @JsonProperty("serialNo")
    private int serialNo;
    @JsonProperty("txnType")
    private String txnType;
    @JsonProperty("instrumentTypeC")
    private String instrumentTypeC;
    @JsonProperty("cardNo")
    private String cardNo;
    @JsonProperty("creditCardType")
    private int creditCardType;
    @JsonProperty("expiryDate")
    private String expiryDate;
    @JsonProperty("amount")
    private BigDecimal amount;
    @JsonProperty("issuingBank")
    private String issuingBank;
    @JsonProperty("issuingBankBranch")
    private String issuingBankBranch;
    @JsonProperty("appliedPercentage")
    private BigDecimal appliedPercentage;
    @JsonProperty("authorizationCode")
    private String authorizationCode;
    @JsonProperty("authorizedOn")
    private String authorizedOn;
    @JsonProperty("authorizedBy")
    private String authorizedBy;
    @JsonProperty("recordStatus")
    private int recordStatus;
    @JsonProperty("chequeNo")
    private String chequeNo;
    @JsonProperty("txnDate")
    private String txnDate;
    @JsonProperty("chequeDate")
    private String chequeDate;
    @JsonProperty("chequeCcyCode")
    private String chequeCcyCode;
    @JsonProperty("chequeAmount")
    private BigDecimal chequeAmount;
    @JsonProperty("drawnOnBank")
    private String drawnOnBank;
    @JsonProperty("drawnOnBankBranch")
    private String drawnOnBankBranch;
    @JsonProperty("authorizingAgent")
    private String authorizingAgent;
    @JsonProperty("instrumentNo")
    private String instrumentNo;
    @JsonProperty("instrumentDate")
    private String instrumentDate;
    @JsonProperty("instrumentValueDate")
    private String instrumentValueDate;
    @JsonProperty("instrumentValue")
    private BigDecimal instrumentValue;
    @JsonProperty("instrumentClass")
    private int instrumentClass;
    @JsonProperty("deliveryStationCode")
    private String deliveryStationCode;
    @JsonProperty("draweeBankCodeI")
    private String draweeBankCodeI;
    @JsonProperty("signatoryName1")
    private String signatoryName1;
    @JsonProperty("signatoryName2")
    private String signatoryName2;
    @JsonProperty("instrumentCharges")
    private BigDecimal instrumentCharges;
    @JsonProperty("instrumentStatus")
    private int instrumentStatus;
    @JsonProperty("bankCode")
    private String bankCode;
    @JsonProperty("serviceCode")
    private String serviceCode;
    @JsonProperty("serviceDescription")
    private String serviceDescription;
    @JsonProperty("description1")
    private String description1;
    @JsonProperty("description2")
    private String description2;
    @JsonProperty("description3")
    private String description3;
    @JsonProperty("description4")
    private String description4;
    @JsonProperty("customerIDIssuedCountryCode")
    private String customerIDIssuedCountryCode;
    @JsonProperty("flashTxnFlag")
    private Integer flashTxnFlag;
    @JsonProperty("dcMsgQSerialNo")
    private int dcMsgQSerialNo;
    @JsonProperty("dcMsgQStageNo")
    private int dcMsgQStageNo;
    @JsonProperty("dcMsgQSource")
    private String dcMsgQSource;
    @JsonProperty("dcMsgQDestination")
    private String dcMsgQDestination;
}
