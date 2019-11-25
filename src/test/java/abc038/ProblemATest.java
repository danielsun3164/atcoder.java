package abc038;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("ICEDT");
		ProblemA.main(null);
		assertResultIs("YES");
	}

	@Test
	void case2() {
		in.input("MUGICHA");
		ProblemA.main(null);
		assertResultIs("NO");
	}

	@Test
	void case3() {
		in.input("OOLONGT");
		ProblemA.main(null);
		assertResultIs("YES");
	}

	@Test
	void case4() {
		in.input("T");
		ProblemA.main(null);
		assertResultIs("YES");
	}

	@Test
	void case5() {
		in.input("TEA");
		ProblemA.main(null);
		assertResultIs("NO");
	}
}
