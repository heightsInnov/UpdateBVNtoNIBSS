
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
 *         &lt;element name="n" type="{http://schemas.datacontract.org/2004/07/UBN.AuthenticationViaAD.Cls}ModuleMin" minOccurs="0"/&gt;
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
    "n"
})
@XmlRootElement(name = "AddModule")
public class AddModule {

    @XmlElementRef(name = "n", namespace = "http://applications.unionbankng.com/ws", type = JAXBElement.class, required = false)
    protected JAXBElement<ModuleMin> n;

    /**
     * Gets the value of the n property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ModuleMin }{@code >}
     *     
     */
    public JAXBElement<ModuleMin> getN() {
        return n;
    }

    /**
     * Sets the value of the n property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ModuleMin }{@code >}
     *     
     */
    public void setN(JAXBElement<ModuleMin> value) {
        this.n = value;
    }

}
