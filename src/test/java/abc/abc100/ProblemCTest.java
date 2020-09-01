package abc.abc100;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "5 2 4", "3");
	}

	@Test
	void case2() {
		check("4\n" + "631 577 243 199", "0");
	}

	@Test
	void case3() {
		check("10\n" + "2184 2126 1721 1800 1024 2528 3360 1945 1280 1776", "39");
	}
}
