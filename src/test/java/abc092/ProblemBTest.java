package abc092;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("3\n" + "7 1\n" + "2\n" + "5\n" + "10");
		ProblemB.main(null);
		assertResultIs("8");
	}

	@Test
	void case2() {
		in.input("2\n" + "8 20\n" + "1\n" + "10");
		ProblemB.main(null);
		assertResultIs("29");
	}

	@Test
	void case3() {
		in.input("5\n" + "30 44\n" + "26\n" + "18\n" + "81\n" + "18\n" + "6");
		ProblemB.main(null);
		assertResultIs("56");
	}
}
