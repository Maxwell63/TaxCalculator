/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author NM Shiundlana
 * Output to send back to the view for calculation
 */
public class TaxCalculationOutputs {
    
    /**
     * @return the annual_income
     */
    public double getAnnual_income() {
        return annual_income;
    }


    private double annual_income;
    
    int year;
    
    TaxRebatesModel rebate;
    
    TaxThresholdModel threshold;
    
    TaxableIncomeModel taxableIncome;
    
    MedicalAidTaxCreditsModel medical_aid_credits;
    
    TaxYearModel model;
    
    public TaxCalculationOutputs(int year, double annual_income, TaxRebatesModel rebate, TaxThresholdModel threshold, TaxableIncomeModel taxableIncome, MedicalAidTaxCreditsModel medical_aid_credits, TaxYearModel model)
    {
        this.annual_income = annual_income;
        this.year = year;
        this.rebate = rebate;
        this.threshold = threshold;
        this.medical_aid_credits = medical_aid_credits;
        this.taxableIncome = taxableIncome;
        
        this.model = model;
    }
    
}
