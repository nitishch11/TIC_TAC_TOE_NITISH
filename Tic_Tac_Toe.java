import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class Tic_Tac_Toe extends JFrame implements ActionListener {
	int i, j, ii, jj, x, y, yesnull;
	int a[][] = { { 1, 2, 3 }, { 1, 4, 7 }, { 1, 5, 9 }, { 2, 5, 8 }, { 3, 5, 7 }, { 3, 6, 9 }, { 4, 5, 6 },
			{ 7, 8, 9 } };

	boolean state, type;
	JPanel p;
	Icon ic1, ic2, icon, ic11, ic22;
	JButton b[] = new JButton[9];
	JButton reset;
	JButton play;

	public void showButton() {

		x = 10;
		y = 10;
		j = 0;
		for (i = 0; i <= 8; i++, x += 100, j++) {
			b[i] = new JButton();
			if (j == 3) {
				j = 0;
				y += 100;
				x = 10;
			}
			b[i].setBounds(x, y, 100, 100);
			b[i].setBackground(Color.pink);
			add(b[i]);
			b[i].addActionListener(this);
		} // eof for

		reset = new JButton("RESET");
		reset.setBounds(100, 350, 100, 50);
		reset.setBackground(Color.orange);
		add(reset);
		reset.addActionListener(this);

	}// eof showButton

	/*********************************************************/
	Tic_Tac_Toe() {
		super("Tic Tac Toe Nitish");

		state = true;
		type = true;
		ic1 = new ImageIcon("D:/NITISH CHOUDHARY/New folder/TIC_TAC_TOE_NITISH/src/ic1.jpg");
		ic2 = new ImageIcon("D:/NITISH CHOUDHARY/New folder/TIC_TAC_TOE_NITISH/src/ic2.jpg");
		ic11 = new ImageIcon("D:/NITISH CHOUDHARY/New folder/TIC_TAC_TOE_NITISH/src/ic11.jpg");
		ic22 = new ImageIcon("D:/NITISH CHOUDHARY/New folder/TIC_TAC_TOE_NITISH/src/ic22.jpg");

		setLayout(null);
		setSize(330, 450);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		p = new JPanel();
		p.setBounds(0, 0, 314, 412);
		p.setBackground(Color.black);
		play = new JButton("START");
		play.setBounds(100, 170, 120, 70);
		play.setBackground(Color.yellow);
		p.add(play);
		play.addActionListener(this);
		add(p);
	}// eof constructor

	/*************************************************************/
	public void actionPerformed(ActionEvent e) {
		/********************************/
		if (e.getSource() == play) {
			showButton();
			play.setVisible(false);
		}
		if (e.getSource() == reset) {
			for (i = 0; i <= 8; i++) {
				b[i].setIcon(null);
			} // eof for
		} else {
			for (i = 0; i <= 8; i++) {
				if (e.getSource() == b[i]) {

					if (b[i].getIcon() == null) {
						if (state == true) {
							icon = ic2;
							state = false;
						} else {
							icon = ic1;
							state = true;
						}
						b[i].setIcon(icon);
					}
				}
			} // eof for
		} // eof else
		int check = 0;
		for (i = 0; i <= 7; i++) {

			Icon icon1 = b[(a[i][0] - 1)].getIcon();
			Icon icon2 = b[(a[i][1] - 1)].getIcon();
			Icon icon3 = b[(a[i][2] - 1)].getIcon();
			if ((icon1 == icon2) && (icon2 == icon3) && (icon1 != null)) {
				if (icon1 == ic1) {
					b[(a[i][0] - 1)].setIcon(ic11);
					b[(a[i][1] - 1)].setIcon(ic11);
					b[(a[i][2] - 1)].setIcon(ic11);
					JOptionPane.showMessageDialog(Tic_Tac_Toe.this, "X won! Click reset");
					check = 1;
					break;
				} else if (icon1 == ic2) {
					b[(a[i][0] - 1)].setIcon(ic22);
					b[(a[i][1] - 1)].setIcon(ic22);
					b[(a[i][2] - 1)].setIcon(ic22);
					JOptionPane.showMessageDialog(Tic_Tac_Toe.this, "O won! Click reset");
					check = 1;
					break;
				}
			}
		}
		if (check == 0) {
			int count = 0;
			for (i = 0; i <= 8; i++) {
				if (b[i].getIcon() != null) {
					count++;
				}
			}
			if (count == 9) {
				JOptionPane.showMessageDialog(Tic_Tac_Toe.this, "Tie! Click reset");
			}
			count = 0;
		}

	}// eof actionperformed

	/************************************************************/
	public static void main(String[] args) {
		new Tic_Tac_Toe();
	}// eof main
}// eof class