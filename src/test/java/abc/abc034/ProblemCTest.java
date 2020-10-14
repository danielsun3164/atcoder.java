package abc.abc034;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("4 3", "10");
	}

	@Test
	void case2() {
		check("123 456", "210368064");
	}
}
