package abc044;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("5\n" + "3\n" + "10000\n" + "9000");
		ProblemA.main(null);
		assertResultIs("48000");
	}

	@Test
	void case2() {
		in.input("2\n" + "3\n" + "10000\n" + "9000");
		ProblemA.main(null);
		assertResultIs("20000");
	}
}
