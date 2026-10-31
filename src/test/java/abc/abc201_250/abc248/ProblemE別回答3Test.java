package abc.abc201_250.abc248;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemE別回答3Test extends TestBase {

	@Test
	void case1() {
		check("5 2\n" + "0 0\n" + "1 0\n" + "0 1\n" + "-1 0\n" + "0 -1", "6");
	}

	@Test
	void case2() {
		check("1 1\n" + "0 0", "Infinity");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc248/E");
	}
}
