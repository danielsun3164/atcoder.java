package abc168;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		in.input("3\n" + "1 2\n" + "-1 1\n" + "2 -1");
		ProblemE.main(null);
		assertResultIs("5");
	}

	@Test
	void case2() {
		in.input("10\n" + "3 2\n" + "3 2\n" + "-1 1\n" + "2 -1\n" + "-3 -9\n" + "-8 12\n" + "7 7\n" + "8 1\n" + "8 2\n"
				+ "8 4");
		ProblemE.main(null);
		assertResultIs("479");
	}
}
