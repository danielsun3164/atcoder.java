package other.joisc2007;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemJ_FiberTest extends TestBase {

	@Test
	void case1() {
		check("8\n" + "7\n" + "3 5\n" + "4 1\n" + "5 4\n" + "7 5\n" + "4 7\n" + "1 4\n" + "6 8", "2");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("joisc2007/Fiber");
	}
}
