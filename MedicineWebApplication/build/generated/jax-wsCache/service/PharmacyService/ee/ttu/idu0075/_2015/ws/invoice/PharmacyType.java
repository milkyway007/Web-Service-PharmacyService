
package ee.ttu.idu0075._2015.ws.invoice;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for pharmacyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="pharmacyType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="address" type="{http://www.ttu.ee/idu0075/2015/ws/invoice}addressType"/&gt;
 *         &lt;element name="manager" type="{http://www.ttu.ee/idu0075/2015/ws/invoice}personType"/&gt;
 *         &lt;element name="class" type="{http://www.ttu.ee/idu0075/2015/ws/invoice}classType" minOccurs="0"/&gt;
 *         &lt;element name="moneyAmount" type="{http://www.ttu.ee/idu0075/2015/ws/invoice}decimalType"/&gt;
 *         &lt;element name="pharmacyMedicineList" type="{http://www.ttu.ee/idu0075/2015/ws/invoice}pharmacyMedicineListType"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pharmacyType", propOrder = {
    "id",
    "name",
    "address",
    "manager",
    "clazz",
    "moneyAmount",
    "pharmacyMedicineList"
})
public class PharmacyType {

    @XmlElement(required = true)
    protected BigInteger id;
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected AddressType address;
    @XmlElement(required = true)
    protected PersonType manager;
    @XmlElement(name = "class")
    @XmlSchemaType(name = "string")
    protected ClassType clazz;
    @XmlElement(required = true)
    protected BigDecimal moneyAmount;
    @XmlElement(required = true)
    protected PharmacyMedicineListType pharmacyMedicineList;

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
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link AddressType }
     *     
     */
    public AddressType getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *     
     */
    public void setAddress(AddressType value) {
        this.address = value;
    }

    /**
     * Gets the value of the manager property.
     * 
     * @return
     *     possible object is
     *     {@link PersonType }
     *     
     */
    public PersonType getManager() {
        return manager;
    }

    /**
     * Sets the value of the manager property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonType }
     *     
     */
    public void setManager(PersonType value) {
        this.manager = value;
    }

    /**
     * Gets the value of the clazz property.
     * 
     * @return
     *     possible object is
     *     {@link ClassType }
     *     
     */
    public ClassType getClazz() {
        return clazz;
    }

    /**
     * Sets the value of the clazz property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassType }
     *     
     */
    public void setClazz(ClassType value) {
        this.clazz = value;
    }

    /**
     * Gets the value of the moneyAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMoneyAmount() {
        return moneyAmount;
    }

    /**
     * Sets the value of the moneyAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMoneyAmount(BigDecimal value) {
        this.moneyAmount = value;
    }

    /**
     * Gets the value of the pharmacyMedicineList property.
     * 
     * @return
     *     possible object is
     *     {@link PharmacyMedicineListType }
     *     
     */
    public PharmacyMedicineListType getPharmacyMedicineList() {
        return pharmacyMedicineList;
    }

    /**
     * Sets the value of the pharmacyMedicineList property.
     * 
     * @param value
     *     allowed object is
     *     {@link PharmacyMedicineListType }
     *     
     */
    public void setPharmacyMedicineList(PharmacyMedicineListType value) {
        this.pharmacyMedicineList = value;
    }

}
