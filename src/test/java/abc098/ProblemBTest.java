package abc098;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("6\n" + "aabbca");
		ProblemB.main(null);
		assertResultIs("2");
	}

	@Test
	void case2() {
		in.input("10\n" + "aaaaaaaaaa");
		ProblemB.main(null);
		assertResultIs("1");
	}

	@Test
	void case3() {
		in.input("45\n" + "tgxgdqkyjzhyputjjtllptdfxocrylqfqjynmfbfucbir");
		ProblemB.main(null);
		assertResultIs("9");
	}
}
