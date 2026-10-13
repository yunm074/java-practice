package cl5;

public class Matrix {
    public static void main(String[] args) {
        int[][] matrix = new int[6][5];
        for (int cow = 0; cow < 6; cow++) {
            for (int col = 0; col < 5; col++) {
                matrix[cow][col] = cow * 5 + col + 1;
                System.out.print(matrix[cow][col] + "\t");
            }
            System.out.println();
        }
    }
}
