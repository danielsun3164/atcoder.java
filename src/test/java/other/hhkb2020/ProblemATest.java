package other.hhkb2020;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("Y\n" + "a", "A");
	}

	@Test
	void case2() {
		check("N\n" + "b", "b");
	}
}
