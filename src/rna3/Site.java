
package rna3;

import java.awt.Color;
import java.awt.Polygon;

public class Site extends Polygon
{
    private int value;

    public Site() {
    }

    public Site(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
    

    public void turnOn() {
        value=1;
    }
    public void turnOff() {
        value=-1;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
}
