/*\
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unionbank.webpay.db.dao;

import java.util.Date;

/**
 *
 * @author oladapoo
 */
public class vwTransactionsDAO implements java.io.Serializable {

    private long txnId;
    private String merchantName;
    private String txnRef;
    private String payRef;
    private Date dateCreated;
    private String responseDesc;
    private String responseCode;
    private Date ResponseUpdateDate;
   private String amountLc;

    public String getAmountLc() {
        return amountLc;
    }

    public void setAmountLc(String amountLc) {
        this.amountLc = amountLc;
    }
    public long getTxnId() {
        return txnId;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public void setTxnId(long txnId) {
        this.txnId = txnId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getTxnRef() {
        return txnRef;
    }

    public void setTxnRef(String txnRef) {
        this.txnRef = txnRef;
    }

    public String getPayRef() {
        return payRef;
    }

    public void setPayRef(String payRef) {
        this.payRef = payRef;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getResponseDesc() {
        return responseDesc;
    }

    public void setResponseDesc(String responseDesc) {
        this.responseDesc = responseDesc;
    }

    public Date getResponseUpdateDate() {
        return ResponseUpdateDate;
    }

    public void setResponseUpdateDate(Date ResponseUpdateDate) {
        this.ResponseUpdateDate = ResponseUpdateDate;
    }

               
}
