package abc079;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("1118");
		ProblemA.main(null);
		assertResultIs("Yes");
	}

	@Test
	void case2() {
		in.input("7777");
		ProblemA.main(null);
		assertResultIs("Yes");
	}

	@Test
	void case3() {
		in.input("1234");
		ProblemA.main(null);
		assertResultIs("No");
	}
}
