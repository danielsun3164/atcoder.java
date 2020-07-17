package abc169;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		in.input("2\n" + "1 2\n" + "2 3");
		ProblemE.main(null);
		assertResultIs("3");
	}

	@Test
	void case2() {
		in.input("3\n" + "100 100\n" + "10 10000\n" + "1 1000000000");
		ProblemE.main(null);
		assertResultIs("9991");
	}
}
