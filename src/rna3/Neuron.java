package rna3;

import java.util.ArrayList;

public class Neuron 
{
    public ArrayList<Synapses> Synaps;//lista de pesos enlazados que llegan a la neurona
    public double output;
    
    public Neuron() 
    {
        Synaps=new ArrayList<>();
        output=-1;
    }
    public Neuron(double n)
    {
        Synaps=new ArrayList<>();
        output=n;
    }
    public void setweight(Synapses w)//enviar el peso que llega a esta neurona
    {
        Synaps.add(w);
    }
    public double WX()
    {
        double WX=0;
        for(Synapses s:Synaps)
        {
            if(s.A==this)
                WX+=s.weight*s.B.output;
            else
                WX+=s.weight*s.A.output;
                
        }
        return WX;
    }
    public double f(double x)
    {
        double y=Math.signum(x);
        return y;
    }
    
    public double out()
    {
        output=f(WX());
        return output;
    }
}
