package abc.abc076;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("2002\n" + "2017", "2032");
	}

	@Test
	void case2() {
		check("4500\n" + "0", "-4500");
	}
}
