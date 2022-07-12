package abc.abc101_150.abc147;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3 4 2", "8");
	}

	@Test
	void case2() {
		check("2 3 -3", "2");
	}

	@Test
	void case3() {
		check("100 14 20", "49805");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC147/F");
	}
}
