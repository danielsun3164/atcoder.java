package abc085;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("4\n" + "10\n" + "8\n" + "8\n" + "6");
		ProblemB.main(null);
		assertResultIs("3");
	}

	@Test
	void case2() {
		in.input("3\n" + "15\n" + "15\n" + "15");
		ProblemB.main(null);
		assertResultIs("1");
	}

	@Test
	void case3() {
		in.input("7\n" + "50\n" + "30\n" + "50\n" + "100\n" + "50\n" + "80\n" + "30");
		ProblemB.main(null);
		assertResultIs("4");
	}
}
