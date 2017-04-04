package com.musabirov;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PayCalculator {

	private JFrame frame;
	private JTextField okladField;       //поля для ввода данных
	private JTextField dniField;
	private JTextField vseDniField;
	private JTextField koeffField;
	private JTextField detiField;
	private JTextField premiyaField;
	private JTextField nadbavkaField;
	private JLabel errorLbl;
	public JCheckBox nadbavkaBox;       //галочки
	public JCheckBox premiyaBox;
	public JCheckBox detiBox;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					PayCalculator window = new PayCalculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PayCalculator() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Зарплатный калькулятор");
		frame.setBounds(100, 100, 420, 306);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 450, 1);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel okladLbl = new JLabel("Оклад");		//подписи для полей ввода на форме
		okladLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		okladLbl.setBounds(10, 25, 190, 19);
		frame.getContentPane().add(okladLbl);

		JLabel dniLbl = new JLabel("Рабочих дней"); //подписи для полей ввода на форме
		dniLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dniLbl.setBounds(10, 84, 190, 19);
		frame.getContentPane().add(dniLbl);

		JLabel vseDniLbl = new JLabel("Отработано дней"); //подписи для полей ввода на форме
		vseDniLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		vseDniLbl.setBounds(10, 55, 190, 19);
		frame.getContentPane().add(vseDniLbl);

		JLabel koeffLbl = new JLabel("Районный коэффицент");//подписи для полей ввода на форме
		koeffLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		koeffLbl.setBounds(10, 114, 190, 19);
		frame.getContentPane().add(koeffLbl);

		JLabel detiLbl = new JLabel("Количество детей");//подписи для полей ввода на форме
		detiLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		detiLbl.setBounds(10, 142, 137, 19);
		frame.getContentPane().add(detiLbl);

		JLabel premiyaLbl = new JLabel("Премия");//подписи для полей ввода на форме
		premiyaLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		premiyaLbl.setBounds(10, 172, 61, 19);
		frame.getContentPane().add(premiyaLbl);

		JLabel nadbavkaLbl = new JLabel("Надбавка");//подписи для полей ввода на форме
		nadbavkaLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nadbavkaLbl.setBounds(10, 202, 74, 19);
		frame.getContentPane().add(nadbavkaLbl);

		okladField = new JTextField();
		okladField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		okladField.setBounds(252, 26, 140, 20);
		frame.getContentPane().add(okladField);    //берем введенные данные
		okladField.setColumns(10);

		dniField = new JTextField();
		dniField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dniField.setColumns(10);
		dniField.setBounds(252, 56, 140, 20);
		frame.getContentPane().add(dniField);  //берем введенные данные

		vseDniField = new JTextField();
		vseDniField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		vseDniField.setColumns(10);
		vseDniField.setBounds(252, 85, 140, 20);
		frame.getContentPane().add(vseDniField);//берем введенные данные

		koeffField = new JTextField();
		koeffField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		koeffField.setColumns(10);
		koeffField.setBounds(252, 115, 140, 20);
		frame.getContentPane().add(koeffField);//берем введенные данные

		detiField = new JTextField();
		detiField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		detiField.setColumns(10);
		detiField.setBounds(252, 143, 140, 20);
		detiField.setVisible(false);
		frame.getContentPane().add(detiField);//берем введенные данные

		premiyaField = new JTextField();
		premiyaField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		premiyaField.setColumns(10);
		premiyaField.setVisible(false);
		premiyaField.setBounds(252, 173, 140, 20);
		frame.getContentPane().add(premiyaField);//берем введенные данные

		nadbavkaField = new JTextField();
		nadbavkaField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nadbavkaField.setColumns(10);
		nadbavkaField.setVisible(false);
		nadbavkaField.setBounds(252, 203, 140, 20);
		frame.getContentPane().add(nadbavkaField);//берем введенные данные

		JButton resultBtn = new JButton("Рассчитать");//нажатие кнопки рассчитать
		resultBtn.addActionListener(new ActionListener() {

			private double premiya = 0;//премия, надбавка и дети по умолчанию 0
			private double nadbavka = 0;
			private int deti = 0;

			public void actionPerformed(ActionEvent arg0) {
				try {

					double oklad = Double.parseDouble(okladField.getText()); //присваиваем вспомогательным переменным
					int vsegoDni = Integer.parseInt(vseDniField.getText()); //введенные значения
					int dni = Integer.parseInt(dniField.getText());
					double koeff = Double.parseDouble(koeffField.getText());

					if (detiBox.isSelected())//если стоит галочка на детях, премии или надбавки, то считываем их значение
						deti = Integer.parseInt(detiField.getText());
					if (premiyaBox.isSelected())
						premiya = Double.parseDouble(premiyaField.getText());
					if (nadbavkaBox.isSelected())
						nadbavka = Double.parseDouble(nadbavkaField.getText());

					Calculating calculating = new Calculating(oklad, vsegoDni, dni, koeff, deti, premiya, nadbavka);
					//Результаты вычислений выводятся через элементы лэйбл на форму Результаты
					Results results = new Results();  
					results.zarplata2Lbl
							.setText(NumberFormat.getCurrencyInstance().format(calculating.getOklad2()) + "");
					results.premiya2Lbl.setText(NumberFormat.getCurrencyInstance().format(premiya) + "");

					results.dobavka2Lbl.setText(NumberFormat.getCurrencyInstance().format(nadbavka) + "");
					results.koeff2Lbl.setText(koeff + "%");
					results.ndfldeti2Lbl
							.setText(NumberFormat.getCurrencyInstance().format(calculating.getNdflDeti()) + "");
					results.ndfl2Lbl.setText(NumberFormat.getCurrencyInstance().format(calculating.getNdfl()) + "");
					results.itogo2Lbl.setText(NumberFormat.getCurrencyInstance().format(calculating.getItogo()) + "");
				} catch (Exception e) {
					errorLbl.setVisible(true);
				}

			}
		});
		resultBtn.setFont(new Font("Tahoma", Font.PLAIN, 15));
		resultBtn.setBounds(10, 234, 190, 23);
		frame.getContentPane().add(resultBtn);

		JButton button = new JButton("\u041E\u0447\u0438\u0441\u0442\u0438\u0442\u044C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				okladField.setText("");
				okladField.setText("");
				dniField.setText("");
				vseDniField.setText("");
				koeffField.setText("");
				detiField.setText("");
				premiyaField.setText("");
				nadbavkaField.setText("");
				detiBox.setSelected(false);
				premiyaBox.setSelected(false);
				nadbavkaBox.setSelected(false);
				detiField.setVisible(false);
				premiyaField.setVisible(false);
				nadbavkaField.setVisible(false);
				errorLbl.setVisible(false);
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setBounds(202, 234, 190, 23);
		frame.getContentPane().add(button);

		errorLbl = new JLabel("Не все данные введены или введены правильно!");
		errorLbl.setForeground(Color.RED);
		errorLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		errorLbl.setBounds(28, 0, 347, 19);
		errorLbl.setVisible(false);
		frame.getContentPane().add(errorLbl);

		detiBox = new JCheckBox("");
		detiBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				if (detiField.isVisible() == false)
					detiField.setVisible(true);
				else
					detiField.setVisible(false);

				if (detiField.isVisible() == false)
					detiBox.setSelected(false);
				else
					detiBox.setSelected(true);

			}

		});
		detiBox.setBounds(139, 142, 21, 19);
		frame.getContentPane().add(detiBox);

		premiyaBox = new JCheckBox("");
		premiyaBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (premiyaField.isVisible() == false)
					premiyaField.setVisible(true);
				else
					premiyaField.setVisible(false);

				if (premiyaField.isVisible() == false)
					premiyaBox.setSelected(false);
				else
					premiyaBox.setSelected(true);
			}
		});
		premiyaBox.setBounds(139, 172, 21, 19);
		frame.getContentPane().add(premiyaBox);

		nadbavkaBox = new JCheckBox("");
		nadbavkaBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (nadbavkaField.isVisible() == false)
					nadbavkaField.setVisible(true);
				else
					nadbavkaField.setVisible(false);

				if (nadbavkaField.isVisible() == false)
					nadbavkaBox.setSelected(false);
				else
					nadbavkaBox.setSelected(true);

			}
		});
		nadbavkaBox.setBounds(139, 202, 21, 19);
		frame.getContentPane().add(nadbavkaBox);
	}
}
