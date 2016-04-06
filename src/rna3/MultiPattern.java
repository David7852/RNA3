package rna3;

import java.util.ArrayList;

public class MultiPattern 
{
    public ArrayList<SinglePattern> patterns;
    public int l,n;

    public MultiPattern(int l, int n) 
    {
        this.l=l;
        this.n=n;
        patterns =new ArrayList<>();
    }
    public void addpattern(SinglePattern s)            
    {
        SinglePattern ss=new SinglePattern(s);
        patterns.add(ss);
    }

    public void reset()
    {        
        patterns.clear();
    }
    
    
    
}
