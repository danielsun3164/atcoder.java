package abc017;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("chokuou");
		ProblemB.main(null);
		assertResultIs("YES");
	}

	@Test
	void case2() {
		in.input("kuccho");
		ProblemB.main(null);
		assertResultIs("NO");
	}

	@Test
	void case3() {
		in.input("atcoder");
		ProblemB.main(null);
		assertResultIs("NO");
	}
}
