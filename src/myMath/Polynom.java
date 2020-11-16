package myMath;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Predicate;

import myMath.Monom;
/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 * 
 * @author Boaz
 *
 */
public class Polynom implements Polynom_able{
	/**
	 * this is the Polynom. we will create a set of Monoms (which is the Polynom)
	 * and test it with the functions below.
	 */
	private ArrayList<Monom>poly;
	private final Monom_Comperator com = new Monom_Comperator();

	/**
	 * this is a constructor. here we create our Polynom.
	 * @param p = is the Polynom we got and transfer into our current Polynom.
	 */
	public  Polynom(Polynom p) {
		poly = new ArrayList<Monom>();
		Iterator<Monom>monom = p.iteretor();
		while(monom.hasNext()) {
			Monom m = new Monom(monom.next());
			poly.add(m);
		}

	}

	/**
	 * this is a Polynom built using a String.
	 * @param str = the Polynom written as a String.
	 */
	public Polynom(String str) {
		poly = new ArrayList<Monom>();

		String[] a = str.split(" ");//we divide the String into smaller strings (Monom strings)
		for (int i = 0; i < a.length; i++) {
			if (i == 0) {//if this if is true it means we are on the first piece of string = a monom.
				Monom m = new Monom(a[i]);//so.. we create it.
				this.add(m);
			}
			else {
				if (a[i].charAt(0) == '+') {//if not, we are on a + 
					i++;//so we do an i++; to get to the next monom and add it.
					Monom m = new Monom(a[i]);
					this.add(m);
				}
				else if(a[i].charAt(0) == '-') {// if its not a + its a -. so we add it with a -1.
					i++;
					Monom m = new Monom(a[i]);
					m.set_coefficient(-1 * m.get_coefficient());
					this.add(m);
				}
			}
		}


	}
	
	/**
	 * a constructor we create a new Polunom.
	 */
	public Polynom() {
		poly = new ArrayList<Monom>();

	}

	/**
	 * we take an input and change it with every monom's 'x' inside the polynom, sum it all up and return it.
	 * param x = the number we will be putting insted of x in the monom.
	 * return the sum of the numbers we get after putting x
	 */
	@Override
	public double f(double x) {
		double sum = 0;
		Iterator<Monom>iterator = this.poly.iterator();
		while(iterator.hasNext()) {
			sum = sum + iterator.next().f(x);
		}
		return sum;
	}

	/**
	 * we get another Polynom and we add it to the current Polynom.
	 * param p1 the polynom we will be adding
	 */
	@Override
	public void add(Polynom_able p1) {
		int length = this.poly.size();
		int i = 0;
		boolean y;
		Iterator<Monom>monom1 = p1.iteretor();
		Iterator<Monom>monom2 = this.poly.iterator();
		while(monom1.hasNext()) {
			y = false;
			Monom m1 = new Monom(monom1.next());
			while(i < length && y == false) {
				Monom m2 = monom2.next();
				if(com.compare(m1, m2) == 0) {//if the power is the same
					if (m1.get_coefficient() == -1 * m2.get_coefficient()) {
						monom2.remove();//we check if it has an opposite coefficient, if it does
						y = true;// we delete it.
					}
					else {
						m2.add(m1); //else we add it to the current monom.
						y = true;
					}
				}
				i++;
			}

			i = 0;
			if(y == false)//if the power isn't equal we just add a new monom to the polynom.
				poly.add(m1);

			monom2 = this.poly.iterator();
		}
		poly.sort(com);//and we sort the arraylist again.
	}

	/**
	 * here we add just one Monom the our Polynom.
	 * param m1 = the monom we will be adding.
	 */
	@Override
	public void add(Monom m1) {
		Iterator<Monom>monom = this.poly.iterator();
		Monom m2;
		boolean y = false;
		while(monom.hasNext() && y == false) {
			m2 = monom.next();
			if(com.compare(m1, m2) == 0) {//if it has the same power we add it.
				m2.add(m1);	
				y = true;
			}
		}
		if(y == false) { //if not we add a new monom to the polynom.
			poly.add(m1);

		}
		poly.sort(com);
	}

	/**
	 * here we get a new Polynom and we take it monoms off of our current polynom.
	 * param p1 = the polynom we will be subing.
	 */
	@Override
	public void substract(Polynom_able p1) {
		// TODO Auto-generated method stub

		boolean y;
		Iterator<Monom>monom1 = p1.iteretor();
		Iterator<Monom>monom2 = this.poly.iterator();
		while(monom1.hasNext()) {
			y = false;
			Monom m1 = new Monom(monom1.next());
			while(monom2.hasNext() && y == false) {
				Monom m2 = new Monom(monom2.next());
				if(com.compare(m1, m2) == 0) {//if the current monoms has the same power:
					double c1 = m1.get_coefficient();//and the coefficients are equal.
					double c2 = m2.get_coefficient();
					double c = (c2*10-c1*10)/10;//just so the numbers dont break (2 turns into 1.99999999)
					monom2.remove();//then we delete it from the polynom.
					if(c != 0) {//if the coefficient are different
						Monom temp = new Monom(c,m2.get_power());
						poly.add(temp);//we add it back again.
					}
					y = true;
				}
			}
			monom2 = this.poly.iterator();//if the power is different we just add the monom to our Polynom 
			if(y == false) {//just mult it by -1
				double c1 = m1.get_coefficient();
				int p = m1.get_power();
				Monom n = new Monom(c1, p);
				n.set_coefficient(-1*c1);
				poly.add(n);
			}
		}
		poly.sort(com);

	}

