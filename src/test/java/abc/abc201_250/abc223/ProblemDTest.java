package abc.abc201_250.abc223;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4 3\n" + "2 1\n" + "3 4\n" + "2 4", "2 1 3 4");
	}

	@Test
	void case2() {
		check("2 3\n" + "1 2\n" + "1 2\n" + "2 1", "-1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc223/D");
	}
}
