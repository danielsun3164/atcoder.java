package abc.abc001_050.abc019;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("aabbbaad", "a2b3a2d1");
	}

	@Test
	void case2() {
		check("aabbbbbbbbbbbbxyza", "a2b12x1y1z1a1");
	}

	@Test
	void case3() {
		check("edcba", "e1d1c1b1a1");
	}
}
