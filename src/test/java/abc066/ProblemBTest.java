package abc066;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("abaababaab");
		ProblemB.main(null);
		assertResultIs("6");
	}

	@Test
	void test_Case2() {
		in.input("xxxx");
		ProblemB.main(null);
		assertResultIs("2");
	}

	@Test
	void test_Case3() {
		in.input("abcabcabcabc");
		ProblemB.main(null);
		assertResultIs("6");
	}

	@Test
	void test_Case4() {
		in.input("akasakaakasakasakaakas");
		ProblemB.main(null);
		assertResultIs("14");
	}
}
