package abc.abc151_200.abc167;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3 2 1", "6");
	}

	@Test
	void case2() {
		check("100 100 0", "73074801");
	}

	@Test
	void case3() {
		check("60522 114575 7559", "479519525");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC167/E");
	}
}
