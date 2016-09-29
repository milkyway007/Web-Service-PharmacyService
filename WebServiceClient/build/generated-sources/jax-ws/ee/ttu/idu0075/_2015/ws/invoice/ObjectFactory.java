
package ee.ttu.idu0075._2015.ws.invoice;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ee.ttu.idu0075._2015.ws.invoice package. 
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

    private final static QName _AddPharmacyResponse_QNAME = new QName("http://www.ttu.ee/idu0075/2015/ws/invoice", "addPharmacyResponse");
    private final static QName _AddMedicineResponse_QNAME = new QName("http://www.ttu.ee/idu0075/2015/ws/invoice", "addMedicineResponse");
    private final static QName _AddPharmacyMedicineResponse_QNAME = new QName("http://www.ttu.ee/idu0075/2015/ws/invoice", "addPharmacyMedicineResponse");
    private final static QName _GetPharmacyMedicineListResponse_QNAME = new QName("http://www.ttu.ee/idu0075/2015/ws/invoice", "getPharmacyMedicineListResponse");
    private final static QName _GetPharmacyResponse_QNAME = new QName("http://www.ttu.ee/idu0075/2015/ws/invoice", "getPharmacyResponse");
    private final static QName _GetMedicineResponse_QNAME = new QName("http://www.ttu.ee/idu0075/2015/ws/invoice", "getMedicineResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ee.ttu.idu0075._2015.ws.invoice
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PharmacyType }
     * 
     */
    public PharmacyType createPharmacyType() {
        return new PharmacyType();
    }

    /**
     * Create an instance of {@link GetPharmacyListResponse }
     * 
     */
    public GetPharmacyListResponse createGetPharmacyListResponse() {
        return new GetPharmacyListResponse();
    }

    /**
     * Create an instance of {@link AddPharmacyMedicineRequest }
     * 
     */
    public AddPharmacyMedicineRequest createAddPharmacyMedicineRequest() {
        return new AddPharmacyMedicineRequest();
    }

    /**
     * Create an instance of {@link AddMedicineRequest }
     * 
     */
    public AddMedicineRequest createAddMedicineRequest() {
        return new AddMedicineRequest();
    }

    /**
     * Create an instance of {@link ActiveIngridientListType }
     * 
     */
    public ActiveIngridientListType createActiveIngridientListType() {
        return new ActiveIngridientListType();
    }

    /**
     * Create an instance of {@link SizeType }
     * 
     */
    public SizeType createSizeType() {
        return new SizeType();
    }

    /**
     * Create an instance of {@link MedicineType }
     * 
     */
    public MedicineType createMedicineType() {
        return new MedicineType();
    }

    /**
     * Create an instance of {@link GetPharmacyMedicineListRequest }
     * 
     */
    public GetPharmacyMedicineListRequest createGetPharmacyMedicineListRequest() {
        return new GetPharmacyMedicineListRequest();
    }

    /**
     * Create an instance of {@link PharmacyMedicineType }
     * 
     */
    public PharmacyMedicineType createPharmacyMedicineType() {
        return new PharmacyMedicineType();
    }

    /**
     * Create an instance of {@link GetMedicineRequest }
     * 
     */
    public GetMedicineRequest createGetMedicineRequest() {
        return new GetMedicineRequest();
    }

    /**
     * Create an instance of {@link GetPharmacyListRequest }
     * 
     */
    public GetPharmacyListRequest createGetPharmacyListRequest() {
        return new GetPharmacyListRequest();
    }

    /**
     * Create an instance of {@link AddPharmacyRequest }
     * 
     */
    public AddPharmacyRequest createAddPharmacyRequest() {
        return new AddPharmacyRequest();
    }

    /**
     * Create an instance of {@link AddressType }
     * 
     */
    public AddressType createAddressType() {
        return new AddressType();
    }

    /**
     * Create an instance of {@link PersonType }
     * 
     */
    public PersonType createPersonType() {
        return new PersonType();
    }

    /**
     * Create an instance of {@link GetMedicineListResponse }
     * 
     */
    public GetMedicineListResponse createGetMedicineListResponse() {
        return new GetMedicineListResponse();
    }

    /**
     * Create an instance of {@link GetPharmacyRequest }
     * 
     */
    public GetPharmacyRequest createGetPharmacyRequest() {
        return new GetPharmacyRequest();
    }

    /**
     * Create an instance of {@link PharmacyMedicineListType }
     * 
     */
    public PharmacyMedicineListType createPharmacyMedicineListType() {
        return new PharmacyMedicineListType();
    }

    /**
     * Create an instance of {@link GetMedicineListRequest }
     * 
     */
    public GetMedicineListRequest createGetMedicineListRequest() {
        return new GetMedicineListRequest();
    }

    /**
     * Create an instance of {@link ActiveIngridientType }
     * 
     */
    public ActiveIngridientType createActiveIngridientType() {
        return new ActiveIngridientType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PharmacyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ttu.ee/idu0075/2015/ws/invoice", name = "addPharmacyResponse")
    public JAXBElement<PharmacyType> createAddPharmacyResponse(PharmacyType value) {
        return new JAXBElement<PharmacyType>(_AddPharmacyResponse_QNAME, PharmacyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MedicineType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ttu.ee/idu0075/2015/ws/invoice", name = "addMedicineResponse")
    public JAXBElement<MedicineType> createAddMedicineResponse(MedicineType value) {
        return new JAXBElement<MedicineType>(_AddMedicineResponse_QNAME, MedicineType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PharmacyMedicineType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ttu.ee/idu0075/2015/ws/invoice", name = "addPharmacyMedicineResponse")
    public JAXBElement<PharmacyMedicineType> createAddPharmacyMedicineResponse(PharmacyMedicineType value) {
        return new JAXBElement<PharmacyMedicineType>(_AddPharmacyMedicineResponse_QNAME, PharmacyMedicineType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PharmacyMedicineListType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ttu.ee/idu0075/2015/ws/invoice", name = "getPharmacyMedicineListResponse")
    public JAXBElement<PharmacyMedicineListType> createGetPharmacyMedicineListResponse(PharmacyMedicineListType value) {
        return new JAXBElement<PharmacyMedicineListType>(_GetPharmacyMedicineListResponse_QNAME, PharmacyMedicineListType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PharmacyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ttu.ee/idu0075/2015/ws/invoice", name = "getPharmacyResponse")
    public JAXBElement<PharmacyType> createGetPharmacyResponse(PharmacyType value) {
        return new JAXBElement<PharmacyType>(_GetPharmacyResponse_QNAME, PharmacyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MedicineType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.ttu.ee/idu0075/2015/ws/invoice", name = "getMedicineResponse")
    public JAXBElement<MedicineType> createGetMedicineResponse(MedicineType value) {
        return new JAXBElement<MedicineType>(_GetMedicineResponse_QNAME, MedicineType.class, null, value);
    }

}
