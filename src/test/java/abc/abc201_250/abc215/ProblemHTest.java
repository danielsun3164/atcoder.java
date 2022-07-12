package abc.abc201_250.abc215;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemHTest extends TestBase {

	@Test
	void case1() {
		check("3 2\n" + "2 2 5\n" + "3 4\n" + "1 0\n" + "1 1\n" + "0 1", "2 6");
	}

	@Test
	void case2() {
		check("1 1\n" + "3\n" + "4\n" + "1", "0 1");
	}

	@Test
	void case3() {
		check("1 3\n" + "100\n" + "30 30 30\n" + "1 1 1", "11 892328666");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc215/H");
	}
}
