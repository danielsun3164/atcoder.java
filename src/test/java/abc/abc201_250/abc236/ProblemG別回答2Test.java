package abc.abc201_250.abc236;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemG別回答2Test extends TestBase {

	@Test
	void case1() {
		check("4 5 3\n" + "2 3\n" + "3 4\n" + "1 2\n" + "3 2\n" + "2 2", "-1 4 5 3");
	}

	@Test
	void case2() {
		check("2 1 1000000000\n" + "1 2", "-1 -1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc236/G");
	}
}
