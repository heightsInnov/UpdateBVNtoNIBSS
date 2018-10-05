
package com.unionbank.ADService;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ArrayOfUserRoleEventStatus complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfUserRoleEventStatus"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="UserRoleEventStatus" type="{http://schemas.datacontract.org/2004/07/UBN.Security.Sms}UserRoleEventStatus" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfUserRoleEventStatus", namespace = "http://schemas.datacontract.org/2004/07/UBN.Security.Sms", propOrder = {
    "userRoleEventStatus"
})
public class ArrayOfUserRoleEventStatus {

    @XmlElement(name = "UserRoleEventStatus", nillable = true)
    protected List<UserRoleEventStatus> userRoleEventStatus;

    /**
     * Gets the value of the userRoleEventStatus property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the userRoleEventStatus property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUserRoleEventStatus().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UserRoleEventStatus }
     * 
     * 
     */
    public List<UserRoleEventStatus> getUserRoleEventStatus() {
        if (userRoleEventStatus == null) {
            userRoleEventStatus = new ArrayList<UserRoleEventStatus>();
        }
        return this.userRoleEventStatus;
    }

}
