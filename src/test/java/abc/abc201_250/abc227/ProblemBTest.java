package abc.abc201_250.abc227;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "10 20 39", "1");
	}

	@Test
	void case2() {
		check("5\n" + "666 777 888 777 666", "3");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc227/B");
	}
}
