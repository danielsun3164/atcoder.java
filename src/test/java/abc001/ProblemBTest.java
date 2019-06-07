package abc001;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("15000");
		ProblemB.main(null);
		assertResultIs("65");
	}

	@Test
	void test_Case2() {
		in.input("75000");
		ProblemB.main(null);
		assertResultIs("89");
	}

	@Test
	void test_Case3() {
		in.input("200");
		ProblemB.main(null);
		assertResultIs("02");
	}
}
