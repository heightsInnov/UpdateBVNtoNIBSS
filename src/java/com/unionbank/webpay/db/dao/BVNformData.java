/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unionbank.webpay.db.dao;

/**
 *
 * @author aojinadu
 */
public class BVNformData {

    private String PicsPath1="";
	private String PicsPath2="";
	private String PicsPath3="";
    private String mainTxID = "";
    private String displayname = "";
    private String Branch = "";
    private String oldBvNumber = "";
    private String oldFirstName = "";
    private String newFirstName = "";
    private String firstNameComment = "";
    private String oldMiddleName = "";
    private String newMiddleName = "";
    private String MiddleComment = "";
    private String oldLastName = "";
    private String newLastName = "";
    private String LastComment = "";
    private String oldDOBName = "";
    private String newDOBName = "";
    private String DOBComment = "";
    private String oldPhoneNumber = "";
    private String newPhoneNumber = "";
    private String phoneNOComment = "";
    private String oldEmailAdd = "";
    private String newEmailAdd = "";
    private String emailComment = "";
    private String oldStateOfOrigin = "";
    private String newStateOfOrigin = "";
    private String stateOfOriginComment = "";
    private String oldLGA = "";
    private String newLGA = "";
    private String lgaComment = "";
    private String oldMaritalStatus = "";
    private String newMaritalStatus = "";
    private String maritalStatusComment = "";
    private String oldResidentialStatus = "";
    private String newResidentialStatus = "";
    private String residentialStatusComment = "";
    private String oldGender = "";
    private String newGender = "";
    private String commentGender = "";
    private String bankOfEnrollment = "";
    private String branchOfEnrollment = "";
    private String title = "";
    private String newTitle = "";
    private String commentTitle = "";
    private String watchlisted = "";
    private String fFirstName = "";
    private String fMiddleName = "";
    private String fLastName = "";
    private String fDob = "";
    private String fPhoneNumber = "";
    private String fEmail = "";
    private String fStateOrigin = "";
    private String fLga = "";
    private String fMaritalstat = "";
    private String fResidentialadd = "";
    private String fGender = "";
    private String userEmail = "";

    private java.sql.Date oldDateConverted = null;
    private java.sql.Date newDateConverted = null;

    private java.util.Date date1 = null;
    private java.util.Date date2 = null;

    public String getMainTxID() {
        return mainTxID;
    }

    public void setMainTxID(String mainTxID) {
        this.mainTxID = mainTxID;
    }

    public String getDisplayname() {
        return displayname;
    }

    public void setDisplayname(String displayname) {
        this.displayname = displayname;
    }

    public String getBranch() {
        return Branch;
    }

    public void setBranch(String Branch) {
        this.Branch = Branch;
    }

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

    public String getNewFirstName() {
        return newFirstName;
    }

    public void setNewFirstName(String newFirstName) {
        this.newFirstName = newFirstName;
    }

    public String getFirstNameComment() {
        return firstNameComment;
    }

    public void setFirstNameComment(String firstNameComment) {
        this.firstNameComment = firstNameComment;
    }

    public String getOldMiddleName() {
        return oldMiddleName;
    }

    public void setOldMiddleName(String oldMiddleName) {
        this.oldMiddleName = oldMiddleName;
    }

    public String getNewMiddleName() {
        return newMiddleName;
    }

    public void setNewMiddleName(String newMiddleName) {
        this.newMiddleName = newMiddleName;
    }

    public String getMiddleComment() {
        return MiddleComment;
    }

    public void setMiddleComment(String MiddleComment) {
        this.MiddleComment = MiddleComment;
    }

    public String getOldLastName() {
        return oldLastName;
    }

    public void setOldLastName(String oldLastName) {
        this.oldLastName = oldLastName;
    }

    public String getNewLastName() {
        return newLastName;
    }

    public void setNewLastName(String newLastName) {
        this.newLastName = newLastName;
    }

    public String getLastComment() {
        return LastComment;
    }

