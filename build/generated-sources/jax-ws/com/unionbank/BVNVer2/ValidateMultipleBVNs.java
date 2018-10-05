
package com.unionbank.BVNVer2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for validateMultipleBVNs complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="validateMultipleBVNs"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SearchInputs" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "validateMultipleBVNs", propOrder = {
    "searchInputs"
})
public class ValidateMultipleBVNs {

    @XmlElement(name = "SearchInputs")
    protected String searchInputs;

    /**
     * Gets the value of the searchInputs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchInputs() {
        return searchInputs;
    }

    /**
     * Sets the value of the searchInputs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchInputs(String value) {
        this.searchInputs = value;
    }

}
