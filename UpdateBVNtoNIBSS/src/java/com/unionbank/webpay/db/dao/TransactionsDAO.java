/*\
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unionbank.webpay.db.dao;

/**
 *
 * @author oladapoo
 */
public class TransactionsDAO implements java.io.Serializable {
    private String requestID;
     private String responseCode;

     private String oldGender;
     private String newGender;
     private String commentGender;

    public String getOldGender() {
        return oldGender;
    }

    public void setOldGender(String oldGender) {
        this.oldGender = oldGender;
    }

    public String getNewGender() {
        return newGender;
    }

    public void setNewGender(String newGender) {
        this.newGender = newGender;
    }

    public String getCommentGender() {
        return commentGender;
    }

    public void setCommentGender(String commentGender) {
        this.commentGender = commentGender;
    }
     private String maker;

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker;
    }
     private String checker;
    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public String getApprovedate() {
        return approvedate;
    }

    public void setApprovedate(String approvedate) {
        this.approvedate = approvedate;
    }
    private String approvedate;
    
    private String oldBvNumber;
    private String oldFirstName;
    private String oldMiddleName;
    private String oldLastName;
    private String oldDateOfBirth;
    private String oldPhoneNumber;
    private String oldEmailAdd;    
    private String newBvNumber;
    private String newFirstName;
     private String newMiddleName;
    private String newLastName;
    private String newDateOfBirth;
    private String newPhoneNumber;
    private String newEmailAdd;
    
    private String bvNumber;
    private String approvalStatus;    
private String recieveDate;;   
    public String getBvNumber() {
        return bvNumber;
    }

    public String getRecieveDate() {
        return recieveDate;
    }

    public void setRecieveDate(String recieveDate) {
        this.recieveDate = recieveDate;
    }

    public void setBvNumber(String bvNumber) {
        this.bvNumber = bvNumber;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getFirstNameComment() {
        return firstNameComment;
    }

    public void setFirstNameComment(String firstNameComment) {
        this.firstNameComment = firstNameComment;
    }

    public String getMiddleNameComment() {
        return middleNameComment;
    }

    public void setMiddleNameComment(String middleNameComment) {
        this.middleNameComment = middleNameComment;
    }

    public String getLastNameComment() {
        return lastNameComment;
    }

    public void setLastNameComment(String lastNameComment) {
        this.lastNameComment = lastNameComment;
    }

    public String getDobComment() {
        return dobComment;
    }

    public void setDobComment(String dobComment) {
        this.dobComment = dobComment;
    }

    public String getPhoneNoComment() {
        return phoneNoComment;
    }

    public void setPhoneNoComment(String phoneNoComment) {
        this.phoneNoComment = phoneNoComment;
    }

    public String getEmailComment() {
        return emailComment;
    }

    public void setEmailComment(String emailComment) {
        this.emailComment = emailComment;
    }
    private String firstNameComment;
    private String middleNameComment;
    private String lastNameComment;
    private String dobComment;
    private String phoneNoComment;
    private String emailComment;
       
    public String getOldBvNumber() {
        return oldBvNumber;
    }

    public void setOldBvNumber(String oldBvNumber) {
        this.oldBvNumber = oldBvNumber;
    }

    public String getOldFirstName() {
        return oldFirstName;
    }

    public void setOldFirstName(String oldFirstName) {
        this.oldFirstName = oldFirstName;
    }

    public String getOldMiddleName() {
        return oldMiddleName;
    }

    public void setOldMiddleName(String oldMiddleName) {
        this.oldMiddleName = oldMiddleName;
    }

    public String getOldLastName() {
        return oldLastName;
    }

    public void setOldLastName(String oldLastName) {
        this.oldLastName = oldLastName;
    }

    public String getOldDateOfBirth() {
        return oldDateOfBirth;
    }

    public void setOldDateOfBirth(String oldDateOfBirth) {
        this.oldDateOfBirth = oldDateOfBirth;
    }

    public String getOldPhoneNumber() {
        return oldPhoneNumber;
    }

    public void setOldPhoneNumber(String oldPhoneNumber) {
        this.oldPhoneNumber = oldPhoneNumber;
    }

    public String getOldEmailAdd() {
        return oldEmailAdd;
    }

    public void setOldEmailAdd(String oldEmailAdd) {
        this.oldEmailAdd = oldEmailAdd;
    }

    public String getNewBvNumber() {
        return newBvNumber;
    }

    public void setNewBvNumber(String newBvNumber) {
        this.newBvNumber = newBvNumber;
    }

    public String getNewFirstName() {
        return newFirstName;
    }

    public void setNewFirstName(String newFirstName) {
        this.newFirstName = newFirstName;
    }

    public String getNewMiddleName() {
        return newMiddleName;
    }

    public void setNewMiddleName(String newMiddleName) {
        this.newMiddleName = newMiddleName;
    }

    public String getNewLastName() {
        return newLastName;
    }

    public void setNewLastName(String newLastName) {
        this.newLastName = newLastName;
    }

    public String getNewDateOfBirth() {
        return newDateOfBirth;
    }

    public void setNewDateOfBirth(String newDateOfBirth) {
        this.newDateOfBirth = newDateOfBirth;
    }

    public String getNewPhoneNumber() {
        return newPhoneNumber;
    }

    public void setNewPhoneNumber(String newPhoneNumber) {
        this.newPhoneNumber = newPhoneNumber;
    }

    public String getNewEmailAdd() {
        return newEmailAdd;
    }

    public void setNewEmailAdd(String newEmailAdd) {
        this.newEmailAdd = newEmailAdd;
    }
   
    }
