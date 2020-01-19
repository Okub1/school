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
public class Hrana 
{
    private int aU; // prvy vrchol incidentny s hranou
    private int aV; // druhy vrchol incidentny s hranou
    
    private boolean aPrvehoPrichodu;
    private boolean aPouzitaSmeromUV;
    private boolean aPouzitaSmeromVU;

    public Hrana(int paU, int paV) 
    {
        this.aU = paU;
        this.aV = paV;
        aPrvehoPrichodu = false;
        aPouzitaSmeromUV = false;
        aPouzitaSmeromVU = false;
    }

    public int getU() 
    {
        return aU;
    }

    public int getV() 
    {
        return aV;
    }

    public boolean isPrvehoPrichodu() 
    {
        return aPrvehoPrichodu;
    }

    public void setPrvehoPrichodu(boolean paPrvehoPrichodu) 
    {
        this.aPrvehoPrichodu = paPrvehoPrichodu;
    }

    public boolean isPouzitaSmeromUV() 
    {
        return aPouzitaSmeromUV;
    }

    public void setPouzitaSmeromUV(boolean paPouzitaSmeromUV) 
    {
        this.aPouzitaSmeromUV = paPouzitaSmeromUV;
    }

    public boolean isPouzitaSmeromVU() 
    {
        return aPouzitaSmeromVU;
    }

    public void setPouzitaSmeromVU(boolean paPouzitaSmeromVU) 
    {
        this.aPouzitaSmeromVU = paPouzitaSmeromVU;
    }
    
    public boolean isIncidentna( int paU )
    {
        return ((aU == paU) || (aV == paU));
    }
    
    @Override
    public String toString()
    {
        return "{" + aU + "," + aV + "}";
    }
}
