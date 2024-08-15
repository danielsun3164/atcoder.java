package abc.abc201_250.abc235;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("123", "666");
	}

	@Test
	void case2() {
		check("999", "2997");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc235/A");
	}
}
