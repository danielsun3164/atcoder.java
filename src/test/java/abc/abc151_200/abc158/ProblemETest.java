package abc.abc151_200.abc158;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("4 3\n" + "3543", "6");
	}

	@Test
	void case2() {
		check("4 2\n" + "2020", "10");
	}

	@Test
	void case3() {
		check("20 11\n" + "33883322005544116655", "68");
	}

	@Test
	void case4() {
		check("4 5\n" + "2020", "6");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC158/E");
	}
}
