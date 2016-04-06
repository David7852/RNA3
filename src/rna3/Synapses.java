package rna3;

import java.util.Random;

public class Synapses 
{
    public Neuron A;
    public double weight;
    public Neuron B;

    public Synapses() {
    }

    public Synapses(Neuron i, Neuron j) 
    {   
        Random r=new Random();
        A = i;
        A.setweight(this);
        B = j;
        B.setweight(this);
        this.weight =r.nextDouble();
    }
    public void renew()
    {
        Random r=new Random();
        this.weight =r.nextDouble();
    }

}
