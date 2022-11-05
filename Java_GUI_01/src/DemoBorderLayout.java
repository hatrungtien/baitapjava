import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
public class DemoBorderLayout extends JFrame {
//	private JButton
//	bn = new JButton("North"),
//	bs = new JButton("South"),
//	be = new JButton("East"),
//    bw = new JButton("West"),
//	bc = new JButton("Center");


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new DemoBorderLayout().setVisible(true);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemoBorderLayout frame = new DemoBorderLayout();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	private JButton
	bn = new JButton("North"),
	bs = new JButton("South"),
	be = new JButton("East"),
    bw = new JButton("West"),
	bc = new JButton("Center");

	public DemoBorderLayout() {
		setTitle("BorderLayout");
		setSize(300,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        add(BorderLayout.NORTH, bn);
        add(BorderLayout.SOUTH, bs);
        add(BorderLayout.EAST, be);
        add(BorderLayout.WEST, bw);
        add(BorderLayout.CENTER,bc);
        
        bn.setBackground(Color.red);
        bn.setBackground(Color.white);
        be.setBackground(Color.blue);
        be.setBackground(Color.white);
        
        
        
		//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//		setContentPane(contentPane);
	}

}
