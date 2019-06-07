package abc002;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("chokudai");
		ProblemB.main(null);
		assertResultIs("chkd");
	}

	@Test
	void test_Case2() {
		in.input("okanemochi");
		ProblemB.main(null);
		assertResultIs("knmch");
	}

	@Test
	void test_Case3() {
		in.input("aoki");
		ProblemB.main(null);
		assertResultIs("k");
	}

	@Test
	void test_Case4() {
		in.input("mazushii");
		ProblemB.main(null);
		assertResultIs("mzsh");
	}
}
