package abc.abc113;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2 3\n" + "1 32\n" + "2 63\n" + "1 12", "000001000002" + LF + "000002000001" + LF + "000001000001");
	}

	@Test
	void case2() {
		check("2 3\n" + "2 55\n" + "2 77\n" + "2 99", "000002000001" + LF + "000002000002" + LF + "000002000003");
	}
}
