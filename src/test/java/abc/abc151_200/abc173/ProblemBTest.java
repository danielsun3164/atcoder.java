package abc.abc151_200.abc173;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("6\n" + "AC\n" + "TLE\n" + "AC\n" + "AC\n" + "WA\n" + "TLE",
				"AC x 3" + LF + "WA x 1" + LF + "TLE x 2" + LF + "RE x 0");
	}

	@Test
	void case2() {
		check("10\n" + "AC\n" + "AC\n" + "AC\n" + "AC\n" + "AC\n" + "AC\n" + "AC\n" + "AC\n" + "AC\n" + "AC",
				"AC x 10" + LF + "WA x 0" + LF + "TLE x 0" + LF + "RE x 0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC173/B");
	}
}
