package abc.abc201_250.abc215;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "0 3\n" + "3 1\n" + "4 10", "4");
	}

	@Test
	void case2() {
		check("4\n" + "0 1\n" + "0 4\n" + "0 10\n" + "0 6", "0");
	}

	@Test
	void case3() {
		check("8\n" + "897 729\n" + "802 969\n" + "765 184\n" + "992 887\n" + "1 104\n" + "521 641\n" + "220 909\n"
				+ "380 378", "801");
	}
}