	/**
	 * this function gets a new polynom and mults every monom in it by every monom it the current polynom.
	 * param p1 = the polynom we will be multiplying.
	 */
	@Override
	public void multiply(Polynom_able p1) {
		// TODO Auto-generated method stub

		Polynom k = new Polynom();//we need a temp polynom to store the new monoms and the update our 
		//current monom.
		Iterator<Monom>monom1 = p1.iteretor();
		Iterator<Monom>monom2 = this.poly.iterator();
		while(monom2.hasNext()) {
			Monom m2 = new Monom(monom2.next());
			while(monom1.hasNext()) {
				Monom m1 = new Monom(monom1.next());
				double c1 = (m1.get_coefficient()*10);
				double c2 = (m2.get_coefficient()*10);
				c1 *= c2;
				double c = (c1/100);
				int p = m2.get_power()+m1.get_power();
				Monom n = new Monom(c, p);
				k.add(new Monom(n));
			}
			monom1 = p1.iteretor();
		}
		this.poly = new ArrayList<Monom>();//here we update our current Polynom to the temp we created earlier.
		Iterator<Monom>monom = k.iteretor();
		while(monom.hasNext()) {
			Monom m = new Monom(monom.next());
			poly.add(m);
		}
		this.poly.sort(com);
	}

	/**
	 * here we check if each monom by order in the polynom we get is equal to out current polynom's monms
	 * param p1 = the polynom we will be comparing.
	 * return true if they are equal and false if not.
	 */
	@Override
	public boolean equals(Polynom_able p1) {
		Iterator<Monom>monom1 = p1.iteretor();
		Iterator<Monom>monom2 = this.poly.iterator();
		while(monom1.hasNext()) {
			Monom m1 = new Monom(monom1.next());
			Monom m2 = new Monom(monom2.next());
			if(com.compare(m1, m2) != 0 || m1.get_coefficient() != m2.get_coefficient())
				return false;// if there are two monoms in order that are somehow different 
			//return false.
		}
		return true;//if not, and they are all equal then return true;
	}

	/**
	 * checks if all of the coefficients in all of the monoms in the polynom are zero.
	 * return true if all coefficients are zero and false if not.
	 */
	@Override
	public boolean isZero() {
		Iterator<Monom> monom = this.poly.iterator();
		while (monom.hasNext()) {
			Monom m = new Monom(monom.next());
			if (m.get_coefficient() != 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * finds the x in between x0 and x1 that its y= +/- eps ~= 0.
	 * param x0 = the min x.
	 * param x1 = the max x.
	 * param eps = how close it needs to be to y=0.
	 * return the x we found.
	 */
	@Override
	public double root(double x0, double x1, double eps) {
		if (f(x0)*f(x1) > 0) {
			throw new RuntimeException("x0 mult x1 has to be negative or else it will never get to y=0");
		}
		if (x1 < x0) {
			double temp = x0;
			x0 = x1;
			x1 = temp;
		}
		double avgx = (x0+x1)/2;
		while (x1-x0 > eps) {
			avgx = (x0+x1)/2;
			if ((f(x0) * f(avgx)) > 0) {
				x0=avgx;
			}
			else x1=avgx;
		}
		return avgx;
	}

	/**
	 * creates a copy of the current polynom.
	 * return the copy. (k)
	 */
	@Override
	public Polynom_able copy() {
		Polynom k = new Polynom();

		Iterator<Monom>monom = this.poly.iterator();
		while(monom.hasNext()) {
			Monom m = new Monom(monom.next());
			k.add(new Monom(m));
		}

		return k;
	}

	/**
	 * updates the current polynom into a polynom of its monoms derivative.
	 * return the updated virsion of the polynom. all derivatives.
	 */
	@Override
	public Polynom_able derivative() {
		Polynom k = new Polynom();//we store the derivatives of the monoms in a temp polynom. then we update it.
		Iterator<Monom>monom = this.poly.iterator();
		while(monom.hasNext()) {
			Monom m = monom.next();
			if(m.get_power() != 0) {
				m.derivative();
				k.add(m);
			}
			else monom.remove();
		}

		return k;
	}

	/**
	 * finds the area under the function beween x1 and x0 as close as "eps".
	 *  * param x0 = the min x.
	 * param x1 = the max x.
	 * param eps = how close it needs to be to y=0.
	 * return the area.
	 */
	@Override
	public double area(double x0, double x1, double eps) {
		double y;
		double ar = 0;//the area
		for(double i = x0; i<x1; i=i+eps) { // cuts the area of our function to parts. 
			for(int j = 0; j<poly.size(); j++) {
				double temp = i+(eps/2);
				y = poly.get(j).f(temp); // using this we find the area of the trapezoid  
				ar = ar + (y*eps); // we sum up all the areas of the trapezoids together. 
			}
		}
		return ar; // returns the area we found.
	}

	/**
	 * this is the function that defines the iteretor.
	 */
	public Iterator<Monom> iteretor() {
		Iterator<Monom> it = new Iterator<Monom>() {

			private int currentIndex = -1;

			@Override
			public boolean hasNext() {
				if (currentIndex+1 >= poly.size()) {
					return false;
				}
				return true;
			}

			@Override
			public Monom next() {
				currentIndex++;
				Monom m = new Monom(poly.get(currentIndex));
				return m; 
			}
		};
		return it;
	}

	/**
	 * at last, this is the function that prints the Polynom.
	 * return the polynom.
	 */
	public String toString()
	{
		boolean first = true;
		String ans = "";
		Iterator<Monom> it = poly.iterator();

		while(it.hasNext())
		{
			Monom s = it.next();
			if(s.get_coefficient() >= 0 && first == false)
				ans += "+";


			ans += s.toString()+"";
			first = false;
		}

		return ans;
	}

}




