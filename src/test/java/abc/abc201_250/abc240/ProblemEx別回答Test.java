package abc.abc201_250.abc240;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemEx別回答Test extends TestBase {

	@Test
	void case1() {
		check("7\n" + "0101010", "3");
	}

	@Test
	void case2() {
		check("30\n" + "000011001110101001011110001001", "9");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc240/Ex");
	}
}
