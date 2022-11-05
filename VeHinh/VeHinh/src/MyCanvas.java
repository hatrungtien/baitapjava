
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;


public class MyCanvas extends Canvas
{
    int x=0,y=0;
    int size = 130;
    int hinh = 0; //0.tron 1.vuong
    Color color = Color.RED;
    Boolean reset = false;

    public MyCanvas()
    {
        this.setBackground(Color.GRAY);
    }

    
    @Override
    public void paint(Graphics g)
    {
        int W = this.getWidth();
        int H = this.getHeight();
        x=(W-size)/2;
        y=(H-size)/2;
        
        if(reset==true)
            g.setColor(this.getBackground());
        else
            g.setColor(color);
        
        switch (hinh)
        {
            case 0: //hinh tron
                g.fillOval(x,y,size,size);
                break;
            case 1: //hinh vuong
                g.fillRect(x,y,size,size);
                break;
        }  
        
        if(reset==true)
            reset=false;
    }
    
    public void setValues(int kt, int h, Color c)
    {
        size = kt;
        hinh = h;
        color = c;
        repaint();
    }
    
    public void setReset(Boolean xoa)
    {
        reset = xoa;
        repaint();
    }
}
