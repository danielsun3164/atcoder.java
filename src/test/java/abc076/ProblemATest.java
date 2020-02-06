package abc076;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("2002\n" + "2017");
		ProblemA.main(null);
		assertResultIs("2032");
	}

	@Test
	void case2() {
		in.input("4500\n" + "0");
		ProblemA.main(null);
		assertResultIs("-4500");
	}
}
