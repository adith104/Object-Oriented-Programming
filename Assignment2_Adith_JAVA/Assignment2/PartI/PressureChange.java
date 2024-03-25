
public class PressureChange {

	public static double calculatePressureChange(double diameter,double length,double mu,double q) {
		
		
		double pre=(128/Math.PI)*((mu*q)/Math.pow(diameter, 4))*length;
		
		
		
		return pre;
	}
	
	public static void main(String[] args) {
		double diameter = .0254;
		double length = 5;
		double mu = 8.9E-4;
		double q = 5e-4;
		
		double pressureChange = calculatePressureChange(diameter,length,mu,q);
		System.out.println("The change in pressure is: " 
		 		+ pressureChange);

	}
}
