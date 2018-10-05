
package com.unionbank.ADService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for Module complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Module"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="_x003C_ClientIp_x003E_k__BackingField" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="_x003C_CreatedBy_x003E_k__BackingField" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="_x003C_DateCreated_x003E_k__BackingField" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="_x003C_DateUpdated_x003E_k__BackingField" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *         &lt;element name="_x003C_InHouse_x003E_k__BackingField" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="_x003C_IsEnabled_x003E_k__BackingField" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="_x003C_ModuleDesc_x003E_k__BackingField" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="_x003C_ModuleId_x003E_k__BackingField" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="_x003C_Owner_x003E_k__BackingField" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="_x003C_TwoFactorClassId_x003E_k__BackingField" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="_x003C_UpdatedBy_x003E_k__BackingField" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="_x003C_Xguid_x003E_k__BackingField" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Module", namespace = "http://schemas.datacontract.org/2004/07/UBN.AuthenticationViaAD.Cls", propOrder = {
    "x003CClientIpX003EKBackingField",
    "x003CCreatedByX003EKBackingField",
    "x003CDateCreatedX003EKBackingField",
    "x003CDateUpdatedX003EKBackingField",
    "x003CInHouseX003EKBackingField",
    "x003CIsEnabledX003EKBackingField",
    "x003CModuleDescX003EKBackingField",
    "x003CModuleIdX003EKBackingField",
    "x003COwnerX003EKBackingField",
    "x003CTwoFactorClassIdX003EKBackingField",
    "x003CUpdatedByX003EKBackingField",
    "x003CXguidX003EKBackingField"
})
public class Module {

