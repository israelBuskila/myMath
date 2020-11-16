
package myMath;
/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Boaz
 *
 *

/** this is the Monom. here we are going to create a new Monom and have a bunch of function we can
* do on it.
*/
public class Monom implements function{
	/**
	 * this is the first constructor that creates a new Monom by getting its coefficient and the power of x.
	 * @param a = represents the coefficient of this Monom.
	 * @param b = represents the power of this Monom.
	 */
	public Monom(double a, int b){
		if(b > -1 && a != 0) {
			this.set_coefficient(a);
			this.set_power(b);
		}
	}
	/**
	 * a constructor, that calls to Monom(a,b).
	 * @param ot Gets another mono and copies it to our monom
	 */
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}
	// ***************** add your code below **********************

	/**
	 * this is also a constructor but this one is different. it gets a string and splits it into smaller 
	 * strings such that we can differ between the different parts of the Monom and threw that
	 * identify the coefficient and the power of the new Monom so we could create it.
	 * @param m Gets a monom from the String type

	 */
	public Monom(String m) {
		String[] parts = m.split("x\\^");//split the string into smaller strings
		if (parts.length < 2) {
			parts = m.split("x");//this Monom has no power(= 0 or 1)
		}
		double c;
		try {
			c =  Double.parseDouble(parts[0]);//Assuming parts[0] contains only the coefficient 
			// we try to invert the string into double
		}
		catch (Exception e) {//if we get here we fail, thus there are two more options:
			// TODO: handle exception
			try {
				parts[0] += 1; //the coefficient is -1 so the Monom was written as "-x^b"
				c =  Double.parseDouble(parts[0]);
			} catch (Exception e2) {
				// TODO: handle exception 
				c = 1; //if we still got an err that means that the Monom was written as "x^b" so the 
				// coefficient is 1.
			}
		}
		this._coefficient = c;
		if(parts.length > 1) {
			int p = Integer.parseInt(parts[1]);//the other part of the array contains the power 
			this._power = p;//of the monom.
			if(c == 0 || p < 0)//if the coefficient entered is equal to 0 or the power is negative
				// then the Monom entered is defective.
				throw new RuntimeException("something is wrong with the monom you have entered");
		}
		else {
			if (m.charAt(m.length()-1) == 'x') {//if the power isn't greater then 0 maybe  we have
				// a monom like: "3x" thus the power might be 1. so we check if the last char is 'x'.
				this._power = 1;
				if(c == 0)
					throw new RuntimeException("something is wrong with the monom you have entered");
			}
			else {
				this._power = 0;//if not the Monom is only a number "a" and its power is 0;
				if(c == 0)
					throw new RuntimeException("something is wrong with the monom you have entered");
			}
		}
	}
	/**
	 * @return the current power of the monom.
	 */
	public int get_power() {
		// TODO Auto-generated method stub
		return this._power;
	}
	/**
	 * 
	 * @return the coefficient of the current monom.
	 */
	public double get_coefficient() {
		// TODO Auto-generated method stub
		return this._coefficient;
	}
	/**
	 * every monom has an "x^b" so in that part we put in x a number. 
	 * @return the new number we got.
	 */
	@Override
	public double f(double x) {
		if(x == 0)
			return 0;
		double y = this.get_coefficient()*Math.pow(x, this._power);
		return y;
	} 
	/**
	 * we multiply two monoms
	 * @param a the monom we mult by the current monom.
	 * @return the new monom we got.
	 */
	public Monom multiply(Monom a) {
		double c = this._coefficient*a._coefficient;
		int p = this._power*a._power;
		Monom n = new Monom(c,p);
		return n;
	}
	/**
	 * @param a = a new monom with the same power as the current monom
	 * we add a's coefficient to the current monoms coefficient.
	 */
	public void add(Monom a) {
		if(a.get_power() == this.get_power()) {
			double c = this._coefficient*10+a._coefficient*10;
			c/=10;
			this.set_coefficient(c);
		}
	}
	/**
	 * we make a derivative of the current monom and update it.
	 */
	public void derivative() {
		double c = (10*this._coefficient)*(10*this._power)/100;
		int p = this._power-1;
		this._coefficient = c;
		this._power = p;
	}
	/**
	 * that is the way we print our monom.
	 */
	public String toString()
	{
		int p = this.get_power();
		double c = this.get_coefficient();
		String ans = ""+c+"*x^"+p;
		return ans;
	}






	//****************** Private Methods and Data *****************

	public void set_coefficient(double a){
		this._coefficient = a;
	}
	public void set_power(int p) {
		this._power = p;
	}

	private double _coefficient; // 
	private int _power;

}
