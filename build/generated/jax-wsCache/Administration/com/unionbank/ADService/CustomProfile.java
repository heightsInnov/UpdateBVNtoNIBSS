
package com.unionbank.ADService;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for CustomProfile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CustomProfile"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="BranchCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="BranchName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="IsActive" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="LimitAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="Misc1" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="Misc2" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="Misc3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Misc4" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="OrgID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="OtherInfo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="SortCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="TillAccountNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="UserAccessMode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ZoneCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CustomProfile", namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", propOrder = {
    "branchCode",
    "branchName",
    "isActive",
    "limitAmount",
    "misc1",
    "misc2",
    "misc3",
    "misc4",
    "orgID",
    "otherInfo",
    "sortCode",
    "tillAccountNo",
    "userAccessMode",
    "zoneCode"
})
@XmlSeeAlso({
    UserProfile.class
})
public class CustomProfile {

    @XmlElementRef(name = "BranchCode", namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", type = JAXBElement.class, required = false)
    protected JAXBElement<String> branchCode;
    @XmlElementRef(name = "BranchName", namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", type = JAXBElement.class, required = false)
    protected JAXBElement<String> branchName;
    @XmlElement(name = "IsActive")
    protected Boolean isActive;
    @XmlElement(name = "LimitAmount")
    protected BigDecimal limitAmount;
    @XmlElement(name = "Misc1")
    protected BigDecimal misc1;
    @XmlElement(name = "Misc2")
    protected Integer misc2;
    @XmlElementRef(name = "Misc3", namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", type = JAXBElement.class, required = false)
    protected JAXBElement<String> misc3;
    @XmlElement(name = "Misc4")
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar misc4;
    @XmlElementRef(name = "OrgID", namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", type = JAXBElement.class, required = false)
    protected JAXBElement<String> orgID;
    @XmlElementRef(name = "OtherInfo", namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", type = JAXBElement.class, required = false)
    protected JAXBElement<String> otherInfo;
    @XmlElementRef(name = "SortCode", namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sortCode;
    @XmlElementRef(name = "TillAccountNo", namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", type = JAXBElement.class, required = false)
    protected JAXBElement<String> tillAccountNo;
    @XmlElementRef(name = "UserAccessMode", namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", type = JAXBElement.class, required = false)
    protected JAXBElement<String> userAccessMode;
    @XmlElementRef(name = "ZoneCode", namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", type = JAXBElement.class, required = false)
    protected JAXBElement<String> zoneCode;

    /**
     * Gets the value of the branchCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBranchCode() {
        return branchCode;
    }

    /**
     * Sets the value of the branchCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBranchCode(JAXBElement<String> value) {
        this.branchCode = value;
    }

    /**
     * Gets the value of the branchName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBranchName() {
        return branchName;
    }

    /**
     * Sets the value of the branchName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBranchName(JAXBElement<String> value) {
        this.branchName = value;
    }

    /**
     * Gets the value of the isActive property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsActive() {
        return isActive;
    }

    /**
     * Sets the value of the isActive property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsActive(Boolean value) {
        this.isActive = value;
    }

    /**
     * Gets the value of the limitAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLimitAmount() {
        return limitAmount;
    }

    /**
     * Sets the value of the limitAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLimitAmount(BigDecimal value) {
        this.limitAmount = value;
    }

    /**
     * Gets the value of the misc1 property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMisc1() {
        return misc1;
    }

    /**
     * Sets the value of the misc1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMisc1(BigDecimal value) {
        this.misc1 = value;
    }

    /**
     * Gets the value of the misc2 property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMisc2() {
        return misc2;
    }

    /**
     * Sets the value of the misc2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMisc2(Integer value) {
        this.misc2 = value;
    }

    /**
     * Gets the value of the misc3 property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMisc3() {
        return misc3;
    }

    /**
     * Sets the value of the misc3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMisc3(JAXBElement<String> value) {
        this.misc3 = value;
    }

    /**
     * Gets the value of the misc4 property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMisc4() {
        return misc4;
    }

    /**
     * Sets the value of the misc4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMisc4(XMLGregorianCalendar value) {
        this.misc4 = value;
    }

    /**
     * Gets the value of the orgID property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOrgID() {
        return orgID;
    }

    /**
     * Sets the value of the orgID property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOrgID(JAXBElement<String> value) {
        this.orgID = value;
    }

    /**
     * Gets the value of the otherInfo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getOtherInfo() {
        return otherInfo;
    }

    /**
     * Sets the value of the otherInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setOtherInfo(JAXBElement<String> value) {
        this.otherInfo = value;
    }

    /**
     * Gets the value of the sortCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSortCode() {
        return sortCode;
    }

    /**
     * Sets the value of the sortCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSortCode(JAXBElement<String> value) {
        this.sortCode = value;
    }

    /**
     * Gets the value of the tillAccountNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTillAccountNo() {
        return tillAccountNo;
    }

    /**
     * Sets the value of the tillAccountNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTillAccountNo(JAXBElement<String> value) {
        this.tillAccountNo = value;
    }

    /**
     * Gets the value of the userAccessMode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUserAccessMode() {
        return userAccessMode;
    }

    /**
     * Sets the value of the userAccessMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUserAccessMode(JAXBElement<String> value) {
        this.userAccessMode = value;
    }

    /**
     * Gets the value of the zoneCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getZoneCode() {
        return zoneCode;
    }

    /**
     * Sets the value of the zoneCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setZoneCode(JAXBElement<String> value) {
        this.zoneCode = value;
    }

}
