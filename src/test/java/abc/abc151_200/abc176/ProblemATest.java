package abc.abc151_200.abc176;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("20 12 6", "12");
	}

	@Test
	void case2() {
		check("1000 1 1000", "1000000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC176/A");
	}
}
