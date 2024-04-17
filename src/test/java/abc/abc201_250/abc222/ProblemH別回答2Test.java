package abc.abc201_250.abc222;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemH別回答2Test extends TestBase {

	@Test
	void case1() {
		check("1", "1");
	}

	@Test
	void case2() {
		check("2", "6");
	}

	@Test
	void case3() {
		check("222", "987355927");
	}

	@Test
	void case4() {
		check("222222", "675337738");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc222/H");
	}
}
