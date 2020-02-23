package com.sample.problems;

import java.util.ArrayList;
import java.util.List;

public class MinStepToReachTarget {
    static class Cell {
        int x, y, dis ;
        Cell(int x, int y, int dis){
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    int solution(List<List<Integer>> lot){
        int distance = -1;
        int[] source = {0,0};
        int[] target = getTargetLocation(lot);
        distance = minStep(lot, source, target, 3 );
        return distance;
    }

    private int minStep(List<List<Integer>> lot, int[] source, int[] target, int matrixSize) {
        int sx[] = {-1, 1, 0, 0};
        int sy[] = {0, 0, 1, -1};
        List<Cell> queue = new ArrayList<>();
        queue.add(new Cell(source[0], source[1], 0));
        Cell expectedTarget;
        int x, y;
        boolean[][] alreadyVisited = new boolean[matrixSize][matrixSize];
        for (int k = 0; k < matrixSize; k++) {
            for (int i = 0; i < matrixSize; i++)
                alreadyVisited[k][i] = false;
        }

        alreadyVisited[source[0]][source[1]] = true;

        while (!queue.isEmpty()) {
            //expectedTarget = queue.remove(0);
            expectedTarget = queue.get(0);
            queue.remove(0);
            if (expectedTarget.x == target[0] && expectedTarget.y == target[1])
                return expectedTarget.dis;
            for (int i = 0; i < 4; i++) {
                x = expectedTarget.x + sx[i];
                y = expectedTarget.y + sy[i];

                // If reachable state is not yet visited and
                // inside board, push that state into queue
                if (isInside(x, y, matrixSize)
                        && !alreadyVisited[x][y]
                        && (getValueOnCell(lot, new int[]{x,y}) == 1 || getValueOnCell(lot, new int[]{x,y}) == 9)) {
                    alreadyVisited[x][y] = true;
                    queue.add(new Cell(x, y, expectedTarget.dis + 1));
                }
            }
        }
        return Integer.MAX_VALUE;
    }
    boolean isInside(int x, int y, int N)
    {
        boolean status = false;
        if (x >= 0 && x < N && y >= 0 && y < N)
            status = true;
        return status;
    }

    int[] getTargetLocation(List<List<Integer>> lot){
        int[] target = null;
        int rows = lot.size();
        for(int k = 0; k < rows; k++){
            List<Integer> row = lot.get(k);
            for (int i = 0; i < row.size(); i++){
                if(row.get(i).intValue() == 9){
                    target = new int[2];
                    target[0] = k;
                    target[1] = i;
                    break;
                }
            }
            if (target != null) {
                break;
            }
        }
        return target;
    }

    private int  getValueOnCell(List<List<Integer>> lot, int[] location){
        List<Integer> row = lot.get(location[0]);
        int value = row.get(location[1]).intValue();
        System.out.println(String.format("%d, %d, %d",location[0], location[1], value));
        return value;
    }
}
