package abc.abc201_250.abc243;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("2 1 2\n" + "2\n" + "1", "221832079");
	}

	@Test
	void case2() {
		check("3 3 2\n" + "1\n" + "1\n" + "1", "0");
	}

	@Test
	void case3() {
		check("3 3 10\n" + "499122176\n" + "499122175\n" + "1", "335346748");
	}

	@Test
	void case4() {
		check("10 8 15\n" + "1\n" + "1\n" + "1\n" + "1\n" + "1\n" + "1\n" + "1\n" + "1\n" + "1\n" + "1", "755239064");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc243/F");
	}
}
