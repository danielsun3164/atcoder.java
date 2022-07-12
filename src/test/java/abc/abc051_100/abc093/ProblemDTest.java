package abc.abc051_100.abc093;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("8\n" + "1 4\n" + "10 5\n" + "3 3\n" + "4 11\n" + "8 9\n" + "22 40\n" + "8 36\n" + "314159265 358979323",
				"1" + LF + "12" + LF + "4" + LF + "11" + LF + "14" + LF + "57" + LF + "31" + LF + "671644785");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC094/D");
	}
}
