import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DemoFlowLayout extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new DemoFlowLayout().setVisible(true);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemoFlowLayout frame = new DemoFlowLayout();
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
	public DemoFlowLayout() {
		setTitle("FlowLayout");
		setSize(330,260);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(new FlowLayout());
		for (int i=1;i<=20;i++) {
			add( new JButton("Button "+i));
		}
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//        
//		setContentPane(contentPane);
	}

}
