package abc.abc167;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + ")\n" + "(()", "Yes");
	}

	@Test
	void case2() {
		check("2\n" + ")(\n" + "()", "No");
	}

	@Test
	void case3() {
		check("4\n" + "((()))\n" + "((((((\n" + "))))))\n" + "()()()", "Yes");
	}

	@Test
	void case4() {
		check("3\n" + "(((\n" + ")\n" + ")", "No");
	}
}
