package abc.abc151_200.abc155;

import org.junit.jupiter.api.Test;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("7\n" + "beat\n" + "vet\n" + "beet\n" + "bed\n" + "vet\n" + "bet\n" + "beet", "beet" + LF + "vet");
	}

	@Test
	void case2() {
		check("8\n" + "buffalo\n" + "buffalo\n" + "buffalo\n" + "buffalo\n" + "buffalo\n" + "buffalo\n" + "buffalo\n"
				+ "buffalo", "buffalo");
	}

	@Test
	void case3() {
		check("7\n" + "bass\n" + "bass\n" + "kick\n" + "kick\n" + "bass\n" + "kick\n" + "kick", "kick");
	}

	@Test
	void case4() {
		check("4\n" + "ushi\n" + "tapu\n" + "nichia\n" + "kun", "kun\n" + "nichia\n" + "tapu\n" + "ushi");
	}
}
