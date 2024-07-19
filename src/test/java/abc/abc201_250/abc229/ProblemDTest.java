package abc.abc201_250.abc229;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("XX...X.X.X.\n" + "2", "5");
	}

	@Test
	void case2() {
		check("XXXX\n" + "200000", "4");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc229/D");
	}
}
