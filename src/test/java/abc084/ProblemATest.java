package abc084;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("21");
		ProblemA.main(null);
		assertResultIs("27");
	}

	@Test
	void case2() {
		in.input("12");
		ProblemA.main(null);
		assertResultIs("36");
	}
}
