package abc.abc201_250.abc233;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemE別回答Test extends TestBase {

	@Test
	void case1() {
		check("1225", "1360");
	}

	@Test
	void case2() {
		check("99999", "111105");
	}

	@Test
	void case3() {
		check("314159265358979323846264338327950288419716939937510",
				"349065850398865915384738153697722542688574377708317");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc233/E");
	}
}
