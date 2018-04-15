/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author NM Shiundlana
 * Medical aid rates per year
 */
public class MedicalAidTaxCreditsModel {
    
    double main_member;
    double first_dependant;
    double add_members;
    
    public MedicalAidTaxCreditsModel(double main_member, double first_dependant, double add_members){
        this.main_member = main_member;
        this.first_dependant = first_dependant;
        this.add_members = add_members;
    }
}
