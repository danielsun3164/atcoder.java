package abc095;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("3 1000\n" + "120\n" + "100\n" + "140");
		ProblemB.main(null);
		assertResultIs("9");
	}

	@Test
	void case2() {
		in.input("4 360\n" + "90\n" + "90\n" + "90\n" + "90");
		ProblemB.main(null);
		assertResultIs("4");
	}

	@Test
	void case3() {
		in.input("5 3000\n" + "150\n" + "130\n" + "150\n" + "130\n" + "110");
		ProblemB.main(null);
		assertResultIs("26");
	}
}
