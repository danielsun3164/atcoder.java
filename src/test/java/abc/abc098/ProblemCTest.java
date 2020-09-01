package abc.abc098;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "WEEWW", "1");
	}

	@Test
	void case2() {
		check("12\n" + "WEWEWEEEWWWE", "4");
	}

	@Test
	void case3() {
		check("8\n" + "WWWWWEEE", "3");
	}
}
