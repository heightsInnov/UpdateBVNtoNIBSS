/*\
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unionbank.webpay.db.dao;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author oladapoo
 */
/*<TransactionQueryResponse xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema">
 <ResponseCode>00</ResponseCode>
 <ResponseDescription>Approved Successful</ResponseDescription>
 <Amount>5000</Amount>
 <CardNumber>0095</CardNumber>
 <MerchantReference>UBN/20150715172758</MerchantReference>
 <PaymentReference>FBN|WEB|WEBP|15-07-2015|132132</PaymentReference>
 <RetrievalReferenceNumber>000000076416</RetrievalReferenceNumber>
 <SplitAccounts />
 <TransactionDate>2015-07-15T17:31:14.987</TransactionDate>
 </TransactionQueryResponse>*/
public class TransactionQueryResponse implements java.io.Serializable {

    private String ResponseCode;
    private String ResponseDescription;
    private String Amount;
    private String CardNumber;
    private String MerchantReference;
    private String RetrievalReferenceNumber;
    private String TransactionDate;

    public String getPaymentReference() {
        return PaymentReference;
    }

    public void setPaymentReference(String PaymentReference) {
        this.PaymentReference = PaymentReference;
    }
    private String PaymentReference;
    
    public String getResponseCode() {
        return ResponseCode;
    }

    public void setResponseCode(String ResponseCode) {
        this.ResponseCode = ResponseCode;
    }

    public String getResponseDescription() {
        return ResponseDescription;
    }

    public void setResponseDescription(String ResponseDescription) {
        this.ResponseDescription = ResponseDescription;
    }

    public String getAmount() {
        return Amount;
    }

    public void setAmount(String Amount) {
        this.Amount = Amount;
    }

    public String getCardNumber() {
        return CardNumber;
    }

    public void setCardNumber(String CardNumber) {
        this.CardNumber = CardNumber;
    }

    public String getMerchantReference() {
        return MerchantReference;
    }

    public void setMerchantReference(String MerchantReference) {
        this.MerchantReference = MerchantReference;
    }

    public String getRetrievalReferenceNumber() {
        return RetrievalReferenceNumber;
    }

    public void setRetrievalReferenceNumber(String RetrievalReferenceNumber) {
        this.RetrievalReferenceNumber = RetrievalReferenceNumber;
    }

    public String getTransactionDate() {
        return TransactionDate;
    }

    public void setTransactionDate(String TransactionDate) {
        this.TransactionDate = TransactionDate;
    }
}
