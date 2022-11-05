import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
public class Dialogs extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new Dialogs().setVisible(true);
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dialogs frame = new Dialogs();
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
	public Dialogs() {
		setTitle("Demo Jdialog");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//       setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300,200);
        setResizable(false);
//		setContentPane(contentPane);
	}

}
