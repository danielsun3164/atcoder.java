package abc066;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("abaababaab");
		ProblemB.main(null);
		assertResultIs("6");
	}

	@Test
	void case2() {
		in.input("xxxx");
		ProblemB.main(null);
		assertResultIs("2");
	}

	@Test
	void case3() {
		in.input("abcabcabcabc");
		ProblemB.main(null);
		assertResultIs("6");
	}

	@Test
	void case4() {
		in.input("akasakaakasakasakaakas");
		ProblemB.main(null);
		assertResultIs("14");
	}
}
