package abc167;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("chokudai\n" + "chokudaiz");
		ProblemA.main(null);
		assertResultIs("Yes");
	}

	@Test
	void case2() {
		in.input("snuke\n" + "snekee");
		ProblemA.main(null);
		assertResultIs("No");
	}

	@Test
	void case3() {
		in.input("a\n" + "aa");
		ProblemA.main(null);
		assertResultIs("Yes");
	}
}
