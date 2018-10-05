
package com.unionbank.ADService;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.unionbank.ADService package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Response_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "Response");
    private final static QName _UserProfile_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "UserProfile");
    private final static QName _CustomProfile_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "CustomProfile");
    private final static QName _ArrayOfUserProfile_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "ArrayOfUserProfile");
    private final static QName _ArrayOfUserRoleEventStatus_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "ArrayOfUserRoleEventStatus");
    private final static QName _UserRoleEventStatus_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "UserRoleEventStatus");
    private final static QName _ArrayOfstring_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "ArrayOfstring");
    private final static QName _Module_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.AuthenticationViaAD.Cls", "Module");
    private final static QName _ArrayOfModule_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.AuthenticationViaAD.Cls", "ArrayOfModule");
    private final static QName _BranchReportLine_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.AuthenticationViaAD.Cls", "BranchReportLine");
    private final static QName _ModuleMin_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.AuthenticationViaAD.Cls", "ModuleMin");
    private final static QName _AnyType_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyType");
    private final static QName _AnyURI_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyURI");
    private final static QName _Base64Binary_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "base64Binary");
    private final static QName _Boolean_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "boolean");
    private final static QName _Byte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "byte");
    private final static QName _DateTime_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "dateTime");
    private final static QName _Decimal_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "decimal");
    private final static QName _Double_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "double");
    private final static QName _Float_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "float");
    private final static QName _Int_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "int");
    private final static QName _Long_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "long");
    private final static QName _QName_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "QName");
    private final static QName _Short_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "short");
    private final static QName _String_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "string");
    private final static QName _UnsignedByte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedByte");
    private final static QName _UnsignedInt_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedInt");
    private final static QName _UnsignedLong_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedLong");
    private final static QName _UnsignedShort_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedShort");
    private final static QName _Char_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "char");
    private final static QName _Duration_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "duration");
    private final static QName _Guid_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "guid");
    private final static QName _AdAuthenticateUser_QNAME = new QName("http://applications.unionbankng.com/ws", "User");
    private final static QName _AdAuthenticatePassword_QNAME = new QName("http://applications.unionbankng.com/ws", "Password");
    private final static QName _AdAuthenticateModuleId_QNAME = new QName("http://applications.unionbankng.com/ws", "ModuleId");
    private final static QName _Ad2XAuthenticateToken_QNAME = new QName("http://applications.unionbankng.com/ws", "Token");
    private final static QName _Ad2XAuthenticateResponseAd2XAuthenticateResult_QNAME = new QName("http://applications.unionbankng.com/ws", "Ad2xAuthenticateResult");
    private final static QName _TwoXtorAuthResponseTwoXtorAuthResult_QNAME = new QName("http://applications.unionbankng.com/ws", "TwoXtorAuthResult");
    private final static QName _GenerateTwoXtorOtpResponseGenerateTwoXtorOtpResult_QNAME = new QName("http://applications.unionbankng.com/ws", "GenerateTwoXtorOtpResult");
    private final static QName _GetTwoXtorUserProfileResponseGetTwoXtorUserProfileResult_QNAME = new QName("http://applications.unionbankng.com/ws", "GetTwoXtorUserProfileResult");
    private final static QName _IsUserInRoleRole_QNAME = new QName("http://applications.unionbankng.com/ws", "Role");
    private final static QName _GetRolesForUserResponseGetRolesForUserResult_QNAME = new QName("http://applications.unionbankng.com/ws", "GetRolesForUserResult");
    private final static QName _GetAdRolesForUserResponseGetAdRolesForUserResult_QNAME = new QName("http://applications.unionbankng.com/ws", "GetAdRolesForUserResult");
    private final static QName _GetCbaRolesForUserResponseGetCbaRolesForUserResult_QNAME = new QName("http://applications.unionbankng.com/ws", "GetCbaRolesForUserResult");
    private final static QName _GetUsersInRoleResponseGetUsersInRoleResult_QNAME = new QName("http://applications.unionbankng.com/ws", "GetUsersInRoleResult");
    private final static QName _AddUserToRoleMaker_QNAME = new QName("http://applications.unionbankng.com/ws", "Maker");
    private final static QName _AddUserToRoleChecker_QNAME = new QName("http://applications.unionbankng.com/ws", "Checker");
    private final static QName _AuthorizeUserRoleResponseAuthorizeUserRoleResult_QNAME = new QName("http://applications.unionbankng.com/ws", "AuthorizeUserRoleResult");
    private final static QName _GetUserProfileResponseGetUserProfileResult_QNAME = new QName("http://applications.unionbankng.com/ws", "GetUserProfileResult");
    private final static QName _SearchUserProfileQ_QNAME = new QName("http://applications.unionbankng.com/ws", "q");
    private final static QName _SearchUserProfileResponseSearchUserProfileResult_QNAME = new QName("http://applications.unionbankng.com/ws", "SearchUserProfileResult");
    private final static QName _GetAllRolesResponseGetAllRolesResult_QNAME = new QName("http://applications.unionbankng.com/ws", "GetAllRolesResult");
    private final static QName _GetAllUsersResponseGetAllUsersResult_QNAME = new QName("http://applications.unionbankng.com/ws", "GetAllUsersResult");
    private final static QName _ChangeCustomerUserPasswordOldPassword_QNAME = new QName("http://applications.unionbankng.com/ws", "OldPassword");
    private final static QName _ChangeCustomerUserPasswordNewPassword_QNAME = new QName("http://applications.unionbankng.com/ws", "NewPassword");
    private final static QName _ChangeCustomerUserPasswordResponseChangeCustomerUserPasswordResult_QNAME = new QName("http://applications.unionbankng.com/ws", "ChangeCustomerUserPasswordResult");
    private final static QName _ChangeCustomerUserStatusUsername_QNAME = new QName("http://applications.unionbankng.com/ws", "Username");
    private final static QName _ChangeCustomerUserStatusResponseChangeCustomerUserStatusResult_QNAME = new QName("http://applications.unionbankng.com/ws", "ChangeCustomerUserStatusResult");
    private final static QName _CreateCustomerUserSecurityQuestion_QNAME = new QName("http://applications.unionbankng.com/ws", "SecurityQuestion");
    private final static QName _CreateCustomerUserSecurityAnswer_QNAME = new QName("http://applications.unionbankng.com/ws", "SecurityAnswer");
    private final static QName _CreateCustomerUserCreatedBy_QNAME = new QName("http://applications.unionbankng.com/ws", "CreatedBy");
    private final static QName _CreateCustomerUserResponseCreateCustomerUserResult_QNAME = new QName("http://applications.unionbankng.com/ws", "CreateCustomerUserResult");
    private final static QName _UpdateUserProfileCustomerProfile_QNAME = new QName("http://applications.unionbankng.com/ws", "CustomerProfile");
    private final static QName _GetModuleResponseGetModuleResult_QNAME = new QName("http://applications.unionbankng.com/ws", "GetModuleResult");
    private final static QName _GetModulesResponseGetModulesResult_QNAME = new QName("http://applications.unionbankng.com/ws", "GetModulesResult");
    private final static QName _GetBranchReportLineResponseGetBranchReportLineResult_QNAME = new QName("http://applications.unionbankng.com/ws", "GetBranchReportLineResult");
    private final static QName _AddModuleN_QNAME = new QName("http://applications.unionbankng.com/ws", "n");
    private final static QName _RequestRemoveUserFromRolesMakerId_QNAME = new QName("http://applications.unionbankng.com/ws", "MakerId");
    private final static QName _GetUserRoleEventStatusStatus_QNAME = new QName("http://applications.unionbankng.com/ws", "Status");
    private final static QName _GetUserRoleEventStatusEventId_QNAME = new QName("http://applications.unionbankng.com/ws", "EventId");
    private final static QName _GetUserRoleEventStatusResponseGetUserRoleEventStatusResult_QNAME = new QName("http://applications.unionbankng.com/ws", "GetUserRoleEventStatusResult");
    private final static QName _UserRoleEventStatusApplicationName_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "ApplicationName");
    private final static QName _UserRoleEventStatusCheckerId_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "CheckerId");
    private final static QName _UserRoleEventStatusDateAuthorized_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "DateAuthorized");
    private final static QName _UserRoleEventStatusDateCreated_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "DateCreated");
    private final static QName _UserRoleEventStatusEventId_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "EventId");
    private final static QName _UserRoleEventStatusMakerId_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "MakerId");
    private final static QName _UserRoleEventStatusRoleId_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "RoleId");
    private final static QName _UserRoleEventStatusRoleName_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "RoleName");
    private final static QName _UserRoleEventStatusStatus_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "Status");
    private final static QName _UserRoleEventStatusUsername_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "Username");
    private final static QName _CustomProfileBranchCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "BranchCode");
    private final static QName _CustomProfileBranchName_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "BranchName");
    private final static QName _CustomProfileMisc3_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "Misc3");
    private final static QName _CustomProfileOrgID_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "OrgID");
    private final static QName _CustomProfileOtherInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "OtherInfo");
    private final static QName _CustomProfileSortCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "SortCode");
    private final static QName _CustomProfileTillAccountNo_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "TillAccountNo");
    private final static QName _CustomProfileUserAccessMode_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "UserAccessMode");
    private final static QName _CustomProfileZoneCode_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "ZoneCode");
    private final static QName _UserProfileADUserID_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "ADUserID");
    private final static QName _UserProfileAddress_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "Address");
    private final static QName _UserProfileDepartment_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "Department");
    private final static QName _UserProfileDisplayName_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "DisplayName");
    private final static QName _UserProfileEmail_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "Email");
    private final static QName _UserProfileEmployeeId_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "EmployeeId");
    private final static QName _UserProfileFCUBSUserID_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "FCUBSUserID");
    private final static QName _UserProfileFirstName_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "FirstName");
    private final static QName _UserProfileGradeLevel_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "GradeLevel");
    private final static QName _UserProfileInitials_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "Initials");
    private final static QName _UserProfileJobTitle_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "JobTitle");
    private final static QName _UserProfileLastName_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "LastName");
    private final static QName _UserProfileMobileNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "MobileNumber");
    private final static QName _UserProfileTelephoneNumber_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "TelephoneNumber");
    private final static QName _ResponseDescription_QNAME = new QName("http://schemas.datacontract.org/2004/07/UBN.Security.Sms", "Description");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.unionbank.ADService
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AdAuthenticate }
     * 
     */
    public AdAuthenticate createAdAuthenticate() {
        return new AdAuthenticate();
    }

    /**
     * Create an instance of {@link AdAuthenticateResponse }
     * 
     */
    public AdAuthenticateResponse createAdAuthenticateResponse() {
        return new AdAuthenticateResponse();
    }

    /**
     * Create an instance of {@link Ad2XAuthenticate }
     * 
     */
    public Ad2XAuthenticate createAd2XAuthenticate() {
        return new Ad2XAuthenticate();
    }

    /**
     * Create an instance of {@link Ad2XAuthenticateResponse }
     * 
     */
    public Ad2XAuthenticateResponse createAd2XAuthenticateResponse() {
        return new Ad2XAuthenticateResponse();
    }

    /**
     * Create an instance of {@link Response }
     * 
     */
    public Response createResponse() {
        return new Response();
    }

    /**
     * Create an instance of {@link TwoXtorAuth }
     * 
     */
    public TwoXtorAuth createTwoXtorAuth() {
        return new TwoXtorAuth();
    }

    /**
     * Create an instance of {@link TwoXtorAuthResponse }
     * 
     */
    public TwoXtorAuthResponse createTwoXtorAuthResponse() {
        return new TwoXtorAuthResponse();
    }

    /**
     * Create an instance of {@link GenerateTwoXtorOtp }
     * 
     */
    public GenerateTwoXtorOtp createGenerateTwoXtorOtp() {
        return new GenerateTwoXtorOtp();
    }

    /**
     * Create an instance of {@link GenerateTwoXtorOtpResponse }
     * 
     */
    public GenerateTwoXtorOtpResponse createGenerateTwoXtorOtpResponse() {
        return new GenerateTwoXtorOtpResponse();
    }

    /**
     * Create an instance of {@link GetTwoXtorUserProfile }
     * 
     */
    public GetTwoXtorUserProfile createGetTwoXtorUserProfile() {
        return new GetTwoXtorUserProfile();
    }

    /**
     * Create an instance of {@link GetTwoXtorUserProfileResponse }
     * 
     */
    public GetTwoXtorUserProfileResponse createGetTwoXtorUserProfileResponse() {
        return new GetTwoXtorUserProfileResponse();
    }

    /**
     * Create an instance of {@link IsUserInRole }
     * 
     */
    public IsUserInRole createIsUserInRole() {
        return new IsUserInRole();
    }

    /**
     * Create an instance of {@link IsUserInRoleResponse }
     * 
     */
    public IsUserInRoleResponse createIsUserInRoleResponse() {
        return new IsUserInRoleResponse();
    }

    /**
     * Create an instance of {@link IsUserInAdRole }
     * 
     */
    public IsUserInAdRole createIsUserInAdRole() {
        return new IsUserInAdRole();
    }

    /**
     * Create an instance of {@link IsUserInAdRoleResponse }
     * 
     */
    public IsUserInAdRoleResponse createIsUserInAdRoleResponse() {
        return new IsUserInAdRoleResponse();
    }

    /**
     * Create an instance of {@link IsUserInCbaRole }
     * 
     */
    public IsUserInCbaRole createIsUserInCbaRole() {
        return new IsUserInCbaRole();
    }

    /**
     * Create an instance of {@link IsUserInCbaRoleResponse }
     * 
     */
    public IsUserInCbaRoleResponse createIsUserInCbaRoleResponse() {
        return new IsUserInCbaRoleResponse();
    }

    /**
     * Create an instance of {@link RoleExist }
     * 
     */
    public RoleExist createRoleExist() {
        return new RoleExist();
    }

    /**
     * Create an instance of {@link RoleExistResponse }
     * 
     */
    public RoleExistResponse createRoleExistResponse() {
        return new RoleExistResponse();
    }

    /**
     * Create an instance of {@link GetRolesForUser }
     * 
     */
    public GetRolesForUser createGetRolesForUser() {
        return new GetRolesForUser();
    }

    /**
     * Create an instance of {@link GetRolesForUserResponse }
     * 
     */
    public GetRolesForUserResponse createGetRolesForUserResponse() {
        return new GetRolesForUserResponse();
    }

    /**
     * Create an instance of {@link ArrayOfstring }
     * 
     */
    public ArrayOfstring createArrayOfstring() {
        return new ArrayOfstring();
    }

    /**
     * Create an instance of {@link GetAdRolesForUser }
     * 
     */
    public GetAdRolesForUser createGetAdRolesForUser() {
        return new GetAdRolesForUser();
    }

    /**
     * Create an instance of {@link GetAdRolesForUserResponse }
     * 
     */
    public GetAdRolesForUserResponse createGetAdRolesForUserResponse() {
        return new GetAdRolesForUserResponse();
    }

    /**
     * Create an instance of {@link GetCbaRolesForUser }
     * 
     */
    public GetCbaRolesForUser createGetCbaRolesForUser() {
        return new GetCbaRolesForUser();
    }

    /**
     * Create an instance of {@link GetCbaRolesForUserResponse }
     * 
     */
    public GetCbaRolesForUserResponse createGetCbaRolesForUserResponse() {
        return new GetCbaRolesForUserResponse();
    }

    /**
     * Create an instance of {@link GetUsersInRole }
     * 
     */
    public GetUsersInRole createGetUsersInRole() {
        return new GetUsersInRole();
    }

    /**
     * Create an instance of {@link GetUsersInRoleResponse }
     * 
     */
    public GetUsersInRoleResponse createGetUsersInRoleResponse() {
        return new GetUsersInRoleResponse();
    }

    /**
     * Create an instance of {@link RemoveUserFromRoles }
     * 
     */
    public RemoveUserFromRoles createRemoveUserFromRoles() {
        return new RemoveUserFromRoles();
    }

    /**
     * Create an instance of {@link RemoveUserFromRolesResponse }
     * 
     */
    public RemoveUserFromRolesResponse createRemoveUserFromRolesResponse() {
        return new RemoveUserFromRolesResponse();
    }

    /**
     * Create an instance of {@link AddUserToRole }
     * 
     */
    public AddUserToRole createAddUserToRole() {
        return new AddUserToRole();
    }

    /**
     * Create an instance of {@link AddUserToRoleResponse }
     * 
     */
    public AddUserToRoleResponse createAddUserToRoleResponse() {
        return new AddUserToRoleResponse();
    }

    /**
     * Create an instance of {@link AuthorizeUserRole }
     * 
     */
    public AuthorizeUserRole createAuthorizeUserRole() {
        return new AuthorizeUserRole();
    }

    /**
     * Create an instance of {@link AuthorizeUserRoleResponse }
     * 
     */
    public AuthorizeUserRoleResponse createAuthorizeUserRoleResponse() {
        return new AuthorizeUserRoleResponse();
    }

    /**
     * Create an instance of {@link CreateRole }
     * 
     */
    public CreateRole createCreateRole() {
        return new CreateRole();
    }

    /**
     * Create an instance of {@link CreateRoleResponse }
     * 
     */
    public CreateRoleResponse createCreateRoleResponse() {
        return new CreateRoleResponse();
    }

    /**
     * Create an instance of {@link DeleteRole }
     * 
     */
    public DeleteRole createDeleteRole() {
        return new DeleteRole();
    }

    /**
     * Create an instance of {@link DeleteRoleResponse }
     * 
     */
    public DeleteRoleResponse createDeleteRoleResponse() {
        return new DeleteRoleResponse();
    }

    /**
     * Create an instance of {@link GetUserProfile }
     * 
     */
    public GetUserProfile createGetUserProfile() {
        return new GetUserProfile();
    }

    /**
     * Create an instance of {@link GetUserProfileResponse }
     * 
     */
    public GetUserProfileResponse createGetUserProfileResponse() {
        return new GetUserProfileResponse();
    }

    /**
     * Create an instance of {@link UserProfile }
     * 
     */
    public UserProfile createUserProfile() {
        return new UserProfile();
    }

    /**
     * Create an instance of {@link SearchUserProfile }
     * 
     */
    public SearchUserProfile createSearchUserProfile() {
        return new SearchUserProfile();
    }

    /**
     * Create an instance of {@link SearchUserProfileResponse }
     * 
     */
    public SearchUserProfileResponse createSearchUserProfileResponse() {
        return new SearchUserProfileResponse();
    }

    /**
     * Create an instance of {@link ArrayOfUserProfile }
     * 
     */
    public ArrayOfUserProfile createArrayOfUserProfile() {
        return new ArrayOfUserProfile();
    }

    /**
     * Create an instance of {@link IsUserExist }
     * 
     */
    public IsUserExist createIsUserExist() {
        return new IsUserExist();
    }

    /**
     * Create an instance of {@link IsUserExistResponse }
     * 
     */
    public IsUserExistResponse createIsUserExistResponse() {
        return new IsUserExistResponse();
    }

    /**
     * Create an instance of {@link GetAllRoles }
     * 
     */
    public GetAllRoles createGetAllRoles() {
        return new GetAllRoles();
    }

    /**
     * Create an instance of {@link GetAllRolesResponse }
     * 
     */
    public GetAllRolesResponse createGetAllRolesResponse() {
        return new GetAllRolesResponse();
    }

    /**
     * Create an instance of {@link GetAllUsers }
     * 
     */
    public GetAllUsers createGetAllUsers() {
        return new GetAllUsers();
    }

    /**
     * Create an instance of {@link GetAllUsersResponse }
     * 
     */
    public GetAllUsersResponse createGetAllUsersResponse() {
        return new GetAllUsersResponse();
    }

    /**
     * Create an instance of {@link ChangeCustomerUserPassword }
     * 
     */
    public ChangeCustomerUserPassword createChangeCustomerUserPassword() {
        return new ChangeCustomerUserPassword();
    }

    /**
     * Create an instance of {@link ChangeCustomerUserPasswordResponse }
     * 
     */
    public ChangeCustomerUserPasswordResponse createChangeCustomerUserPasswordResponse() {
        return new ChangeCustomerUserPasswordResponse();
    }

    /**
     * Create an instance of {@link ChangeCustomerUserStatus }
     * 
     */
    public ChangeCustomerUserStatus createChangeCustomerUserStatus() {
        return new ChangeCustomerUserStatus();
    }

    /**
     * Create an instance of {@link ChangeCustomerUserStatusResponse }
     * 
     */
    public ChangeCustomerUserStatusResponse createChangeCustomerUserStatusResponse() {
        return new ChangeCustomerUserStatusResponse();
    }

    /**
     * Create an instance of {@link CreateCustomerUser }
     * 
     */
    public CreateCustomerUser createCreateCustomerUser() {
        return new CreateCustomerUser();
    }

    /**
     * Create an instance of {@link CreateCustomerUserResponse }
     * 
     */
    public CreateCustomerUserResponse createCreateCustomerUserResponse() {
        return new CreateCustomerUserResponse();
    }

    /**
     * Create an instance of {@link CustomAuthentication }
     * 
     */
    public CustomAuthentication createCustomAuthentication() {
        return new CustomAuthentication();
    }

    /**
     * Create an instance of {@link CustomAuthenticationResponse }
     * 
     */
    public CustomAuthenticationResponse createCustomAuthenticationResponse() {
        return new CustomAuthenticationResponse();
    }

    /**
     * Create an instance of {@link IsCustomerUserExist }
     * 
     */
    public IsCustomerUserExist createIsCustomerUserExist() {
        return new IsCustomerUserExist();
    }

    /**
     * Create an instance of {@link IsCustomerUserExistResponse }
     * 
     */
    public IsCustomerUserExistResponse createIsCustomerUserExistResponse() {
        return new IsCustomerUserExistResponse();
    }

    /**
     * Create an instance of {@link UpdateUserProfile }
     * 
     */
    public UpdateUserProfile createUpdateUserProfile() {
        return new UpdateUserProfile();
    }

    /**
     * Create an instance of {@link CustomProfile }
     * 
     */
    public CustomProfile createCustomProfile() {
        return new CustomProfile();
    }

    /**
     * Create an instance of {@link UpdateUserProfileResponse }
     * 
     */
    public UpdateUserProfileResponse createUpdateUserProfileResponse() {
        return new UpdateUserProfileResponse();
    }

    /**
     * Create an instance of {@link GetModule }
     * 
     */
    public GetModule createGetModule() {
        return new GetModule();
    }

    /**
     * Create an instance of {@link GetModuleResponse }
     * 
     */
    public GetModuleResponse createGetModuleResponse() {
        return new GetModuleResponse();
    }

    /**
     * Create an instance of {@link Module }
     * 
     */
    public Module createModule() {
        return new Module();
    }

    /**
     * Create an instance of {@link GetModules }
     * 
     */
    public GetModules createGetModules() {
        return new GetModules();
    }

    /**
     * Create an instance of {@link GetModulesResponse }
     * 
     */
    public GetModulesResponse createGetModulesResponse() {
        return new GetModulesResponse();
    }

    /**
     * Create an instance of {@link ArrayOfModule }
     * 
     */
    public ArrayOfModule createArrayOfModule() {
        return new ArrayOfModule();
    }

    /**
     * Create an instance of {@link GetBranchReportLine }
     * 
     */
    public GetBranchReportLine createGetBranchReportLine() {
        return new GetBranchReportLine();
    }

    /**
     * Create an instance of {@link GetBranchReportLineResponse }
     * 
     */
    public GetBranchReportLineResponse createGetBranchReportLineResponse() {
        return new GetBranchReportLineResponse();
    }

    /**
     * Create an instance of {@link BranchReportLine }
     * 
     */
    public BranchReportLine createBranchReportLine() {
        return new BranchReportLine();
    }

    /**
     * Create an instance of {@link AddModule }
     * 
     */
    public AddModule createAddModule() {
        return new AddModule();
    }

    /**
     * Create an instance of {@link ModuleMin }
     * 
     */
    public ModuleMin createModuleMin() {
        return new ModuleMin();
    }

    /**
     * Create an instance of {@link AddModuleResponse }
     * 
     */
    public AddModuleResponse createAddModuleResponse() {
        return new AddModuleResponse();
    }

    /**
     * Create an instance of {@link UpdateModule }
     * 
     */
    public UpdateModule createUpdateModule() {
        return new UpdateModule();
    }

    /**
     * Create an instance of {@link UpdateModuleResponse }
     * 
     */
    public UpdateModuleResponse createUpdateModuleResponse() {
        return new UpdateModuleResponse();
    }

    /**
     * Create an instance of {@link IsModuleExist }
     * 
     */
    public IsModuleExist createIsModuleExist() {
        return new IsModuleExist();
    }

    /**
     * Create an instance of {@link IsModuleExistResponse }
     * 
     */
    public IsModuleExistResponse createIsModuleExistResponse() {
        return new IsModuleExistResponse();
    }

    /**
     * Create an instance of {@link RequestRemoveUserFromRoles }
     * 
     */
    public RequestRemoveUserFromRoles createRequestRemoveUserFromRoles() {
        return new RequestRemoveUserFromRoles();
    }

    /**
     * Create an instance of {@link RequestRemoveUserFromRolesResponse }
     * 
     */
    public RequestRemoveUserFromRolesResponse createRequestRemoveUserFromRolesResponse() {
        return new RequestRemoveUserFromRolesResponse();
    }

    /**
     * Create an instance of {@link GetUserRoleEventStatus }
     * 
     */
    public GetUserRoleEventStatus createGetUserRoleEventStatus() {
        return new GetUserRoleEventStatus();
    }

    /**
     * Create an instance of {@link GetUserRoleEventStatusResponse }
     * 
     */
    public GetUserRoleEventStatusResponse createGetUserRoleEventStatusResponse() {
        return new GetUserRoleEventStatusResponse();
    }

    /**
     * Create an instance of {@link ArrayOfUserRoleEventStatus }
     * 
     */
    public ArrayOfUserRoleEventStatus createArrayOfUserRoleEventStatus() {
        return new ArrayOfUserRoleEventStatus();
    }

    /**
     * Create an instance of {@link UserRoleEventStatus }
     * 
     */
    public UserRoleEventStatus createUserRoleEventStatus() {
        return new UserRoleEventStatus();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "Response")
    public JAXBElement<Response> createResponse(Response value) {
        return new JAXBElement<Response>(_Response_QNAME, Response.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserProfile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "UserProfile")
    public JAXBElement<UserProfile> createUserProfile(UserProfile value) {
        return new JAXBElement<UserProfile>(_UserProfile_QNAME, UserProfile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomProfile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "CustomProfile")
    public JAXBElement<CustomProfile> createCustomProfile(CustomProfile value) {
        return new JAXBElement<CustomProfile>(_CustomProfile_QNAME, CustomProfile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfUserProfile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "ArrayOfUserProfile")
    public JAXBElement<ArrayOfUserProfile> createArrayOfUserProfile(ArrayOfUserProfile value) {
        return new JAXBElement<ArrayOfUserProfile>(_ArrayOfUserProfile_QNAME, ArrayOfUserProfile.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfUserRoleEventStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "ArrayOfUserRoleEventStatus")
    public JAXBElement<ArrayOfUserRoleEventStatus> createArrayOfUserRoleEventStatus(ArrayOfUserRoleEventStatus value) {
        return new JAXBElement<ArrayOfUserRoleEventStatus>(_ArrayOfUserRoleEventStatus_QNAME, ArrayOfUserRoleEventStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserRoleEventStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "UserRoleEventStatus")
    public JAXBElement<UserRoleEventStatus> createUserRoleEventStatus(UserRoleEventStatus value) {
        return new JAXBElement<UserRoleEventStatus>(_UserRoleEventStatus_QNAME, UserRoleEventStatus.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/Arrays", name = "ArrayOfstring")
    public JAXBElement<ArrayOfstring> createArrayOfstring(ArrayOfstring value) {
        return new JAXBElement<ArrayOfstring>(_ArrayOfstring_QNAME, ArrayOfstring.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Module }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.AuthenticationViaAD.Cls", name = "Module")
    public JAXBElement<Module> createModule(Module value) {
        return new JAXBElement<Module>(_Module_QNAME, Module.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfModule }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.AuthenticationViaAD.Cls", name = "ArrayOfModule")
    public JAXBElement<ArrayOfModule> createArrayOfModule(ArrayOfModule value) {
        return new JAXBElement<ArrayOfModule>(_ArrayOfModule_QNAME, ArrayOfModule.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BranchReportLine }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.AuthenticationViaAD.Cls", name = "BranchReportLine")
    public JAXBElement<BranchReportLine> createBranchReportLine(BranchReportLine value) {
        return new JAXBElement<BranchReportLine>(_BranchReportLine_QNAME, BranchReportLine.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModuleMin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.AuthenticationViaAD.Cls", name = "ModuleMin")
    public JAXBElement<ModuleMin> createModuleMin(ModuleMin value) {
        return new JAXBElement<ModuleMin>(_ModuleMin_QNAME, ModuleMin.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "anyType")
    public JAXBElement<Object> createAnyType(Object value) {
        return new JAXBElement<Object>(_AnyType_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "anyURI")
    public JAXBElement<String> createAnyURI(String value) {
        return new JAXBElement<String>(_AnyURI_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "base64Binary")
    public JAXBElement<byte[]> createBase64Binary(byte[] value) {
        return new JAXBElement<byte[]>(_Base64Binary_QNAME, byte[].class, null, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "boolean")
    public JAXBElement<Boolean> createBoolean(Boolean value) {
        return new JAXBElement<Boolean>(_Boolean_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "byte")
    public JAXBElement<Byte> createByte(Byte value) {
        return new JAXBElement<Byte>(_Byte_QNAME, Byte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "dateTime")
    public JAXBElement<XMLGregorianCalendar> createDateTime(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_DateTime_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "decimal")
    public JAXBElement<BigDecimal> createDecimal(BigDecimal value) {
        return new JAXBElement<BigDecimal>(_Decimal_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "double")
    public JAXBElement<Double> createDouble(Double value) {
        return new JAXBElement<Double>(_Double_QNAME, Double.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "float")
    public JAXBElement<Float> createFloat(Float value) {
        return new JAXBElement<Float>(_Float_QNAME, Float.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "int")
    public JAXBElement<Integer> createInt(Integer value) {
        return new JAXBElement<Integer>(_Int_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "long")
    public JAXBElement<Long> createLong(Long value) {
        return new JAXBElement<Long>(_Long_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "QName")
    public JAXBElement<QName> createQName(QName value) {
        return new JAXBElement<QName>(_QName_QNAME, QName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "short")
    public JAXBElement<Short> createShort(Short value) {
        return new JAXBElement<Short>(_Short_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "string")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<String>(_String_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedByte")
    public JAXBElement<Short> createUnsignedByte(Short value) {
        return new JAXBElement<Short>(_UnsignedByte_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedInt")
    public JAXBElement<Long> createUnsignedInt(Long value) {
        return new JAXBElement<Long>(_UnsignedInt_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedLong")
    public JAXBElement<BigInteger> createUnsignedLong(BigInteger value) {
        return new JAXBElement<BigInteger>(_UnsignedLong_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedShort")
    public JAXBElement<Integer> createUnsignedShort(Integer value) {
        return new JAXBElement<Integer>(_UnsignedShort_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "char")
    public JAXBElement<Integer> createChar(Integer value) {
        return new JAXBElement<Integer>(_Char_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Duration }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "duration")
    public JAXBElement<Duration> createDuration(Duration value) {
        return new JAXBElement<Duration>(_Duration_QNAME, Duration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "guid")
    public JAXBElement<String> createGuid(String value) {
        return new JAXBElement<String>(_Guid_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "User", scope = AdAuthenticate.class)
    public JAXBElement<String> createAdAuthenticateUser(String value) {
        return new JAXBElement<String>(_AdAuthenticateUser_QNAME, String.class, AdAuthenticate.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "Password", scope = AdAuthenticate.class)
    public JAXBElement<String> createAdAuthenticatePassword(String value) {
        return new JAXBElement<String>(_AdAuthenticatePassword_QNAME, String.class, AdAuthenticate.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "ModuleId", scope = AdAuthenticate.class)
    public JAXBElement<String> createAdAuthenticateModuleId(String value) {
        return new JAXBElement<String>(_AdAuthenticateModuleId_QNAME, String.class, AdAuthenticate.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "User", scope = Ad2XAuthenticate.class)
    public JAXBElement<String> createAd2XAuthenticateUser(String value) {
        return new JAXBElement<String>(_AdAuthenticateUser_QNAME, String.class, Ad2XAuthenticate.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "Password", scope = Ad2XAuthenticate.class)
    public JAXBElement<String> createAd2XAuthenticatePassword(String value) {
        return new JAXBElement<String>(_AdAuthenticatePassword_QNAME, String.class, Ad2XAuthenticate.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "Token", scope = Ad2XAuthenticate.class)
    public JAXBElement<String> createAd2XAuthenticateToken(String value) {
        return new JAXBElement<String>(_Ad2XAuthenticateToken_QNAME, String.class, Ad2XAuthenticate.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "ModuleId", scope = Ad2XAuthenticate.class)
    public JAXBElement<String> createAd2XAuthenticateModuleId(String value) {
        return new JAXBElement<String>(_AdAuthenticateModuleId_QNAME, String.class, Ad2XAuthenticate.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "Ad2xAuthenticateResult", scope = Ad2XAuthenticateResponse.class)
    public JAXBElement<Response> createAd2XAuthenticateResponseAd2XAuthenticateResult(Response value) {
        return new JAXBElement<Response>(_Ad2XAuthenticateResponseAd2XAuthenticateResult_QNAME, Response.class, Ad2XAuthenticateResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "User", scope = TwoXtorAuth.class)
    public JAXBElement<String> createTwoXtorAuthUser(String value) {
        return new JAXBElement<String>(_AdAuthenticateUser_QNAME, String.class, TwoXtorAuth.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "Token", scope = TwoXtorAuth.class)
    public JAXBElement<String> createTwoXtorAuthToken(String value) {
        return new JAXBElement<String>(_Ad2XAuthenticateToken_QNAME, String.class, TwoXtorAuth.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "ModuleId", scope = TwoXtorAuth.class)
    public JAXBElement<String> createTwoXtorAuthModuleId(String value) {
        return new JAXBElement<String>(_AdAuthenticateModuleId_QNAME, String.class, TwoXtorAuth.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "TwoXtorAuthResult", scope = TwoXtorAuthResponse.class)
    public JAXBElement<Response> createTwoXtorAuthResponseTwoXtorAuthResult(Response value) {
        return new JAXBElement<Response>(_TwoXtorAuthResponseTwoXtorAuthResult_QNAME, Response.class, TwoXtorAuthResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "User", scope = GenerateTwoXtorOtp.class)
    public JAXBElement<String> createGenerateTwoXtorOtpUser(String value) {
        return new JAXBElement<String>(_AdAuthenticateUser_QNAME, String.class, GenerateTwoXtorOtp.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "ModuleId", scope = GenerateTwoXtorOtp.class)
    public JAXBElement<String> createGenerateTwoXtorOtpModuleId(String value) {
        return new JAXBElement<String>(_AdAuthenticateModuleId_QNAME, String.class, GenerateTwoXtorOtp.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "GenerateTwoXtorOtpResult", scope = GenerateTwoXtorOtpResponse.class)
    public JAXBElement<Response> createGenerateTwoXtorOtpResponseGenerateTwoXtorOtpResult(Response value) {
        return new JAXBElement<Response>(_GenerateTwoXtorOtpResponseGenerateTwoXtorOtpResult_QNAME, Response.class, GenerateTwoXtorOtpResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "User", scope = GetTwoXtorUserProfile.class)
    public JAXBElement<String> createGetTwoXtorUserProfileUser(String value) {
        return new JAXBElement<String>(_AdAuthenticateUser_QNAME, String.class, GetTwoXtorUserProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "ModuleId", scope = GetTwoXtorUserProfile.class)
    public JAXBElement<String> createGetTwoXtorUserProfileModuleId(String value) {
        return new JAXBElement<String>(_AdAuthenticateModuleId_QNAME, String.class, GetTwoXtorUserProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Response }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "GetTwoXtorUserProfileResult", scope = GetTwoXtorUserProfileResponse.class)
    public JAXBElement<Response> createGetTwoXtorUserProfileResponseGetTwoXtorUserProfileResult(Response value) {
        return new JAXBElement<Response>(_GetTwoXtorUserProfileResponseGetTwoXtorUserProfileResult_QNAME, Response.class, GetTwoXtorUserProfileResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "User", scope = IsUserInRole.class)
    public JAXBElement<String> createIsUserInRoleUser(String value) {
        return new JAXBElement<String>(_AdAuthenticateUser_QNAME, String.class, IsUserInRole.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "Role", scope = IsUserInRole.class)
    public JAXBElement<String> createIsUserInRoleRole(String value) {
        return new JAXBElement<String>(_IsUserInRoleRole_QNAME, String.class, IsUserInRole.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "ModuleId", scope = IsUserInRole.class)
    public JAXBElement<String> createIsUserInRoleModuleId(String value) {
        return new JAXBElement<String>(_AdAuthenticateModuleId_QNAME, String.class, IsUserInRole.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "User", scope = IsUserInAdRole.class)
    public JAXBElement<String> createIsUserInAdRoleUser(String value) {
        return new JAXBElement<String>(_AdAuthenticateUser_QNAME, String.class, IsUserInAdRole.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "Role", scope = IsUserInAdRole.class)
    public JAXBElement<String> createIsUserInAdRoleRole(String value) {
        return new JAXBElement<String>(_IsUserInRoleRole_QNAME, String.class, IsUserInAdRole.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "ModuleId", scope = IsUserInAdRole.class)
    public JAXBElement<String> createIsUserInAdRoleModuleId(String value) {
        return new JAXBElement<String>(_AdAuthenticateModuleId_QNAME, String.class, IsUserInAdRole.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "User", scope = IsUserInCbaRole.class)
    public JAXBElement<String> createIsUserInCbaRoleUser(String value) {
        return new JAXBElement<String>(_AdAuthenticateUser_QNAME, String.class, IsUserInCbaRole.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "Role", scope = IsUserInCbaRole.class)
    public JAXBElement<String> createIsUserInCbaRoleRole(String value) {
        return new JAXBElement<String>(_IsUserInRoleRole_QNAME, String.class, IsUserInCbaRole.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "ModuleId", scope = IsUserInCbaRole.class)
    public JAXBElement<String> createIsUserInCbaRoleModuleId(String value) {
        return new JAXBElement<String>(_AdAuthenticateModuleId_QNAME, String.class, IsUserInCbaRole.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "Role", scope = RoleExist.class)
    public JAXBElement<String> createRoleExistRole(String value) {
        return new JAXBElement<String>(_IsUserInRoleRole_QNAME, String.class, RoleExist.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "ModuleId", scope = RoleExist.class)
    public JAXBElement<String> createRoleExistModuleId(String value) {
        return new JAXBElement<String>(_AdAuthenticateModuleId_QNAME, String.class, RoleExist.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "User", scope = GetRolesForUser.class)
    public JAXBElement<String> createGetRolesForUserUser(String value) {
        return new JAXBElement<String>(_AdAuthenticateUser_QNAME, String.class, GetRolesForUser.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "ModuleId", scope = GetRolesForUser.class)
    public JAXBElement<String> createGetRolesForUserModuleId(String value) {
        return new JAXBElement<String>(_AdAuthenticateModuleId_QNAME, String.class, GetRolesForUser.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "GetRolesForUserResult", scope = GetRolesForUserResponse.class)
    public JAXBElement<ArrayOfstring> createGetRolesForUserResponseGetRolesForUserResult(ArrayOfstring value) {
        return new JAXBElement<ArrayOfstring>(_GetRolesForUserResponseGetRolesForUserResult_QNAME, ArrayOfstring.class, GetRolesForUserResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "User", scope = GetAdRolesForUser.class)
    public JAXBElement<String> createGetAdRolesForUserUser(String value) {
        return new JAXBElement<String>(_AdAuthenticateUser_QNAME, String.class, GetAdRolesForUser.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "ModuleId", scope = GetAdRolesForUser.class)
    public JAXBElement<String> createGetAdRolesForUserModuleId(String value) {
        return new JAXBElement<String>(_AdAuthenticateModuleId_QNAME, String.class, GetAdRolesForUser.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "GetAdRolesForUserResult", scope = GetAdRolesForUserResponse.class)
    public JAXBElement<ArrayOfstring> createGetAdRolesForUserResponseGetAdRolesForUserResult(ArrayOfstring value) {
        return new JAXBElement<ArrayOfstring>(_GetAdRolesForUserResponseGetAdRolesForUserResult_QNAME, ArrayOfstring.class, GetAdRolesForUserResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "User", scope = GetCbaRolesForUser.class)
    public JAXBElement<String> createGetCbaRolesForUserUser(String value) {
        return new JAXBElement<String>(_AdAuthenticateUser_QNAME, String.class, GetCbaRolesForUser.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "ModuleId", scope = GetCbaRolesForUser.class)
    public JAXBElement<String> createGetCbaRolesForUserModuleId(String value) {
        return new JAXBElement<String>(_AdAuthenticateModuleId_QNAME, String.class, GetCbaRolesForUser.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "GetCbaRolesForUserResult", scope = GetCbaRolesForUserResponse.class)
    public JAXBElement<ArrayOfstring> createGetCbaRolesForUserResponseGetCbaRolesForUserResult(ArrayOfstring value) {
        return new JAXBElement<ArrayOfstring>(_GetCbaRolesForUserResponseGetCbaRolesForUserResult_QNAME, ArrayOfstring.class, GetCbaRolesForUserResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "Role", scope = GetUsersInRole.class)
    public JAXBElement<String> createGetUsersInRoleRole(String value) {
        return new JAXBElement<String>(_IsUserInRoleRole_QNAME, String.class, GetUsersInRole.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "ModuleId", scope = GetUsersInRole.class)
    public JAXBElement<String> createGetUsersInRoleModuleId(String value) {
        return new JAXBElement<String>(_AdAuthenticateModuleId_QNAME, String.class, GetUsersInRole.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "GetUsersInRoleResult", scope = GetUsersInRoleResponse.class)
    public JAXBElement<ArrayOfstring> createGetUsersInRoleResponseGetUsersInRoleResult(ArrayOfstring value) {
        return new JAXBElement<ArrayOfstring>(_GetUsersInRoleResponseGetUsersInRoleResult_QNAME, ArrayOfstring.class, GetUsersInRoleResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "User", scope = RemoveUserFromRoles.class)
    public JAXBElement<String> createRemoveUserFromRolesUser(String value) {
        return new JAXBElement<String>(_AdAuthenticateUser_QNAME, String.class, RemoveUserFromRoles.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "Role", scope = RemoveUserFromRoles.class)
    public JAXBElement<ArrayOfstring> createRemoveUserFromRolesRole(ArrayOfstring value) {
        return new JAXBElement<ArrayOfstring>(_IsUserInRoleRole_QNAME, ArrayOfstring.class, RemoveUserFromRoles.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "ModuleId", scope = RemoveUserFromRoles.class)
    public JAXBElement<String> createRemoveUserFromRolesModuleId(String value) {
        return new JAXBElement<String>(_AdAuthenticateModuleId_QNAME, String.class, RemoveUserFromRoles.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "User", scope = AddUserToRole.class)
    public JAXBElement<String> createAddUserToRoleUser(String value) {
        return new JAXBElement<String>(_AdAuthenticateUser_QNAME, String.class, AddUserToRole.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "Role", scope = AddUserToRole.class)
    public JAXBElement<String> createAddUserToRoleRole(String value) {
        return new JAXBElement<String>(_IsUserInRoleRole_QNAME, String.class, AddUserToRole.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "Maker", scope = AddUserToRole.class)
    public JAXBElement<String> createAddUserToRoleMaker(String value) {
        return new JAXBElement<String>(_AddUserToRoleMaker_QNAME, String.class, AddUserToRole.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "Checker", scope = AddUserToRole.class)
    public JAXBElement<String> createAddUserToRoleChecker(String value) {
        return new JAXBElement<String>(_AddUserToRoleChecker_QNAME, String.class, AddUserToRole.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "ModuleId", scope = AddUserToRole.class)
    public JAXBElement<String> createAddUserToRoleModuleId(String value) {
        return new JAXBElement<String>(_AdAuthenticateModuleId_QNAME, String.class, AddUserToRole.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "User", scope = AuthorizeUserRole.class)
    public JAXBElement<String> createAuthorizeUserRoleUser(String value) {
        return new JAXBElement<String>(_AdAuthenticateUser_QNAME, String.class, AuthorizeUserRole.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "Role", scope = AuthorizeUserRole.class)
    public JAXBElement<String> createAuthorizeUserRoleRole(String value) {
        return new JAXBElement<String>(_IsUserInRoleRole_QNAME, String.class, AuthorizeUserRole.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "Checker", scope = AuthorizeUserRole.class)
    public JAXBElement<String> createAuthorizeUserRoleChecker(String value) {
        return new JAXBElement<String>(_AddUserToRoleChecker_QNAME, String.class, AuthorizeUserRole.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "ModuleId", scope = AuthorizeUserRole.class)
    public JAXBElement<String> createAuthorizeUserRoleModuleId(String value) {
        return new JAXBElement<String>(_AdAuthenticateModuleId_QNAME, String.class, AuthorizeUserRole.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "AuthorizeUserRoleResult", scope = AuthorizeUserRoleResponse.class)
    public JAXBElement<String> createAuthorizeUserRoleResponseAuthorizeUserRoleResult(String value) {
        return new JAXBElement<String>(_AuthorizeUserRoleResponseAuthorizeUserRoleResult_QNAME, String.class, AuthorizeUserRoleResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "Role", scope = CreateRole.class)
    public JAXBElement<String> createCreateRoleRole(String value) {
        return new JAXBElement<String>(_IsUserInRoleRole_QNAME, String.class, CreateRole.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "ModuleId", scope = CreateRole.class)
    public JAXBElement<String> createCreateRoleModuleId(String value) {
        return new JAXBElement<String>(_AdAuthenticateModuleId_QNAME, String.class, CreateRole.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "Role", scope = DeleteRole.class)
    public JAXBElement<String> createDeleteRoleRole(String value) {
        return new JAXBElement<String>(_IsUserInRoleRole_QNAME, String.class, DeleteRole.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "ModuleId", scope = DeleteRole.class)
    public JAXBElement<String> createDeleteRoleModuleId(String value) {
        return new JAXBElement<String>(_AdAuthenticateModuleId_QNAME, String.class, DeleteRole.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "User", scope = GetUserProfile.class)
    public JAXBElement<String> createGetUserProfileUser(String value) {
        return new JAXBElement<String>(_AdAuthenticateUser_QNAME, String.class, GetUserProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "ModuleId", scope = GetUserProfile.class)
    public JAXBElement<String> createGetUserProfileModuleId(String value) {
        return new JAXBElement<String>(_AdAuthenticateModuleId_QNAME, String.class, GetUserProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UserProfile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "GetUserProfileResult", scope = GetUserProfileResponse.class)
    public JAXBElement<UserProfile> createGetUserProfileResponseGetUserProfileResult(UserProfile value) {
        return new JAXBElement<UserProfile>(_GetUserProfileResponseGetUserProfileResult_QNAME, UserProfile.class, GetUserProfileResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "q", scope = SearchUserProfile.class)
    public JAXBElement<String> createSearchUserProfileQ(String value) {
        return new JAXBElement<String>(_SearchUserProfileQ_QNAME, String.class, SearchUserProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "ModuleId", scope = SearchUserProfile.class)
    public JAXBElement<String> createSearchUserProfileModuleId(String value) {
        return new JAXBElement<String>(_AdAuthenticateModuleId_QNAME, String.class, SearchUserProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfUserProfile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "SearchUserProfileResult", scope = SearchUserProfileResponse.class)
    public JAXBElement<ArrayOfUserProfile> createSearchUserProfileResponseSearchUserProfileResult(ArrayOfUserProfile value) {
        return new JAXBElement<ArrayOfUserProfile>(_SearchUserProfileResponseSearchUserProfileResult_QNAME, ArrayOfUserProfile.class, SearchUserProfileResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "User", scope = IsUserExist.class)
    public JAXBElement<String> createIsUserExistUser(String value) {
        return new JAXBElement<String>(_AdAuthenticateUser_QNAME, String.class, IsUserExist.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "ModuleId", scope = IsUserExist.class)
    public JAXBElement<String> createIsUserExistModuleId(String value) {
        return new JAXBElement<String>(_AdAuthenticateModuleId_QNAME, String.class, IsUserExist.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "ModuleId", scope = GetAllRoles.class)
    public JAXBElement<String> createGetAllRolesModuleId(String value) {
        return new JAXBElement<String>(_AdAuthenticateModuleId_QNAME, String.class, GetAllRoles.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "GetAllRolesResult", scope = GetAllRolesResponse.class)
    public JAXBElement<ArrayOfstring> createGetAllRolesResponseGetAllRolesResult(ArrayOfstring value) {
        return new JAXBElement<ArrayOfstring>(_GetAllRolesResponseGetAllRolesResult_QNAME, ArrayOfstring.class, GetAllRolesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "ModuleId", scope = GetAllUsers.class)
    public JAXBElement<String> createGetAllUsersModuleId(String value) {
        return new JAXBElement<String>(_AdAuthenticateModuleId_QNAME, String.class, GetAllUsers.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "GetAllUsersResult", scope = GetAllUsersResponse.class)
    public JAXBElement<ArrayOfstring> createGetAllUsersResponseGetAllUsersResult(ArrayOfstring value) {
        return new JAXBElement<ArrayOfstring>(_GetAllUsersResponseGetAllUsersResult_QNAME, ArrayOfstring.class, GetAllUsersResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "User", scope = ChangeCustomerUserPassword.class)
    public JAXBElement<String> createChangeCustomerUserPasswordUser(String value) {
        return new JAXBElement<String>(_AdAuthenticateUser_QNAME, String.class, ChangeCustomerUserPassword.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "OldPassword", scope = ChangeCustomerUserPassword.class)
    public JAXBElement<String> createChangeCustomerUserPasswordOldPassword(String value) {
        return new JAXBElement<String>(_ChangeCustomerUserPasswordOldPassword_QNAME, String.class, ChangeCustomerUserPassword.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "NewPassword", scope = ChangeCustomerUserPassword.class)
    public JAXBElement<String> createChangeCustomerUserPasswordNewPassword(String value) {
        return new JAXBElement<String>(_ChangeCustomerUserPasswordNewPassword_QNAME, String.class, ChangeCustomerUserPassword.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "ModuleId", scope = ChangeCustomerUserPassword.class)
    public JAXBElement<String> createChangeCustomerUserPasswordModuleId(String value) {
        return new JAXBElement<String>(_AdAuthenticateModuleId_QNAME, String.class, ChangeCustomerUserPassword.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "ChangeCustomerUserPasswordResult", scope = ChangeCustomerUserPasswordResponse.class)
    public JAXBElement<String> createChangeCustomerUserPasswordResponseChangeCustomerUserPasswordResult(String value) {
        return new JAXBElement<String>(_ChangeCustomerUserPasswordResponseChangeCustomerUserPasswordResult_QNAME, String.class, ChangeCustomerUserPasswordResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "Username", scope = ChangeCustomerUserStatus.class)
    public JAXBElement<String> createChangeCustomerUserStatusUsername(String value) {
        return new JAXBElement<String>(_ChangeCustomerUserStatusUsername_QNAME, String.class, ChangeCustomerUserStatus.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "ModuleId", scope = ChangeCustomerUserStatus.class)
    public JAXBElement<String> createChangeCustomerUserStatusModuleId(String value) {
        return new JAXBElement<String>(_AdAuthenticateModuleId_QNAME, String.class, ChangeCustomerUserStatus.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "ChangeCustomerUserStatusResult", scope = ChangeCustomerUserStatusResponse.class)
    public JAXBElement<String> createChangeCustomerUserStatusResponseChangeCustomerUserStatusResult(String value) {
        return new JAXBElement<String>(_ChangeCustomerUserStatusResponseChangeCustomerUserStatusResult_QNAME, String.class, ChangeCustomerUserStatusResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "User", scope = CreateCustomerUser.class)
    public JAXBElement<String> createCreateCustomerUserUser(String value) {
        return new JAXBElement<String>(_AdAuthenticateUser_QNAME, String.class, CreateCustomerUser.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "SecurityQuestion", scope = CreateCustomerUser.class)
    public JAXBElement<String> createCreateCustomerUserSecurityQuestion(String value) {
        return new JAXBElement<String>(_CreateCustomerUserSecurityQuestion_QNAME, String.class, CreateCustomerUser.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "SecurityAnswer", scope = CreateCustomerUser.class)
    public JAXBElement<String> createCreateCustomerUserSecurityAnswer(String value) {
        return new JAXBElement<String>(_CreateCustomerUserSecurityAnswer_QNAME, String.class, CreateCustomerUser.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "CreatedBy", scope = CreateCustomerUser.class)
    public JAXBElement<String> createCreateCustomerUserCreatedBy(String value) {
        return new JAXBElement<String>(_CreateCustomerUserCreatedBy_QNAME, String.class, CreateCustomerUser.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "ModuleId", scope = CreateCustomerUser.class)
    public JAXBElement<String> createCreateCustomerUserModuleId(String value) {
        return new JAXBElement<String>(_AdAuthenticateModuleId_QNAME, String.class, CreateCustomerUser.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "CreateCustomerUserResult", scope = CreateCustomerUserResponse.class)
    public JAXBElement<String> createCreateCustomerUserResponseCreateCustomerUserResult(String value) {
        return new JAXBElement<String>(_CreateCustomerUserResponseCreateCustomerUserResult_QNAME, String.class, CreateCustomerUserResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "Username", scope = CustomAuthentication.class)
    public JAXBElement<String> createCustomAuthenticationUsername(String value) {
        return new JAXBElement<String>(_ChangeCustomerUserStatusUsername_QNAME, String.class, CustomAuthentication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "Password", scope = CustomAuthentication.class)
    public JAXBElement<String> createCustomAuthenticationPassword(String value) {
        return new JAXBElement<String>(_AdAuthenticatePassword_QNAME, String.class, CustomAuthentication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "ModuleId", scope = CustomAuthentication.class)
    public JAXBElement<String> createCustomAuthenticationModuleId(String value) {
        return new JAXBElement<String>(_AdAuthenticateModuleId_QNAME, String.class, CustomAuthentication.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "User", scope = IsCustomerUserExist.class)
    public JAXBElement<String> createIsCustomerUserExistUser(String value) {
        return new JAXBElement<String>(_AdAuthenticateUser_QNAME, String.class, IsCustomerUserExist.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "ModuleId", scope = IsCustomerUserExist.class)
    public JAXBElement<String> createIsCustomerUserExistModuleId(String value) {
        return new JAXBElement<String>(_AdAuthenticateModuleId_QNAME, String.class, IsCustomerUserExist.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "User", scope = UpdateUserProfile.class)
    public JAXBElement<String> createUpdateUserProfileUser(String value) {
        return new JAXBElement<String>(_AdAuthenticateUser_QNAME, String.class, UpdateUserProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomProfile }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "CustomerProfile", scope = UpdateUserProfile.class)
    public JAXBElement<CustomProfile> createUpdateUserProfileCustomerProfile(CustomProfile value) {
        return new JAXBElement<CustomProfile>(_UpdateUserProfileCustomerProfile_QNAME, CustomProfile.class, UpdateUserProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "ModuleId", scope = GetModule.class)
    public JAXBElement<String> createGetModuleModuleId(String value) {
        return new JAXBElement<String>(_AdAuthenticateModuleId_QNAME, String.class, GetModule.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Module }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "GetModuleResult", scope = GetModuleResponse.class)
    public JAXBElement<Module> createGetModuleResponseGetModuleResult(Module value) {
        return new JAXBElement<Module>(_GetModuleResponseGetModuleResult_QNAME, Module.class, GetModuleResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfModule }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "GetModulesResult", scope = GetModulesResponse.class)
    public JAXBElement<ArrayOfModule> createGetModulesResponseGetModulesResult(ArrayOfModule value) {
        return new JAXBElement<ArrayOfModule>(_GetModulesResponseGetModulesResult_QNAME, ArrayOfModule.class, GetModulesResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BranchReportLine }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "GetBranchReportLineResult", scope = GetBranchReportLineResponse.class)
    public JAXBElement<BranchReportLine> createGetBranchReportLineResponseGetBranchReportLineResult(BranchReportLine value) {
        return new JAXBElement<BranchReportLine>(_GetBranchReportLineResponseGetBranchReportLineResult_QNAME, BranchReportLine.class, GetBranchReportLineResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModuleMin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "n", scope = AddModule.class)
    public JAXBElement<ModuleMin> createAddModuleN(ModuleMin value) {
        return new JAXBElement<ModuleMin>(_AddModuleN_QNAME, ModuleMin.class, AddModule.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModuleMin }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "n", scope = UpdateModule.class)
    public JAXBElement<ModuleMin> createUpdateModuleN(ModuleMin value) {
        return new JAXBElement<ModuleMin>(_AddModuleN_QNAME, ModuleMin.class, UpdateModule.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "ModuleId", scope = IsModuleExist.class)
    public JAXBElement<String> createIsModuleExistModuleId(String value) {
        return new JAXBElement<String>(_AdAuthenticateModuleId_QNAME, String.class, IsModuleExist.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "User", scope = RequestRemoveUserFromRoles.class)
    public JAXBElement<String> createRequestRemoveUserFromRolesUser(String value) {
        return new JAXBElement<String>(_AdAuthenticateUser_QNAME, String.class, RequestRemoveUserFromRoles.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "Role", scope = RequestRemoveUserFromRoles.class)
    public JAXBElement<String> createRequestRemoveUserFromRolesRole(String value) {
        return new JAXBElement<String>(_IsUserInRoleRole_QNAME, String.class, RequestRemoveUserFromRoles.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "MakerId", scope = RequestRemoveUserFromRoles.class)
    public JAXBElement<String> createRequestRemoveUserFromRolesMakerId(String value) {
        return new JAXBElement<String>(_RequestRemoveUserFromRolesMakerId_QNAME, String.class, RequestRemoveUserFromRoles.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "ModuleId", scope = RequestRemoveUserFromRoles.class)
    public JAXBElement<String> createRequestRemoveUserFromRolesModuleId(String value) {
        return new JAXBElement<String>(_AdAuthenticateModuleId_QNAME, String.class, RequestRemoveUserFromRoles.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "ModuleId", scope = GetUserRoleEventStatus.class)
    public JAXBElement<String> createGetUserRoleEventStatusModuleId(String value) {
        return new JAXBElement<String>(_AdAuthenticateModuleId_QNAME, String.class, GetUserRoleEventStatus.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "Status", scope = GetUserRoleEventStatus.class)
    public JAXBElement<String> createGetUserRoleEventStatusStatus(String value) {
        return new JAXBElement<String>(_GetUserRoleEventStatusStatus_QNAME, String.class, GetUserRoleEventStatus.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "EventId", scope = GetUserRoleEventStatus.class)
    public JAXBElement<String> createGetUserRoleEventStatusEventId(String value) {
        return new JAXBElement<String>(_GetUserRoleEventStatusEventId_QNAME, String.class, GetUserRoleEventStatus.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfUserRoleEventStatus }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://applications.unionbankng.com/ws", name = "GetUserRoleEventStatusResult", scope = GetUserRoleEventStatusResponse.class)
    public JAXBElement<ArrayOfUserRoleEventStatus> createGetUserRoleEventStatusResponseGetUserRoleEventStatusResult(ArrayOfUserRoleEventStatus value) {
        return new JAXBElement<ArrayOfUserRoleEventStatus>(_GetUserRoleEventStatusResponseGetUserRoleEventStatusResult_QNAME, ArrayOfUserRoleEventStatus.class, GetUserRoleEventStatusResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "ApplicationName", scope = UserRoleEventStatus.class)
    public JAXBElement<String> createUserRoleEventStatusApplicationName(String value) {
        return new JAXBElement<String>(_UserRoleEventStatusApplicationName_QNAME, String.class, UserRoleEventStatus.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "CheckerId", scope = UserRoleEventStatus.class)
    public JAXBElement<String> createUserRoleEventStatusCheckerId(String value) {
        return new JAXBElement<String>(_UserRoleEventStatusCheckerId_QNAME, String.class, UserRoleEventStatus.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "DateAuthorized", scope = UserRoleEventStatus.class)
    public JAXBElement<XMLGregorianCalendar> createUserRoleEventStatusDateAuthorized(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_UserRoleEventStatusDateAuthorized_QNAME, XMLGregorianCalendar.class, UserRoleEventStatus.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "DateCreated", scope = UserRoleEventStatus.class)
    public JAXBElement<XMLGregorianCalendar> createUserRoleEventStatusDateCreated(XMLGregorianCalendar value) {
        return new JAXBElement<XMLGregorianCalendar>(_UserRoleEventStatusDateCreated_QNAME, XMLGregorianCalendar.class, UserRoleEventStatus.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "EventId", scope = UserRoleEventStatus.class)
    public JAXBElement<String> createUserRoleEventStatusEventId(String value) {
        return new JAXBElement<String>(_UserRoleEventStatusEventId_QNAME, String.class, UserRoleEventStatus.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "MakerId", scope = UserRoleEventStatus.class)
    public JAXBElement<String> createUserRoleEventStatusMakerId(String value) {
        return new JAXBElement<String>(_UserRoleEventStatusMakerId_QNAME, String.class, UserRoleEventStatus.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "RoleId", scope = UserRoleEventStatus.class)
    public JAXBElement<String> createUserRoleEventStatusRoleId(String value) {
        return new JAXBElement<String>(_UserRoleEventStatusRoleId_QNAME, String.class, UserRoleEventStatus.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "RoleName", scope = UserRoleEventStatus.class)
    public JAXBElement<String> createUserRoleEventStatusRoleName(String value) {
        return new JAXBElement<String>(_UserRoleEventStatusRoleName_QNAME, String.class, UserRoleEventStatus.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "Status", scope = UserRoleEventStatus.class)
    public JAXBElement<String> createUserRoleEventStatusStatus(String value) {
        return new JAXBElement<String>(_UserRoleEventStatusStatus_QNAME, String.class, UserRoleEventStatus.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "Username", scope = UserRoleEventStatus.class)
    public JAXBElement<String> createUserRoleEventStatusUsername(String value) {
        return new JAXBElement<String>(_UserRoleEventStatusUsername_QNAME, String.class, UserRoleEventStatus.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "BranchCode", scope = CustomProfile.class)
    public JAXBElement<String> createCustomProfileBranchCode(String value) {
        return new JAXBElement<String>(_CustomProfileBranchCode_QNAME, String.class, CustomProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "BranchName", scope = CustomProfile.class)
    public JAXBElement<String> createCustomProfileBranchName(String value) {
        return new JAXBElement<String>(_CustomProfileBranchName_QNAME, String.class, CustomProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "Misc3", scope = CustomProfile.class)
    public JAXBElement<String> createCustomProfileMisc3(String value) {
        return new JAXBElement<String>(_CustomProfileMisc3_QNAME, String.class, CustomProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "OrgID", scope = CustomProfile.class)
    public JAXBElement<String> createCustomProfileOrgID(String value) {
        return new JAXBElement<String>(_CustomProfileOrgID_QNAME, String.class, CustomProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "OtherInfo", scope = CustomProfile.class)
    public JAXBElement<String> createCustomProfileOtherInfo(String value) {
        return new JAXBElement<String>(_CustomProfileOtherInfo_QNAME, String.class, CustomProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "SortCode", scope = CustomProfile.class)
    public JAXBElement<String> createCustomProfileSortCode(String value) {
        return new JAXBElement<String>(_CustomProfileSortCode_QNAME, String.class, CustomProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "TillAccountNo", scope = CustomProfile.class)
    public JAXBElement<String> createCustomProfileTillAccountNo(String value) {
        return new JAXBElement<String>(_CustomProfileTillAccountNo_QNAME, String.class, CustomProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "UserAccessMode", scope = CustomProfile.class)
    public JAXBElement<String> createCustomProfileUserAccessMode(String value) {
        return new JAXBElement<String>(_CustomProfileUserAccessMode_QNAME, String.class, CustomProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "ZoneCode", scope = CustomProfile.class)
    public JAXBElement<String> createCustomProfileZoneCode(String value) {
        return new JAXBElement<String>(_CustomProfileZoneCode_QNAME, String.class, CustomProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "ADUserID", scope = UserProfile.class)
    public JAXBElement<String> createUserProfileADUserID(String value) {
        return new JAXBElement<String>(_UserProfileADUserID_QNAME, String.class, UserProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "Address", scope = UserProfile.class)
    public JAXBElement<String> createUserProfileAddress(String value) {
        return new JAXBElement<String>(_UserProfileAddress_QNAME, String.class, UserProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "Department", scope = UserProfile.class)
    public JAXBElement<String> createUserProfileDepartment(String value) {
        return new JAXBElement<String>(_UserProfileDepartment_QNAME, String.class, UserProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "DisplayName", scope = UserProfile.class)
    public JAXBElement<String> createUserProfileDisplayName(String value) {
        return new JAXBElement<String>(_UserProfileDisplayName_QNAME, String.class, UserProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "Email", scope = UserProfile.class)
    public JAXBElement<String> createUserProfileEmail(String value) {
        return new JAXBElement<String>(_UserProfileEmail_QNAME, String.class, UserProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "EmployeeId", scope = UserProfile.class)
    public JAXBElement<String> createUserProfileEmployeeId(String value) {
        return new JAXBElement<String>(_UserProfileEmployeeId_QNAME, String.class, UserProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "FCUBSUserID", scope = UserProfile.class)
    public JAXBElement<String> createUserProfileFCUBSUserID(String value) {
        return new JAXBElement<String>(_UserProfileFCUBSUserID_QNAME, String.class, UserProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "FirstName", scope = UserProfile.class)
    public JAXBElement<String> createUserProfileFirstName(String value) {
        return new JAXBElement<String>(_UserProfileFirstName_QNAME, String.class, UserProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "GradeLevel", scope = UserProfile.class)
    public JAXBElement<String> createUserProfileGradeLevel(String value) {
        return new JAXBElement<String>(_UserProfileGradeLevel_QNAME, String.class, UserProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "Initials", scope = UserProfile.class)
    public JAXBElement<String> createUserProfileInitials(String value) {
        return new JAXBElement<String>(_UserProfileInitials_QNAME, String.class, UserProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "JobTitle", scope = UserProfile.class)
    public JAXBElement<String> createUserProfileJobTitle(String value) {
        return new JAXBElement<String>(_UserProfileJobTitle_QNAME, String.class, UserProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "LastName", scope = UserProfile.class)
    public JAXBElement<String> createUserProfileLastName(String value) {
        return new JAXBElement<String>(_UserProfileLastName_QNAME, String.class, UserProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "MobileNumber", scope = UserProfile.class)
    public JAXBElement<String> createUserProfileMobileNumber(String value) {
        return new JAXBElement<String>(_UserProfileMobileNumber_QNAME, String.class, UserProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "TelephoneNumber", scope = UserProfile.class)
    public JAXBElement<String> createUserProfileTelephoneNumber(String value) {
        return new JAXBElement<String>(_UserProfileTelephoneNumber_QNAME, String.class, UserProfile.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", name = "Description", scope = Response.class)
    public JAXBElement<String> createResponseDescription(String value) {
        return new JAXBElement<String>(_ResponseDescription_QNAME, String.class, Response.class, value);
    }

}
