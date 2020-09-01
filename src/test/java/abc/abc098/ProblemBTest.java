package abc.abc098;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("6\n" + "aabbca", "2");
	}

	@Test
	void case2() {
		check("10\n" + "aaaaaaaaaa", "1");
	}

	@Test
	void case3() {
		check("45\n" + "tgxgdqkyjzhyputjjtllptdfxocrylqfqjynmfbfucbir", "9");
	}
}
