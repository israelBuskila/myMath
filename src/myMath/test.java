package myMath;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Polynom_able p1 = new Polynom("-6 + 11x + -6x^2 + 1x^3");
		Polynom_able p2 = new Polynom("20 + -29x + 10x^2 + -1x^3");
		Polynom p3 = new Polynom("-6 + 11x + -6x^2 + 1x^3");
		Polynom p4 = new Polynom(" ");

		//isZero
		System.out.println("\nisZero\n");
		boolean c = p3.isZero();
		System.out.println("isZero? = get false");
		System.out.println(c);
		System.out.println("isZero? = get true");
		c = p4.isZero();
		System.out.println(c);
		
		//equals
		System.out.println("\nequals\n");
		boolean f = p1.equals(p2);
		System.out.println("equals? = get false");
		System.out.println(f);
		
		f = p1.equals(p3);
		System.out.println("equals? = get true");
		System.out.println(f);
		
		//add
		System.out.println("\nadd\n");
		p1.add(p2);
		System.out.println("p1 + p2 = get \"14.0*x^0-18.0*x^1+4.0*x^2\":");
		System.out.println(p1);

		//substract
		System.out.println("\nsubstract\n");
		p1.substract(p2);
		System.out.println("p1 - p2 = get \"-6.0*x^0+11.0*x^1-6.0*x^2+1.0*x^3\":");
		System.out.println(p1);

		//multiply
		System.out.println("\nmultiply\n");
		Polynom_able mul = p1.copy();
		mul.multiply(p2);
		System.out.println("p1 * p2 = get \"-120.0*x^0+394.0*x^1-499.0*x^2+310.0*x^3-100.0*x^4+16.0*x^5-1.0*x^6\":");
		System.out.println(mul);

		//derivative
		System.out.println("\nderivative\n");
		
		Polynom_able t1 = p1.copy();
		t1.derivative();
		System.out.println("derivative(t1) = get \"11.0*x^0-12.0*x^1+3.0*x^2\":");
		System.out.println(t1);

		Polynom_able t2 = p2.copy();
		t2.derivative();
		System.out.println("derivative(d2) = get \"-29.0*x^0+20.0*x^1-3.0*x^2\":");
		System.out.println(t2);

		//f(x)
		System.out.println("\nf(x)\n");
		
		System.out.println("f(p1) = get 0:" + p1.f(2));
		System.out.println("f(p2) = get -6:" + p2.f(2));


		//root p1
		System.out.println("\nroot\n");
		
		
		System.out.println("root 1 = get something close to 1:" + p1.root(0,0.5, 0.0001));
		System.out.println("root 2 = get something close to 2:" + p1.root(1.5, 2.5, 0.0001));
		System.out.println("root 3 = get something close to 3:" + p1.root(2.5, 3.5, 0.0001));

		//root p2
		System.out.println("root 1 = get something close to 1:" + p2.root(-1, 2, 0.0001));
		System.out.println("root 2 = get something close to 4:" + p2.root(3.5, 4.5, 0.0001));
		System.out.println("root 3 = get something close to 5:" + p2.root(4.5, 5.5, 0.0001));

		//area
		System.out.println("\narea\n");
		
		System.out.println("get something close to -2.25:" + p1.area(0, 1, 0.0001));
		System.out.println("get something close to -0.25:" + p1.area(0.5, 1.5, 0.0001));
		System.out.println("get something close to -0.140:" + p1.area(0.5, 2, 0.0001));
		System.out.println("get something close to 8.58:" + p2.area(0, 1, 0.0001));


	}

}
