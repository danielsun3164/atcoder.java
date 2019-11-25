package abc003;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("6");
		ProblemA.main(null);
		assertResultIs("35000");
	}

	@Test
	void case2() {
		in.input("91");
		ProblemA.main(null);
		assertResultIs("460000");
	}
}
