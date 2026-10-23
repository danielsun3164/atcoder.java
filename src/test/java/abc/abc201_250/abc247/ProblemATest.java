package abc.abc201_250.abc247;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("1011", "0101");
	}

	@Test
	void case2() {
		check("0000", "0000");
	}

	@Test
	void case3() {
		check("1111", "0111");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc247/A");
	}
}
