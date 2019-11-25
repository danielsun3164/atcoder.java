package abc055;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("20");
		ProblemA.main(null);
		assertResultIs("15800");
	}

	@Test
	void case2() {
		in.input("60");
		ProblemA.main(null);
		assertResultIs("47200");
	}
}
