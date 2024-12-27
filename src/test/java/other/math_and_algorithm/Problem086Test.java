package other.math_and_algorithm;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class Problem086Test extends TestBase {

	@Test
	void case1() {
		check("8\n" + "(()())()", "Yes");
	}

	@Test
	void case2() {
		check("6\n" + "))()((", "No");
	}
}
