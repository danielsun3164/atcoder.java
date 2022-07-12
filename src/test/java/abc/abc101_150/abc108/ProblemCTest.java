package abc.abc101_150.abc108;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3 2", "9");
	}

	@Test
	void case2() {
		check("5 3", "1");
	}

	@Test
	void case3() {
		check("31415 9265", "27");
	}

	@Test
	void case4() {
		check("35897 932", "114191");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC108/C");
	}
}
