package abc084;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemD別回答Test extends TestBase {

	@Test
	void case1() {
		in.input("1\n" + "3 7");
		ProblemD別回答.main(null);
		assertResultIs("2");
	}

	@Test
	void case2() {
		in.input("4\n" + "13 13\n" + "7 11\n" + "7 11\n" + "2017 2017");
		ProblemD別回答.main(null);
		assertResultIs("1\n" + "0\n" + "0\n" + "1");
	}

	@Test
	void case3() {
		in.input("6\n" + "1 53\n" + "13 91\n" + "37 55\n" + "19 51\n" + "73 91\n" + "13 49");
		ProblemD別回答.main(null);
		assertResultIs("4\n" + "4\n" + "1\n" + "1\n" + "1\n" + "2");
	}
}
