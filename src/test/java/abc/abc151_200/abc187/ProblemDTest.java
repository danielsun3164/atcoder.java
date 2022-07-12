package abc.abc151_200.abc187;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "2 1\n" + "2 2\n" + "5 1\n" + "1 3", "1");
	}

	@Test
	void case2() {
		check("5\n" + "2 1\n" + "2 1\n" + "2 1\n" + "2 1\n" + "2 1", "3");
	}

	@Test
	void case3() {
		check("1\n" + "273 691", "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC187/D");
	}
}
