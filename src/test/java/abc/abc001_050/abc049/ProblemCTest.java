package abc.abc001_050.abc049;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("erasedream", "YES");
	}

	@Test
	void case2() {
		check("dreameraser", "YES");
	}

	@Test
	void case3() {
		check("dreamerer", "NO");
	}
}
