
package tps.bpel.pingpong;

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
 *         &lt;element name="echoInputReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "echoInputReturn"
})
@XmlRootElement(name = "echoInputResponse")
public class EchoInputResponse {

    @XmlElement(required = true)
    protected String echoInputReturn;

    /**
     * Gets the value of the echoInputReturn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEchoInputReturn() {
        return echoInputReturn;
    }

    /**
     * Sets the value of the echoInputReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEchoInputReturn(String value) {
        this.echoInputReturn = value;
    }

}
