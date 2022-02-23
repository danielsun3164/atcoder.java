package abc.abc101_150.abc150;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "0 2 1\n" + "1 2 3", "1 3");
	}

	@Test
	void case2() {
		check("5\n" + "0 0 0 0 0\n" + "2 2 2 2 2", "0 2" + LF + "1 2" + LF + "2 2" + LF + "3 2" + LF + "4 2");
	}

	@Test
	void case3() {
		check("6\n" + "0 1 3 7 6 4\n" + "1 5 4 6 2 3", "2 2" + LF + "5 5");
	}

	@Test
	void case4() {
		// 出力に改行がないため、checkメソッドが使用できない
		in.input("2\n" + "1 2\n" + "0 0");
		execute();
		assertEquals("", out.toString());
	}
}
