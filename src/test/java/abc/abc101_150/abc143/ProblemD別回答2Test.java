package abc.abc101_150.abc143;

import java.io.File;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemD別回答2Test extends TestBase {

	@Test
	void case1() {
		check("4\n" + "3 4 2 1", "1");
	}

	@Test
	void case2() {
		check("3\n" + "1 1000 1", "0");
	}

	@Test
	void case3() {
		check("7\n" + "218 786 704 233 645 728 389", "23");
	}

	@Test
	void case4() {
		check(new File("/daniel/tmp/abc143/D/in/handmade04"), new File("/daniel/tmp/abc143/D/out/handmade04"));
	}
}
