package abc.abc201_250.abc237;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("4 5", "135");
	}

	@Test
	void case2() {
		check("3 4", "4");
	}

	@Test
	void case3() {
		check("111 3", "144980434");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc237/F");
	}
}
