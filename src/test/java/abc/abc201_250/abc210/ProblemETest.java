package abc.abc201_250.abc210;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("4 2\n" + "2 3\n" + "3 5", "11");
	}

	@Test
	void case2() {
		check("6 1\n" + "3 4", "-1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc210/E");
	}
}
