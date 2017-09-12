package Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _353 {
	// [[3,3,[[2,0],[0,0],[0,2],[2,2]]],["D"],["D"],["R"],["U"],["U"],["L"],["D"],["R"],["R"],["U"],["L"],["D"]]
	public static void main(String[] args) {
		_353 a = new _353(3, 3, new int[][] { { 2, 0 }, { 0, 0 }, { 0, 2 }, { 2, 2 } });
		a.execute();
	}

	public void execute() {
		// ["D"],["D"],["R"],["U"],["U"],["L"],["D"],["R"],["R"],["U"],["L"],["D"]]
		System.out.println(move("D"));
		System.out.println(move("D"));
		System.out.println(move("R"));

		System.out.println(move("U"));
		System.out.println(move("U"));
		System.out.println(move("L"));

		System.out.println(move("D"));
		System.out.println(move("R"));

		System.out.println(move("R"));

		System.out.println(move("U"));
		System.out.println(move("L"));
		System.out.println(move("D"));

	}

	int foodIdx;
	int[][] food;
	int width;
	int height;
	int point;
	HashSet<Integer> occupied;
	LinkedList<int[]> pos;

	public _353(int width, int height, int[][] food) {
		occupied = new HashSet<Integer>();
		pos = new LinkedList<int[]>();
		pos.add(new int[] { 0, 0 });
		occupied.add(0);
		foodIdx = 0;
		point = 0;
		this.width = width;
		this.height = height;
		this.food = food;
	}

	/**
	 * Moves the snake.
	 * 
	 * @param direction
	 *            - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
	 * @return The game's score after the move. Return -1 if game over. Game over
	 *         when snake crosses the screen boundary or bites its body.
	 */
	public int move(String direction) {
		System.out.println(occupied + " " + direction);
		int nextX = pos.getLast()[0];
		int nextY = pos.getLast()[1];
		if (direction.equals("U")) {
			nextX -= 1;
		} else if (direction.equals("L")) {
			nextY -= 1;
		} else if (direction.equals("R")) {
			nextY += 1;
		} else {
			nextX += 1;
		}

		if (nextX < 0 || nextY < 0 || nextX == height || nextY == width) {
			return -1;
		}
		int[] first = pos.peekFirst();
		occupied.remove(first[0] * width + first[1]);
		pos.removeFirst();
		if (occupied.contains(nextX * width + nextY)) {
			return -1;
		} else {
			occupied.add(nextX * width + nextY);
			pos.addLast(new int[] { nextX, nextY });
			if (foodIdx < food.length && food[foodIdx][0] == nextX && food[foodIdx][1] == nextY) {
				occupied.add(first[0] * width + first[1]);
				pos.addFirst(new int[] { first[0], first[1] });
				foodIdx++;
				point++;
			}
			return point;
		}

	}
}
