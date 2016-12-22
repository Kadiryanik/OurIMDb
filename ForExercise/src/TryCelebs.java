import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.ScrollPaneConstants;

public class TryCelebs {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TryCelebs window = new TryCelebs();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TryCelebs() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 661, 881);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JPanel panelCelebs = new JPanel();
		frame.getContentPane().add(panelCelebs);
		panelCelebs.setBounds(0, 0, 550, 675);
		panelCelebs.setLayout(null);
		
		final JPanel panelCelebsTop = new JPanel();
		panelCelebsTop.setBackground(new Color(248, 248, 248));
		panelCelebsTop.setBounds(0, 0, 550, 53);
		panelCelebs.add(panelCelebsTop);
		panelCelebsTop.setLayout(null);
		
		JLabel lblSortBy = new JLabel("Sort by: ");
		lblSortBy.setBounds(209, 5, 42, 14);
		panelCelebsTop.add(lblSortBy);
		
		JLabel lblAz = new JLabel("A-Z,");
		lblAz.setBounds(261, 5, 21, 14);
		panelCelebsTop.add(lblAz);
		
		JLabel lblBirthDate = new JLabel("Birth Date");
		lblBirthDate.setBounds(292, 5, 48, 14);
		panelCelebsTop.add(lblBirthDate);
		
		JLabel lblLine = new JLabel("");
		lblLine.setBounds(25, 24, 500, 2);
		lblLine.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\line.png"));
		panelCelebsTop.add(lblLine);
		
		JLabel lblPrev = new JLabel("<< PreviusPage");
		lblPrev.setBounds(10, 32, 78, 14);
		panelCelebsTop.add(lblPrev);
		
		JLabel lblTotalNames = new JLabel("      Total Names: "+ 15);
		lblTotalNames.setBounds(195, 32, 96, 14);
		panelCelebsTop.add(lblTotalNames);
		
		JLabel lblPage = new JLabel("Page:");
		lblPage.setBounds(301, 32, 28, 14);
		panelCelebsTop.add(lblPage);
		
		JLabel lblPageNumber = new JLabel("1      ");
		lblPageNumber.setBounds(339, 32, 24, 14);
		panelCelebsTop.add(lblPageNumber);
		
		final JLabel lblNext = new JLabel("NextPage >>");
		lblNext.setBounds(470, 32, 70, 17);
		lblNext.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblNext.setForeground(new Color(150,90,240));
		lblNext.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Font font = lblNext.getFont();
				Map attributes = font.getAttributes();
				attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				lblNext.setFont(font.deriveFont(attributes));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNext.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
			}
			@Override
			public void mouseClicked(MouseEvent e) {}
		});
		
		panelCelebsTop.add(lblNext);
		
		JScrollPane scrollPaneContent = new JScrollPane();
		scrollPaneContent.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPaneContent.setBounds(0, 53, 550, 622);
		panelCelebs.add(scrollPaneContent);
		
		final JPanel panelCelebsContents= new JPanel();
		panelCelebsContents.setBackground(new Color(248, 248, 248));
		panelCelebsContents.setLayout(new WrapLayout(FlowLayout.CENTER, 10, 5));
		panelCelebsContents.setBounds(0, 0, 10, 10);
		scrollPaneContent.add(panelCelebsContents);
		scrollPaneContent.setViewportView(panelCelebsContents);
		

		
		
		/*
		JScrollPane scrollPaneC = new JScrollPane();
		scrollPaneC.setBounds(0, 0, 550, 675);
		panelCelebs.add(scrollPaneC);
		
		final JPanel panelCelebsScroll = new JPanel();
		panelCelebsScroll.setBackground(UIManager.getColor("Button.shadow"));
		panelCelebsScroll.setLayout(new WrapLayout(FlowLayout.CENTER, 10, 5));
		panelCelebsScroll.setBounds(0, 0, 10, 10);
		scrollPaneC.add(panelCelebsScroll);
		scrollPaneC.setViewportView(panelCelebsScroll);
		
		String celebQuery = "SELECT peopleId,pTitle,pDescription FROM People";
		final ArrayList<People> celebList = SqlOperations.getPeople(celebQuery);
		
		JLabel lblSortBy = new JLabel("Sort by: ");
		panelCelebsScroll.add(lblSortBy);
		
		JLabel lblAz = new JLabel("A-Z,");
		panelCelebsScroll.add(lblAz);
		
		JLabel lblBirthDate = new JLabel("Birth Date");
		panelCelebsScroll.add(lblBirthDate);
		
		JLabel lblLine = new JLabel("");
		lblLine.setIcon(new ImageIcon("C:\\Workplace\\OurIMDb\\Design\\Button Png\\line.png"));
		panelCelebsScroll.add(lblLine);
		
		JLabel lblPrev = new JLabel("<< PreviusPage");
		panelCelebsScroll.add(lblPrev);
		
		JLabel lblTotalNames = new JLabel("      Total Names: "+ celebList.size());
		panelCelebsScroll.add(lblTotalNames);
		
		JLabel lblPage = new JLabel("Page:");
		panelCelebsScroll.add(lblPage);
		
		JLabel lblPageNumber = new JLabel("1      ");
		panelCelebsScroll.add(lblPageNumber);
		
		final JLabel lblNext = new JLabel("NextPage >>");
		lblNext.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
		lblNext.setForeground(new Color(150,90,240));
		lblNext.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				Font font = lblNext.getFont();
				Map attributes = font.getAttributes();
				attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
				lblNext.setFont(font.deriveFont(attributes));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNext.setFont(new Font("Comic Sans MS", Font.BOLD, 11));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(limitValueLeft > celebList.size()){
					limitValueLeft = celebList.size();
				}
				//For delete before celebs
				for(int i = limitValueLeft; i < limitValueLeft + 49; i++){
					panelCelebsScroll.remove(9+i); 
				}
				for(int i = limitValueLeft; i < limitValueLeft + 49; i++){
					new CelebsComponent(celebList.get(i).getPeopleId(), celebList.get(i).getpTitle(), 
							celebList.get(i).getpDescription(), panelCelebsScroll);
				}
				limitValueLeft = limitValueLeft + 49;
			}
		});
		
		panelCelebsScroll.add(lblNext);
		
		JScrollPane scrollPaneContent = new JScrollPane();
		scrollPaneContent.setBounds(0, 0, 400, 400);
		panelCelebs.add(scrollPaneContent);
		
		final JPanel panelCelebsContents= new JPanel();
		panelCelebsContents.setBackground(Color.WHITE);
		panelCelebsContents.setLayout(new WrapLayout(FlowLayout.CENTER, 10, 5));
		panelCelebsContents.setBounds(0, 0, 10, 10);
		scrollPaneContent.add(panelCelebsContents);
		scrollPaneContent.setViewportView(panelCelebsContents);
		new CelebsComponent(celebList.get(0).getPeopleId(), celebList.get(0).getpTitle(), 
				celebList.get(0).getpDescription(), panelCelebsContents);
		*/
		
		
	}

}
