package past201912;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("678");
		ProblemA.main(null);
		assertResultIs("1356");
	}

	@Test
	void case2() {
		in.input("abc");
		ProblemA.main(null);
		assertResultIs("error");
	}

	@Test
	void case3() {
		in.input("0x8");
		ProblemA.main(null);
		assertResultIs("error");
	}

	@Test
	void case4() {
		in.input("012");
		ProblemA.main(null);
		assertResultIs("24");
	}
}
