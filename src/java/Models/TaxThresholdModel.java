/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author NM Shiundlana
 * Threshold tax models
 */
public class TaxThresholdModel {
    
    int min_age;
    int max_age;
    double threshold_amount;
    
    public TaxThresholdModel(int min_age, int max_age, double threshold_amount){
        this.min_age = min_age;
        this.max_age = max_age;
        this.threshold_amount = threshold_amount;
    }
}
