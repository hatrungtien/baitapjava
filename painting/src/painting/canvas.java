package painting;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;


public class canvas extends Canvas
{
    int x=0,y=0;
    int size = 120;
    int paintgeo = 0; 
    Color color = Color.RED;
    Boolean reset = false;

    public canvas()
    {
        this.setBackground(Color.GRAY);
    }

    
    @Override
    public void paint(Graphics gra)
    {
        int W = this.getWidth();
        int H = this.getHeight();
        x=(W-size)/2;
        y=(H-size)/2;
        
        if(reset==true)
            gra.setColor(this.getBackground());
        else
            gra.setColor(color);
        
        switch (paintgeo)
        {
            case 0: 
                gra.fillOval(x,y,size,size);
                break;
            case 1: 
                gra.fillRect(x,y,size,size);
                break;
        }  
        
        if(reset==true)
            reset=false;
    }
    
    public void setValues(int kt, int h, Color c)
    {
        size = kt;
        paintgeo = h;
        color = c;
        repaint();
    }
    
    public void setReset(Boolean xoa)
    {
        reset = xoa;
        repaint();
    }
}

