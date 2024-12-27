package other.math_and_algorithm;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem043別回答Test extends TestBase {

	@Test
	void case1() {
		check("3 2\n" + "1 3\n" + "2 3", "The graph is connected.");
	}

	@Test
	void case2() {
		check("6 6\n" + "1 4\n" + "2 3\n" + "3 4\n" + "5 6\n" + "1 2\n" + "2 4", "The graph is not connected.");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("tessoku-book/A62");
	}
}
