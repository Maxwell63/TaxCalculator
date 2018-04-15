/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author NM Shiundlana
 * Holds the blueprint for the each tax rates data
 */
public class TaxableIncomeModel {

    /**
     * @return the min_income
     */
    public double getMin_income() {
        return min_income;
    }

    /**
     * @return the max_income
     */
    public double getMax_income() {
        return max_income;
    }

    /**
     * @return the base_tax_payable
     */
    public double getBase_tax_payable() {
        return base_tax_payable;
    }

    /**
     * @return the tax_percentage
     */
    public double getTax_percentage() {
        return tax_percentage;
    }

    /**
     * @return the base_for_tax_percentage
     */
    public double getBase_for_tax_percentage() {
        return base_for_tax_percentage;
    }
    private double min_income;
    private double max_income;
    
    private double base_tax_payable;
    private double tax_percentage;
    
    private double base_for_tax_percentage;
    
    public TaxableIncomeModel(double min_income, double max_income, double base_tax_payable, double tax_percenatge, double base_for_tax_percentage){
        this.min_income = min_income;
        this.max_income = max_income;
        this.base_tax_payable = base_tax_payable;
        this.tax_percentage = tax_percenatge;
        this.base_for_tax_percentage = base_for_tax_percentage;
    }
    
    
    public boolean isInTaxBracket(double salary){
        if (salary<=max_income && salary>= min_income){
            return true;
        }
        
        return false;
    }
}
