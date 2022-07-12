package abc.abc151_200.abc188;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemE別回答1Test extends TestBase {

	@Test
	void case1() {
		check("4 3\n" + "2 3 1 5\n" + "2 4\n" + "1 2\n" + "1 3", "3");
	}

	@Test
	void case2() {
		check("5 5\n" + "13 8 3 15 18\n" + "2 4\n" + "1 2\n" + "4 5\n" + "2 3\n" + "1 3", "10");
	}

	@Test
	void case3() {
		check("3 1\n" + "1 100 1\n" + "2 3", "-99");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC188/E");
	}
}
