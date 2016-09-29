/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webserviceclient;

import ee.ttu.idu0075._2015.ws.invoice.ActiveIngridientListType;
import ee.ttu.idu0075._2015.ws.invoice.ActiveIngridientType;
import ee.ttu.idu0075._2015.ws.invoice.AddMedicineRequest;
import ee.ttu.idu0075._2015.ws.invoice.GetMedicineListResponse;
import ee.ttu.idu0075._2015.ws.invoice.GetMedicineRequest;
import ee.ttu.idu0075._2015.ws.invoice.MedicineType;
import ee.ttu.idu0075._2015.ws.invoice.SizeType;
import ee.ttu.idu0075._2015.ws.invoice.UnitType;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class WebServiceClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        
        System.out.println("Insert token: ");
        String token = obj.next();
        if (token.equals("salajane")){
            System.out.println("ADD or GET: ");
            String choice = obj.next();
            if(choice.equalsIgnoreCase("get")){
                
                BigInteger id = null;
                Boolean isCorrectId = false;
                while (isCorrectId == false){
                    System.out.println("Enter medicine's id: ");
                    id = new BigInteger(obj.next());
                    if (id.compareTo(BigInteger.ZERO) > -1){
                        isCorrectId = true;
                    } else {
                        System.out.println("Entered id is negative.");
                    }

                }
                try{
                    MedicineType medicine = findMedicine(token, id);
                    showMedicineInformation(medicine);
                } catch(Exception e){
                    System.out.println("Something went wrong(");
                }
            } else if (choice.equalsIgnoreCase("add")){
                AddMedicineRequest request = generateAddMedicineRequest(token);
                MedicineType medicine = addMedicine(request);
                showMedicineInformation(medicine);
            } else {
                System.out.println("Incorrect command(");
            }
        } else {
            System.out.println("Token is incorrect(");
        }    
    }
    
    private static AddMedicineRequest generateAddMedicineRequest(String token){
        AddMedicineRequest request = new AddMedicineRequest();
        request.setToken(token);
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter medicine's name: ");
        String name = obj.next();
        System.out.println("Enter medicine's usage: ");
        String usage = obj.next();
        
        String units = "";
        Boolean areCorrectUnits = false;
        while (areCorrectUnits == false){
            System.out.println("TBL/CAPS/L?");
            units = obj.next().toUpperCase();
            if (units.equals("TBL") || units.equals("CAPS") || units.equals("L")){
                areCorrectUnits = true;
            } else {
                System.out.println("This units do not suit(");
            }
        }
        
        BigDecimal packageSize = null;
        Boolean isCorrectPackageSize = false;
        while (isCorrectPackageSize == false){
            System.out.println("How many " + units + " are there in a package?");
            packageSize = new BigDecimal(obj.next());
            if (packageSize.compareTo(BigDecimal.ZERO) > -1){
                isCorrectPackageSize = true;
                packageSize = packageSize.setScale(2, BigDecimal.ROUND_DOWN);
            } else {
                System.out.println("Entered amount is negative.");
            }
            
        }

        SizeType size = new SizeType();
        size.setAmount(packageSize);
        size.setUnit(UnitType.valueOf(units));
        
        ActiveIngridientListType activeIngridientList = new ActiveIngridientListType();
        
        Boolean stopAddingActiveIngridients = false;
        while (stopAddingActiveIngridients == false){
            ActiveIngridientType activeIngridient = new ActiveIngridientType();
            
            System.out.println("Enter one of the medicine's active ingridients:");
            String activeIngridientName = obj.next();

            BigDecimal activeIngridientAmount = null;
            Boolean isCorrectActiveIngridientAmount = false;
            while (isCorrectActiveIngridientAmount == false){
                System.out.println("Enter amount of this active ingridient:");
                activeIngridientAmount = new BigDecimal(obj.next());
                if (activeIngridientAmount.compareTo(BigDecimal.ZERO) > -1){
                    isCorrectActiveIngridientAmount = true;
                    activeIngridientAmount = activeIngridientAmount.setScale(2, BigDecimal.ROUND_DOWN);
                } else {
                    System.out.println("Entered amount is negative.");
                }
            }

            String activeIngridientUnits = "";
            Boolean areCorrectActiveIngridientUnits = false;
            while (areCorrectActiveIngridientUnits == false){
                System.out.println("Enter units (L/MG):");
                activeIngridientUnits = obj.next().toUpperCase();
                if (activeIngridientUnits.equals("L") || activeIngridientUnits.equals("MG")){
                    areCorrectActiveIngridientUnits = true;
                } else {
                    System.out.println("Entered units are incorrect.");
                }
            } 
            activeIngridient.setName(activeIngridientName);
            activeIngridient.setAmount(activeIngridientAmount);
            activeIngridient.setUnit(UnitType.valueOf(activeIngridientUnits));
            activeIngridientList.getActiveIngridient().add(activeIngridient);
            String answer = "";
            Boolean isCorrectAnswer = false;
            while(isCorrectAnswer == false){
                System.out.println("Do you want to enter more active ingridients?(y/yes/n/no)");
                answer = obj.next();
                if (answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")){
                    isCorrectAnswer = true;
                    stopAddingActiveIngridients = false;
                } else if (answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")){
                    isCorrectAnswer = true;
                    stopAddingActiveIngridients = true;
                } else {
                    System.out.println("I do not understand you(");
                    isCorrectAnswer = false;
                }
            }
            
            
        }
        request.setToken(token);
        request.setName(name);
        request.setUsage(usage);
        request.setSize(size);
        request.setActiveIngridientList(activeIngridientList);
        return request;
    }
    
    private static void showMedicineInformation(MedicineType medicine){
        System.out.println("Medicine's information");
        System.out.println("ID: " + medicine.getId());
        System.out.println("Name: " + medicine.getName());
        System.out.println("Usage: " + medicine.getUsage());
        SizeType size = medicine.getSize();
        System.out.println("Package: " + size.getAmount() + " " + size.getUnit());
        ActiveIngridientListType activeIngridientList = medicine.getActiveIngridientList();
        List<ActiveIngridientType> ingridientList = activeIngridientList.getActiveIngridient();
        System.out.println("Active ingridients: ");
        int counter = 1;
        for (ActiveIngridientType ingridient: ingridientList){
            System.out.println(counter + ". " + ingridient.getName() + " " + ingridient.getAmount() + " " + ingridient.getUnit());
            counter++;
        } 
    }
    
    private static MedicineType findMedicine(String token, BigInteger id){
        GetMedicineRequest request = new GetMedicineRequest();
        request.setToken(token);
        request.setId(id);
        MedicineType medicine = getMedicine(request);
        return medicine;
    }

    private static MedicineType getMedicine(ee.ttu.idu0075._2015.ws.invoice.GetMedicineRequest parameter) {
        ee.ttu.idu0075._2015.ws.invoice.PharmacyService service = new ee.ttu.idu0075._2015.ws.invoice.PharmacyService();
        ee.ttu.idu0075._2015.ws.invoice.PharmacyPortType port = service.getPharmacyPort();
        return port.getMedicine(parameter);
    }

    private static MedicineType addMedicine(ee.ttu.idu0075._2015.ws.invoice.AddMedicineRequest parameter) {
        ee.ttu.idu0075._2015.ws.invoice.PharmacyService service = new ee.ttu.idu0075._2015.ws.invoice.PharmacyService();
        ee.ttu.idu0075._2015.ws.invoice.PharmacyPortType port = service.getPharmacyPort();
        return port.addMedicine(parameter);
    }

}
