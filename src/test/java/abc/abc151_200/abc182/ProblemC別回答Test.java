package abc.abc151_200.abc182;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemC別回答Test extends TestBase {

	@Test
	void case1() {
		check("35", "1");
	}

	@Test
	void case2() {
		check("369", "0");
	}

	@Test
	void case3() {
		check("6227384", "1");
	}

	@Test
	void case4() {
		check("11", "-1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC182/C");
	}
}
