//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.02.08 at 09:50:36 AM EAT 
//


package com.techprimers.spring_boot_soap_example;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userObject" type="{http://techprimers.com/spring-boot-soap-example}userObject"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "userObject"
})
@XmlRootElement(name = "registerUser")
public class RegisterUser {

    @XmlElement(required = true)
    protected UserObject userObject;

    /**
     * Gets the value of the userObject property.
     * 
     * @return
     *     possible object is
     *     {@link UserObject }
     *     
     */
    public UserObject getUserObject() {
        return userObject;
    }

    /**
     * Sets the value of the userObject property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserObject }
     *     
     */
    public void setUserObject(UserObject value) {
        this.userObject = value;
    }

}