    @XmlElement(name = "_x003C_ClientIp_x003E_k__BackingField", required = true, nillable = true)
    protected String x003CClientIpX003EKBackingField;
    @XmlElement(name = "_x003C_CreatedBy_x003E_k__BackingField", required = true, nillable = true)
    protected String x003CCreatedByX003EKBackingField;
    @XmlElement(name = "_x003C_DateCreated_x003E_k__BackingField", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar x003CDateCreatedX003EKBackingField;
    @XmlElement(name = "_x003C_DateUpdated_x003E_k__BackingField", required = true, nillable = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar x003CDateUpdatedX003EKBackingField;
    @XmlElement(name = "_x003C_InHouse_x003E_k__BackingField", required = true, nillable = true)
    protected String x003CInHouseX003EKBackingField;
    @XmlElement(name = "_x003C_IsEnabled_x003E_k__BackingField", required = true, nillable = true)
    protected String x003CIsEnabledX003EKBackingField;
    @XmlElement(name = "_x003C_ModuleDesc_x003E_k__BackingField", required = true, nillable = true)
    protected String x003CModuleDescX003EKBackingField;
    @XmlElement(name = "_x003C_ModuleId_x003E_k__BackingField", required = true, nillable = true)
    protected String x003CModuleIdX003EKBackingField;
    @XmlElement(name = "_x003C_Owner_x003E_k__BackingField", required = true, nillable = true)
    protected String x003COwnerX003EKBackingField;
    @XmlElement(name = "_x003C_TwoFactorClassId_x003E_k__BackingField", required = true, nillable = true)
    protected String x003CTwoFactorClassIdX003EKBackingField;
    @XmlElement(name = "_x003C_UpdatedBy_x003E_k__BackingField", required = true, nillable = true)
    protected String x003CUpdatedByX003EKBackingField;
    @XmlElement(name = "_x003C_Xguid_x003E_k__BackingField", required = true, nillable = true)
    protected String x003CXguidX003EKBackingField;

    /**
     * Gets the value of the x003CClientIpX003EKBackingField property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getX003CClientIpX003EKBackingField() {
        return x003CClientIpX003EKBackingField;
    }

    /**
     * Sets the value of the x003CClientIpX003EKBackingField property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setX003CClientIpX003EKBackingField(String value) {
        this.x003CClientIpX003EKBackingField = value;
    }

    /**
     * Gets the value of the x003CCreatedByX003EKBackingField property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getX003CCreatedByX003EKBackingField() {
        return x003CCreatedByX003EKBackingField;
    }

    /**
     * Sets the value of the x003CCreatedByX003EKBackingField property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setX003CCreatedByX003EKBackingField(String value) {
        this.x003CCreatedByX003EKBackingField = value;
    }

    /**
     * Gets the value of the x003CDateCreatedX003EKBackingField property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getX003CDateCreatedX003EKBackingField() {
        return x003CDateCreatedX003EKBackingField;
    }

    /**
     * Sets the value of the x003CDateCreatedX003EKBackingField property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setX003CDateCreatedX003EKBackingField(XMLGregorianCalendar value) {
        this.x003CDateCreatedX003EKBackingField = value;
    }

    /**
     * Gets the value of the x003CDateUpdatedX003EKBackingField property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getX003CDateUpdatedX003EKBackingField() {
        return x003CDateUpdatedX003EKBackingField;
    }

    /**
     * Sets the value of the x003CDateUpdatedX003EKBackingField property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setX003CDateUpdatedX003EKBackingField(XMLGregorianCalendar value) {
        this.x003CDateUpdatedX003EKBackingField = value;
    }

    /**
     * Gets the value of the x003CInHouseX003EKBackingField property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getX003CInHouseX003EKBackingField() {
        return x003CInHouseX003EKBackingField;
    }

    /**
     * Sets the value of the x003CInHouseX003EKBackingField property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setX003CInHouseX003EKBackingField(String value) {
        this.x003CInHouseX003EKBackingField = value;
    }

    /**
     * Gets the value of the x003CIsEnabledX003EKBackingField property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getX003CIsEnabledX003EKBackingField() {
        return x003CIsEnabledX003EKBackingField;
    }

    /**
     * Sets the value of the x003CIsEnabledX003EKBackingField property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setX003CIsEnabledX003EKBackingField(String value) {
        this.x003CIsEnabledX003EKBackingField = value;
    }

    /**
     * Gets the value of the x003CModuleDescX003EKBackingField property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getX003CModuleDescX003EKBackingField() {
        return x003CModuleDescX003EKBackingField;
    }

    /**
     * Sets the value of the x003CModuleDescX003EKBackingField property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setX003CModuleDescX003EKBackingField(String value) {
        this.x003CModuleDescX003EKBackingField = value;
    }

    /**
     * Gets the value of the x003CModuleIdX003EKBackingField property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getX003CModuleIdX003EKBackingField() {
        return x003CModuleIdX003EKBackingField;
    }

    /**
     * Sets the value of the x003CModuleIdX003EKBackingField property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setX003CModuleIdX003EKBackingField(String value) {
        this.x003CModuleIdX003EKBackingField = value;
    }

    /**
     * Gets the value of the x003COwnerX003EKBackingField property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getX003COwnerX003EKBackingField() {
        return x003COwnerX003EKBackingField;
    }

    /**
     * Sets the value of the x003COwnerX003EKBackingField property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setX003COwnerX003EKBackingField(String value) {
        this.x003COwnerX003EKBackingField = value;
    }

    /**
     * Gets the value of the x003CTwoFactorClassIdX003EKBackingField property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getX003CTwoFactorClassIdX003EKBackingField() {
        return x003CTwoFactorClassIdX003EKBackingField;
    }

    /**
     * Sets the value of the x003CTwoFactorClassIdX003EKBackingField property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setX003CTwoFactorClassIdX003EKBackingField(String value) {
        this.x003CTwoFactorClassIdX003EKBackingField = value;
    }

    /**
     * Gets the value of the x003CUpdatedByX003EKBackingField property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getX003CUpdatedByX003EKBackingField() {
        return x003CUpdatedByX003EKBackingField;
    }

    /**
     * Sets the value of the x003CUpdatedByX003EKBackingField property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setX003CUpdatedByX003EKBackingField(String value) {
        this.x003CUpdatedByX003EKBackingField = value;
    }

    /**
     * Gets the value of the x003CXguidX003EKBackingField property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getX003CXguidX003EKBackingField() {
        return x003CXguidX003EKBackingField;
    }

    /**
     * Sets the value of the x003CXguidX003EKBackingField property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setX003CXguidX003EKBackingField(String value) {
        this.x003CXguidX003EKBackingField = value;
    }

}
