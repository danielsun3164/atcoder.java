package practice.practice2;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemKTest extends TestBase {

	@Test
	void case1() {
		check("5 7\n" + "1 2 3 4 5\n" + "1 0 5\n" + "0 2 4 100 101\n" + "1 0 3\n" + "0 1 3 102 103\n" + "1 2 5\n"
				+ "0 2 5 104 105\n" + "1 0 5", "15" + LF + "404" + LF + "41511" + LF + "4317767");
	}
}
