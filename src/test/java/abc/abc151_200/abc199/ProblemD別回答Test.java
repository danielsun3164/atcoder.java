package abc.abc151_200.abc199;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemD別回答Test extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "1 2\n" + "2 3\n" + "3 1", "6");
	}

	@Test
	void case2() {
		check("3 0", "27");
	}

	@Test
	void case3() {
		check("4 6\n" + "1 2\n" + "2 3\n" + "3 4\n" + "2 4\n" + "1 3\n" + "1 4", "0");
	}

	@Test
	void case4() {
		check("20 0", "3486784401");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc199/D");
	}
}
