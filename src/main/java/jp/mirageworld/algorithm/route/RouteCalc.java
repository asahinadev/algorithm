package jp.mirageworld.algorithm.route;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class RouteCalc {

	class Position {
		int y, x;

		public Position(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public int hashCode() {
			return y * 0xFF + x;
		}

		public void setValue(String value) {
			matrix[y][x] = value;
		}

		public String getValue() {
			return matrix[y][x];
		}

		public String getBlock() {
			try {
				return matrix[y][x];
			} catch (Exception e) {
				return "b";
			}
		}

		public Integer getInt() {
			return Integer.valueOf(matrix[y][x]);
		}

		public Position up() {
			return new Position(y + 1, x);
		}

		public Position down() {
			return new Position(y - 1, x);
		}

		public Position right() {
			return new Position(y, x + 1);
		}

		public Position left() {
			return new Position(y, x - 1);
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Position) {
				return this.hashCode() == ((Position) obj).hashCode();

			}
			return false;
		}
	}

	int pos = 0;
	int min = Integer.MAX_VALUE;
	String[][] matrix;

	Set<Position> exec = new HashSet<>();
	Set<Position> next = new HashSet<>();

	public int calc(String[][] matrix) {

		this.matrix = matrix;

		int sx = -1;
		int sy = -1;

		for (int y = 0; y < matrix.length; y++) {
			for (int x = 0; x < matrix[y].length; x++) {
				if (Objects.equals(matrix[y][x], "1")) {
					matrix[y][x] = "b";
				}
				if (Objects.equals(matrix[y][x], "s")) {
					sx = x;
					sy = y;
				}
			}
		}

		if (sx == -1 || sy == -1) {
			throw new IllegalArgumentException("start not found");
		}
		return calc(sy, sx);
	}

	public int calc(int y, int x) {
		next.add(new Position(y, x));
		do {
			exec = new HashSet<>(next);
			next.clear();
			exec.forEach(this::calc);
			pos++;
		} while (!next.isEmpty());
		return min;
	}

	public void calc(Position start) {
		if (pos > min) {
			return;
		}
		switch (start.getBlock()) {
		case "g":
			// ゴール
			min = Math.min(min, pos);
			return;

		case "s":
			if (pos != 0) {
				return;
			}
			// スタート
			break;

		case "0":
			int c = start.getInt();
			if (c != 0 && c < pos) {
				return;
			}
			if (c == 0 || c > pos) {
				start.setValue(Integer.toString(pos));
			}
			break;
		}

		next.add(start.up());
		next.add(start.down());
		next.add(start.right());
		next.add(start.left());

		next.removeIf(i -> Objects.equals("b", i.getBlock()));
		next.removeIf(i -> Objects.equals("s", i.getBlock()));

	}
}
