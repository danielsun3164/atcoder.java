package abc.abc051_100.abc052;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "IIDID", "2");
	}

	@Test
	void case2() {
		check("7\n" + "DDIDDII", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC067/B");
	}
}
