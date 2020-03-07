package abc082;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("yx\n" + "axy");
		ProblemB.main(null);
		assertResultIs("Yes");
	}

	@Test
	void case2() {
		in.input("ratcode\n" + "atlas");
		ProblemB.main(null);
		assertResultIs("Yes");
	}

	@Test
	void case3() {
		in.input("cd\n" + "abc");
		ProblemB.main(null);
		assertResultIs("No");
	}

	@Test
	void case4() {
		in.input("w\n" + "ww");
		ProblemB.main(null);
		assertResultIs("Yes");
	}

	@Test
	void case5() {
		in.input("zzz\n" + "zzz");
		ProblemB.main(null);
		assertResultIs("No");
	}
}
