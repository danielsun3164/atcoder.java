package abc.abc201_250.abc237;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemExTest extends TestBase {

	@Test
	void case1() {
		check("ababb", "3");
	}

	@Test
	void case2() {
		check("xyz", "3");
	}

	@Test
	void case3() {
		check("xxxxxxxxxx", "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc237/Ex");
	}
}
