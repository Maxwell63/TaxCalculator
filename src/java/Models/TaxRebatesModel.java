/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author NM Shiundlana
 * Model for the tax rebates
 */
public class TaxRebatesModel {
    String rebate_type;
    int min_age;
    int max_age;
    double rebate_amount;
    
    public TaxRebatesModel(String rebate_type, int min_age, int max_age, double rebate_amount){
        this.rebate_type = rebate_type;
        this.min_age = min_age;
        this.max_age = max_age;
        this.rebate_amount = rebate_amount;
    }
}
