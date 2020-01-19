/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nakladanepolozky;

import java.io.Serializable;

/**
 *
 * @author bohacikj
 */
public enum PrichutCukrika implements Serializable{
    JAHODOVA("jahodova"),
    MENTOLOVA("mentolova");
    
    private String chut;
    
    PrichutCukrika(String chut){
        this.chut = chut;
    
    }
    
    public String toString() {
        return this.chut;  
    }
}
