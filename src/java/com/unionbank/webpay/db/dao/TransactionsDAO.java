package com.unionbank.webpay.db.dao;

import java.io.Serializable;

public class TransactionsDAO
  implements Serializable
{
  private String requestID;
  private String responseCode;
  private String oldGender;
  private String newGender;
  private String commentGender;
  private String fGender;
  private String rejectComment;
  private String maker;
  private String checker;
  private String approvedate;
  private String oldBvNumber;
  private String oldBankEnrollment;
  private String oldBranchEnrollment;
  private String oldStateOfOrigin;
  private String oldLGA;
  private String oldMaritalStatus;
  private String oldResidentialStatus;
  private String oldFirstName;
  private String oldMiddleName;
  private String oldLastName;
  private String oldDateOfBirth;
  private String oldPhoneNumber;
  private String oldEmailAdd;
  private String newBvNumber;
  private String newStateOfOrigin;
  private String newLGA;
  private String newMaritalStatus;
  private String newResidentialStatus;
  private String newFirstName;
  private String newMiddleName;
  private String newLastName;
  private String newDateOfBirth;
  private String newPhoneNumber;
  private String newEmailAdd;
  private String bvNumber;
  private String approvalStatus;
  private String recieveDate;
  private String firstNameComment;
  private String middleNameComment;
  private String lastNameComment;
  private String dobComment;
  private String phoneNoComment;
  private String emailComment;
  private String stateOfOriginComment;
  private String lgaComment;
  private String maritalStatusComment;
  private String residentialStatusComment;
  private String fFirstName;
  private String fMiddleName;
  private String fLastName;
  private String fDoB;
  private String fStateOfOrigin;
  private String fSex;
  private String fResidentAddress;
  private String fEmailAdd;
  private String fMaritalStatus;
  private String fMobileNumber;
  private String fLga;
  private byte[] image;
  private String makerEmailAdd;
  private String checkerEmailAdd;
  private String bankEnroll;
  private String branchEnroll;
  private String fileAddress;
  private String fileAddress2;
  private String fileAddress3;

    public String getFileAddress() {
        return fileAddress;
    }

    public void setFileAddress(String fileAddress) {
        this.fileAddress = fileAddress;
    }
  
  private String title;
  private String newTitle;
  private String commentTitle;
  private String watchlisted;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWatchlisted() {
        return watchlisted;
    }

    public void setWatchlisted(String watchlisted) {
        this.watchlisted = watchlisted;
    }
  
  

    public String getBankEnroll() {
        return bankEnroll;
    }

    public void setBankEnroll(String bankEnroll) {
        this.bankEnroll = bankEnroll;
    }

    public String getBranchEnroll() {
        return branchEnroll;
    }

    public void setBranchEnroll(String branchEnroll) {
        this.branchEnroll = branchEnroll;
    }
  
    public String getMakerEmailAdd() {
        return makerEmailAdd;
    }

    public void setMakerEmailAdd(String makerEmailAdd) {
        this.makerEmailAdd = makerEmailAdd;
    }

    public String getCheckerEmailAdd() {
        return checkerEmailAdd;
    }

    public void setCheckerEmailAdd(String checkerEmailAdd) {
        this.checkerEmailAdd = checkerEmailAdd;
    }
  
    public String getOldBankEnrollment() {
        return oldBankEnrollment;
    }

    public void setOldBankEnrollment(String oldBankEnrollment) {
        this.oldBankEnrollment = oldBankEnrollment;
    }

    public String getOldBranchEnrollment() {
        return oldBranchEnrollment;
    }

    public void setOldBranchEnrollment(String oldBranchEnrollment) {
        this.oldBranchEnrollment = oldBranchEnrollment;
    }
  
    public String getfLga() {
        return fLga;
    }

    public void setfLga(String fLga) {
        this.fLga = fLga;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
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

    public String getfDoB() {
        return fDoB;
    }

    public void setfDoB(String fDoB) {
        this.fDoB = fDoB;
    }

    public String getfStateOfOrigin() {
        return fStateOfOrigin;
    }

    public void setfStateOfOrigin(String fStateOfOrigin) {
        this.fStateOfOrigin = fStateOfOrigin;
    }

    public String getfSex() {
        return fSex;
    }

    public void setfSex(String fSex) {
        this.fSex = fSex;
    }

    public String getfResidentAddress() {
        return fResidentAddress;
    }

    public void setfResidentAddress(String fResidentAddress) {
        this.fResidentAddress = fResidentAddress;
    }

    public String getfEmailAdd() {
        return fEmailAdd;
    }

    public void setfEmailAdd(String fEmailAdd) {
        this.fEmailAdd = fEmailAdd;
    }

    public String getfMaritalStatus() {
        return fMaritalStatus;
    }

    public void setfMaritalStatus(String fMaritalStatus) {
        this.fMaritalStatus = fMaritalStatus;
    }

    public String getfMobileNumber() {
        return fMobileNumber;
    }

    public void setfMobileNumber(String fMobileNumber) {
        this.fMobileNumber = fMobileNumber;
    }
 
    public String getOldStateOfOrigin() {
        return oldStateOfOrigin;
    }

    public void setOldStateOfOrigin(String oldStateOfOrigin) {
        this.oldStateOfOrigin = oldStateOfOrigin;
    }

    public String getOldLGA() {
        return oldLGA;
    }

    public void setOldLGA(String oldLGA) {
        this.oldLGA = oldLGA;
    }

    public String getOldMaritalStatus() {
        return oldMaritalStatus;
    }

    public void setOldMaritalStatus(String oldMaritalStatus) {
        this.oldMaritalStatus = oldMaritalStatus;
    }

    public String getOldResidentialStatus() {
        return oldResidentialStatus;
    }

    public void setOldResidentialStatus(String oldResidentialStatus) {
        this.oldResidentialStatus = oldResidentialStatus;
    }

    public String getNewStateOfOrigin() {
        return newStateOfOrigin;
    }

    public void setNewStateOfOrigin(String newStateOfOrigin) {
        this.newStateOfOrigin = newStateOfOrigin;
    }

    public String getNewLGA() {
        return newLGA;
    }

    public void setNewLGA(String newLGA) {
        this.newLGA = newLGA;
    }

    public String getNewMaritalStatus() {
        return newMaritalStatus;
    }

    public void setNewMaritalStatus(String newMaritalStatus) {
        this.newMaritalStatus = newMaritalStatus;
    }

    public String getNewResidentialStatus() {
        return newResidentialStatus;
    }

    public void setNewResidentialStatus(String newResidentialStatus) {
        this.newResidentialStatus = newResidentialStatus;
    }

    public String getStateOfOriginComment() {
        return stateOfOriginComment;
    }

    public void setStateOfOriginComment(String stateOfOriginComment) {
        this.stateOfOriginComment = stateOfOriginComment;
    }

    public String getLgaComment() {
        return lgaComment;
    }

    public void setLgaComment(String lgaComment) {
        this.lgaComment = lgaComment;
    }

    public String getMaritalStatusComment() {
        return maritalStatusComment;
    }

    public void setMaritalStatusComment(String maritalStatusComment) {
        this.maritalStatusComment = maritalStatusComment;
    }

    public String getResidentialStatusComment() {
        return residentialStatusComment;
    }

    public void setResidentialStatusComment(String residentialStatusComment) {
        this.residentialStatusComment = residentialStatusComment;
    }

  public String getRejectComment()
  {
    return rejectComment;
  }
  
  public void setRejectComment(String rejectComment)
  {
    this.rejectComment = rejectComment;
  }
  
  public String getOldGender()
  {
    return oldGender;
  }
  
  public void setOldGender(String oldGender)
  {
    this.oldGender = oldGender;
  }
  
  public String getNewGender()
  {
    return newGender;
  }
  
  public void setNewGender(String newGender)
  {
    this.newGender = newGender;
  }
  
  public String getCommentGender()
  {
    return commentGender;
  }
  
  public void setCommentGender(String commentGender)
  {
    this.commentGender = commentGender;
  }
  
  public String getMaker()
  {
    return maker;
  }
  
  public void setMaker(String maker)
  {
    this.maker = maker;
  }
  
  public String getChecker()
  {
    return checker;
  }
  
  public void setChecker(String checker)
  {
    this.checker = checker;
  }
  
  public String getResponseCode()
  {
    return responseCode;
  }
  
  public void setResponseCode(String responseCode)
  {
    this.responseCode = responseCode;
  }
  
  public String getRequestID()
  {
    return requestID;
  }
  
  public void setRequestID(String requestID)
  {
    this.requestID = requestID;
  }
  
  public String getApprovedate()
  {
    return approvedate;
  }
  
  public void setApprovedate(String approvedate)
  {
    this.approvedate = approvedate;
  }
  
  public String getBvNumber()
  {
    return bvNumber;
  }
  
  public String getRecieveDate()
  {
    return recieveDate;
  }
  
  public void setRecieveDate(String recieveDate)
  {
    this.recieveDate = recieveDate;
  }
  
  public void setBvNumber(String bvNumber)
  {
    this.bvNumber = bvNumber;
  }
  
  public String getApprovalStatus()
  {
    return approvalStatus;
  }
  
  public void setApprovalStatus(String approvalStatus)
  {
    this.approvalStatus = approvalStatus;
  }
  
  public String getFirstNameComment()
  {
    return firstNameComment;
  }
  
  public void setFirstNameComment(String firstNameComment)
  {
    this.firstNameComment = firstNameComment;
  }
  
  public String getMiddleNameComment()
  {
    return middleNameComment;
  }
  
  public void setMiddleNameComment(String middleNameComment)
  {
    this.middleNameComment = middleNameComment;
  }
  
  public String getLastNameComment()
  {
    return lastNameComment;
  }
  
  public void setLastNameComment(String lastNameComment)
  {
    this.lastNameComment = lastNameComment;
  }
  
  public String getDobComment()
  {
    return dobComment;
  }
  
  public void setDobComment(String dobComment)
  {
    this.dobComment = dobComment;
  }
  
  public String getPhoneNoComment()
  {
    return phoneNoComment;
  }
  
  public void setPhoneNoComment(String phoneNoComment)
  {
    this.phoneNoComment = phoneNoComment;
  }
  
  public String getEmailComment()
  {
    return emailComment;
  }
  
  public void setEmailComment(String emailComment)
  {
    this.emailComment = emailComment;
  }
  
  public String getOldBvNumber()
  {
    return oldBvNumber;
  }
  
  public void setOldBvNumber(String oldBvNumber)
  {
    this.oldBvNumber = oldBvNumber;
  }
  
  public String getOldFirstName()
  {
    return oldFirstName;
  }
  
  public void setOldFirstName(String oldFirstName)
  {
    this.oldFirstName = oldFirstName;
  }
  
  public String getOldMiddleName()
  {
    return oldMiddleName;
  }
  
  public void setOldMiddleName(String oldMiddleName)
  {
    this.oldMiddleName = oldMiddleName;
  }
  
  public String getOldLastName()
  {
    return oldLastName;
  }
  
  public void setOldLastName(String oldLastName)
  {
    this.oldLastName = oldLastName;
  }
  
  public String getOldDateOfBirth()
  {
    return oldDateOfBirth;
  }
  
  public void setOldDateOfBirth(String oldDateOfBirth)
  {
    this.oldDateOfBirth = oldDateOfBirth;
  }
  
  public String getOldPhoneNumber()
  {
    return oldPhoneNumber;
  }
  
  public void setOldPhoneNumber(String oldPhoneNumber)
  {
    this.oldPhoneNumber = oldPhoneNumber;
  }
  
  public String getOldEmailAdd()
  {
    return oldEmailAdd;
  }
  
  public void setOldEmailAdd(String oldEmailAdd)
  {
    this.oldEmailAdd = oldEmailAdd;
  }
  
  public String getNewBvNumber()
  {
    return newBvNumber;
  }
  
  public void setNewBvNumber(String newBvNumber)
  {
    this.newBvNumber = newBvNumber;
  }
  
  public String getNewFirstName()
  {
    return newFirstName;
  }
  
  public void setNewFirstName(String newFirstName)
  {
    this.newFirstName = newFirstName;
  }
  
  public String getNewMiddleName()
  {
    return newMiddleName;
  }
  
  public void setNewMiddleName(String newMiddleName)
  {
    this.newMiddleName = newMiddleName;
  }
  
  public String getNewLastName()
  {
    return newLastName;
  }
  
  public void setNewLastName(String newLastName)
  {
    this.newLastName = newLastName;
  }
  
  public String getNewDateOfBirth()
  {
    return newDateOfBirth;
  }
  
  public void setNewDateOfBirth(String newDateOfBirth)
  {
    this.newDateOfBirth = newDateOfBirth;
  }
  
  public String getNewPhoneNumber()
  {
    return newPhoneNumber;
  }
  
  public void setNewPhoneNumber(String newPhoneNumber)
  {
    this.newPhoneNumber = newPhoneNumber;
  }
  
  public String getNewEmailAdd()
  {
    return newEmailAdd;
  }
  
  public void setNewEmailAdd(String newEmailAdd)
  {
    this.newEmailAdd = newEmailAdd;
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

	public String getFileAddress2() {
		return fileAddress2;
	}

	public void setFileAddress2(String fileAddress2) {
		this.fileAddress2 = fileAddress2;
	}

	public String getFileAddress3() {
		return fileAddress3;
	}

	public void setFileAddress3(String fileAddress3) {
		this.fileAddress3 = fileAddress3;
	}

	public String getfGender() {
		return fGender;
	}

	public void setfGender(String fGender) {
		this.fGender = fGender;
	}
}
