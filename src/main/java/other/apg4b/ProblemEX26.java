package other.apg4b;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ProblemEX26 {

	/** INTをPRINTするコマンド */
	private static final String PRINT_INT = "print_int";
	/** VECをPRINTするコマンド */
	private static final String PRINT_VEC = "print_vec";
	/** 数字の正規表現 */
	private static final Pattern INT_PATTERN = Pattern.compile("-?[0-9]+");
	/** VECの正規表現 */
	private static final Pattern VECTOR_PATTERN = Pattern.compile("\\[.*\\]");
	/** 符号(+) */
	private static final char ADD = '+';
	/** 符号(-) */
	private static final char SUBSTRACT = '-';
	/** 符号(=) */
	private static final char EQUAL = '=';

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			scanner.nextLine();
			Map<String, Data> map = new HashMap<>();
			IntStream.range(0, n).forEach(i -> {
				String command = scanner.next();
				String string = scanner.nextLine().replace(";", "").trim();
				if (PRINT_INT.equals(command)) {
					print(evalInt(string, map));
				} else if (PRINT_VEC.equals(command)) {
					print(evalVector(string, map));
				} else if (DataType.INT.code.equals(command)) {
					evalInt(string, map);
				} else if (DataType.VECTOR.code.equals(command)) {
					evalVector(string, map);
				}
			});
		}
	}

	/**
	 * データの値を出力する
	 * 
	 * @param data データ
	 */
	private static void print(Data data) {
		if (DataType.INT == data.dataType) {
			System.out.println(data.value);
		} else {
			System.out.println(data.values.stream().map(String::valueOf).collect(Collectors.joining(" ", "[ ", " ]")));
		}
	}

	/**
	 * INT型のデータを計算する
	 * 
	 * @param string 数式
	 * @param map    変数を格納するマップ
	 * @return INT型のデータ
	 */
	private static Data evalInt(String string, Map<String, Data> map) {
		int index = string.indexOf(EQUAL);
		if (index > 0) {
			String val = string.substring(0, index).trim();
			map.put(val, evalInt(string.substring(index + 1).trim(), map));
			return map.get(val);
		}
		index = Math.max(string.lastIndexOf(ADD), string.lastIndexOf(SUBSTRACT));
		if (index > 0) {
			if (ADD == string.charAt(index)) {
				return addInt(evalInt(string.substring(0, index).trim(), map),
						evalInt(string.substring(index + 1).trim(), map));
			} else if (SUBSTRACT == string.charAt(index)) {
				return substractInt(evalInt(string.substring(0, index).trim(), map),
						evalInt(string.substring(index + 1).trim(), map));
			}
		}
		if (INT_PATTERN.matcher(string).matches()) {
			Data data = new Data();
			data.dataType = DataType.INT;
			data.value = Integer.parseInt(string);
			return data;
		} else {
			return map.get(string);
		}
	}

	/**
	 * INT型データの足し算を行う
	 * 
	 * @param data1 データ1
	 * @param data2 データ2
	 * @return 足し算の計算結果
	 */
	private static Data addInt(Data data1, Data data2) {
		Data data = new Data();
		data.dataType = DataType.INT;
		data.value = data1.value + data2.value;
		return data;
	}

	/**
	 * INT型データの引き算を行う
	 * 
	 * @param data1 データ1
	 * @param data2 データ2
	 * @return 引き算の計算結果
	 */
	private static Data substractInt(Data data1, Data data2) {
		Data data = new Data();
		data.dataType = DataType.INT;
		data.value = data1.value - data2.value;
		return data;
	}

	/**
	 * VECTOR型のデータを計算する
	 * 
	 * @param string 数式
	 * @param map    変数を格納するマップ
	 * @return VECTOR型のデータ
	 */
	private static Data evalVector(String string, Map<String, Data> map) {
		int index = string.indexOf(EQUAL);
		if (index > 0) {
			String val = string.substring(0, index).trim();
			map.put(val, evalVector(string.substring(index + 1).trim(), map));
			return map.get(val);
		}
		index = Math.max(string.lastIndexOf(ADD), string.lastIndexOf(SUBSTRACT));
		if (index > 0) {
			if (ADD == string.charAt(index)) {
				return addVector(evalVector(string.substring(0, index).trim(), map),
						evalVector(string.substring(index + 1).trim(), map));
			} else if (SUBSTRACT == string.charAt(index)) {
				return substractVector(evalVector(string.substring(0, index).trim(), map),
						evalVector(string.substring(index + 1).trim(), map));
			}
		}
		if (VECTOR_PATTERN.matcher(string).matches()) {
			string = string.replace("[", "").replace("]", "").trim();
			String[] strings = string.split(",");
			Data data = new Data();
			data.dataType = DataType.VECTOR;
			data.values = Arrays.stream(strings).map(s -> evalInt(s.trim(), map).value).collect(Collectors.toList());
			return data;
		} else {
			return map.get(string);
		}
	}

	/**
	 * VECTOR型データの足し算を行う
	 * 
	 * @param data1 データ1
	 * @param data2 データ2
	 * @return 足し算の計算結果
	 */
	private static Data addVector(Data data1, Data data2) {
		Data data = new Data();
		data.dataType = DataType.VECTOR;
		data.values = IntStream.range(0, Math.max(data1.values.size(), data2.values.size()))
				.map(i -> ((data1.values.size() > i) ? data1.values.get(i) : 0)
						+ ((data2.values.size() > i) ? data2.values.get(i) : 0))
				.boxed().collect(Collectors.toList());
		return data;
	}

	/**
	 * VECTOR型データの引き算を行う
	 * 
	 * @param data1 データ1
	 * @param data2 データ2
	 * @return 引き算の計算結果
	 */
	private static Data substractVector(Data data1, Data data2) {
		Data data = new Data();
		data.dataType = DataType.VECTOR;
		data.values = IntStream.range(0, Math.max(data1.values.size(), data2.values.size()))
				.map(i -> ((data1.values.size() > i) ? data1.values.get(i) : 0)
						- ((data2.values.size() > i) ? data2.values.get(i) : 0))
				.boxed().collect(Collectors.toList());
		return data;
	}

	/**
	 * データタイプを定義するenum
	 */
	private static enum DataType {
		INT("int"), VECTOR("vec");

		/** 文字列の値 */
		String code;

		DataType(String code) {
			this.code = code;
		}
	}

	/**
	 * データを格納するクラス
	 */
	private static class Data {
		/** データタイプ */
		DataType dataType;
		/** データタイプがINTの時の値 */
		int value;
		/** データタイプがVECの時の値 */
		List<Integer> values;
	}
}
