package rna3;

import java.awt.Color;
import java.util.ArrayList;

public class SinglePattern
{
    public ArrayList<Site> sites;
    short cont;
    public Color c= Color.GRAY;
    public int l, n;

    public SinglePattern() 
    {
        sites =new ArrayList<Site>();
        cont=0;
    }
    
    public SinglePattern(SinglePattern s) 
    {
        sites =new ArrayList<Site>();
        l=s.l;
        n=s.n;
        c=s.c;
        cont=s.cont;
        int atom=(int)l/n;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                if(s.sites.get(n*i+j).getValue()==1)
                {
                    Site xs=new Site(1);
                    xs.addPoint(i*atom, j*atom);
                    xs.addPoint(i*atom, j*atom + atom);
                    xs.addPoint(i*atom + atom, j*atom + atom);
                    xs.addPoint(i*atom + atom, j*atom);
                    sites.add(xs);
                }else
                    {
                        Site xs=new Site(-1);
                        xs.addPoint(i*atom, j*atom);
                        xs.addPoint(i*atom, j*atom + atom);
                        xs.addPoint(i*atom + atom, j*atom + atom);
                        xs.addPoint(i*atom + atom, j*atom);
                        sites.add(xs);
                    }
        
        
    }

    public SinglePattern(int l, int n) 
    {
        sites =new ArrayList<Site>();
        this.l = l;
        this.n = n;
        int atom=(int)l/n;
        cont=0;
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
            {
                Site s=new Site(-1);
                s.addPoint(i*atom, j*atom);
                s.addPoint(i*atom, j*atom + atom);
                s.addPoint(i*atom + atom, j*atom + atom);
                s.addPoint(i*atom + atom, j*atom);
                sites.add(s);
            }
    }
    public void click(int x,int y)
    {
        for(Site s:sites)
        {
            if(s.contains(x, y))
            {
                if(s.getValue()==-1)
                {
                    cont++;
                    s.turnOn();
                }
                break;
            }
        }
    }
    public void unclick(int x,int y)
    {
        for(Site s:sites)
        {
            if(s.contains(x, y))
            {
                if(s.getValue()==1)
                {
                    cont--;
                    s.turnOff();
                }
                break;
            }
        }
    }
    public void clean()
    {
        for(Site s:sites)
            s.turnOff();
        cont=0;
    }
    
    
}
