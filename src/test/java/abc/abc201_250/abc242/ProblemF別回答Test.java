package abc.abc201_250.abc242;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemF別回答Test extends TestBase {

	@Test
	void case1() {
		check("2 2 1 1", "4");
	}

	@Test
	void case2() {
		check("1 2 1 1", "0");
	}

	@Test
	void case3() {
		check("40 40 30 30", "467620384");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc242/F");
	}
}
