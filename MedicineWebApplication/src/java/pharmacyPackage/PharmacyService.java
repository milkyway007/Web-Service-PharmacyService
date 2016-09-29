/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacyPackage;

import com.sun.xml.ws.developer.SchemaValidation;
import ee.ttu.idu0075._2015.ws.invoice.AddPharmacyMedicineRequest;
import ee.ttu.idu0075._2015.ws.invoice.ClassType;
import ee.ttu.idu0075._2015.ws.invoice.GetMedicineListResponse;
import ee.ttu.idu0075._2015.ws.invoice.GetMedicineRequest;
import ee.ttu.idu0075._2015.ws.invoice.GetPharmacyListResponse;
import ee.ttu.idu0075._2015.ws.invoice.GetPharmacyMedicineListRequest;
import ee.ttu.idu0075._2015.ws.invoice.MedicineType;
import ee.ttu.idu0075._2015.ws.invoice.PharmacyMedicineListType;
import ee.ttu.idu0075._2015.ws.invoice.PharmacyMedicineType;
import ee.ttu.idu0075._2015.ws.invoice.PharmacyType;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import java.math.*;

/**
 *
 * @author BonBon
 */
@SchemaValidation
@WebService(serviceName = "PharmacyService", portName = "PharmacyPort", endpointInterface = "ee.ttu.idu0075._2015.ws.invoice.PharmacyPortType", targetNamespace = "http://www.ttu.ee/idu0075/2015/ws/invoice", wsdlLocation = "WEB-INF/wsdl/PharmacyService/medicines.wsdl")
public class PharmacyService {
    
    static List<MedicineType> medicineList = new ArrayList<MedicineType>();
    static List<PharmacyType> pharmacyList = new ArrayList<PharmacyType>();
    static int nextMedicineId = 1;
    static int nextPharmacyId = 1;
    static int nextPharmacyMedicineId = 1;

    public ee.ttu.idu0075._2015.ws.invoice.MedicineType getMedicine(ee.ttu.idu0075._2015.ws.invoice.GetMedicineRequest parameter) {
        MedicineType medicine = null;
        
        if(parameter.getToken().equalsIgnoreCase("salajane")){
            for(int i = 0; i<medicineList.size();i++){
                if(medicineList.get(i).getId().equals(parameter.getId())){
                    medicine = medicineList.get(i);
                }
            }
        }
        return medicine;
    }

    public ee.ttu.idu0075._2015.ws.invoice.MedicineType addMedicine(ee.ttu.idu0075._2015.ws.invoice.AddMedicineRequest parameter) {
        MedicineType medicine = new MedicineType();
        
        if(parameter.getToken().equalsIgnoreCase("salajane")){
            medicine.setId(BigInteger.valueOf(nextMedicineId++));
            medicine.setName(parameter.getName());
            medicine.setActiveIngridientList(parameter.getActiveIngridientList());
            medicine.setSize(parameter.getSize());
            medicine.setUsage(parameter.getUsage());
            medicineList.add(medicine);
        }
        return medicine;
    }

    public ee.ttu.idu0075._2015.ws.invoice.GetMedicineListResponse getMedicineList(ee.ttu.idu0075._2015.ws.invoice.GetMedicineListRequest parameter) {
        GetMedicineListResponse response = new GetMedicineListResponse();
        if(parameter.getToken().equalsIgnoreCase("salajane")){
            for(MedicineType medicine: medicineList){
                    response.getMedicine().add(medicine);
            }
        }
        return response;
    }

    public ee.ttu.idu0075._2015.ws.invoice.PharmacyType getPharmacy(ee.ttu.idu0075._2015.ws.invoice.GetPharmacyRequest parameter) {
        PharmacyType pharmacy = null;
        if (parameter.getToken().equalsIgnoreCase("salajane")) {
            for (int i = 0; i < pharmacyList.size(); i++) {
                if (pharmacyList.get(i).getId().equals(parameter.getId())) {
                    pharmacy = pharmacyList.get(i);
                }

            }    
        }
        return pharmacy;
    }

    public ee.ttu.idu0075._2015.ws.invoice.PharmacyType addPharmacy(ee.ttu.idu0075._2015.ws.invoice.AddPharmacyRequest parameter) {
        PharmacyType pharmacy = new PharmacyType();
        if (parameter.getToken().equalsIgnoreCase("salajane")) {
            pharmacy.setId(BigInteger.valueOf(nextPharmacyId++));
            pharmacy.setName(parameter.getName());
            pharmacy.setAddress(parameter.getAddress());
            pharmacy.setManager(parameter.getManager());
            pharmacy.setMoneyAmount(BigDecimal.ZERO);
            pharmacy.setPharmacyMedicineList(new PharmacyMedicineListType());
            pharmacy.setClazz(parameter.getClazz());
            pharmacyList.add(pharmacy);
        }
        return pharmacy;
    }

