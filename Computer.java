package main;

public class Computer {
	
	String brand ;
	String model ;
	long SN ;
	double price ;
	private static int numberOfCreatedComputers = 0;
	
	public Computer(String br , String md , long s , double pr) {
		
		brand = br ;
		model = md ;
		SN = s ;
		price = pr ;
		numberOfCreatedComputers++;
	}

	public String getBrand() {
		return brand ;
	}
	
	public void setBrand(String br) {
		brand = br ;
	}
	
	public String getModel() {
		return model ;
	}
	
	public void setModel(String md) {
		model = md ;
	}
	
	public long getSN() {
		return SN ;
	}
	
	public void setSN(long s) {
		SN = s;
	}
	
	public double getPrice() {
		return price ;
	}
	
	public void setPrice(double pr) {
		price = pr ;
	}
	
	public int findNumberOfCreatedComputers() {
		return numberOfCreatedComputers;
	}
	
	public void showInfo() {
		System.out.println("Brand : " + brand + ", Model : " + model 
				+ ", Sr. No. : " + SN + ", Price : " + price);
	}
	
	public boolean equals (Computer c) {
		if( brand == c.brand && model == c.model && SN == c.SN && price == c.price) {
			return true ;
		}else {
			return false ;
		}
	}
}
