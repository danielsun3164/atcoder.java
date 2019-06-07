package abc017;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("chokuou");
		ProblemB.main(null);
		assertResultIs("YES");
	}

	@Test
	void test_Case2() {
		in.input("kuccho");
		ProblemB.main(null);
		assertResultIs("NO");
	}

	@Test
	void test_Case3() {
		in.input("atcoder");
		ProblemB.main(null);
		assertResultIs("NO");
	}
}
