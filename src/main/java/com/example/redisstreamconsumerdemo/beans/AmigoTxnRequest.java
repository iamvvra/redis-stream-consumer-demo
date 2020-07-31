package com.example.redisstreamconsumerdemo.beans;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "eventType", "source", "txnDetails", "txnStatusObj", "txnReqVerifyObj" })
@NoArgsConstructor
@Data
@ToString
public class AmigoTxnRequest implements Serializable {

    /**
    * 
    */
    private static final long serialVersionUID = -4067911090361982792L;

    @JsonProperty("eventType")
    private String eventType;

    @JsonProperty("source")
    private String source;

    @JsonProperty("txnDetails")
    private TxnDetails txnDetails;

    @JsonProperty("txnStatusObj")
    private TxnStatusObj txnStatusObj;

    @JsonProperty("txnReqVerifyObj")
    private TxnReqVerifyObj txnReqVerifyObj;

    @JsonProperty("cancelTxnObj")
    private CancelTxnObj cancelTxnObj;

}