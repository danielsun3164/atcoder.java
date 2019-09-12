package abc055;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("20");
		ProblemA.main(null);
		assertResultIs("15800");
	}

	@Test
	void test_Case2() {
		in.input("60");
		ProblemA.main(null);
		assertResultIs("47200");
	}
}
