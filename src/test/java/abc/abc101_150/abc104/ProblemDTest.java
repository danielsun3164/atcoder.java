package abc.abc101_150.abc104;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("A??C", "8");

	}

	@Test
	void case2() {
		check("ABCBC", "3");
	}

	@Test
	void case3() {
		check("????C?????B??????A???????", "979596887");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC104/D");
	}
}
