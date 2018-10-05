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
public class CustomerData implements java.io.Serializable {

    private String Field;
    private String NIBSS;
    private String FCUBS;
    private String Modification;
    private String OldValue;
    private String FValue;
    private String NewValue;
    private String Comment;
    private String Fileupload;
    private Byte[] Imageupload;

    public String getNIBSS() {
        return NIBSS;
    }

    public void setNIBSS(String NIBSS) {
        this.NIBSS = NIBSS;
    }

    public String getFCUBS() {
        return FCUBS;
    }

    public void setFCUBS(String FCUBS) {
        this.FCUBS = FCUBS;
    }

    public String getModification() {
        return Modification;
    }

    public void setModification(String Modification) {
        this.Modification = Modification;
    }
   
    public String getFValue() {
        return FValue;
    }

    public void setFValue(String FValue) {
        this.FValue = FValue;
    }   
    

    public Byte[] getImageupload() {
        return Imageupload;
    }

    public void setImageupload(Byte[] Imageupload) {
        this.Imageupload = Imageupload;
    }
   
    public String getField() {
        return Field;
    }

    public void setField(String Field) {
        this.Field = Field;
    }

    public String getOldValue() {
        return OldValue;
    }

    public void setOldValue(String OldValue) {
        this.OldValue = OldValue;
    }

    public String getNewValue() {
        return NewValue;
    }

    public void setNewValue(String NewValue) {
        this.NewValue = NewValue;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String Comment) {
        this.Comment = Comment;
    }

    public String getFileupload() {
        return Fileupload;
    }

    public void setFileupload(String Fileupload) {
        this.Fileupload = Fileupload;
    }
    
    
    private List<CustomerData> compemployes;
   

    @Override
	public String toString() {
	   return "CustomerData [Field=" + Field + ", OldValue=" + OldValue + ", NewValue="
		+ NewValue + ", Comment=" + Comment + ", Fileupload=" + Fileupload + "]";
	}

    public List<CustomerData> getCompemployes() {
        return compemployes;
    }

    public void setCompemployes(List<CustomerData> compemployes) {
        this.compemployes = compemployes;
    }
}
