package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem020Test extends TestBase {

	@Test
	void case1() {
		check("5\n" + "100 150 200 250 300", "1");
	}

	@Test
	void case2() {
		check("13\n" + "243 156 104 280 142 286 196 132 128 195 265 300 130", "4");
	}
}
