package abc.abc051_100.abc051;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("2 2", "6");
	}

	@Test
	void case2() {
		check("5 15", "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC051/B");
	}
}
