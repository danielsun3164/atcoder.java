package abc.abc201_250.abc241;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemExTest extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "3 1\n" + "5 2\n" + "6 3", "819");
	}

	@Test
	void case2() {
		check("3 2\n" + "1 1\n" + "5 2\n" + "25 1", "180");
	}

	@Test
	void case3() {
		check("10 232657150901347497\n" + "139547946 28316250877914575\n" + "682142538 78223540024979445\n"
				+ "110643588 74859962623690081\n" + "173455495 60713016476190629\n" + "271056265 85335723211047202\n"
				+ "801329567 48049062628894325\n" + "864844366 54979173822804784\n" + "338794337 69587449430302156\n"
				+ "737638908 15812229161735902\n" + "462149872 49993004923078537", "39761306");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc241/Ex");
	}
}
