import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
 
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
 
public class BT {
 
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;
 
    public BT() {
        prepareGUI();
        prepareGUI1();
        
    }
 
    public static void main(String[] args) {
        BT swingControlDemo = new BT();
        swingControlDemo.showRadioButtonDemo();
    }
 
    private void prepareGUI() {
        mainFrame = new JFrame("Choose button");
        mainFrame.setSize(400, 250);
        mainFrame.getContentPane().setLayout(new GridLayout(3, 1));
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 100);
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        mainFrame.getContentPane().add(headerLabel);
        mainFrame.getContentPane().add(controlPanel);
        mainFrame.getContentPane().add(statusLabel);
        mainFrame.setVisible(true);
    }
 
    private void showRadioButtonDemo() {
        headerLabel.setText(" Chọn con vật");
        final JRadioButton bt1 = new JRadioButton("Bò", true);
        final JRadioButton bt2 = new JRadioButton("Gà");
        final JRadioButton bt3 = new JRadioButton("Cá");
//       
        ButtonGroup group = new ButtonGroup();
        group.add(bt1);
        group.add(bt2);
        group.add(bt3);
        controlPanel.add(bt1);
        controlPanel.add(bt2);
        controlPanel.add(bt3);
        mainFrame.setVisible(true);
    }
    private void prepareGUI1() {
        mainFrame = new JFrame("Choose button");
        mainFrame.setAlwaysOnTop(true);
        mainFrame.setResizable(false);
        mainFrame.setSize(92, 356);
        mainFrame.getContentPane().setLayout(new GridLayout(3, 1));
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 100);
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        mainFrame.getContentPane().add(headerLabel);
        mainFrame.getContentPane().add(controlPanel);
        mainFrame.getContentPane().add(statusLabel);
        mainFrame.setVisible(true);
        mainFrame.setVisible(true);
        
    }
 
    private ( showRadioButtonDemo1() {
        headerLabel.setText(" Món có thể chọn");
        final JRadioButton bt1 = new JRadioButton("Nướng", true);
        final JRadioButton bt2 = new JRadioButton("Luộc ");
        final JRadioButton bt3 = new JRadioButton("Chiên");
//       
        ButtonGroup group = new ButtonGroup();
        group.add(bt1);
a.add(bt2);
        group.add(bt3);
        headerLabel= new JLabel("", JLabel.EAST);
        statusLabel = new JLabel("",J )
        
    }
}