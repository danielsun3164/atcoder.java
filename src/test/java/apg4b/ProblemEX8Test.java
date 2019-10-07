package apg4b;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemEX8Test extends TestBase {

	@Test
	void test_Case1() {
		in.input("1\n" + "80\n" + "5");
		ProblemEX8.main(null);
		assertResultIs("400");
	}

	@Test
	void test_Case2() {
		in.input("2\n" + "umai\n" + "150\n" + "3");
		ProblemEX8.main(null);
		assertResultIs("umai!" + LF + "450");
	}

	@Test
	void test_Case3() {
		in.input("2\n" + "good!\n" + "30\n" + "8");
		ProblemEX8.main(null);
		assertResultIs("good!!" + LF + "240");
	}
}
