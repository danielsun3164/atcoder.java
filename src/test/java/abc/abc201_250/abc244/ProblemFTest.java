package abc.abc201_250.abc244;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3 2\n" + "1 2\n" + "2 3", "14");
	}

	@Test
	void case2() {
		check("5 5\n" + "4 2\n" + "2 3\n" + "1 3\n" + "2 1\n" + "1 5", "108");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc244/F");
	}
}
