package abc.abc051_100.abc099;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("8 13", "2");
	}

	@Test
	void case2() {
		check("54 65", "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC099/B");
	}
}
