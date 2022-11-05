
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
//author: Lecturer Tấn Dũng VÕ, votandung@yahoo.com, since 2006

public class Painting extends Frame implements AdjustmentListener, ItemListener,ActionListener
{
    Label lbSize = new Label("Size:");
    Scrollbar scrSize;
    Button btnExit = new Button("Exit");
    Button btnReset = new Button("Reset");
    Label lbShape = new Label("Shape:");
    Choice choiceShape = new Choice();
    CheckboxGroup g;
    Checkbox cbRed,cbGreen,cbBlue;
    MyCanvas cvs = new MyCanvas();
    MenuBar menubar = new MenuBar();
    Menu menuShape = new Menu("Shape");    
    CheckboxMenuItem menuitemRound = new CheckboxMenuItem("Round");
    CheckboxMenuItem menuitemSquare = new CheckboxMenuItem("Square");
    MenuItem menuitemExit = new MenuItem("Exit");
    Menu menuColor = new Menu("Color");
    CheckboxMenuItem menuitemRed = new CheckboxMenuItem("Red");
    CheckboxMenuItem menuitemGreen = new CheckboxMenuItem("Green");
    CheckboxMenuItem menuitemBlue = new CheckboxMenuItem("Blue");

    
    int size = 130;
    int hinh = 0; //0.tron 1.vuong
    Color color = Color.RED;
    Boolean reset = false;
    
    Painting()
    {
        setTitle("My Painting");
        setLayout(null);
        setBackground(Color.CYAN);
        
        lbSize.setBounds(30,50,40,30);
        this.add(lbSize);
        lbShape.setBounds(30, 95, 50, 30);
        this.add(lbShape);
        
        final int visible = 10;
        final int minValue = 20;
        final int maxValue = 240;
        final int value = size;
        
        scrSize = new Scrollbar(Scrollbar.HORIZONTAL,value,visible,minValue,maxValue+visible);
        scrSize.setBounds(70, 50, 215, 30);
        scrSize.addAdjustmentListener(this);
        add(scrSize);
        
        btnExit.setBounds(315, 50, 50, 30);
        btnExit.setBackground(Color.YELLOW);
        btnExit.addActionListener(this);
        add(btnExit);
        
        btnReset.setBounds(375, 50, 50, 30);
        btnReset.setBackground(Color.ORANGE);
        btnReset.addActionListener(this);
        add(btnReset);
        
        choiceShape.setBounds(30, 125, 80, 30);
        choiceShape.add("Round");
        choiceShape.add("Square");
        choiceShape.addItemListener(this);
        add(choiceShape);
        
        g=new CheckboxGroup();
        cbRed = new Checkbox("Red",g,true);
        cbRed.setBounds(30,175,50,30);
        cbRed.addItemListener(this);
        add(cbRed);       
        cbGreen = new Checkbox("Green",g,false);
        cbGreen.setBounds(30,215,50,30);
        cbGreen.addItemListener(this);
        add(cbGreen);
        cbBlue = new Checkbox("Blue",g,false);
        cbBlue.setBounds(30,255,50,30);
        cbBlue.addItemListener(this);
        add(cbBlue);
        
        cvs.setBounds(140,125,285,250);
        //cvs.setBackground(Color.GRAY);
        add(cvs);
        menubar.add(menuShape);
        menuitemRound.setState(true);
        menuitemSquare.setState(false);
        menuitemRound.addItemListener(this);
        menuitemSquare.addItemListener(this);
        menuShape.add(menuitemRound);
        menuShape.add(menuitemSquare);
        menuShape.addSeparator();
        menuitemExit.addActionListener(this);
        menuShape.add(menuitemExit);

        menubar.add(menuColor);
        menuitemRed.setState(true);
        menuitemRed.addItemListener(this);
        menuColor.add(menuitemRed);
        menuitemGreen.setState(false);
        menuitemGreen.addItemListener(this);
        menuColor.add(menuitemGreen);
        menuitemBlue.setState(false);
        menuitemBlue.addItemListener(this);
        menuColor.add(menuitemBlue);
        this.setMenuBar(menubar);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //System.exit(0);
                Thoat();
            }            
        });
    }
    
    public static void main(String[] args) {
        Painting mp = new Painting();
        mp.setBounds(50, 50, 455, 415);
        mp.setResizable(false);
        mp.setVisible(true);
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
        size = scrSize.getValue();
        cvs.setValues(size,hinh,color);
        System.out.println("size=" + size);
    }

    @Override
    public void itemStateChanged(ItemEvent e)
    {
        if(e.getSource()== menuitemRound)
        {
                menuitemSquare.setState(false);
                hinh = 0;
                choiceShape.select(0);
        }
        if(e.getSource()==menuitemSquare)
        {
                menuitemRound.setState(false);
                hinh = 1;
                choiceShape.select(1);
        }
        if (e.getSource()==choiceShape)
        {
                hinh = choiceShape.getSelectedIndex();
                switch (hinh)
                {
                        case 0: 
                                menuitemRound.setState(true);
                                menuitemSquare.setState(false); 
                                break;
                        case 1:
                                menuitemRound.setState(false);
                                menuitemSquare.setState(true); 
                                break;
                }
        }
		
        if (e.getSource()==cbRed || e.getSource() == menuitemRed)
        {
                color = Color.RED;
                menuitemRed.setState(true);
                menuitemGreen.setState(false);
                menuitemBlue.setState(false);
                cbRed.setState(true);
        }
        if (e.getSource()==cbGreen || e.getSource() == menuitemGreen)
        {
                color = Color.GREEN;
                menuitemRed.setState(false);
                menuitemGreen.setState(true);
                menuitemBlue.setState(false);
                cbGreen.setState(true);
        }
        if (e.getSource()==cbBlue || e.getSource() == menuitemBlue)
        {
                color = color.BLUE;
                menuitemRed.setState(false);
                menuitemGreen.setState(false);
                menuitemBlue.setState(true);
                cbBlue.setState(true);
        }
        
        cvs.setValues(size, hinh, color);
    }

    private void Thoat()
    {
        int t = JOptionPane.showConfirmDialog(this,"Bạn có muốn thoát không?","Thoát chương trình",JOptionPane.OK_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
        if(t==0)
            System.exit(0);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnExit || e.getSource() == menuitemExit)
        {
            Thoat();
        }
        if(e.getSource()==btnReset)
        {
            reset = true;
            cvs.setReset(reset);
            
            scrSize.setValue(130);
            size = 130;
            choiceShape.select(0);
            hinh = 0;
            cbRed.setState(true);           
            color = Color.RED;
            
            menuitemRound.setState(true);
            menuitemSquare.setState(false);
            
            menuitemRed.setState(true);
            menuitemGreen.setState(false);
            menuitemBlue.setState(false);          
        }
    }

}
