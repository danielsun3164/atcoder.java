package abc.abc151_200.abc161;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("11 3 2\n" + "ooxxxoxxxoo", "6");
	}

	@Test
	void case2() {
		check("5 2 3\n" + "ooxoo", "1" + LF + "5");
	}

	@Test
	void case3() {
		// 出力に改行がないため、checkメソッドが使用できない
		in.input("5 1 0\n" + "ooooo");
		execute();
		assertEquals("", out.toString());
	}

	@Test
	void case4() {
		check("16 4 3\n" + "ooxxoxoxxxoxoxxo", "11" + LF + "16");
	}
}
