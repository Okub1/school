/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarryhoalg_1c;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author majer
 */
public class Graf 
{
    private int aN; // pocet vrcholov
    private int aM; // pocet hran
    private Vrchol[] aVrcholy;
    private Hrana[] aHrany;

    public Graf(int paN, int paM) 
    {
        this.aN = paN;
        this.aM = paM;
        this.aVrcholy = new Vrchol[1+paN];
        this.aHrany = new Hrana[1+paM];
    }
    
    public static Graf nacitajSubor( String paNazovSuboru ) 
            throws FileNotFoundException
    {
        Scanner s = new Scanner( new File(paNazovSuboru));
        int pocetVrcholov = s.nextInt();
        int pocetHran = s.nextInt();
        
        Graf g = new Graf(pocetVrcholov,pocetHran);
        
        for ( int i = 1; i <= pocetVrcholov; i++ )
        {
            g.aVrcholy[i] = new Vrchol(i);
        }
        
        for ( int j = 1; j <= pocetHran; j++ )
        {
            int u = s.nextInt();
            int v = s.nextInt();
            
            g.aHrany[j] = new Hrana(u, v);
        }
        
        return g;
    }
    
    private int najdiHranu( int paU )
    {
        for ( int j = 1; j <= aM; j++ )
        {
            Hrana h = aHrany[j];
            
            if (h.isPrvehoPrichodu())
                continue;
            
            if (h.getU() == paU && !h.isPouzitaSmeromUV())
            {
                return j;
            }
            else if (h.getV() == paU && !h.isPouzitaSmeromVU())
            {
                return j;
            }
        }

        for ( int j = 1; j <= aM; j++ )
        {
            Hrana h = aHrany[j];
            if (h.getU() == paU && !h.isPouzitaSmeromUV())
            {
                return j;
            }
            else if (h.getV() == paU && !h.isPouzitaSmeromVU())
            {
                return j;
            }
        }
        
        return 0;
    }
    
    public void tarryhoAlg( int paS )
    {
        System.out.println("Tarryho sled so zaciatkom " + paS);
        
        int u = paS;
        aVrcholy[u].setObjaveny(true);
        
        while (true)
        {
            System.out.println("Hladam hranu incidentnu s vrcholom " 
                    + u + " splnujucu T1 a T2.");
            int j = najdiHranu(u);
            if (j <= 0) 
            {
                System.out.println("Taka hrana neexistuje, STOP.");
                break;
            }
            
            Hrana h = aHrany[j];
            if (h.getU() == u)
            {
                System.out.println("Pokracujem hranou " 
                        + h + " v smere u->v.");
                h.setPouzitaSmeromUV(true);
                Vrchol v = aVrcholy[h.getV()];
                if (!v.isObjaveny())
                {
                    v.setObjaveny(true);
                    h.setPrvehoPrichodu(true);
                }
                u = v.getCislo();
            }
            else
            {
                System.out.println("Pokracujem hranou " 
                        + h + " v smere v->u.");
                h.setPouzitaSmeromVU(true);
                Vrchol v = aVrcholy[h.getU()];
                if (!v.isObjaveny())
                {
                    v.setObjaveny(true);
                    h.setPrvehoPrichodu(true);
                }
                u = v.getCislo();
            }
        }
    }
}
