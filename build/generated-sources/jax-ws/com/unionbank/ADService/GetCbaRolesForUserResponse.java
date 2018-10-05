
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
 *         &lt;element name="GetCbaRolesForUserResult" type="{http://schemas.microsoft.com/2003/10/Serialization/Arrays}ArrayOfstring" minOccurs="0"/&gt;
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
    "getCbaRolesForUserResult"
})
@XmlRootElement(name = "GetCbaRolesForUserResponse")
public class GetCbaRolesForUserResponse {

    @XmlElementRef(name = "GetCbaRolesForUserResult", namespace = "http://applications.unionbankng.com/ws", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfstring> getCbaRolesForUserResult;

    /**
     * Gets the value of the getCbaRolesForUserResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public JAXBElement<ArrayOfstring> getGetCbaRolesForUserResult() {
        return getCbaRolesForUserResult;
    }

    /**
     * Sets the value of the getCbaRolesForUserResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfstring }{@code >}
     *     
     */
    public void setGetCbaRolesForUserResult(JAXBElement<ArrayOfstring> value) {
        this.getCbaRolesForUserResult = value;
    }

}
