package abc.abc119;

import org.junit.jupiter.api.Test;

import practice.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5 100 90 80\n" + "98\n" + "40\n" + "30\n" + "21\n" + "80", "23");
	}

	@Test
	void case2() {
		check("8 100 90 80\n" + "100\n" + "100\n" + "90\n" + "90\n" + "90\n" + "80\n" + "80\n" + "80", "0");
	}

	@Test
	void case3() {
		check("8 1000 800 100\n" + "300\n" + "333\n" + "400\n" + "444\n" + "500\n" + "555\n" + "600\n" + "666", "243");
	}
}
