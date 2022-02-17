package abc.abc151_200.abc159;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3 5 4\n" + "11100\n" + "10001\n" + "00111", "2");
	}

	@Test
	void case2() {
		check("3 5 8\n" + "11100\n" + "10001\n" + "00111", "0");
	}

	@Test
	void case3() {
		check("4 10 4\n" + "1110010010\n" + "1000101110\n" + "0011101001\n" + "1101000111", "3");
	}
}
