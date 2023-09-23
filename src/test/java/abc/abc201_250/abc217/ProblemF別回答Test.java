package abc.abc201_250.abc217;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemF別回答Test extends TestBase {

	@Test
	void case1() {
		check("2 3\n" + "1 2\n" + "1 4\n" + "2 3", "1");
	}

	@Test
	void case2() {
		check("2 2\n" + "1 2\n" + "3 4", "2");
	}

	@Test
	void case3() {
		check("2 2\n" + "1 3\n" + "2 4", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc217/F");
	}
}
