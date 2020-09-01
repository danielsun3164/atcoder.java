package abc.abc038;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("ICEDT", "YES");
	}

	@Test
	void case2() {
		check("MUGICHA", "NO");
	}

	@Test
	void case3() {
		check("OOLONGT", "YES");
	}

	@Test
	void case4() {
		check("T", "YES");
	}

	@Test
	void case5() {
		check("TEA", "NO");
	}
}
