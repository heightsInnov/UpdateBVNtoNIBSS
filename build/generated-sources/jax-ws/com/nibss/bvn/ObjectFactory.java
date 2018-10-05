
package com.nibss.bvn;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.nibss.bvn package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _VerifyMultipleBVNs_QNAME = new QName("http://validation.bvn.nibss.com/", "verifyMultipleBVNs");
    private final static QName _VerifyMultipleBVNsResponse_QNAME = new QName("http://validation.bvn.nibss.com/", "verifyMultipleBVNsResponse");
    private final static QName _VerifySingleBVN_QNAME = new QName("http://validation.bvn.nibss.com/", "verifySingleBVN");
    private final static QName _VerifySingleBVNResponse_QNAME = new QName("http://validation.bvn.nibss.com/", "verifySingleBVNResponse");
    private final static QName _Exception_QNAME = new QName("http://validation.bvn.nibss.com/", "Exception");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.nibss.bvn
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link VerifyMultipleBVNs }
     * 
     */
    public VerifyMultipleBVNs createVerifyMultipleBVNs() {
        return new VerifyMultipleBVNs();
    }

    /**
     * Create an instance of {@link VerifyMultipleBVNsResponse }
     * 
     */
    public VerifyMultipleBVNsResponse createVerifyMultipleBVNsResponse() {
        return new VerifyMultipleBVNsResponse();
    }

    /**
     * Create an instance of {@link VerifySingleBVN }
     * 
     */
    public VerifySingleBVN createVerifySingleBVN() {
        return new VerifySingleBVN();
    }

    /**
     * Create an instance of {@link VerifySingleBVNResponse }
     * 
     */
    public VerifySingleBVNResponse createVerifySingleBVNResponse() {
        return new VerifySingleBVNResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifyMultipleBVNs }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://validation.bvn.nibss.com/", name = "verifyMultipleBVNs")
    public JAXBElement<VerifyMultipleBVNs> createVerifyMultipleBVNs(VerifyMultipleBVNs value) {
        return new JAXBElement<VerifyMultipleBVNs>(_VerifyMultipleBVNs_QNAME, VerifyMultipleBVNs.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifyMultipleBVNsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://validation.bvn.nibss.com/", name = "verifyMultipleBVNsResponse")
    public JAXBElement<VerifyMultipleBVNsResponse> createVerifyMultipleBVNsResponse(VerifyMultipleBVNsResponse value) {
        return new JAXBElement<VerifyMultipleBVNsResponse>(_VerifyMultipleBVNsResponse_QNAME, VerifyMultipleBVNsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifySingleBVN }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://validation.bvn.nibss.com/", name = "verifySingleBVN")
    public JAXBElement<VerifySingleBVN> createVerifySingleBVN(VerifySingleBVN value) {
        return new JAXBElement<VerifySingleBVN>(_VerifySingleBVN_QNAME, VerifySingleBVN.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link VerifySingleBVNResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://validation.bvn.nibss.com/", name = "verifySingleBVNResponse")
    public JAXBElement<VerifySingleBVNResponse> createVerifySingleBVNResponse(VerifySingleBVNResponse value) {
        return new JAXBElement<VerifySingleBVNResponse>(_VerifySingleBVNResponse_QNAME, VerifySingleBVNResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://validation.bvn.nibss.com/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

}
