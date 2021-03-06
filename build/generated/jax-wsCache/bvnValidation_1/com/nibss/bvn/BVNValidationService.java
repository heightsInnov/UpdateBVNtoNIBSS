
package com.nibss.bvn;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "BVNValidationService", targetNamespace = "http://validation.bvn.nibss.com/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface BVNValidationService {


    /**
     * 
     * @param bankCode
     * @param bvn
     * @return
     *     returns java.lang.String
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(name = "searchResult", targetNamespace = "")
    @RequestWrapper(localName = "verifySingleBVN", targetNamespace = "http://validation.bvn.nibss.com/", className = "com.nibss.bvn.VerifySingleBVN")
    @ResponseWrapper(localName = "verifySingleBVNResponse", targetNamespace = "http://validation.bvn.nibss.com/", className = "com.nibss.bvn.VerifySingleBVNResponse")
    public String verifySingleBVN(
        @WebParam(name = "BVN", targetNamespace = "")
        String bvn,
        @WebParam(name = "bankCode", targetNamespace = "")
        String bankCode)
        throws Exception_Exception
    ;

    /**
     * 
     * @param bankCode
     * @param bvNs
     * @return
     *     returns java.lang.String
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(name = "searchResults", targetNamespace = "")
    @RequestWrapper(localName = "verifyMultipleBVNs", targetNamespace = "http://validation.bvn.nibss.com/", className = "com.nibss.bvn.VerifyMultipleBVNs")
    @ResponseWrapper(localName = "verifyMultipleBVNsResponse", targetNamespace = "http://validation.bvn.nibss.com/", className = "com.nibss.bvn.VerifyMultipleBVNsResponse")
    public String verifyMultipleBVNs(
        @WebParam(name = "BVNs", targetNamespace = "")
        String bvNs,
        @WebParam(name = "bankCode", targetNamespace = "")
        String bankCode)
        throws Exception_Exception
    ;

}
