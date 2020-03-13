package abc085;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("2017/01/07");
		ProblemA.main(null);
		assertResultIs("2018/01/07");
	}

	@Test
	void case2() {
		in.input("2017/01/31");
		ProblemA.main(null);
		assertResultIs("2018/01/31");
	}

	@Test
	void case3() {
		in.input("2017/01/01");
		ProblemA.main(null);
		assertResultIs("2018/01/01");
	}
}
