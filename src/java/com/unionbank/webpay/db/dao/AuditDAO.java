/*\
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unionbank.webpay.db.dao;

/**
 *
 * @author oladapoo
 */


public class AuditDAO implements java.io.Serializable {

    public String getAuditDesc() {
        return auditDesc;
    }

    public void setAuditDesc(String auditDesc) {
        this.auditDesc = auditDesc;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String gettAddress() {
        return tAddress;
    }

    public void settAddress(String tAddress) {
        this.tAddress = tAddress;
    }

    public String gettDepartment() {
        return tDepartment;
    }

    public void settDepartment(String tDepartment) {
        this.tDepartment = tDepartment;
    }

    public String gettDisplayName() {
        return tDisplayName;
    }

    public void settDisplayName(String tDisplayName) {
        this.tDisplayName = tDisplayName;
    }

    public String gettEmployeeId() {
        return tEmployeeId;
    }

    public void settEmployeeId(String tEmployeeId) {
        this.tEmployeeId = tEmployeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public String gettInitial() {
        return tInitial;
    }

    public void settInitial(String tInitial) {
        this.tInitial = tInitial;
    }

    public String gettLastName() {
        return tLastName;
    }

    public void settLastName(String tLastName) {
        this.tLastName = tLastName;
    }

    public String getModileNumber() {
        return modileNumber;
    }

    public void setModileNumber(String modileNumber) {
        this.modileNumber = modileNumber;
    }

    public String gettTelephone() {
        return tTelephone;
    }

    public void settTelephone(String tTelephone) {
        this.tTelephone = tTelephone;
    }

    public String getBranchname() {
        return branchname;
    }

    public void setBranchname(String branchname) {
        this.branchname = branchname;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
   
    private String auditDesc;
    private String userId;
    private String dateTime;
    private String tAddress;
    private String tDepartment;
    private String tDisplayName;
    private String tEmployeeId;
    private String firstName;
    private String gradeLevel;
    private String tInitial;
    private String tLastName;
    private String modileNumber;
    private String tTelephone;
    private String branchname;
    private String branchcode;

    public String getBranchcode() {
        return branchcode;
    }

    public void setBranchcode(String branchcode) {
        this.branchcode = branchcode;
    }
    private String requestId;
    
    
       }
