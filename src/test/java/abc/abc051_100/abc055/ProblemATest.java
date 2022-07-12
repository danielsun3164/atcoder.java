package abc.abc051_100.abc055;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("20", "15800");
	}

	@Test
	void case2() {
		check("60", "47200");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC069/A");
	}
}
