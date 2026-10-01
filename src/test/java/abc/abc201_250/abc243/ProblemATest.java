package abc.abc201_250.abc243;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("25 10 11 12", "T");
	}

	@Test
	void case2() {
		check("30 10 10 10", "F");
	}

	@Test
	void case3() {
		check("100000 1 1 1", "M");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc243/A");
	}
}
