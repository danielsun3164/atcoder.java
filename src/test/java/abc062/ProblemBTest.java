package abc062;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("2 3\n" + "abc\n" + "arc");
		ProblemB.main(null);
		assertResultIs("#####" + LF + "#abc#" + LF + "#arc#" + LF + "#####");
	}

	@Test
	void test_Case2() {
		in.input("1 1\n" + "z");
		ProblemB.main(null);
		assertResultIs("###" + LF + "#z#" + LF + "###");
	}
}
