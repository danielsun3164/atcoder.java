package abc072;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("atcoder");
		ProblemB.main(null);
		assertResultIs("acdr");
	}

	@Test
	void case2() {
		in.input("aaaa");
		ProblemB.main(null);
		assertResultIs("aa");
	}

	@Test
	void case3() {
		in.input("z");
		ProblemB.main(null);
		assertResultIs("z");
	}

	@Test
	void case4() {
		in.input("fukuokayamaguchi");
		ProblemB.main(null);
		assertResultIs("fkoaaauh");
	}
}
