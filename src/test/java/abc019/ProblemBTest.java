package abc019;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("aabbbaad");
		ProblemB.main(null);
		assertResultIs("a2b3a2d1");
	}

	@Test
	void case2() {
		in.input("aabbbbbbbbbbbbxyza");
		ProblemB.main(null);
		assertResultIs("a2b12x1y1z1a1");
	}

	@Test
	void case3() {
		in.input("edcba");
		ProblemB.main(null);
		assertResultIs("e1d1c1b1a1");
	}
}
