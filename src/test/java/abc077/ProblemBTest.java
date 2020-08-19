package abc077;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("10", "9");
	}

	@Test
	void case2() {
		check("81", "81");
	}

	@Test
	void case3() {
		check("271828182", "271821169");
	}
}
