/*\
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unionbank.webpay.db.dao;

import java.util.List;

/**
 *
 * @author oladapoo
 */
public class fileUploadData implements java.io.Serializable {

    private String field;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getUrlID() {
        return urlID;
    }

    public void setUrlID(String urlID) {
        this.urlID = urlID;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
    private String urlID;
    private String requestId;
    

}
