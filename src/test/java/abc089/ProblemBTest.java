package abc089;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("6\n" + "G W Y P Y W");
		ProblemB.main(null);
		assertResultIs("Four");
	}

	@Test
	void case2() {
		in.input("9\n" + "G W W G P W P G G");
		ProblemB.main(null);
		assertResultIs("Three");
	}

	@Test
	void case3() {
		in.input("8\n" + "P Y W G Y W Y Y");
		ProblemB.main(null);
		assertResultIs("Four");
	}
}
