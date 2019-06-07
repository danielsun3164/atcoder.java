package abc008;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void test_Case1() {
		in.input("4\n" + "taro\n" + "jiro\n" + "taro\n" + "saburo");
		ProblemB.main(null);
		assertResultIs("taro");
	}

	@Test
	void test_Case2() {
		in.input("1\n" + "takahashikun");
		ProblemB.main(null);
		assertResultIs("takahashikun");
	}

	@Test
	void test_Case3() {
		in.input("9\n" + "a\n" + "b\n" + "c\n" + "c\n" + "b\n" + "c\n" + "b\n" + "d\n" + "e");
		ProblemB.main(null);
		assertResultMatches("(b|c)");
	}
}
