package myMath;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MonomTest {

	@Test
	void constructortest() {
		double coe = 2;
		int pow = 1;
		assertNotNull(pow);
		assertNotNull(pow);
		if(coe == 0) fail("coe shouldnt be zero");
		if(pow < 0) fail("power is smaller then 0");
		Monom m = new Monom(coe,pow);
		assertEquals(coe, 2.0);
		assertEquals(pow, 1);
	}

	@Test
	void  StringConsTest() {
		Monom m1 = new Monom("3x^2");
		Monom ans = new Monom(3,2);
		assertEquals(ans.get_coefficient(), m1.get_coefficient());
		assertEquals(ans.get_power(), m1.get_power());
	}
	
	@Test
	void FXTest () {
		Monom m1 = new Monom(3,1);
		double m1f = m1.f(5);
		double ans = 15;
		assertEquals(ans, m1f);
	}
	
	@Test
	void AddTest() {
		Monom m1 = new Monom(2,5);
		Monom m2 = new Monom(4,5);
		Monom m3 = new Monom(6,5);
		m1.add(m2);
		assertEquals(m3.get_coefficient(), m1.get_coefficient());
		assertEquals(m3.get_power(), m1.get_power());
	}
	
	@Test
	void MultTest() {
		Monom m1 = new Monom(3,4);
		Monom m2 = new Monom(4,1);
		Monom ans = new Monom(12,5);
		Monom expected = m1.multiply(m2);
		assertEquals(ans.get_coefficient(), expected.get_coefficient());
		assertEquals(ans.get_power(), expected.get_power());
	}
	
	@Test
	void derivativeTest() {
		Monom m1 = new Monom(3,4);
		m1.derivative();
		Monom ans = new Monom(12,3);
		assertEquals(ans.get_coefficient(), m1.get_coefficient());
		assertEquals(ans.get_power(), m1.get_power());
	}
	
	@Test
	void toStringTest() {
		Monom m1 = new Monom(3,4);
		String str = m1.toString();
		String ans = "3.0*x^4";
		if (!str.equals(ans)) {
			fail("the ToString of this monom is WRONG!");
		}
	}
}
