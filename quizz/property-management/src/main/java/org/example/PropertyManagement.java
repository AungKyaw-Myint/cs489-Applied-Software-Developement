package org.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.domain.Apartment;
import org.example.domain.Lease;
import org.example.util.LocalDateAdapter;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PropertyManagement {
    public static void main(String[] args) {


        Lease lease1=new Lease(3128874121L, LocalDate.of(2025,2,1),
                               LocalDate.of(2026,2,1),1750.50,"Michael Philips");
        Lease lease2=new Lease(2927458265L, LocalDate.of(2025,4,2),
                               LocalDate.of(2025,10,2),1500.00,"Anna Smith");
        Lease lease3=new Lease(9189927460L, LocalDate.of(2025,3,1),
                               LocalDate.of(2026,3,1),2560.75,"Alex Campos");
        Lease lease4=new Lease(3128874119L, LocalDate.of(2023,2,1),
                               LocalDate.of(2024,2,1),1650.55,"Michael Philips");

        Apartment apt1=new Apartment("B1102", "The Cameron House", 11, 790, 3, Arrays.asList(lease2));
        Apartment apt2=new Apartment("A705","The Cameron House",7,855,4,Arrays.asList(lease1,lease4));
        Apartment apt3=new Apartment("C1210","Pointe Palace",12,1000,4,new ArrayList<>());
        Apartment apt4=new Apartment("A1371","The Cameron House",13,1000,4,Arrays.asList(lease3));

        List<Apartment> aptList=Arrays.asList(apt1,apt2,apt3,apt4);
        printApartmentJson(aptList);
        totalRevenue(aptList);
    }

    public static void printApartmentJson(List<Apartment> apartments){

        Comparator<Apartment> comparator= Comparator.comparing(Apartment::getSize).reversed()
                                                    .thenComparing(Apartment::getApartmentNo);

        apartments.sort(comparator);

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
                .setPrettyPrinting()
                .create();

        System.out.println("All Apartments:");
        System.out.println(gson.toJson(apartments));
        System.out.println("-----------------------------------");
    }


    public static void totalRevenue(List<Apartment> apartments){

        for(Apartment apt:apartments){
            System.out.println(apt.getApartmentNo()+" - "+String.format("$%,.2f",apt.totalRevenueLeases()));
        }
    }
}