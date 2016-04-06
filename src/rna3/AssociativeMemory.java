package rna3;

import java.awt.Color;
import java.util.ArrayList;

public class AssociativeMemory 
{
    public int m,p;
    public ArrayList<Neuron> Neurons;
    public ArrayList<Synapses> weights;

    public AssociativeMemory(int M) 
    {
        Neurons=new ArrayList<>();
        weights=new ArrayList<>();
        this.m=M*M;
        p=0;
        for(int i=0;i<m;i++)
        {
            Neuron n=new Neuron(-1);
            Neurons.add(n);
        }
        for(Neuron n:Neurons)
            for(Neuron o:Neurons)
                if(o!=n)
                {
                    boolean add=true;
                    for(Synapses s:weights)
                        if((s.A==n&&s.B==o)||(s.B==n&&s.A==o))
                            add=false;
                    if(add)
                    {
                        Synapses s=new Synapses(n, o);
                        weights.add(s);
                    }
                }
    }
    public void reset()
    {
        p=0;
        for(Neuron n:Neurons)
            n.output=-1;
        for(Synapses s:weights)
            s.renew();
    }
    public void learnpattern(SinglePattern pattern)
    {
        p++;
        for(int i=0;i<m;i++)//se presenta el patron a las neuronas
            Neurons.get(i).output=pattern.sites.get(i).getValue();
        boolean metaerror=true;
        int metac=0;
        while(metaerror&&metac<500)
        {
            metaerror=false;
            for(Neuron n:Neurons)
            {
                boolean error=true;
                int c=0;
                while(error&&c<5000)
                {
                    error=false;
                    int z;
                    if(n.f(n.WX())<0)
                        z=-1;
                    else
                        z=1;
                    if(z!=n.output)
                    {
                        error=true;
                        metaerror=true;
                        for(Synapses s:n.Synaps)
                            {   
                                if(s.A==n)
                                    s.weight+=(double)0.03*(1-n.output*z)*(n.output*s.B.output/m);
                                else
                                    s.weight+=(double)0.03*(1-n.output*z)*(n.output*s.A.output/m);
                            }
                    }
                    c++;
                }
            }
            metac++;
        }
    }    
    public SinglePattern stimulate(SinglePattern pattern)
    {
        SinglePattern flashback=new SinglePattern(pattern.l, pattern.n);
        flashback.c=Color.BLACK;
        for(int i=0;i<m;i++)//se presenta el patron a las neuronas
        {
            Neurons.get(i).output=pattern.sites.get(i).getValue();
        }
        for(int i=0;i<m;i++)//se obtiene la salida
            flashback.sites.get(i).setValue((int)Neurons.get(i).f(Neurons.get(i).WX()));
        return flashback;
    }
    
    
}
