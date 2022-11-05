import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
//import java.awt.Choice;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BoGaCa extends Frame implements ActionListener{
    Label labelConVat = new Label("Chon con vat:");
    Label labelMonAn = new Label("Chon mon an:");
    Label labelMonDaChon = new Label("Cac mon da chon:");
    
    CheckboxGroup g = new CheckboxGroup();
    Checkbox radioBo = new Checkbox("Bo",g,true);
    Checkbox radioGa = new Checkbox("Ga",g,false);
    Checkbox radioCa = new Checkbox("Ca",g,false);
    
    Checkbox checkboxNuong = new Checkbox("Nuong");
    Checkbox checkboxLuoc = new Checkbox("Luoc");
    Checkbox checkboxChien = new Checkbox("Chien");
    
    List listMonDaChon =new List();
    Button buttonThoat = new Button("Thoat");
    Button buttonChon = new Button(">>");
    Button buttonBoChon = new Button("<<");

    public BoGaCa(String s)
    {
        this.setTitle(s);
        this.setLayout(null);
        
        labelConVat.setBounds(30,40,100,30);
        this.add(labelConVat);
        radioBo.setBounds(50,80,50,30);
        radioGa.setBounds(50,120,50,30);
        radioCa.setBounds(50,160,50,30);
        this.add(radioBo);
        this.add(radioGa);
        this.add(radioCa);
        
        labelMonAn.setBounds(30,200,100,30);
        this.add(labelMonAn);
        checkboxNuong.setBounds(50,240,55,30);
        checkboxLuoc.setBounds(50,280,50,30);
        checkboxChien.setBounds(50,320,50,30);
        this.add(checkboxNuong);
        this.add(checkboxLuoc);
        this.add(checkboxChien);
        
        labelMonDaChon.setBounds(220,160,105,30);
        this.add(labelMonDaChon);
        listMonDaChon.setBounds(220,200,100,150);
        this.add(listMonDaChon);
        
        buttonThoat.setBounds(220,100,100,30);
        buttonThoat.addActionListener(this);
        this.add(buttonThoat);
        
        buttonChon.setBounds(130,240,70,30);
        buttonChon.addActionListener(this);
        this.add(buttonChon);
        buttonBoChon.setBounds(130,280,70,30);
        buttonBoChon.addActionListener(this);
        this.add(buttonBoChon);
        
        
        
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
            
        });
    }
    
    public static void main(String[] args) {
        BoGaCa f = new BoGaCa("Chon mon an");
        f.setBounds(100,100,350,400);
        f.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s1="",s="";
        String [] s2 = {"","",""};
        //String [] s2 = new String[3];
        //s2[0]="";
        //s2[1]="";
        //s2[2]="";
        if(e.getSource()== buttonThoat)
        {
            System.exit(0);
        }
        if(e.getSource()== buttonChon)
        {
            if(radioBo.getState()==true) s1=radioBo.getLabel();
            if(radioGa.getState()==true) s1=radioGa.getLabel();
            if(radioCa.getState()==true) s1=radioCa.getLabel();
            
            if(checkboxChien.getState()==true)  s2[0]= checkboxChien.getLabel();
            if(checkboxNuong.getState()==true) s2[1] = checkboxNuong.getLabel();
            if(checkboxLuoc.getState()==true) s2[2] = checkboxLuoc.getLabel();
            
            for(int i=0;i<s2.length;i++)
            {
                if(!s2[i].equals("")) //s2[i]!=""
                            listMonDaChon.add(s1 + " " +s2[i]);
            }
            
            checkboxChien.setState(false);
            checkboxLuoc.setState(false);
            checkboxNuong.setState(false);
        }
        
        if(e.getSource()== buttonBoChon)
        {
            int i = listMonDaChon.getSelectedIndex();
            if(i<0)
            {
              javax.swing.JOptionPane.showMessageDialog(this, "Ban chua chon!");
              return;
            }
            listMonDaChon.remove(i);
        }
        
        