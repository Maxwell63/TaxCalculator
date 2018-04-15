/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author NM Shiundlana
 * This is the tax model for the each year
 */
public class TaxYearModel {

    /**
     * @return the rebates
     */
    public Map<Integer, TaxRebatesModel> getRebates() {
        return rebates;
    }

    /**
     * @param rebates the rebates to set
     */
    public void setRebates(Map<Integer, TaxRebatesModel> rebates) {
        this.rebates = rebates;
    }

    /**
     * @return the thresholds
     */
    public Map<Integer, TaxThresholdModel> getThresholds() {
        return thresholds;
    }

    /**
     * @param thresholds the thresholds to set
     */
    public void setThresholds(Map<Integer, TaxThresholdModel> thresholds) {
        this.thresholds = thresholds;
    }

    /**
     * @return the taxableIncome
     */
    public ArrayList<TaxableIncomeModel> getTaxableIncome() {
        return taxableIncome;
    }

    /**
     * @param taxableIncome the taxableIncome to set
     */
    public void setTaxableIncome(ArrayList<TaxableIncomeModel> taxableIncome) {
        this.taxableIncome = taxableIncome;
    }


    /**
     * @return the medicalAid
     */
    public MedicalAidTaxCreditsModel getMedicalAid() {
        return medicalAid;
    }

    /**
     * @param medicalAid the medicalAid to set
     */
    public void setMedicalAid(MedicalAidTaxCreditsModel medicalAid) {
        this.medicalAid = medicalAid;
    }
    
    private ArrayList<TaxableIncomeModel> taxableIncome;
    private Map<Integer, TaxRebatesModel> rebates;
    private Map<Integer, TaxThresholdModel> thresholds;
    private MedicalAidTaxCreditsModel medicalAid;
    
    public TaxRebatesModel getTaxRebatesModel(int age){
        return getRebates().get(age);
    }
    
    public TaxThresholdModel getTaxThresholdModel(int age){ 
        return getThresholds().get(age);
    } 
    
    public TaxableIncomeModel getTaxableIncomeModel(double salary){
        for (TaxableIncomeModel tax: getTaxableIncome()){
            if (tax.isInTaxBracket(salary)){
                return tax;
            }
        }
        
        return null;
    }
    
    
    
    
}
