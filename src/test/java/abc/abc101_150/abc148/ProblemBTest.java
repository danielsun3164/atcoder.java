package abc.abc101_150.abc148;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "ip cc", "icpc");
	}

	@Test
	void case2() {
		check("8\n" + "hmhmnknk uuuuuuuu", "humuhumunukunuku");
	}

	@Test
	void case3() {
		check("5\n" + "aaaaa aaaaa", "aaaaaaaaaa");
	}
}
