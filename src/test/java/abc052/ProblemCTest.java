package abc052;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3", "4");
	}

	@Test
	void case2() {
		check("6", "30");
	}

	@Test
	void case3() {
		check("1000", "972926972");
	}
}
