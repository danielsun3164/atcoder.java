package abc.abc151_200.abc196;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemF別回答Test extends TestBase {

	@Test
	void case1() {
		check("0001\n" + "101", "1");
	}

	@Test
	void case2() {
		check("0101010\n" + "1010101", "7");
	}

	@Test
	void case3() {
		check("10101000010011011110\n" + "0010011111", "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC196/F");
	}
}
