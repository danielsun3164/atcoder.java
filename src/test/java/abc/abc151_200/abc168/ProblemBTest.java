package abc.abc151_200.abc168;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("7\n" + "nikoandsolstice", "nikoand...");
	}

	@Test
	void case2() {
		check("40\n" + "ferelibenterhominesidquodvoluntcredunt", "ferelibenterhominesidquodvoluntcredunt");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC168/B");
	}
}
