package abc034;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("4 3");
		ProblemC.main(null);
		assertResultIs("10");
	}

	@Test
	void case2() {
		in.input("123 456");
		ProblemC.main(null);
		assertResultIs("210368064");
	}
}
