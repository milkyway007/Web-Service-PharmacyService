/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacyPackage;

import ee.ttu.idu0075._2015.ws.invoice.AddPharmacyMedicineRequest;
import ee.ttu.idu0075._2015.ws.invoice.AddPharmacyRequest;
import ee.ttu.idu0075._2015.ws.invoice.ClassType;
import ee.ttu.idu0075._2015.ws.invoice.GetPharmacyListRequest;
import ee.ttu.idu0075._2015.ws.invoice.GetPharmacyListResponse;
import ee.ttu.idu0075._2015.ws.invoice.GetPharmacyMedicineListRequest;
import ee.ttu.idu0075._2015.ws.invoice.GetPharmacyRequest;
import ee.ttu.idu0075._2015.ws.invoice.MedicineType;
import ee.ttu.idu0075._2015.ws.invoice.PharmacyMedicineListType;
import ee.ttu.idu0075._2015.ws.invoice.PharmacyMedicineType;
import ee.ttu.idu0075._2015.ws.invoice.PharmacyType;
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

/**
 * REST Web Service
 *
 * @author BonBon
 */
@Path("pharmacies")
public class PharmaciesResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PharmaciesResource
     */
    public PharmaciesResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public GetPharmacyListResponse getPharmacyList(@QueryParam ("token") String token, @QueryParam("city") String city,
            @QueryParam("manager") String managerLastName,
            @QueryParam("clazz") String clazz){
        PharmacyService pharmacyService = new PharmacyService();
        GetPharmacyListRequest request = new GetPharmacyListRequest();
        request.setToken(token);
        if (city != null){
            request.setCity(city);
        }
        if (managerLastName != null){
            request.setManagerLastName(managerLastName);
        }
        if (clazz != null){
            request.setClazz(ClassType.fromValue(clazz));
        }
        return pharmacyService.getPharmacyList(request);

    }
    
    @GET
    @Path("{id: \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public PharmacyType getPharmacy(@PathParam("id") String id, @QueryParam("token") String token) {
        PharmacyService pharmacyService = new PharmacyService();
        GetPharmacyRequest request = new GetPharmacyRequest();
        request.setId(BigInteger.valueOf(Integer.parseInt(id)));
        request.setToken(token);
        return pharmacyService.getPharmacy(request);
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PharmacyType addPharmacy(PharmacyType content,@QueryParam("token") String token) {
         PharmacyService pharmacyService = new PharmacyService();
         AddPharmacyRequest request = new AddPharmacyRequest();
         request.setToken(token);
         request.setName(content.getName());
         request.setAddress(content.getAddress());
         request.setManager(content.getManager());
         request.setClazz(content.getClazz());
         return pharmacyService.addPharmacy(request);
    }
    
    @GET
    @Path("{id: \\d+}/medicines")
    @Produces(MediaType.APPLICATION_JSON)
    public PharmacyMedicineListType getPharmacyMedicineList(@PathParam("id") String id, @QueryParam("token") String token) {
        PharmacyService pharmacyService = new PharmacyService();
        GetPharmacyMedicineListRequest request = new GetPharmacyMedicineListRequest();
        request.setPharmacyId(BigInteger.valueOf(Integer.parseInt(id)));
        request.setToken(token);
        return pharmacyService.getPharmacyMedicineList(request);
    }
    
    @POST
    @Path("{id : \\d+}/medicines")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PharmacyMedicineType addPharmacyMedicine(AddPharmacyMedicineRequest content, 
                                @QueryParam("token") String token,
                                @PathParam("id") String id) {
        
        if (content.getQuantity().compareTo(BigDecimal.ZERO) == -1 || MedicinesResource.countNumberOfDecimalPlaces(content.getQuantity())>2){
            return giveFakePharmacyMedicine();
         } 
         
        if (content.getUnitPrice().compareTo(BigDecimal.ZERO) == -1 || MedicinesResource.countNumberOfDecimalPlaces(content.getUnitPrice())>2){
            return giveFakePharmacyMedicine();
        }
         
        PharmacyService pharmacyService = new PharmacyService();
        AddPharmacyMedicineRequest request = new AddPharmacyMedicineRequest();
        request.setToken(token);
        request.setPharmacyId(BigInteger.valueOf(Integer.parseInt(id)));
        request.setMedicineId(content.getMedicineId());
        request.setQuantity(content.getQuantity());
        request.setUnitPrice(content.getUnitPrice());
        return pharmacyService.addPharmacyMedicine(request);    
    }
    
    private PharmacyMedicineType giveFakePharmacyMedicine(){
        PharmacyMedicineType medicine = new PharmacyMedicineType();
        medicine.setId(BigInteger.ZERO);
        medicine.setMedicine(null);
        medicine.setQuantity(null);
        medicine.setUnitPrice(null);
        medicine.setError("Inserted values are incorrect");
        return medicine;
    }
}
