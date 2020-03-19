package abc090;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("ant\n" + "obe\n" + "rec");
		ProblemA.main(null);
		assertResultIs("abc");
	}

	@Test
	void case2() {
		in.input("edu\n" + "cat\n" + "ion");
		ProblemA.main(null);
		assertResultIs("ean");
	}
}
