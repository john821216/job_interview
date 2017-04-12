package Bfs;

import java.util.Scanner;

public class _27B {
	static int[][] g = new int[53][53];
	static int[] play;
	static int[] vis;
	static int player;
	static int findA = -1;
	static int findB = -1;

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		player = input.nextInt();
		play = new int[player + 1];
		vis = new int[player + 1];

		for (int i = 0; i < player * (player - 1) / 2 - 1; i++) {
			int from = input.nextInt();
			int to = input.nextInt();
			g[from][to] = 1;
			play[from]++;
			play[to]++;
		}

		for (int i = 1; i <= player; i++) {
			if (play[i] == player - 2) {
				if (findA == -1)
					findA = i;
				else {
					findB = i;
				}
			}
		}
		if (find(findB, findA) == 1)
			System.out.println(findB + " " + findA);
		else{
			System.out.println(findA + " " + findB);
		}

	}

	public static int find(int start, int end) {
		vis[start] = 1;
		if (start == end) {
			return 1;
		}

		for (int i = 1; i <= player; i++) {
			if (vis[i] == 0 && g[start][i] != 0) {
				if(find(i, end) == 1) return 1;
			}
		}
		return 0;
	}
}
