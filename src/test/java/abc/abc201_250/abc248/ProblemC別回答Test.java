package abc.abc201_250.abc248;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemC別回答Test extends TestBase {

	@Test
	void case1() {
		check("2 3 4", "6");
	}

	@Test
	void case2() {
		check("31 41 592", "798416518");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc248/C");
	}
}