    public ee.ttu.idu0075._2015.ws.invoice.GetPharmacyListResponse getPharmacyList(ee.ttu.idu0075._2015.ws.invoice.GetPharmacyListRequest parameter) {
        GetPharmacyListResponse response = new GetPharmacyListResponse();
        if (parameter.getToken().equalsIgnoreCase("salajane")) {
            String parameterCity = parameter.getCity();
            String parameterManager = parameter.getManagerLastName();
            ClassType parameterClass = parameter.getClazz();
            for (PharmacyType pharmacy :pharmacyList) {
                String pharmacyCity = pharmacy.getAddress().getCity();
                String pharmacyManager = pharmacy.getManager().getLastName();
                ClassType pharmacyClass = pharmacy.getClazz();
                if (parameterCity == null && parameterManager == null && parameterClass == null){
                        response.getPharmacy().add(pharmacy);
                }
                
                if (parameterCity != null && parameterManager == null && parameterClass == null){
                    if (parameterCity.equalsIgnoreCase(pharmacyCity)){
                       response.getPharmacy().add(pharmacy);
                    }
                }
                
                if (parameterManager != null && parameterCity == null && parameterClass == null){
                    if (parameterManager.equalsIgnoreCase(pharmacyManager)){
                       response.getPharmacy().add(pharmacy);
                    }
                }
                
                if (parameterManager == null && parameterCity == null && parameterClass != null){
                    if (parameterClass.equals(pharmacyClass)){
                       response.getPharmacy().add(pharmacy);
                    }
                }
                
                if (parameterCity != null && parameterManager != null && parameterClass == null){
                    if (parameterCity.equalsIgnoreCase(pharmacyCity) && parameterManager.equalsIgnoreCase(pharmacyManager)){
                       response.getPharmacy().add(pharmacy);
                    }
                }
                
                if (parameterManager != null && parameterCity == null && parameterClass != null){
                    if (parameterManager.equalsIgnoreCase(pharmacyManager) && parameterClass.equals(pharmacyClass)){
                       response.getPharmacy().add(pharmacy);
                    }
                }
                
                if (parameterManager == null && parameterCity != null && parameterClass != null){
                    if (parameterClass.equals(pharmacyClass) && parameterCity.equalsIgnoreCase(pharmacyCity)){
                       response.getPharmacy().add(pharmacy);
                    }
                }
                
                if (parameterManager != null && parameterCity != null && parameterClass != null){
                    if (parameterManager.equalsIgnoreCase(pharmacyManager) && parameterClass.equals(pharmacyClass) && parameterCity.equalsIgnoreCase(pharmacyCity)){
                       response.getPharmacy().add(pharmacy);
                    }
                }
            }
        }
        return response;
    }

    public ee.ttu.idu0075._2015.ws.invoice.PharmacyMedicineListType getPharmacyMedicineList(ee.ttu.idu0075._2015.ws.invoice.GetPharmacyMedicineListRequest parameter) {
        PharmacyMedicineListType pharmacyMedicineList = null;
        if (parameter.getToken().equalsIgnoreCase("salajane")) {
            for (int i = 0; i < pharmacyList.size(); i++) {
                if (pharmacyList.get(i).getId().equals(parameter.getPharmacyId())) {
                    pharmacyMedicineList = pharmacyList.get(i).getPharmacyMedicineList();
                }
            }    
        }
        return pharmacyMedicineList;
    }

    public ee.ttu.idu0075._2015.ws.invoice.PharmacyMedicineType addPharmacyMedicine(ee.ttu.idu0075._2015.ws.invoice.AddPharmacyMedicineRequest parameter) {
        PharmacyMedicineType pharmacyMedicine = new PharmacyMedicineType();
        if (parameter.getToken().equalsIgnoreCase("salajane")) {
            GetMedicineRequest request = new GetMedicineRequest();

            
            request.setId(parameter.getMedicineId());
            request.setToken(parameter.getToken());
            
            pharmacyMedicine.setId(BigInteger.valueOf(nextPharmacyMedicineId++));
            pharmacyMedicine.setMedicine(getMedicine(request));
            pharmacyMedicine.setQuantity(parameter.getQuantity());
            pharmacyMedicine.setUnitPrice(parameter.getUnitPrice());
            
        
            for (int i = 0; i < pharmacyList.size(); i++) {
                if (pharmacyList.get(i).getId().equals(parameter.getPharmacyId())) {
                    pharmacyList.get(i).getPharmacyMedicineList().getPharmacyMedicine().add(pharmacyMedicine);
                    
                    pharmacyList.get(i).setMoneyAmount(pharmacyList.get(i).getMoneyAmount().add(pharmacyMedicine.getQuantity().multiply(pharmacyMedicine.getUnitPrice())));
                    return pharmacyMedicine;
                } 
            }
        
        }
        return null;
    }
}
