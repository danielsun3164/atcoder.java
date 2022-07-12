package abc.abc051_100.abc066;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 2 1 3", "3" + LF + "5" + LF + "4" + LF + "1");
	}

	@Test
	void case2() {
		check("1\n" + "1 1", "1" + LF + "1");
	}

	@Test
	void case3() {
		check("32\n" + "29 19 7 10 26 32 27 4 11 20 2 8 16 23 5 14 6 12 17 22 18 30 28 24 15 1 25 3 13 21 19 31 9",
				"32" + LF + "525" + LF + "5453" + LF + "40919" + LF + "237336" + LF + "1107568" + LF + "4272048" + LF
						+ "13884156" + LF + "38567100" + LF + "92561040" + LF + "193536720" + LF + "354817320" + LF
						+ "573166440" + LF + "818809200" + LF + "37158313" + LF + "166803103" + LF + "166803103" + LF
						+ "37158313" + LF + "818809200" + LF + "573166440" + LF + "354817320" + LF + "193536720" + LF
						+ "92561040" + LF + "38567100" + LF + "13884156" + LF + "4272048" + LF + "1107568" + LF
						+ "237336" + LF + "40920" + LF + "5456" + LF + "528" + LF + "33" + LF + "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC077/D");
	}
}
