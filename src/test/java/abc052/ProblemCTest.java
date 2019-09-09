package abc052;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("3");
		ProblemC.main(null);
		assertResultIs("4");
	}

	@Test
	void test_Case2() {
		in.input("6");
		ProblemC.main(null);
		assertResultIs("30");
	}

	@Test
	void test_Case3() {
		in.input("1000");
		ProblemC.main(null);
		assertResultIs("972926972");
	}
}
