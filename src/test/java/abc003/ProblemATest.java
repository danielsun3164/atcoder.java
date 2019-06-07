package abc003;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("6");
		ProblemA.main(null);
		assertResultIs("35000");
	}

	@Test
	void test_Case2() {
		in.input("91");
		ProblemA.main(null);
		assertResultIs("460000");
	}
}
