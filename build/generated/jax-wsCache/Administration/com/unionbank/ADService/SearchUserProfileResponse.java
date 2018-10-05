
package com.unionbank.ADService;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SearchUserProfileResult" type="{http://schemas.datacontract.org/2004/07/UBN.Security.Sms}ArrayOfUserProfile" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "searchUserProfileResult"
})
@XmlRootElement(name = "SearchUserProfileResponse")
public class SearchUserProfileResponse {

    @XmlElementRef(name = "SearchUserProfileResult", namespace = "http://applications.unionbankng.com/ws", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfUserProfile> searchUserProfileResult;

    /**
     * Gets the value of the searchUserProfileResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfUserProfile }{@code >}
     *     
     */
    public JAXBElement<ArrayOfUserProfile> getSearchUserProfileResult() {
        return searchUserProfileResult;
    }

    /**
     * Sets the value of the searchUserProfileResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfUserProfile }{@code >}
     *     
     */
    public void setSearchUserProfileResult(JAXBElement<ArrayOfUserProfile> value) {
        this.searchUserProfileResult = value;
    }

}
