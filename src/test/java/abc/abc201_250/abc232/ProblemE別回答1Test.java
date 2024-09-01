package abc.abc201_250.abc232;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemE別回答1Test extends TestBase {

	@Test
	void case1() {
		check("2 2 2\n" + "1 2 2 1", "2");
	}

	@Test
	void case2() {
		check("1000000000 1000000000 1000000\n" + "1000000000 1000000000 1000000000 1000000000", "24922282");
	}

	@Test
	void case3() {
		check("3 3 3\n" + "1 3 3 3", "9");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc232/E");
	}
}
