package abc001;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("15000");
		ProblemB.main(null);
		assertResultIs("65");
	}

	@Test
	void case2() {
		in.input("75000");
		ProblemB.main(null);
		assertResultIs("89");
	}

	@Test
	void case3() {
		in.input("200");
		ProblemB.main(null);
		assertResultIs("02");
	}
}
