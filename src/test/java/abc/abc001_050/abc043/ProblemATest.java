package abc.abc001_050.abc043;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3", "6");
	}

	@Test
	void case2() {
		check("10", "55");
	}

	@Test
	void case3() {
		check("1", "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC059_ABC043/A");
	}
}
