package abc.abc201_250.abc223;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemG別回答Test extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 2\n" + "2 3", "2");
	}

	@Test
	void case2() {
		check("2\n" + "1 2", "0");
	}

	@Test
	void case3() {
		check("6\n" + "2 5\n" + "3 5\n" + "1 4\n" + "4 5\n" + "4 6", "4");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc223/G");
	}
}
