
package com.unionbank.BVNVer2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for validateSingleBVN complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="validateSingleBVN"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SearchInput" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "validateSingleBVN", propOrder = {
    "searchInput"
})
public class ValidateSingleBVN {

    @XmlElement(name = "SearchInput")
    protected String searchInput;

    /**
     * Gets the value of the searchInput property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSearchInput() {
        return searchInput;
    }

    /**
     * Sets the value of the searchInput property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSearchInput(String value) {
        this.searchInput = value;
    }

}
