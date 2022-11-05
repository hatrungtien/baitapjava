
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

public class BoGaCa extends Frame implements ActionListener
{
    Label labelConVat = new Label("Chọn con vật:");
    Label labelCheBien = new Label("Chọn cách chế biến:");
    Label labelMonDaChon = new Label("Các món đã chọn:");
    
    CheckboxGroup g = new CheckboxGroup();
    String [] tenConVat = {"Bò","Gà","Cá"};
    Checkbox [] radioConVat = new Checkbox[3];
    
    Checkbox [] checkboxCachCheBien = new Checkbox[3];
    String [] tenCachCheBien = {"Nướng","Luộc","Chiên"};
    
    List listMonDaChon =new List();
    Button buttonThoat = new Button("THOÁT");
    Button buttonChon = new Button(">>");
    Button buttonBoChon = new Button("<<");

    public BoGaCa()
    {
        this.setTitle("Nhà hàng ITC");
        this.setLayout(null);
        this.setBackground(Color.cyan);
        Font f = new Font("Times New Roman",Font.BOLD+Font.ITALIC,18);
        
        labelConVat.setBounds(30,40,100,30);
        this.add(labelConVat);        
        for(int i=0;i<radioConVat.length;i++)
        {
            radioConVat[i] = new Checkbox(tenConVat[i]);
            radioConVat[i].setCheckboxGroup(g);
            radioConVat[i].setBounds(50, 70 + i*40,50,30);
            this.add(radioConVat[i]);
        }
        radioConVat[0].setState(true);
        
        labelCheBien.setBounds(30,200,150,30);
        this.add(labelCheBien);
        for(int i=0;i<checkboxCachCheBien.length;i++)
        {
            checkboxCachCheBien[i] = new Checkbox(tenCachCheBien[i]);
            checkboxCachCheBien[i].setBounds(50, 230 + i*40, 60, 30); //50
            this.add(checkboxCachCheBien[i]);
        }
        
        labelMonDaChon.setBounds(220,160,105,30);
        this.add(labelMonDaChon);
        listMonDaChon.setBounds(220,200,100,150);
        listMonDaChon.setMultipleMode(true);
        this.add(listMonDaChon);
        
        buttonThoat.setBounds(220,100,100,30);
        buttonThoat.setFont(f);
        buttonThoat.setBackground(new Color(255,0,0)); //Color.RED
        buttonThoat.setForeground(Color.yellow);
        buttonThoat.addActionListener(this);
        this.add(buttonThoat);
        
        buttonChon.setBounds(135,240,70,30);
        buttonChon.addActionListener(this);
        this.add(buttonChon);
        
        buttonBoChon.setBounds(135,280,70,30);
        buttonBoChon.addActionListener(this);
        this.add(buttonBoChon);
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Thoat();
            }           
        });
    }
    
    private void Thoat()
    {
        int input = JOptionPane.showConfirmDialog(this, "Bạn có muốn thoát không?", "Hộp thoại thoát", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(input == 0)
           System.exit(0);
    }
        
    private boolean KTCoTrongListKhong(String sTam, List list)
    {
        for(int i=0;i<list.getItemCount();i++)
        {
            if(sTam.equals(list.getItem(i)))
                return true;
        }
        return false;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String sTam = "";
        int vitriConVatDaChon = 0;
        
        if(e.getSource()== buttonThoat)
        {
           Thoat();
        }
        
        if(e.getSource()== buttonChon)
        {
            for(int i=0;i<radioConVat.length;i++)
                if(radioConVat[i].getState()) vitriConVatDaChon = i;
            
            boolean daChonCachCheBien = false;
            for(int i=0;i<checkboxCachCheBien.length;i++)
            {
                if(checkboxCachCheBien[i].getState())
                {
                    daChonCachCheBien = true;
                    sTam = tenConVat[vitriConVatDaChon] + " " + tenCachCheBien[i];
                    if(KTCoTrongListKhong(sTam, listMonDaChon)== true)
                    {
                        JOptionPane.showMessageDialog(this,"Bạn chọn bị trùng món\n\"" +sTam +"\" !");
                    }
                    else //(KTCoTrongListKhong(sTam, listMonDaChon)==false)                
                        listMonDaChon.add(sTam);
                    checkboxCachCheBien[i].setState(false);
                }
            }
            if(daChonCachCheBien==false)
                JOptionPane.showMessageDialog(this,"Bạn chưa chọn cách chế biến");
        }
        
        if(e.getSource()== buttonBoChon)
        {
            if(listMonDaChon.getItemCount()==0)
                JOptionPane.showMessageDialog(this,"Danh sách các món ăn đã rỗng!");
            else
            {
                int [] vitriItemDuocChon = listMonDaChon.getSelectedIndexes();
                if(vitriItemDuocChon.length == 0)
                    JOptionPane.showMessageDialog(this,"Bạn chưa chọn món để xóa!");
                else
                {
                    for(int i=vitriItemDuocChon.length-1; i>-1;i--)
                        listMonDaChon.remove(vitriItemDuocChon[i]);
                }
            }
        }
    }
    
    public static void main(String[] args)
    {
        BoGaCa f = new BoGaCa();
        f.setBounds(100,100,350,400);
        f.setResizable(false);
        f.setVisible(true);       
    } 

}
    
