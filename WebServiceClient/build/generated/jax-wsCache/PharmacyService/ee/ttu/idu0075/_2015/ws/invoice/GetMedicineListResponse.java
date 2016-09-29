
package ee.ttu.idu0075._2015.ws.invoice;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="medicine" type="{http://www.ttu.ee/idu0075/2015/ws/invoice}medicineType" maxOccurs="unbounded" minOccurs="0"/>
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
    "medicine"
})
@XmlRootElement(name = "getMedicineListResponse")
public class GetMedicineListResponse {

    protected List<MedicineType> medicine;

    /**
     * Gets the value of the medicine property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the medicine property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMedicine().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link MedicineType }
     * 
     * 
     */
    public List<MedicineType> getMedicine() {
        if (medicine == null) {
            medicine = new ArrayList<MedicineType>();
        }
        return this.medicine;
    }

}
