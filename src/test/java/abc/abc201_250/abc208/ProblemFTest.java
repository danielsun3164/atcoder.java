package abc.abc201_250.abc208;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3 4 2", "35");
	}

	@Test
	void case2() {
		check("0 1 2", "0");
	}

	@Test
	void case3() {
		check("1000000000000000000 30 123456", "297085514");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc208/F");
	}
}
