package abc.abc201_250.abc229;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "31 4 159 2 65\n" + "5 5 5 5 10", "16");
	}

	@Test
	void case2() {
		check("4\n" + "100 100 100 1000000000\n" + "1 2 3 4", "10");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc229/F");
	}
}
