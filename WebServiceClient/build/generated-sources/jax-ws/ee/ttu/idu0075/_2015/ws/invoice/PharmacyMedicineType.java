
package ee.ttu.idu0075._2015.ws.invoice;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for pharmacyMedicineType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="pharmacyMedicineType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="medicine" type="{http://www.ttu.ee/idu0075/2015/ws/invoice}medicineType"/>
 *         &lt;element name="quantity" type="{http://www.ttu.ee/idu0075/2015/ws/invoice}decimalType"/>
 *         &lt;element name="unitPrice" type="{http://www.ttu.ee/idu0075/2015/ws/invoice}decimalType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pharmacyMedicineType", propOrder = {
    "id",
    "medicine",
    "quantity",
    "unitPrice"
})
public class PharmacyMedicineType {

    @XmlElement(required = true)
    protected BigInteger id;
    @XmlElement(required = true)
    protected MedicineType medicine;
    @XmlElement(required = true)
    protected BigDecimal quantity;
    @XmlElement(required = true)
    protected BigDecimal unitPrice;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setId(BigInteger value) {
        this.id = value;
    }

    /**
     * Gets the value of the medicine property.
     * 
     * @return
     *     possible object is
     *     {@link MedicineType }
     *     
     */
    public MedicineType getMedicine() {
        return medicine;
    }

    /**
     * Sets the value of the medicine property.
     * 
     * @param value
     *     allowed object is
     *     {@link MedicineType }
     *     
     */
    public void setMedicine(MedicineType value) {
        this.medicine = value;
    }

    /**
     * Gets the value of the quantity property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setQuantity(BigDecimal value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the unitPrice property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    /**
     * Sets the value of the unitPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUnitPrice(BigDecimal value) {
        this.unitPrice = value;
    }

}
