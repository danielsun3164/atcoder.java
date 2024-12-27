package abc.abc201_250.abc236;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemExTest extends TestBase {

	@Test
	void case1() {
		check("3 7\n" + "2 3 4", "3");
	}

	@Test
	void case2() {
		check("3 3\n" + "1 2 2", "0");
	}

	@Test
	void case3() {
		check("6 1000000000000000000\n" + "380214083 420492929 929717250 666796775 209977152 770361643", "325683519");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc236/Ex");
	}
}
