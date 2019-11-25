package abc025;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("3 5 10\n" + "East 7\n" + "West 3\n" + "West 11");
		ProblemB.main(null);
		assertResultIs("West 8");
	}

	@Test
	void case2() {
		in.input("3 3 8\n" + "West 6\n" + "East 3\n" + "East 1");
		ProblemB.main(null);
		assertResultIs("0");
	}

	@Test
	void case3() {
		in.input("5 25 25\n" + "East 1\n" + "East 1\n" + "West 1\n" + "East 100\n" + "West 1");
		ProblemB.main(null);
		assertResultIs("East 25");
	}
}
