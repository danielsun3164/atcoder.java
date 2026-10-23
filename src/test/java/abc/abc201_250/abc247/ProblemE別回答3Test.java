package abc.abc201_250.abc247;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemE別回答3Test extends TestBase {

	@Test
	void case1() {
		check("4 3 1\n" + "1 2 3 1", "4");
	}

	@Test
	void case2() {
		check("5 2 1\n" + "1 3 2 4 1", "0");
	}

	@Test
	void case3() {
		check("5 1 1\n" + "1 1 1 1 1", "15");
	}

	@Test
	void case4() {
		check("10 8 1\n" + "2 7 1 8 2 8 1 8 2 8", "36");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc247/E");
	}
}
