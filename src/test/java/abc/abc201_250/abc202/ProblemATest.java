package abc.abc201_250.abc202;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("1 4 3", "13");
	}

	@Test
	void case2() {
		check("5 6 4", "6");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc202/A");
	}
}
