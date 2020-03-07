package abc083;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("20 2 5");
		ProblemB.main(null);
		assertResultIs("84");
	}

	@Test
	void case2() {
		in.input("10 1 2");
		ProblemB.main(null);
		assertResultIs("13");
	}

	@Test
	void case3() {
		in.input("100 4 16");
		ProblemB.main(null);
		assertResultIs("4554");
	}
}
