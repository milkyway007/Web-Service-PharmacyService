/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacyPackage;

import ee.ttu.idu0075._2015.ws.invoice.ActiveIngridientType;
import ee.ttu.idu0075._2015.ws.invoice.AddMedicineRequest;
import ee.ttu.idu0075._2015.ws.invoice.GetMedicineListRequest;
import ee.ttu.idu0075._2015.ws.invoice.GetMedicineListResponse;
import ee.ttu.idu0075._2015.ws.invoice.GetMedicineRequest;
import ee.ttu.idu0075._2015.ws.invoice.MedicineType;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("medicines")
public class MedicinesResource {

    @Context
    private UriInfo context;

    public MedicinesResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public GetMedicineListResponse getMedicineList(@QueryParam ("token") String token) {
        PharmacyService pharmacyService = new PharmacyService();
        GetMedicineListRequest request = new GetMedicineListRequest();
        request.setToken(token);
        return pharmacyService.getMedicineList(request);
    }
    
    @GET
    @Path("{id: \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public MedicineType getMedicine(@PathParam("id") String id, @QueryParam("token") String token) {
        PharmacyService pharmacyService = new PharmacyService();
        GetMedicineRequest request = new GetMedicineRequest();
        request.setId(BigInteger.valueOf(Integer.parseInt(id)));
        request.setToken(token);
        return pharmacyService.getMedicine(request);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public MedicineType addMedicine(MedicineType content,@QueryParam("token") String token) {
         if (content.getSize().getAmount().compareTo(BigDecimal.ZERO) == -1 || countNumberOfDecimalPlaces(content.getSize().getAmount())>2){
            return giveFakeMedicine();
         } 
         
         for(ActiveIngridientType activeIngridient: content.getActiveIngridientList().getActiveIngridient()){
             if (activeIngridient.getAmount().compareTo(BigDecimal.ZERO) == -1 || countNumberOfDecimalPlaces(activeIngridient.getAmount()) > 2){
                 return giveFakeMedicine();
             }
         }
         
        PharmacyService pharmacyService = new PharmacyService();
        AddMedicineRequest request = new AddMedicineRequest();
        request.setToken(token);
        request.setName(content.getName());
        request.setActiveIngridientList(content.getActiveIngridientList());
        request.setSize(content.getSize());
        request.setUsage(content.getUsage());
        return pharmacyService.addMedicine(request);
    }
    
    public static int countNumberOfDecimalPlaces(BigDecimal givenBigDecimal){
        String amountString = givenBigDecimal.toString();
        amountString = amountString.substring(amountString.indexOf(".") + 1);
        int numberOfDecimalPlaces = amountString.length();
        return numberOfDecimalPlaces;
    }
    
    private MedicineType giveFakeMedicine(){
        MedicineType medicine = new MedicineType();
        medicine.setId(BigInteger.ZERO);
        medicine.setName(null);
        medicine.setActiveIngridientList(null);
        medicine.setSize(null);
        medicine.setErrorr("Inserted values are incorrect");
        return medicine;
    }
}

