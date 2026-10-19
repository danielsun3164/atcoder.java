package abc.abc201_250.abc245;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("1 2\n" + "2 1\n" + "12 14 8 2", "6 4 2");
	}

	@Test
	void case2() {
		check("1 1\n" + "100 1\n" + "10000 0 -1", "100 -1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc245/D");
	}
}
