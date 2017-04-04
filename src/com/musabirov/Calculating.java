package com.musabirov;

public class Calculating {
	
	private double oklad2;      //���������� ����������
	private double ndflDeti;    //���������� ����������
	private double ndfl;	    //���������� ����������
	private double zarplata;    //���������� ����������
	private double itogo;       //���������� ����������
	
	
	public double getOklad2() {  
		return oklad2;
	}
	public double getNdflDeti() {
		return ndflDeti;
	}
	public double getNdfl() {
		return ndfl;
	}
	public double getZarplata() {
		return zarplata;
	}
	public double getItogo() {
		return itogo;
	}
	public Calculating(double oklad, int vsegoDni, int dni, double koeff, int deti, double premiya, double nadbavka ){
	//�������� ������������ �������� �� ��������� ������
		oklad2 = (oklad+nadbavka)*dni/vsegoDni;    //�����+�������� � ������ ������������� �������
		if (deti<3) ndflDeti = (double)(deti*1400); else ndflDeti =(double)(2800 + (deti-2)*3);  
		//���� ����� 2 ��� 1, �� �� ������� ����� ���� �� ����� 1400, �� 3-�� � ������ �� 2800
		zarplata = (double)(oklad2 + premiya + (oklad2*koeff/100)); //�-� ������������ �� ������������ ������ � ������ � 
		//������ ��������� ������������
		ndfl = (double)((zarplata - ndflDeti) * 13/100); //���� ��������� ��� ��� �� - ����� �� �����
		itogo = zarplata - ndfl;  //�������� �� �� ���� � ������ ���� ������ � �������
	}

}
