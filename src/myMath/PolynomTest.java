package myMath;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PolynomTest {

	@Test
	void ConstTest() {
		Polynom_able p1 = new Polynom("-6 + 11x + -6x^2 + 1x^3");
		String str = p1.toString();
		String ans = "-6.0*x^0+11.0*x^1-6.0*x^2+1.0*x^3";
		if (!str.equals(ans)) {
			fail("the polynom doesn't match its ToString");
		}
	}
	
	@Test
	void FxTest() {
		Polynom_able p1 = new Polynom("-6 + 11x + -6x^2 + 1x^3");
		double num = p1.f(2);
		double ans = 0; 
		assertEquals(ans, num);
	}
	
	@Test
	void AddTest() {
		Polynom_able p1 = new Polynom("-6 + 11x + -6x^2 + 1x^3");
		Polynom_able p2 = new Polynom("20 + -29x + 10x^2 + -1x^3");
		p1.add(p2);
		String str = p1.toString(), ans = "14.0*x^0-18.0*x^1+4.0*x^2";
		if (!str.equals(ans)) {
			fail("there is something wrong with the ADD function");
		}
	}
	
	@Test
	void MonomAddTest() {
		Polynom_able p1 = new Polynom("-6 + 11x + -6x^2 + 1x^3");
		Monom m = new Monom(12,3);
		p1.add(m);
		String str = p1.toString(), ans = "-6.0*x^0+11.0*x^1-6.0*x^2+13.0*x^3";
		if (!str.equals(ans)) {
			fail("there is something wrong with the AddMonom function");
		}
	}
	
	@Test
	void substractTest() {
		Polynom_able p1 = new Polynom("-6 + 11x + -6x^2 + 1x^3");
		Polynom_able p2 = new Polynom("20 + -29x + 10x^2 + -1x^3");
		p1.substract(p2);
		String str = p1.toString(), ans = "-26.0*x^0+40.0*x^1-16.0*x^2+2.0*x^3";
		if (!str.equals(ans)) {
			fail("there is something wrong with the SUBSTRACT function");
		}
	}
	
	@Test
	void multiplyTest() {
		Polynom_able p1 = new Polynom("-6 + 11x + -6x^2 + 1x^3");
		Polynom_able p2 = new Polynom("20 + -29x + 10x^2 + -1x^3");
		p1.multiply(p2);
		String str = p1.toString(), ans = "-120.0*x^0+394.0*x^1-499.0*x^2+310.0*x^3-100.0*x^4+16.0*x^5-1.0*x^6";
		if (!str.equals(ans)) {
			fail("there is something wrong with the Multiply function");
		}
	}
	
	@Test
	void equalsTest() {
		Polynom_able p1 = new Polynom("-6 + 11x + -6x^2 + 1x^3");
		Polynom_able p2 = new Polynom("-6 + 11x + -6x^2 + 1x^3");
		boolean b = p1.equals(p2);
		assertTrue(b,"the EQUALS function is Wrong");	
	}
	
	@Test
	void ISZEROTest() {
		Polynom_able p1 = new Polynom("-6 + 11x + -6x^2 + 1x^3");
		boolean b = p1.isZero();
		assertFalse(b,"ISZERO function has something off with it..");
	}

	@Test
	void RootTest() {
		Polynom_able p1 = new Polynom("-6 + 11x + -6x^2 + 1x^3");
		double num = Math.round(p1.root(1.5,2.5, 0.0001));
		assertEquals(2.0, num);
	}
	
	@Test
	void CopyTest() {
		Polynom_able p1 = new Polynom("-6 + 11x + -6x^2 + 1x^3");
		Polynom_able k = new Polynom();
		k = p1.copy();
		assertTrue(p1.equals(k));
	}
	
	@Test
	void derivativeTest() {
		Polynom_able p1 = new Polynom("-6 + 11x + -6x^2 + 1x^3");
		Polynom_able k = p1.derivative();
		Polynom_able p1der = new Polynom("11 + -12x + 3x^2");
		assertTrue(p1der.equals(k));
	}
	
	@Test
	void AreaTest() {
		Polynom_able p1 = new Polynom("-6 + 11x + -6x^2 + 1x^3");
		assertEquals(-2,Math.round(p1.area(0, 1, 0.0001)));
	}
	
	
	
}
