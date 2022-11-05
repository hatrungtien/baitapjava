package painting;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

public class pain extends Frame implements AdjustmentListener, ItemListener,ActionListener
{
    Label labelsize = new Label("Size:");
    Scrollbar scrollsize;
    Button btnExit = new Button("Exit");
    Button btnReset = new Button("Reset");
    Label labelshape = new Label("Shape:");
    Choice choiceshape = new Choice();
    CheckboxGroup group;
    Checkbox checkboxred,checkboxbgreen,checkboxblue;
    canvas can = new canvas();
    MenuBar menubar = new MenuBar();
    Menu menushape = new Menu("Shape");    
    CheckboxMenuItem menuitemround = new CheckboxMenuItem("Round");
    CheckboxMenuItem menuitemsquare = new CheckboxMenuItem("Square");
    MenuItem menuitemexit = new MenuItem("Exit");
    Menu menucolor = new Menu("Color");
    CheckboxMenuItem menuitemred = new CheckboxMenuItem("Red");
    CheckboxMenuItem menuitemgreen = new CheckboxMenuItem("Green");
    CheckboxMenuItem menuitemblue = new CheckboxMenuItem("Blue");

    
    int size = 125;
    int paintgeo = 0; 
    Color color = Color.BLUE;
    Boolean reset = false;
    
    pain()
    {
        setTitle("PAINYING");
        setLayout(null);
        setBackground(Color.WHITE);
        
        labelsize.setBounds(25,50,40,25);
        this.add(labelsize);
        labelshape.setBounds(25, 95, 50, 35);
        this.add(labelshape);
        
        final int visible = 10;
        final int min = 20;
        final int max = 250;
        final int value = size;
        
        scrollsize = new Scrollbar(Scrollbar.HORIZONTAL,value,visible,min,max+visible);
        scrollsize.setBounds(70, 55, 220, 30);
        scrollsize.addAdjustmentListener(this);
        add(scrollsize);
        
        btnExit.setBounds(320, 50, 50, 30);
        btnExit.setBackground(Color.WHITE);
        btnExit.addActionListener(this);
        add(btnExit);
        
        btnReset.setBounds(375, 50, 50, 30);
        btnReset.setBackground(Color.WHITE);
        btnReset.addActionListener(this);
        add(btnReset);
        
        choiceshape.setBounds(30, 125, 80, 30);
        choiceshape.add("Round");
        choiceshape.add("Square");
        choiceshape.addItemListener(this);
        add(choiceshape);
        
        group=new CheckboxGroup();
        checkboxred = new Checkbox("Red",group,true);
        checkboxred.setBounds(30,160,50,25);
        checkboxred.addItemListener(this);
        add(checkboxred);       
        checkboxbgreen = new Checkbox("Green",group,false);
        checkboxbgreen.setBounds(30,215,50,30);
        checkboxbgreen.addItemListener(this);
        add(checkboxbgreen);
        checkboxblue = new Checkbox("Blue",group,false);
        checkboxblue.setBounds(30,255,50,30);
        checkboxblue.addItemListener(this);
        add(checkboxblue);
        
        can.setBounds(140,125,285,250);
        can.setBackground(Color.GRAY);
        add(can);
        menubar.add(menushape);
        menuitemround.setState(true);
        menuitemsquare.setState(false);
        menuitemround.addItemListener(this);
        menuitemsquare.addItemListener(this);
        menushape.add(menuitemround);
        menushape.add(menuitemsquare);
        menushape.addSeparator();
        menuitemexit.addActionListener(this);
        menushape.add(menuitemexit);

        menubar.add(menucolor);
        menuitemred.setState(true);
        menuitemred.addItemListener(this);
        menucolor.add(menuitemred);
        menuitemgreen.setState(false);
        menuitemgreen.addItemListener(this);
        menucolor.add(menuitemgreen);
        menuitemblue.setState(false);
        menuitemblue.addItemListener(this);
        menucolor.add(menuitemblue);
        this.setMenuBar(menubar);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
                
            }            
        });
    }
    
    public static void main(String[] args) {
        pain p = new pain();
        p.setBounds(50, 50, 455, 415);
        p.setResizable(false);
        p.setVisible(true);
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        size = scrollsize.getValue();
        can.setValues(size,paintgeo,color);
        System.out.println("size=" + size);
    }

    @Override
    public void itemStateChanged(ItemEvent e)
    {
        if(e.getSource()== menuitemround)
        {
                menuitemsquare.setState(false);
                paintgeo = 0;
                choiceshape.select(0);
        }
        if(e.getSource()==menuitemsquare)
        {
                menuitemround.setState(false);
                paintgeo = 1;
                choiceshape.select(1);
        }
        if (e.getSource()==choiceshape)
        {
                paintgeo = choiceshape.getSelectedIndex();
                switch (paintgeo)
                {
                        case 0: 
                                menuitemround.setState(true);
                                menuitemsquare.setState(false); 
                                break;
                        case 1:
                                menuitemround.setState(false);
                                menuitemsquare.setState(true); 
                                break;
                }
        }
		
        if (e.getSource()==checkboxred || e.getSource() == menuitemred)
        {
                color = Color.RED;
                menuitemred.setState(true);
                menuitemgreen.setState(false);
                menuitemblue.setState(false);
                checkboxred.setState(true);
        }
        if (e.getSource()==checkboxbgreen || e.getSource() == menuitemgreen)
        {
                color = Color.GREEN;
                menuitemred.setState(false);
                menuitemgreen.setState(true);
                menuitemblue.setState(false);
                checkboxbgreen.setState(true);
        }
        if (e.getSource()==checkboxblue || e.getSource() == menuitemblue)
        {
                color = color.BLUE;
                menuitemred.setState(false);
                menuitemgreen.setState(false);
                menuitemblue.setState(true);
                checkboxblue.setState(true);
        }
        
        can.setValues(size,paintgeo ,color);
    }

    private void Thoat()
    {
            System.exit(0);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnExit || e.getSource() == menuitemexit)
        {
            Thoat();
        }
        if(e.getSource()==btnReset)
        {
            reset = true;
            can.setReset(reset);
            
            scrollsize.setValue(130);
            size = 130;
            choiceshape.select(0);
            paintgeo = 0;
            checkboxred.setState(true);           
            color = Color.RED;
            
            menuitemround.setState(true);
            menuitemsquare.setState(false);
            menuitemred.setState(true);
            menuitemgreen.setState(false);
            menuitemblue.setState(false);          
        }
    }

}
