
package ee.ttu.idu0075._2015.ws.invoice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for activeIngridientListType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="activeIngridientListType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="activeIngridient" type="{http://www.ttu.ee/idu0075/2015/ws/invoice}activeIngridientType" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "activeIngridientListType", propOrder = {
    "activeIngridient"
})
public class ActiveIngridientListType {

    @XmlElement(required = true)
    protected List<ActiveIngridientType> activeIngridient;

    /**
     * Gets the value of the activeIngridient property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the activeIngridient property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActiveIngridient().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ActiveIngridientType }
     * 
     * 
     */
    public List<ActiveIngridientType> getActiveIngridient() {
        if (activeIngridient == null) {
            activeIngridient = new ArrayList<ActiveIngridientType>();
        }
        return this.activeIngridient;
    }

}
