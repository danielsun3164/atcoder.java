package abc025;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("abcde\n" + "8");
		ProblemA.main(null);
		assertResultIs("bc");
	}

	@Test
	void case2() {
		in.input("aeiou\n" + "22");
		ProblemA.main(null);
		assertResultIs("ue");
	}

	@Test
	void case3() {
		in.input("vwxyz\n" + "25");
		ProblemA.main(null);
		assertResultIs("zz");
	}
}
