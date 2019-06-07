package abc003;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("ch@ku@ai\n" + "choku@@i");
		ProblemB.main(null);
		assertResultIs("You can win");
	}

	@Test
	void test_Case2() {
		in.input("aoki\n" + "@ok@");
		ProblemB.main(null);
		assertResultIs("You will lose");
	}

	@Test
	void test_Case3() {
		in.input("arc\n" + "abc");
		ProblemB.main(null);
		assertResultIs("You will lose");
	}
}
