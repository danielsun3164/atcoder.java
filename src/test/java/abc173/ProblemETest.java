package abc173;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		in.input("4 2\n" + "1 2 -3 -4");
		ProblemE.main(null);
		assertResultIs("12");
	}

	@Test
	void case2() {
		in.input("4 3\n" + "-1 -2 -3 -4");
		ProblemE.main(null);
		assertResultIs("1000000001");
	}

	@Test
	void case3() {
		in.input("2 1\n" + "-1 1000000000");
		ProblemE.main(null);
		assertResultIs("1000000000");
	}

	@Test
	void case4() {
		in.input("10 10\n" + "1000000000 100000000 10000000 1000000 100000 10000 1000 100 10 1");
		ProblemE.main(null);
		assertResultIs("999983200");
	}
}
