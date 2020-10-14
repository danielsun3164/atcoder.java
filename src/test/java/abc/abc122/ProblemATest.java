package abc.abc122;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("A", "T");
	}

	@Test
	void case2() {
		check("G", "C");
	}

	@Test
	void case3() {
		check("T", "A");
	}

	@Test
	void case4() {
		check("C", "G");
	}
}
