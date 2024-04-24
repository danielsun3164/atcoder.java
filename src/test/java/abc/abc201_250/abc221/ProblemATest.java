package abc.abc201_250.abc221;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("6 4", "1024");
	}

	@Test
	void case2() {
		check("5 5", "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc221/A");
	}
}
