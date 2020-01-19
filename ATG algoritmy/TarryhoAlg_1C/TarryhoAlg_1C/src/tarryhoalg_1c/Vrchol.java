/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarryhoalg_1c;

/**
 *
 * @author majer
 */
public class Vrchol 
{
    private int aCislo;
    private boolean aObjaveny;

    public Vrchol(int paCislo) 
    {
        this.aCislo = paCislo;
    }

    public int getCislo() 
    {
        return aCislo;
    }

    public boolean isObjaveny() 
    {
        return aObjaveny;
    }

    public void setObjaveny(boolean paObjaveny) 
    {
        this.aObjaveny = paObjaveny;
    }
    
    
    
}
