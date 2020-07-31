package com.example.redisstreamconsumerdemo.beans;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CancelTxnObj implements Serializable {

    private static final long serialVersionUID = -5250215961086596865L;

    @JsonProperty("txnRefNo")
    private String txnRefNo;
    @JsonProperty("cancellationAgentCode")
    private String cancellationAgentCode;
    @JsonProperty("instrumentType")
    private String instrumentType;
    @JsonProperty("txnType")
    private String txnType;
    @JsonProperty("deliveryChannel")
    private String deliveryChannel;
    @JsonProperty("agentTxnRefNo")
    private String agentTxnRefNo;
    @JsonProperty("cancellationDate")
    private String cancellationDate;
    @JsonProperty("cancellationReasonCode")
    private Integer cancellationReasonCode;
    @JsonProperty("paymentMode")
    private String paymentMode;
    @JsonProperty("baseCcyCode")
    private String baseCcyCode;
    @JsonProperty("payinCcyCode")
    private String payinCcyCode;
    @JsonProperty("payoutCcyCode")
    private String payoutCcyCode;
    @JsonProperty("settlementCcyCode")
    private String settlementCcyCode;
    @JsonProperty("agentXchgRatePayinToPayout")
    private BigDecimal agentXchgRatePayinToPayout;
    @JsonProperty("agentXchgRatePayinToPayoutO")
    private BigDecimal agentXchgRatePayinToPayoutO;
    @JsonProperty("xchgRatePayinToPayout")
    private BigDecimal xchgRatePayinToPayout;
    @JsonProperty("xchgRateUSDToPayin")
    private BigDecimal xchgRateUSDToPayin;
    @JsonProperty("xchgRateUSDToPayout")
    private BigDecimal xchgRateUSDToPayout;
    @JsonProperty("xchgRateUSDToSettlement")
    private BigDecimal xchgRateUSDToSettlement;
    @JsonProperty("xchgRateUSDToSettlementBuy")
    private BigDecimal xchgRateUSDToSettlementBuy;
    @JsonProperty("xchgRateSettlementToPayin")
    private BigDecimal xchgRateSettlementToPayin;
    @JsonProperty("xchgRateSettlementToPayout")
    private BigDecimal xchgRateSettlementToPayout;
    @JsonProperty("xchgRateSettlementToSPCcy")
    private BigDecimal xchgRateSettlementToSPCcy;
    @JsonProperty("payoutAmount")
    private BigDecimal payoutAmount;
    @JsonProperty("refundPayinAmount")
    private BigDecimal refundPayinAmount;
    @JsonProperty("refundCommission")
    private BigDecimal refundCommission;
    @JsonProperty("refundTax")
    private BigDecimal refundTax;
    @JsonProperty("refundOtherCharges")
    private BigDecimal refundOtherCharges;
    @JsonProperty("refundCardCharges")
    private BigDecimal refundCardCharges;
    @JsonProperty("refundAdditionalCharges")
    private BigDecimal refundAdditionalCharges;
    @JsonProperty("cancellationCharges")
    private BigDecimal cancellationCharges;
    @JsonProperty("totalRefundPayinAmount")
    private BigDecimal totalRefundPayinAmount;
    @JsonProperty("xmCancellationChargesInLC")
    private BigDecimal xmCancellationChargesInLC;
    @JsonProperty("xmRefundPayinAmount")
    private BigDecimal xmRefundPayinAmount;
    @JsonProperty("xmRefundCommission")
    private BigDecimal xmRefundCommission;
    @JsonProperty("xmRefundTax")
    private BigDecimal xmRefundTax;
    @JsonProperty("xmRefundOtherCharges")
    private BigDecimal xmRefundOtherCharges;
    @JsonProperty("xmRefundCardCharges")
    private BigDecimal xmRefundCardCharges;
    @JsonProperty("xmRefundAdditionalCharges")
    private BigDecimal xmRefundAdditionalCharges;
    @JsonProperty("xmCancellationCharges")
    private BigDecimal xmCancellationCharges;
    @JsonProperty("xmRefundPayinAmountInSCcy")
    private BigDecimal xmRefundPayinAmountInSCcy;
    @JsonProperty("xmRefundCommissionInSCcy")
    private BigDecimal xmRefundCommissionInSCcy;
    @JsonProperty("xmRefundTaxInSCcy")
    private BigDecimal xmRefundTaxInSCcy;
    @JsonProperty("xmRefundOtherChargesInSCcy")
    private BigDecimal xmRefundOtherChargesInSCcy;
    @JsonProperty("xmCancellationChargesInSCcy")
    private BigDecimal xmCancellationChargesInSCcy;
    @JsonProperty("xmRefundCardChargesInSCcy")
    private BigDecimal xmRefundCardChargesInSCcy;
    @JsonProperty("xmRefundAddlChargesInSCcy")
    private BigDecimal xmRefundAddlChargesInSCcy;
    @JsonProperty("payin2BaseCcyRate")
    private BigDecimal payin2BaseCcyRate;
    @JsonProperty("refundPayinAmountInBaseCcy")
    private BigDecimal refundPayinAmountInBaseCcy;
    @JsonProperty("sPCcyCode")
    private String sPCcyCode;
    @JsonProperty("refundPayinAmountInSPCcy")
    private BigDecimal refundPayinAmountInSPCcy;
    @JsonProperty("refundCommissionInSPCcy")
    private BigDecimal refundCommissionInSPCcy;
    @JsonProperty("refundTaxInSPCcy")
    private BigDecimal refundTaxInSPCcy;
    @JsonProperty("refundOtherChargesInSPCcy")
    private BigDecimal refundOtherChargesInSPCcy;
    @JsonProperty("cancellationChargesInSPCcy")
    private BigDecimal cancellationChargesInSPCcy;
    @JsonProperty("refundCardChargesInSPCcy")
    private BigDecimal refundCardChargesInSPCcy;
    @JsonProperty("refundAddlChargesInSPCcy")
    private BigDecimal refundAddlChargesInSPCcy;
    @JsonProperty("serviceProviderCode")
    private String serviceProviderCode;
    @JsonProperty("draweeBankBranchCode")
    private String draweeBankBranchCode;
    @JsonProperty("remarks")
    private String remarks;
    @JsonProperty("xrCancellationStatus")
    private Integer xrCancellationStatus;
    @JsonProperty("createdOn")
    private String createdOn;
    @JsonProperty("createdBy")
    private String createdBy;
    @JsonProperty("modifiedOn")
    private String modifiedOn;
    @JsonProperty("modifiedBy")
    private String modifiedBy;
    @JsonProperty("txnGMTDate")
    private String txnGMTDate;
    @JsonProperty("sendingAgentCode")
    private String sendingAgentCode;
    @JsonProperty("instrumentNo")
    private String instrumentNo;
    @JsonProperty("xmCancelCreditToAgent")
    private BigDecimal xmCancelCreditToAgent;
    @JsonProperty("xmCancelDebitToAgent")
    private BigDecimal xmCancelDebitToAgent;
    @JsonProperty("xmCancelCreditToAgentInSCcy")
    private BigDecimal xmCancelCreditToAgentInSCcy;
    @JsonProperty("xmCancelDebitToAgentInSCcy")
    private BigDecimal xmCancelDebitToAgentInSCcy;
    @JsonProperty("cancelCreditToAgentInSPCcy")
    private BigDecimal cancelCreditToAgentInSPCcy;
    @JsonProperty("cancelDebitToAgentInSPCcy")
    private BigDecimal cancelDebitToAgentInSPCcy;
    @JsonProperty("deliveryOption")
    private String deliveryOption;
    @JsonProperty("xchgRateUSDToPSettlement")
    private BigDecimal xchgRateUSDToPSettlement;
    @JsonProperty("xchgRateUSDToPSSettlementSell")
    private BigDecimal xchgRateUSDToPSSettlementSell;
    @JsonProperty("xchgRatePSSettlementToPayin")
    private BigDecimal xchgRatePSSettlementToPayin;
    @JsonProperty("xchgRatePSSettlementToPayout")
    private BigDecimal xchgRatePSSettlementToPayout;
    @JsonProperty("psSettlementAmount")
    private BigDecimal psSettlementAmount;
    @JsonProperty("psSettlementCcy")
    private String psSettlementCcy;
    @JsonProperty("psCommissionInSettlementCcy")
    private BigDecimal psCommissionInSettlementCcy;
    @JsonProperty("psTaxInSettlementCcy")
    private BigDecimal psTaxInSettlementCcy;
    @JsonProperty("psOtherChargesInSettlementCcy")
    private BigDecimal psOtherChargesInSettlementCcy;
    @JsonProperty("psCardChargesInSettlementCcy")
    private BigDecimal psCardChargesInSettlementCcy;
    @JsonProperty("psAdditionalChargesInSCcy")
    private BigDecimal psAdditionalChargesInSCcy;
    @JsonProperty("settellmentRateInUSD")
    private BigDecimal settellmentRateInUSD;
    @JsonProperty("settellmentAmountInUSD")
    private BigDecimal settellmentAmountInUSD;

}