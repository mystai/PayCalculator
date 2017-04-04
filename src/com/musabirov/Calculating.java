package com.musabirov;

public class Calculating {
	
	private double oklad2;      //объ€вление переменной
	private double ndflDeti;    //объ€вление переменной
	private double ndfl;	    //объ€вление переменной
	private double zarplata;    //объ€вление переменной
	private double itogo;       //объ€вление переменной
	
	
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
	//начинаем рассчитывать зарплату по введенным данным
		oklad2 = (oklad+nadbavka)*dni/vsegoDni;    //ќклад+надбавка с учетом отработанного времени
		if (deti<3) ndflDeti = (double)(deti*1400); else ndflDeti =(double)(2800 + (deti-2)*3);  
		//≈сли детей 2 или 1, то за каждого вычет Ќƒ‘Ћ на сумму 1400, за 3-го и дальше по 2800
		zarplata = (double)(oklad2 + premiya + (oklad2*koeff/100)); //«-п складываетс€ из подсчитнного оклада и премии с 
		//учетом районного коэффициента
		ndfl = (double)((zarplata - ndflDeti) * 13/100); //Ќдфл считаетс€ как вс€ зп - вычет за детей
		itogo = zarplata - ndfl;  //»тогова€ «п на руки с учетом всех премий и вычетов
	}

}
