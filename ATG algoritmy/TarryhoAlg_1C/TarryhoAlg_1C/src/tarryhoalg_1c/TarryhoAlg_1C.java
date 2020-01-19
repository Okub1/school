/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarryhoalg_1c;

import java.io.FileNotFoundException;

/**
 *
 * @author majer
 */
public class TarryhoAlg_1C 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
            throws FileNotFoundException 
    {
        // TODO code application logic here
        
        Graf g = Graf.nacitajSubor("graf.txt");
        g.tarryhoAlg(4);
    }
    
}
