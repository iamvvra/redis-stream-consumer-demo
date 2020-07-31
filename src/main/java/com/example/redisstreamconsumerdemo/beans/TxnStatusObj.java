package com.example.redisstreamconsumerdemo.beans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "txnRefNo", "stageNo", "instrumentType", "serialNo", "instrumentNo", "instrumentStatus",
        "statusType", "statusInfo", "sendingAgentCode", "serviceProviderCode", "xRAgentStatus", "xRAgentStatus2",
        "userID", "recordDate", "txnGMTDate", })
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TxnStatusObj implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("txnRefNo")
    private String txnRefNo;
    @JsonProperty("instrumentType")
    private String instrumentType;
    @JsonProperty("serialNo")
    private int serialNo;
    @JsonProperty("instrumentNo")
    private String instrumentNo;
    @JsonProperty("instrumentStatus")
    private int instrumentStatus;
    @JsonProperty("statusType")
    private int statusType;
    @JsonProperty("statusInfo")
    private String statusInfo;
    @JsonProperty("sendingAgentCode")
    private String sendingAgentCode;
    @JsonProperty("serviceProviderCode")
    private String serviceProviderCode;
    @JsonProperty("xrAgentStatus")
    private int xrAgentStatus;
    @JsonProperty("xrAgentStatus2")
    private int xrAgentStatus2;
    @JsonProperty("userID")
    private String userID;
    @JsonProperty("recordDate")
    private String recordDate;
    @JsonProperty("txnGMTDate")
    private String txnGMTDate;

}
