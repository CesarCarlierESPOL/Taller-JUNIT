/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tallerpruebasunitarias;

import com.mycompany.tallerpruebasunitarias.Employee.EmployeeType;
import static com.mycompany.tallerpruebasunitarias.Employee.EmployeeType.*;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.time.LocalDate;
import java.time.ZoneId;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author allisonbarrezueta
 */
public class EmployeeTest {
    
    /**
     * Test of CalculateYearBonus method, of class Employee.
     */    
    
    @org.junit.Test
    public void testCalculateYearBonusWorker() {
        
        System.out.println("METODO CalculateYearBonus");
        Employee instance = new Employee(400, "USD", 10, Worker);
        float expResult = instance.getRmu();
        float result = instance.CalculateYearBonus();
        assertEquals(expResult, result, 0.0);
        
        //fail("Fallo en la prueba worker.");
    }
    
    @org.junit.Test
    public void testCalculateYearBonusSupervisor() {
        
        System.out.println("METODO CalculateYearBonus");
        Employee instance = new Employee(800, "USD", 15, Supervisor);
        float expResult = (float) (800 +386*0.5);
        float result = instance.CalculateYearBonus();
        assertEquals(expResult, result, 0.0);
        
        //fail("Fallo en la prueba Supervisor.");
    }
    @org.junit.Test
    public void testCalculateYearBonusManager() {
        
        System.out.println("METODO CalculateYearBonus");
        Employee instance = new Employee(1000, "USD", 20, Manager);
        float expResult = (float) (1000 + 386*1);
        float result = instance.CalculateYearBonus();
        System.out.println(result);
        assertEquals(expResult, result, 0.0);
        
        //fail("Fallo en la prueba Manager.");
    }
    
    @Test
    public void pruebaCurrencyUSD(){
        String expectedCurrency = "USD";
        Employee instance = new Employee(800, "USD", 15, Worker);
        String result = instance.getCurrency();
        assertEquals(expectedCurrency,result);
    }
    
    @Test
    public void mesPar() {
        int expectedValue = 0;
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue();
        assertEquals(expectedValue, month % 2);
    }
    
    @org.junit.Test
    public void testCSWorker() {
        
        System.out.println("METODO Salario Worker");
        Employee instance = new Employee(400, "USD", 10, Worker);
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue();
        float expResult = 0;
        if (month%2==0) {
            expResult = (float) (instance.getSalary() + 386.0/12*2);
        }
        float result = instance.cs();
        assertEquals(expResult, result, 0.0);
        
        //fail("Fallo en la prueba worker.");
    }
}
