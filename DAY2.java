import java.util.Scanner;

class Solution{
	
	private int partition(int[] elements, int beg, int end){
		int pivot = elements[beg];
		int pivotIndex = beg;

		while (beg < end){
			
			while (beg < end && elements[beg+1] <= pivot) {
				beg = beg + 1;
			}

			while (end >= beg && elements[end] > pivot) {
				end = end - 1;
			}

			if(beg != end){
				int temp = elements[beg+1];
				elements[beg+1] = elements[end];
				elements[end] = temp;
			} 
		}

		int temp = elements[beg];
		elements[beg] = elements[pivotIndex];
		elements[pivotIndex] = temp;
		

		for (int i = 0;i < elements.length ;i++ ) {
			System.out.print(elements[i]+" ");
		}

		System.out.println();
		return beg;
	}	
	
	void quickSort(int[] elements, int beg, int end){
		
		Solution s = new Solution();
		
		if(beg < end){
			
			int splitpoint = s.partition(elements, beg, end);
			
			//System.out.println(beg+ " " +splitpoint);

			s.quickSort(elements, beg, splitpoint-1);

			//System.out.println(splitpoint+1 + " " +end);

			s.quickSort(elements, splitpoint+1, end);
			
		}
	}


	


	int[] selectionSort(int[] elements){
		

		for(int i = 0; i<elements.length; i++) {
			int j = i+1;

			int minElement = elements[i];
			int indexOfMinimumElement = i;
			
			while(j < elements.length ){
				if(elements[j] < minElement ) {
					minElement = elements[j];
					indexOfMinimumElement = j ;
				
				}
				j++;
			}

			int temp = elements[i];
			elements[i] = elements[indexOfMinimumElement];
			elements[indexOfMinimumElement] =  temp;
		}	

		return elements;
	}	

//	
	int[][] matrixMultiplication(int matrix1[][], int matrix2[][]) {

		int [][]result = new int[matrix1.length][matrix2[0].length];

		for(int i = 0; i<matrix1.length; i++){
			
			for(int j = 0; j<matrix2[0].length; j++){
				result[i][j] = 0;

				for (int k = 0; k < matrix1[0].length ; k++) {
					result[i][j] += matrix1[i][k] * matrix2[k][j];
				}
			}
		}


		return result;
	}
}


class Day2{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		Solution s = new Solution();
		
		System.out.println("1. Quick Sort");
		System.out.print("Enter the size of the array: ");
		int size = scan.nextInt();
		int[] elements = new int[size];

		
		for(int i = 0; i<size; i++){
			elements[i] = scan.nextInt();
		}
		
		s.quickSort(elements,0,elements.length-1);

		System.out.println("Final Output: ");

		for(int i=0; i< elements.length; i++){
			System.out.print(elements[i]+" ");
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("2. Selection Sort");
		s.selectionSort(elements);

		for(int i = 0; i<elements.length; i++){
			System.out.print(elements[i]+" ");
		}


		System.out.println();
		System.out.println();

		System.out.println("3. Matrix Multiplication");
		System.out.print("Enter number of rows for Matrix1 : ");
		int rowsOfMatrix1 = scan.nextInt();
		System.out.println();

		System.out.print("Enter number of columns for Matrix1 : ");
		int columnsOfMatrix1 = scan.nextInt();
		System.out.println();


		int [][]Matrix1 = new int[rowsOfMatrix1][columnsOfMatrix1];

		System.out.print("Enter the elements of Matrix1: ");
		for(int i = 0; i<rowsOfMatrix1; i++){
			for(int j = 0; j<columnsOfMatrix1; j++){
				Matrix1[i][j] = scan.nextInt();
			}
		}


		System.out.print("Enter number of rows for Matrix2 : ");
		int rowsOfMatrix2 = scan.nextInt();
		System.out.println();

		System.out.print("Enter number of columns for Matrix2 : ");
		int columnsOfMatrix2 = scan.nextInt();
		System.out.println();


		int [][]Matrix2 = new int[rowsOfMatrix2][columnsOfMatrix2];

		System.out.print("Enter the elements of Matrix2: ");
		for(int i = 0; i<rowsOfMatrix2; i++){
			for(int j = 0; j<columnsOfMatrix2; j++){
				Matrix2[i][j] = scan.nextInt();
			}
		}


		int result[][] = s.matrixMultiplication(Matrix1, Matrix2);
		
		for (int i = 0; i< result.length; i++) {
			for (int j = 0; j<result[0].length ; j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}

		scan.close();
	}
}
