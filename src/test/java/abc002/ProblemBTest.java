package abc002;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		in.input("chokudai");
		ProblemB.main(null);
		assertResultIs("chkd");
	}

	@Test
	void case2() {
		in.input("okanemochi");
		ProblemB.main(null);
		assertResultIs("knmch");
	}

	@Test
	void case3() {
		in.input("aoki");
		ProblemB.main(null);
		assertResultIs("k");
	}

	@Test
	void case4() {
		in.input("mazushii");
		ProblemB.main(null);
		assertResultIs("mzsh");
	}
}
