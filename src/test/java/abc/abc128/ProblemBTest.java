package abc.abc128;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("6\n" + "khabarovsk 20\n" + "moscow 10\n" + "kazan 50\n" + "kazan 35\n" + "moscow 60\n" + "khabarovsk 40",
				"3" + LF + "4" + LF + "6" + LF + "1" + LF + "5" + LF + "2");
	}

	@Test
	void case2() {
		check("10\n" + "yakutsk 10\n" + "yakutsk 20\n" + "yakutsk 30\n" + "yakutsk 40\n" + "yakutsk 50\n"
				+ "yakutsk 60\n" + "yakutsk 70\n" + "yakutsk 80\n" + "yakutsk 90\n" + "yakutsk 100",
				"10" + LF + "9" + LF + "8" + LF + "7" + LF + "6" + LF + "5" + LF + "4" + LF + "3" + LF + "2" + LF
						+ "1");
	}
}
