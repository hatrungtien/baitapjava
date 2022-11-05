import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DemoBoxLayout extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new DemoBoxLayout().setVisible(true);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemoBoxLayout frame = new DemoBoxLayout();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public DemoBoxLayout() {
		setTitle("Boxlayout");
		setSize(450,250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		Box bv,bh1, bh2, bv1;
		add(bv=Box.createVerticalBox());
		bv.add(bh1=Box.createHorizontalBox());
		bv.add(bh2=Box.createHorizontalBox());
		bv.add(bv1=Box.createVerticalBox());
		for (int i=0;i<5;i++) {
			bh1.add(Box.createHorizontalGlue());
			bh1.add(new JButton("Button"+i));
			
		}
		bh1.add(Box.createHorizontalGlue());
		for ( int i=0;i<5;i++) {
			bh2.add(new JButton("Button"+i));
		}
		for (int i=0;i<5;i++) {
			bv1.add(Box.createVerticalStrut(5));
			bv1.add(new JButton("Button"+i));
		}
		bv1.add(Box.createVerticalStrut(5));
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//		setContentPane(contentPane);
	}

}
