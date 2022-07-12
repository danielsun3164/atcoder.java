package abc.abc051_100.abc063;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("uncopyrightable", "yes");
	}

	@Test
	void case2() {
		check("different", "no");
	}

	@Test
	void case3() {
		check("no", "yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC075/B");
	}
}
