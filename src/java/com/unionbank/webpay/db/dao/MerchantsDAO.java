/*
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
public class MerchantsDAO implements java.io.Serializable {

    public MerchantsDAO() {
        super();
    }
    private long merchantID;
    private String merchantName;
    private String siteRedirectUrl;
    private Date dateCreated;
    private String authFlag;
    private String disableFlag;
    private String payItemId;
    private String macKey;

    public String getMerchantName() {
        return merchantName;
    }

    public long getMerchantID() {
        return merchantID;
    }

    public void setMerchantID(long merchantID) {
        this.merchantID = merchantID;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getSiteRedirectUrl() {
        return siteRedirectUrl;
    }

    public void setSiteRedirectUrl(String siteRedirectUrl) {
        this.siteRedirectUrl = siteRedirectUrl;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getAuthFlag() {
        return authFlag;
    }

    public void setAuthFlag(String authFlag) {
        this.authFlag = authFlag;
    }

    public String getDisableFlag() {
        return disableFlag;
    }

    public void setDisableFlag(String disableFlag) {
        this.disableFlag = disableFlag;
    }

    public String getPayItemId() {
        return payItemId;
    }

    public void setPayItemId(String payItemId) {
        this.payItemId = payItemId;
    }

    public String getMacKey() {
        return macKey;
    }

    public void setMacKey(String macKey) {
        this.macKey = macKey;
    }
}
