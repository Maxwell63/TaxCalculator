/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author NM Shiundlana
 * This class holds the data tables for each tax year
 */
public class TaxData {
    
    private static Map<Integer, TaxYearModel> tax_data = new HashMap<Integer, TaxYearModel>();
    
    static void createTaxModels(){
       tax_data.put(2017, fillYear2017());
       tax_data.put(2018, fillYear2018());
    }
    
  
    public static TaxYearModel getYear(int year){ 
        createTaxModels();
        
        return tax_data.get(year);
    }
    
    static TaxYearModel fillYear2017(){
        TaxYearModel year2017 = new TaxYearModel();
        //tax thresholds
        Map<Integer, TaxRebatesModel> rebates = new HashMap<Integer, TaxRebatesModel>();
        
        TaxRebatesModel r = new TaxRebatesModel("Primary", 0, 64, 13500);
        rebates.put(1, r);
        
        r = new TaxRebatesModel("Secondary (Persons 65 and older)", 65, 75, 7407);
        rebates.put(2, r);
        
        r = new TaxRebatesModel("Tertiary", 76, Integer.MAX_VALUE, 2466);
        rebates.put(3, r);
        
        //tax rebates
        Map<Integer, TaxThresholdModel> thresholds = new HashMap<Integer, TaxThresholdModel>();
        
        TaxThresholdModel t = new TaxThresholdModel(0, 64, 75000);
        thresholds.put(1, t); 
        
        t = new TaxThresholdModel(65, 75, 116150);
        thresholds.put(2, t);
        
        t = new TaxThresholdModel(76, Integer.MAX_VALUE, 129850);
        thresholds.put(3, t);
        
        //medical aid tax credits
        MedicalAidTaxCreditsModel medicalAid = new MedicalAidTaxCreditsModel(286, 286, 192);
        
        //taxable income
        ArrayList<TaxableIncomeModel> incomeTax = new ArrayList<TaxableIncomeModel>();
        
        TaxableIncomeModel tax = new TaxableIncomeModel(0, 188000, 0, 18, 0);
        incomeTax.add(tax);
        
        tax = new TaxableIncomeModel(188001, 293600, 33840, 26, 188000);
        incomeTax.add(tax);
        
        tax = new TaxableIncomeModel(293601, 406400, 61296, 31, 293600);
        incomeTax.add(tax);
        
        tax = new TaxableIncomeModel(406401, 550100, 96264, 36, 406400);
        incomeTax.add(tax);
        
        tax = new TaxableIncomeModel(550101, 701300, 147996, 39, 550100);
        incomeTax.add(tax);
        
        tax = new TaxableIncomeModel(701301, Integer.MAX_VALUE, 206964, 41, 701300);
        incomeTax.add(tax);
        
        year2017.setTaxableIncome(incomeTax);
        year2017.setRebates(rebates);
        year2017.setThresholds(thresholds);
        year2017.setMedicalAid(medicalAid);
        
        return year2017;
    }
      
    static TaxYearModel fillYear2018(){
        TaxYearModel year2018 = new TaxYearModel();
        //tax thresholds
        Map<Integer, TaxRebatesModel> rebates = new HashMap<Integer, TaxRebatesModel>();
        
        TaxRebatesModel r = new TaxRebatesModel("Primary", 0, 64, 13635);
        rebates.put(1, r);
        
        r = new TaxRebatesModel("Secondary (Persons 65 and older)", 65, 75, 7479);
        rebates.put(2, r);
        
        r = new TaxRebatesModel("Tertiary", 76, Integer.MAX_VALUE, 2493);
        rebates.put(3, r);
        
        //tax rebates
        Map<Integer, TaxThresholdModel> thresholds = new HashMap<Integer, TaxThresholdModel>();
        
        TaxThresholdModel t = new TaxThresholdModel(0, 64, 75750);
        thresholds.put(1, t); 
        
        t = new TaxThresholdModel(65, 75, 117300);
        thresholds.put(2, t);
        
        t = new TaxThresholdModel(76, Integer.MAX_VALUE, 131150);
        thresholds.put(3, t);
        
        //medical aid tax credits
        MedicalAidTaxCreditsModel medicalAid = new MedicalAidTaxCreditsModel(303, 303, 204);
        
        //taxable income
        ArrayList<TaxableIncomeModel> incomeTax = new ArrayList<TaxableIncomeModel>();
        
        TaxableIncomeModel tax = new TaxableIncomeModel(0, 189880, 0, 18, 0);
        incomeTax.add(tax);
        
        tax = new TaxableIncomeModel(189881, 296540, 34178, 26, 189880);
        incomeTax.add(tax);
        
        tax = new TaxableIncomeModel(296541, 410460, 61910, 31, 296540);
        incomeTax.add(tax);
        
        tax = new TaxableIncomeModel(410461, 555600, 97225, 36, 410460);
        incomeTax.add(tax);
        
        tax = new TaxableIncomeModel(555601, 708310, 149475, 39, 555600);
        incomeTax.add(tax);
        
        tax = new TaxableIncomeModel(708311, 1500000, 209032, 41, 708310);
        incomeTax.add(tax);
        
        tax = new TaxableIncomeModel(1500001, Integer.MAX_VALUE, 533625, 45, 1500000);
        incomeTax.add(tax);
        
        year2018.setTaxableIncome(incomeTax);
        year2018.setRebates(rebates);
        year2018.setThresholds(thresholds);
        year2018.setMedicalAid(medicalAid);
        
        return year2018;
    }
}
