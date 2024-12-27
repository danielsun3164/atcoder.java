package other.math_and_algorithm;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem041Test extends TestBase {

	@Test
	void case1() {
		check("10\n" + "7\n" + "0 3\n" + "2 4\n" + "1 3\n" + "0 3\n" + "5 6\n" + "5 6\n" + "5 6",
				"2" + LF + "3" + LF + "4" + LF + "1" + LF + "0" + LF + "3" + LF + "0" + LF + "0" + LF + "0" + LF + "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("tessoku-book/B07");
	}
}
