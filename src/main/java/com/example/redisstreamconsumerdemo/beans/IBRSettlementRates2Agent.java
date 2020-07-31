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
public class IBRSettlementRates2Agent implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("txnID")
    private String txnID;
    @JsonProperty("txnRefNo")
    private String txnRefNo;
    @JsonProperty("instrumentType")
    private String instrumentType;
    @JsonProperty("activityNo")
    private Integer activityNo;
    @JsonProperty("ibrAskInPayinCcy")
    private BigDecimal ibrAskInPayinCcy;
    @JsonProperty("ibrBidInPayinCcy")
    private BigDecimal ibrBidInPayinCcy;
    @JsonProperty("ibrAskInPayoutCcy")
    private BigDecimal ibrAskInPayoutCcy;
    @JsonProperty("ibrBidInPayoutCcy")
    private BigDecimal ibrBidInPayoutCcy;
    @JsonProperty("ibrAskInSettlementCcy")
    private BigDecimal ibrAskInSettlementCcy;
    @JsonProperty("ibrBidInSettlementCcy")
    private BigDecimal ibrBidInSettlementCcy;
    @JsonProperty("xchgCcyAskMarkupInPayinCcy")
    private BigDecimal xchgCcyAskMarkupInPayinCcy;
    @JsonProperty("xchgCcyBidMarkupInPayinCcy")
    private BigDecimal xchgCcyBidMarkupInPayinCcy;
    @JsonProperty("xchgCcyAskMarkupInPayoutCcy")
    private BigDecimal xchgCcyAskMarkupInPayoutCcy;
    @JsonProperty("xchgCcyBidMarkupInPayoutCcy")
    private BigDecimal xchgCcyBidMarkupInPayoutCcy;
    @JsonProperty("xchgCcyAskMarkupInSettCcy")
    private BigDecimal xchgCcyAskMarkupInSettCcy;
    @JsonProperty("xchgCcyBidMarkupInSettCcy")
    private BigDecimal xchgCcyBidMarkupInSettCcy;
    @JsonProperty("settRates2AgentInPayinCcy")
    private BigDecimal settRates2AgentInPayinCcy;
    @JsonProperty("settRates2AgentInPayoutCcy")
    private BigDecimal settRates2AgentInPayoutCcy;
    @JsonProperty("settRates2AgentInSettCcy")
    private BigDecimal settRates2AgentInSettCcy;
    @JsonProperty("userID")
    private String userID;
    @JsonProperty("gMTDate")
    private String gmTDate;
    @JsonProperty("recordDate")
    private String recordDate;

}
