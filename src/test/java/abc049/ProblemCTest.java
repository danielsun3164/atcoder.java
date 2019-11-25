package abc049;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		in.input("erasedream");
		ProblemC.main(null);
		assertResultIs("YES");
	}

	@Test
	void case2() {
		in.input("dreameraser");
		ProblemC.main(null);
		assertResultIs("YES");
	}

	@Test
	void case3() {
		in.input("dreamerer");
		ProblemC.main(null);
		assertResultIs("NO");
	}
}
