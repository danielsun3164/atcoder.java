package abc.abc051_100.abc057;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("9 12", "21");
	}

	@Test
	void case2() {
		check("19 0", "19");
	}

	@Test
	void case3() {
		check("23 2", "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC057/A");
	}
}
