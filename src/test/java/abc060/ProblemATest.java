package abc060;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void test_Case1() {
		in.input("rng gorilla apple");
		ProblemA.main(null);
		assertResultIs("YES");
	}

	@Test
	void test_Case2() {
		in.input("yakiniku unagi sushi");
		ProblemA.main(null);
		assertResultIs("NO");
	}

	@Test
	void test_Case3() {
		in.input("a a a");
		ProblemA.main(null);
		assertResultIs("YES");
	}

	@Test
	void test_Case4() {
		in.input("aaaaaaaaab aaaaaaaaaa aaaaaaaaab");
		ProblemA.main(null);
		assertResultIs("NO");
	}
}