    public void setLastComment(String LastComment) {
        this.LastComment = LastComment;
    }

    public String getOldDOBName() {
        return oldDOBName;
    }

    public void setOldDOBName(String oldDOBName) {
        this.oldDOBName = oldDOBName;
    }

    public String getNewDOBName() {
        return newDOBName;
    }

    public void setNewDOBName(String newDOBName) {
        this.newDOBName = newDOBName;
    }

    public String getDOBComment() {
        return DOBComment;
    }

    public void setDOBComment(String DOBComment) {
        this.DOBComment = DOBComment;
    }

    public String getOldPhoneNumber() {
        return oldPhoneNumber;
    }

    public void setOldPhoneNumber(String oldPhoneNumber) {
        this.oldPhoneNumber = oldPhoneNumber;
    }

    public String getNewPhoneNumber() {
        return newPhoneNumber;
    }

    public void setNewPhoneNumber(String newPhoneNumber) {
        this.newPhoneNumber = newPhoneNumber;
    }

    public String getPhoneNOComment() {
        return phoneNOComment;
    }

    public void setPhoneNOComment(String phoneNOComment) {
        this.phoneNOComment = phoneNOComment;
    }

    public String getOldEmailAdd() {
        return oldEmailAdd;
    }

    public void setOldEmailAdd(String oldEmailAdd) {
        this.oldEmailAdd = oldEmailAdd;
    }

    public String getNewEmailAdd() {
        return newEmailAdd;
    }

    public void setNewEmailAdd(String newEmailAdd) {
        this.newEmailAdd = newEmailAdd;
    }

    public String getEmailComment() {
        return emailComment;
    }

    public void setEmailComment(String emailComment) {
        this.emailComment = emailComment;
    }

    public String getOldStateOfOrigin() {
        return oldStateOfOrigin;
    }

    public void setOldStateOfOrigin(String oldStateOfOrigin) {
        this.oldStateOfOrigin = oldStateOfOrigin;
    }

    public String getNewStateOfOrigin() {
        return newStateOfOrigin;
    }

    public void setNewStateOfOrigin(String newStateOfOrigin) {
        this.newStateOfOrigin = newStateOfOrigin;
    }

    public String getStateOfOriginComment() {
        return stateOfOriginComment;
    }

    public void setStateOfOriginComment(String stateOfOriginComment) {
        this.stateOfOriginComment = stateOfOriginComment;
    }

    public String getOldLGA() {
        return oldLGA;
    }

    public void setOldLGA(String oldLGA) {
        this.oldLGA = oldLGA;
    }

    public String getNewLGA() {
        return newLGA;
    }

    public void setNewLGA(String newLGA) {
        this.newLGA = newLGA;
    }

    public String getLgaComment() {
        return lgaComment;
    }

    public void setLgaComment(String lgaComment) {
        this.lgaComment = lgaComment;
    }

    public String getOldMaritalStatus() {
        return oldMaritalStatus;
    }

    public void setOldMaritalStatus(String oldMaritalStatus) {
        this.oldMaritalStatus = oldMaritalStatus;
    }

    public String getNewMaritalStatus() {
        return newMaritalStatus;
    }

    public void setNewMaritalStatus(String newMaritalStatus) {
        this.newMaritalStatus = newMaritalStatus;
    }

    public String getMaritalStatusComment() {
        return maritalStatusComment;
    }

    public void setMaritalStatusComment(String maritalStatusComment) {
        this.maritalStatusComment = maritalStatusComment;
    }

    public String getOldResidentialStatus() {
        return oldResidentialStatus;
    }

    public void setOldResidentialStatus(String oldResidentialStatus) {
        this.oldResidentialStatus = oldResidentialStatus;
    }

    public String getNewResidentialStatus() {
        return newResidentialStatus;
    }

    public void setNewResidentialStatus(String newResidentialStatus) {
        this.newResidentialStatus = newResidentialStatus;
    }

