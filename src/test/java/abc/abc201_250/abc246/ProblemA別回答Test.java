package abc.abc201_250.abc246;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemA別回答Test extends TestBase {

	@Test
	void case1() {
		check("-1 -1\n" + "-1 2\n" + "3 2", "3 -1");
	}

	@Test
	void case2() {
		check("-60 -40\n" + "-60 -80\n" + "-20 -80", "-20 -40");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc246/A");
	}
}
