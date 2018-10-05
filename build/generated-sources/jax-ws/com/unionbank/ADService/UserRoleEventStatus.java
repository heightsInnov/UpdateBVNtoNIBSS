
package com.unionbank.ADService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for UserRoleEventStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserRoleEventStatus"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ApplicationName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="CheckerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="DateAuthorized" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="DateCreated" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="EventId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="MakerId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RoleId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RoleName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserRoleEventStatus", namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", propOrder = {
    "applicationName",
    "checkerId",
    "dateAuthorized",
    "dateCreated",
    "eventId",
    "makerId",
    "roleId",
    "roleName",
    "status",
    "username"
})
public class UserRoleEventStatus {

    @XmlElementRef(name = "ApplicationName", namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", type = JAXBElement.class, required = false)
    protected JAXBElement<String> applicationName;
    @XmlElementRef(name = "CheckerId", namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", type = JAXBElement.class, required = false)
    protected JAXBElement<String> checkerId;
    @XmlElementRef(name = "DateAuthorized", namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> dateAuthorized;
    @XmlElementRef(name = "DateCreated", namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", type = JAXBElement.class, required = false)
    protected JAXBElement<XMLGregorianCalendar> dateCreated;
    @XmlElementRef(name = "EventId", namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", type = JAXBElement.class, required = false)
    protected JAXBElement<String> eventId;
    @XmlElementRef(name = "MakerId", namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", type = JAXBElement.class, required = false)
    protected JAXBElement<String> makerId;
    @XmlElementRef(name = "RoleId", namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", type = JAXBElement.class, required = false)
    protected JAXBElement<String> roleId;
    @XmlElementRef(name = "RoleName", namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", type = JAXBElement.class, required = false)
    protected JAXBElement<String> roleName;
    @XmlElementRef(name = "Status", namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", type = JAXBElement.class, required = false)
    protected JAXBElement<String> status;
    @XmlElementRef(name = "Username", namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", type = JAXBElement.class, required = false)
    protected JAXBElement<String> username;

    /**
     * Gets the value of the applicationName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getApplicationName() {
        return applicationName;
    }

    /**
     * Sets the value of the applicationName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setApplicationName(JAXBElement<String> value) {
        this.applicationName = value;
    }

    /**
     * Gets the value of the checkerId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCheckerId() {
        return checkerId;
    }

    /**
     * Sets the value of the checkerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCheckerId(JAXBElement<String> value) {
        this.checkerId = value;
    }

    /**
     * Gets the value of the dateAuthorized property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDateAuthorized() {
        return dateAuthorized;
    }

    /**
     * Sets the value of the dateAuthorized property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDateAuthorized(JAXBElement<XMLGregorianCalendar> value) {
        this.dateAuthorized = value;
    }

    /**
     * Gets the value of the dateCreated property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getDateCreated() {
        return dateCreated;
    }

    /**
     * Sets the value of the dateCreated property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setDateCreated(JAXBElement<XMLGregorianCalendar> value) {
        this.dateCreated = value;
    }

    /**
     * Gets the value of the eventId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEventId() {
        return eventId;
    }

    /**
     * Sets the value of the eventId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEventId(JAXBElement<String> value) {
        this.eventId = value;
    }

    /**
     * Gets the value of the makerId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMakerId() {
        return makerId;
    }

    /**
     * Sets the value of the makerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMakerId(JAXBElement<String> value) {
        this.makerId = value;
    }

    /**
     * Gets the value of the roleId property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRoleId() {
        return roleId;
    }

    /**
     * Sets the value of the roleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRoleId(JAXBElement<String> value) {
        this.roleId = value;
    }

    /**
     * Gets the value of the roleName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRoleName() {
        return roleName;
    }

    /**
     * Sets the value of the roleName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRoleName(JAXBElement<String> value) {
        this.roleName = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStatus(JAXBElement<String> value) {
        this.status = value;
    }

    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUsername(JAXBElement<String> value) {
        this.username = value;
    }

}
