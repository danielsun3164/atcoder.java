package abc171;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("5 3\n" + "50 100 80 120 80");
		ProblemB.main(null);
		assertResultIs("210");
	}

	@Test
	void case2() {
		in.input("1 1\n" + "1000");
		ProblemB.main(null);
		assertResultIs("1000");
	}
}
