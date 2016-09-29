
package ee.ttu.idu0075._2015.ws.invoice;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for unitType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="unitType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="mg"/&gt;
 *     &lt;enumeration value="l"/&gt;
 *     &lt;enumeration value="tbl"/&gt;
 *     &lt;enumeration value="caps"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "unitType")
@XmlEnum
public enum UnitType {

    @XmlEnumValue("mg")
    MG("mg"),
    @XmlEnumValue("l")
    L("l"),
    @XmlEnumValue("tbl")
    TBL("tbl"),
    @XmlEnumValue("caps")
    CAPS("caps");
    private final String value;

    UnitType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static UnitType fromValue(String v) {
        for (UnitType c: UnitType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
