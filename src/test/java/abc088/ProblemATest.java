package abc088;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("2018\n" + "218");
		ProblemA.main(null);
		assertResultIs("Yes");
	}

	@Test
	void case2() {
		in.input("2763\n" + "0");
		ProblemA.main(null);
		assertResultIs("No");
	}

	@Test
	void case3() {
		in.input("37\n" + "514");
		ProblemA.main(null);
		assertResultIs("Yes");
	}
}
