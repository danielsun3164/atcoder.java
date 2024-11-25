package abc.abc201_250.abc236;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "4 5 3", "7");
	}

	@Test
	void case2() {
		check("4\n" + "9 7 9 7 10 4 3 9 4 8 10 5 6 3 8", "15");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc236/F");
	}
}
