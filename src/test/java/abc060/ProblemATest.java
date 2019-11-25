package abc060;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		in.input("rng gorilla apple");
		ProblemA.main(null);
		assertResultIs("YES");
	}

	@Test
	void case2() {
		in.input("yakiniku unagi sushi");
		ProblemA.main(null);
		assertResultIs("NO");
	}

	@Test
	void case3() {
		in.input("a a a");
		ProblemA.main(null);
		assertResultIs("YES");
	}

	@Test
	void case4() {
		in.input("aaaaaaaaab aaaaaaaaaa aaaaaaaaab");
		ProblemA.main(null);
		assertResultIs("NO");
	}
}
