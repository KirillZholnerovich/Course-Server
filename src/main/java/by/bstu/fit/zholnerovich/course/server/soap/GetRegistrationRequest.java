
package by.bstu.fit.zholnerovich.course.server.soap;

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
 *         &lt;element name="registreringUser" type="{http://bstu.by/fit/zholnerovich/course/server/soap}registreringUser"/>
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
    "registreringUser"
})
@XmlRootElement(name = "getRegistrationRequest", namespace = "http://bstu.by/fit/zholnerovich/course/server/soap")
public class GetRegistrationRequest {

    @XmlElement(namespace = "http://bstu.by/fit/zholnerovich/course/server/soap", required = true)
    protected RegistreringUser registreringUser;

    /**
     * Gets the value of the registreringUser property.
     * 
     * @return
     *     possible object is
     *     {@link RegistreringUser }
     *     
     */
    public RegistreringUser getRegistreringUser() {
        return registreringUser;
    }

    /**
     * Sets the value of the registreringUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link RegistreringUser }
     *     
     */
    public void setRegistreringUser(RegistreringUser value) {
        this.registreringUser = value;
    }

}
