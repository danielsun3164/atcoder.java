package abc038;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("ICEDT");
		ProblemA.main(null);
		assertResultIs("YES");
	}

	@Test
	void test_Case2() {
		in.input("MUGICHA");
		ProblemA.main(null);
		assertResultIs("NO");
	}

	@Test
	void test_Case3() {
		in.input("OOLONGT");
		ProblemA.main(null);
		assertResultIs("YES");
	}

	@Test
	void test_Case4() {
		in.input("T");
		ProblemA.main(null);
		assertResultIs("YES");
	}

	@Test
	void test_Case5() {
		in.input("TEA");
		ProblemA.main(null);
		assertResultIs("NO");
	}
}
