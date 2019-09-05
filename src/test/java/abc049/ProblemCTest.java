package abc049;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("erasedream");
		ProblemC.main(null);
		assertResultIs("YES");
	}

	@Test
	void test_Case2() {
		in.input("dreameraser");
		ProblemC.main(null);
		assertResultIs("YES");
	}

	@Test
	void test_Case3() {
		in.input("dreamerer");
		ProblemC.main(null);
		assertResultIs("NO");
	}
}
