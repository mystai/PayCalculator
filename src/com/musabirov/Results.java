package com.musabirov;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;

public class Results {
	public JFrame frame;
	public JLabel zarplataLbl;
	public JLabel zarplata2Lbl;
	public JLabel premiya2Lbl;
	public JLabel dobavka2Lbl;
	public JLabel koeff2Lbl;
	public JLabel ndfldeti2Lbl;
	public JLabel ndfl2Lbl;
	public JLabel itogo2Lbl;
	
	public Results() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setType(Type.UTILITY);
		frame.setTitle("Результаты");
		frame.setBounds(100, 100, 420, 306);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 404, 268);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		//выводим полученные результаты вычислений
		zarplataLbl = new JLabel("Текущий оклад:");
		zarplataLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		zarplataLbl.setBounds(31, 25, 190, 19);
		panel.add(zarplataLbl);
		
		JLabel ndflLbl = new JLabel("Вычет НДФЛ (13%):");
		ndflLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ndflLbl.setBounds(31, 174, 190, 19);
		panel.add(ndflLbl);
		
		JLabel ndflDetiLbl = new JLabel("Удержано НДФЛ на детей:");
		ndflDetiLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ndflDetiLbl.setBounds(31, 144, 190, 19);
		panel.add(ndflDetiLbl);
		
		JLabel premiyaLbl = new JLabel("Премиальные:");
		premiyaLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		premiyaLbl.setBounds(31, 55, 190, 19);
		panel.add(premiyaLbl);
		
		JLabel dobavkaLbl = new JLabel("Надбавка к окладу:");
		dobavkaLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dobavkaLbl.setBounds(31, 85, 190, 19);
		panel.add(dobavkaLbl);
		
		JLabel koeffLbl = new JLabel("Районный коэффицент:");
		koeffLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		koeffLbl.setBounds(31, 114, 190, 19);
		panel.add(koeffLbl);
		
		JLabel itogoLbl = new JLabel("Итого к выплате:");
		itogoLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		itogoLbl.setBounds(31, 204, 190, 19);
		panel.add(itogoLbl);
		
		JButton backBtn = new JButton("Назад");//при нажатии кнопки Назад,
		backBtn.addActionListener(new ActionListener() {// возвращаемся к предыдущему окну
			public void actionPerformed(ActionEvent e) {

				frame.dispose();

			}
		});
		backBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		backBtn.setBounds(31, 234, 190, 23);
		panel.add(backBtn);
		//Обнуление значений лэблов на форме результатов
		zarplata2Lbl = new JLabel("");
		zarplata2Lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		zarplata2Lbl.setBounds(231, 25, 163, 19);
		panel.add(zarplata2Lbl);
		
		premiya2Lbl = new JLabel("");
		premiya2Lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		premiya2Lbl.setBounds(231, 55, 163, 19);
		panel.add(premiya2Lbl);
		
		dobavka2Lbl = new JLabel("");
		dobavka2Lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dobavka2Lbl.setBounds(231, 85, 163, 19);
		panel.add(dobavka2Lbl);
		
		koeff2Lbl = new JLabel("");
		koeff2Lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		koeff2Lbl.setBounds(231, 118, 163, 19);
		panel.add(koeff2Lbl);
		
		ndfldeti2Lbl = new JLabel("");
		ndfldeti2Lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ndfldeti2Lbl.setBounds(231, 144, 163, 19);
		panel.add(ndfldeti2Lbl);
		
		ndfl2Lbl = new JLabel("");
		ndfl2Lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ndfl2Lbl.setBounds(231, 174, 163, 19);
		panel.add(ndfl2Lbl);
		
		itogo2Lbl = new JLabel("");
		itogo2Lbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		itogo2Lbl.setBounds(231, 204, 163, 19);
		panel.add(itogo2Lbl);
		frame.setVisible(true);

	}
}