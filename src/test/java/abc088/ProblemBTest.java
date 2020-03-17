package abc088;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("2\n" + "3 1");
		ProblemB.main(null);
		assertResultIs("2");
	}

	@Test
	void case2() {
		in.input("3\n" + "2 7 4");
		ProblemB.main(null);
		assertResultIs("5");
	}

	@Test
	void case3() {
		in.input("4\n" + "20 18 2 18");
		ProblemB.main(null);
		assertResultIs("18");
	}
}
