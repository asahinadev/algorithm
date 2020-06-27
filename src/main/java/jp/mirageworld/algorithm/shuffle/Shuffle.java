package jp.mirageworld.algorithm.shuffle;

import java.util.List;

public interface Shuffle<T> {

	public List<T> apply(List<T> list);

}