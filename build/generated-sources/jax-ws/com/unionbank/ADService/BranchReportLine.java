
package com.unionbank.ADService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for BranchReportLine complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BranchReportLine"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="_x003C_BdmEmail_x003E_k__BackingField" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="_x003C_BranchCode_x003E_k__BackingField" type="{http://www.w3.org/2001/XMLSchema}short"/&gt;
 *         &lt;element name="_x003C_CsoEmail_x003E_k__BackingField" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="_x003C_EdEmail_x003E_k__BackingField" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="_x003C_HboEmail_x003E_k__BackingField" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="_x003C_RgEmail_x003E_k__BackingField" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="_x003C_ZcEmail_x003E_k__BackingField" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="_x003C_ZoneName_x003E_k__BackingField" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BranchReportLine", namespace = "http://schemas.datacontract.org/2004/07/UBN.AuthenticationViaAD.Cls", propOrder = {
    "x003CBdmEmailX003EKBackingField",
    "x003CBranchCodeX003EKBackingField",
    "x003CCsoEmailX003EKBackingField",
    "x003CEdEmailX003EKBackingField",
    "x003CHboEmailX003EKBackingField",
    "x003CRgEmailX003EKBackingField",
    "x003CZcEmailX003EKBackingField",
    "x003CZoneNameX003EKBackingField"
})
public class BranchReportLine {

    @XmlElement(name = "_x003C_BdmEmail_x003E_k__BackingField", required = true, nillable = true)
    protected String x003CBdmEmailX003EKBackingField;
    @XmlElement(name = "_x003C_BranchCode_x003E_k__BackingField")
    protected short x003CBranchCodeX003EKBackingField;
    @XmlElement(name = "_x003C_CsoEmail_x003E_k__BackingField", required = true, nillable = true)
    protected String x003CCsoEmailX003EKBackingField;
    @XmlElement(name = "_x003C_EdEmail_x003E_k__BackingField", required = true, nillable = true)
    protected String x003CEdEmailX003EKBackingField;
    @XmlElement(name = "_x003C_HboEmail_x003E_k__BackingField", required = true, nillable = true)
    protected String x003CHboEmailX003EKBackingField;
    @XmlElement(name = "_x003C_RgEmail_x003E_k__BackingField", required = true, nillable = true)
    protected String x003CRgEmailX003EKBackingField;
    @XmlElement(name = "_x003C_ZcEmail_x003E_k__BackingField", required = true, nillable = true)
    protected String x003CZcEmailX003EKBackingField;
    @XmlElement(name = "_x003C_ZoneName_x003E_k__BackingField", required = true, nillable = true)
    protected String x003CZoneNameX003EKBackingField;

    /**
     * Gets the value of the x003CBdmEmailX003EKBackingField property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getX003CBdmEmailX003EKBackingField() {
        return x003CBdmEmailX003EKBackingField;
    }

    /**
     * Sets the value of the x003CBdmEmailX003EKBackingField property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setX003CBdmEmailX003EKBackingField(String value) {
        this.x003CBdmEmailX003EKBackingField = value;
    }

    /**
     * Gets the value of the x003CBranchCodeX003EKBackingField property.
     * 
     */
    public short getX003CBranchCodeX003EKBackingField() {
        return x003CBranchCodeX003EKBackingField;
    }

    /**
     * Sets the value of the x003CBranchCodeX003EKBackingField property.
     * 
     */
    public void setX003CBranchCodeX003EKBackingField(short value) {
        this.x003CBranchCodeX003EKBackingField = value;
    }

    /**
     * Gets the value of the x003CCsoEmailX003EKBackingField property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getX003CCsoEmailX003EKBackingField() {
        return x003CCsoEmailX003EKBackingField;
    }

    /**
     * Sets the value of the x003CCsoEmailX003EKBackingField property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setX003CCsoEmailX003EKBackingField(String value) {
        this.x003CCsoEmailX003EKBackingField = value;
    }

    /**
     * Gets the value of the x003CEdEmailX003EKBackingField property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getX003CEdEmailX003EKBackingField() {
        return x003CEdEmailX003EKBackingField;
    }

    /**
     * Sets the value of the x003CEdEmailX003EKBackingField property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setX003CEdEmailX003EKBackingField(String value) {
        this.x003CEdEmailX003EKBackingField = value;
    }

    /**
     * Gets the value of the x003CHboEmailX003EKBackingField property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getX003CHboEmailX003EKBackingField() {
        return x003CHboEmailX003EKBackingField;
    }

    /**
     * Sets the value of the x003CHboEmailX003EKBackingField property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setX003CHboEmailX003EKBackingField(String value) {
        this.x003CHboEmailX003EKBackingField = value;
    }

    /**
     * Gets the value of the x003CRgEmailX003EKBackingField property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getX003CRgEmailX003EKBackingField() {
        return x003CRgEmailX003EKBackingField;
    }

    /**
     * Sets the value of the x003CRgEmailX003EKBackingField property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setX003CRgEmailX003EKBackingField(String value) {
        this.x003CRgEmailX003EKBackingField = value;
    }

    /**
     * Gets the value of the x003CZcEmailX003EKBackingField property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getX003CZcEmailX003EKBackingField() {
        return x003CZcEmailX003EKBackingField;
    }

    /**
     * Sets the value of the x003CZcEmailX003EKBackingField property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setX003CZcEmailX003EKBackingField(String value) {
        this.x003CZcEmailX003EKBackingField = value;
    }

    /**
     * Gets the value of the x003CZoneNameX003EKBackingField property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getX003CZoneNameX003EKBackingField() {
        return x003CZoneNameX003EKBackingField;
    }

    /**
     * Sets the value of the x003CZoneNameX003EKBackingField property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setX003CZoneNameX003EKBackingField(String value) {
        this.x003CZoneNameX003EKBackingField = value;
    }

}
