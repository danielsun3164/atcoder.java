package abc.abc101_150.abc118;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("4 12", "16");
	}

	@Test
	void case2() {
		check("8 20", "12");
	}

	@Test
	void case3() {
		check("1 1", "2");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC118/A");
	}
}