    public String getResidentialStatusComment() {
        return residentialStatusComment;
    }

    public void setResidentialStatusComment(String residentialStatusComment) {
        this.residentialStatusComment = residentialStatusComment;
    }

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

    public String getBankOfEnrollment() {
        return bankOfEnrollment;
    }

    public void setBankOfEnrollment(String bankOfEnrollment) {
        this.bankOfEnrollment = bankOfEnrollment;
    }

    public String getBranchOfEnrollment() {
        return branchOfEnrollment;
    }

    public void setBranchOfEnrollment(String branchOfEnrollment) {
        this.branchOfEnrollment = branchOfEnrollment;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }

    public String getCommentTitle() {
        return commentTitle;
    }

    public void setCommentTitle(String commentTitle) {
        this.commentTitle = commentTitle;
    }

    public String getWatchlisted() {
        return watchlisted;
    }

    public void setWatchlisted(String watchlisted) {
        this.watchlisted = watchlisted;
    }

    public String getfFirstName() {
        return fFirstName;
    }

    public void setfFirstName(String fFirstName) {
        this.fFirstName = fFirstName;
    }

    public String getfMiddleName() {
        return fMiddleName;
    }

    public void setfMiddleName(String fMiddleName) {
        this.fMiddleName = fMiddleName;
    }

    public String getfLastName() {
        return fLastName;
    }

    public void setfLastName(String fLastName) {
        this.fLastName = fLastName;
    }

    public String getfDob() {
        return fDob;
    }

    public void setfDob(String fDob) {
        this.fDob = fDob;
    }

    public String getfPhoneNumber() {
        return fPhoneNumber;
    }

    public void setfPhoneNumber(String fPhoneNumber) {
        this.fPhoneNumber = fPhoneNumber;
    }

    public String getfEmail() {
        return fEmail;
    }

    public void setfEmail(String fEmail) {
        this.fEmail = fEmail;
    }

    public String getfStateOrigin() {
        return fStateOrigin;
    }

    public void setfStateOrigin(String fStateOrigin) {
        this.fStateOrigin = fStateOrigin;
    }

    public String getfLga() {
        return fLga;
    }

    public void setfLga(String fLga) {
        this.fLga = fLga;
    }

    public String getfMaritalstat() {
        return fMaritalstat;
    }

    public void setfMaritalstat(String fMaritalstat) {
        this.fMaritalstat = fMaritalstat;
    }

    public String getfResidentialadd() {
        return fResidentialadd;
    }

    public void setfResidentialadd(String fResidentialadd) {
        this.fResidentialadd = fResidentialadd;
    }

    public String getfGender() {
        return fGender;
    }

    public void setfGender(String fGender) {
        this.fGender = fGender;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public java.sql.Date getOldDateConverted() {
        return oldDateConverted;
    }

    public void setOldDateConverted(java.sql.Date oldDateConverted) {
        this.oldDateConverted = oldDateConverted;
    }

    public java.sql.Date getNewDateConverted() {
        return newDateConverted;
    }

    public void setNewDateConverted(java.sql.Date newDateConverted) {
        this.newDateConverted = newDateConverted;
    }

    public java.util.Date getDate1() {
        return date1;
    }

    public void setDate1(java.util.Date date1) {
        this.date1 = date1;
    }

    public java.util.Date getDate2() {
        return date2;
    }

    public void setDate2(java.util.Date date2) {
        this.date2 = date2;
    }

    public String getPicsPath1() {
        return PicsPath1;
    }

    public void setPicsPath1(String PicsPath1) {
        this.PicsPath1 = PicsPath1;
    }

	public String getPicsPath2() {
		return PicsPath2;
	}

	public void setPicsPath2(String PicsPath2) {
		this.PicsPath2 = PicsPath2;
	}

	public String getPicsPath3() {
		return PicsPath3;
	}

	public void setPicsPath3(String PicsPath3) {
		this.PicsPath3 = PicsPath3;
	}

}
