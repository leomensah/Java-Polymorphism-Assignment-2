abstract class staffMember{
	String name;
	String address;
	String phone;
	
	staffMember(String name, String address, String phone){
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	
	public String toString() {
		return "Name of staff is: "+this.name+" Address is: "+this.address+" with phone number: "+this.phone;
	}
	
	
	public abstract double pay();
}

class Volunteer extends staffMember{	
	Volunteer(String name, String address, String phone){
		super(name, address, phone);
	}
	public double pay() {
		return 0.0;
	}
}


class Employee extends staffMember{
	String socialSecurityNumber;
	double payRate;
	
	Employee(String name, String address, String phone, String socialSecurityNumber, double payRate){
		super(name, address, phone);
		this.socialSecurityNumber = socialSecurityNumber;
		this.payRate = payRate;
	}
	
	public String toString() {
		return super.toString()+
				"\nSocial Security Number: "+this.socialSecurityNumber+" with a salary of: $"+this.pay();
	}
	
	public double pay() {
		return payRate;
	}
}

class Executive extends Employee{
	private double bonus = 0.00;
	
	Executive(String name, String address, String phone, String socialSecurityNumber, double payRate){
		super(name, address, phone, socialSecurityNumber, payRate);
	}
	
	public void awardBonus(double execBonus) {
		bonus = execBonus;
	}
	
	public double getBonus() {
		return bonus;
	}
	
	public String toString() {
		return super.toString()+
				"\nand Bonus of Executive is: "+this.getBonus();
	}
	
	public double pay() {
		return super.pay() + this.getBonus();
	}
}

class Hourly extends Employee{
	private int hoursWorked;
	
	public void addHours(int moreHours) {
		hoursWorked = moreHours;
	}
	
	public int hoursWorked() {
		return hoursWorked;
	}
	
	Hourly(String name, String address, String phone, String socialSecurityNumber, double payRate){
		super(name, address, phone, socialSecurityNumber, payRate);
	}
	
	public double pay() {
		return super.pay() * this.hoursWorked();
	}
	
	public String toString() {
		return super.toString() + "\nand number of hours worked is: "+this.hoursWorked()+" Hours";
	}
}


class Commission extends Hourly{
	double totalSales = 0.0;
	double commRate = 0.0;
	
	
	Commission(String name, String address, String phone, String socialSecurityNumber, double payRate, double commRate){
		super(name, address, phone, socialSecurityNumber, payRate);
		this.commRate = commRate;
	}
	
	public void addSales(double totalSales) {
		this.totalSales = totalSales; 
	}
	
	public double pay() {
		double commAmount = totalSales * commRate;
		return super.pay() + commAmount;
	}
	
	public String toString() {
		return super.toString() + "\nand the commision rate is: "+commRate;
	}
}

class Staff{
	staffMember[] staffList;
	
	Staff(){
		staffList = new staffMember[7];
		
		staffList[0] = new Commission("Leonard", "Kumasi", "0245654576", "NSS123A23ER34", 6.25, 0.2);
		staffList[1] = new Commission("Simon", "Kasoa", "0245923023", "NCC1432UCI2021", 9.75, 0.15);
		
		
		((Commission) staffList[0]).addHours(35);
		((Commission) staffList[0]).addSales(400);
		
		((Commission) staffList[1]).addHours(40);
		((Commission) staffList[1]).addSales(950);
		
		
	}
}

public class Firm{
	public static void main(String[] args) {
		
		Staff sf = new Staff();
		
		
		for(int i=0; i<2; i++) {
			System.out.println(sf.staffList[i].toString());
		}
	}
}



















