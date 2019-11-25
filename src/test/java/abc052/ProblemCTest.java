package abc052;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("3");
		ProblemC.main(null);
		assertResultIs("4");
	}

	@Test
	void case2() {
		in.input("6");
		ProblemC.main(null);
		assertResultIs("30");
	}

	@Test
	void case3() {
		in.input("1000");
		ProblemC.main(null);
		assertResultIs("972926972");
	}
}
