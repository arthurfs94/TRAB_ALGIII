import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Matriz {
	private int[][] matrixFinal;
	//private int[][] matrixCopy01;
	//private int[][] matrixCopy02;
	private int colum;
	private int line;
	
	public void readDocument() throws FileNotFoundException, IOException {
		//MATRIZ
		try (BufferedReader br = new BufferedReader(new FileReader("/Users/arthur/Documents/workspace/ALG_III/Matriz/example_0.txt"))) {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			boolean firsTime = false;
			int count = 0;
			this.createTheMatrixFromADocument(line);

			while (line != null) {

				if (firsTime) {
					this.populateTheMatrix(line, count);
					if (count < this.colum) {
						count++;
					}
				}

				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();

				firsTime = true;
			}

			System.out.println("-----------------------------------------");
			this.printMatrix(this.matrixFinal);

		}
	}
		//PRINTAR MATRIZ
		public void printMatrix(int[][] matrix) {
			Arrays.stream(matrix).forEach((row) -> {
				System.out.print("|");
				Arrays.stream(row).forEach((el) -> System.out.print(" " + el + " "));
				System.out.println("|");
			});
		
		}
		//CONVERSOR
		private int getValueFromAChar(char[] index, int position) {
			int result = 0;
			result = Character.getNumericValue(index[position]);
			return result;
		}
		//CREATE MATRIZ
		private void createTheMatrixFromADocument(String line) {
			String[] meh = line.split(" ");
			int colum = Integer.parseInt(meh[0]);
			int lines = Integer.parseInt(meh[1]);
			this.line = lines;
			this.colum = colum;

			this.matrixFinal = this.instantiateTheMatrix(colum, lines);
		}
		//ESTANCIAR
		private int[][] instantiateTheMatrix(int line, int colum) {
			int[][] result = new int[colum][line];
			return result;
		}
		//POPULAR
		private void populateTheMatrix(String line, int count) {
			char[] index = line.toCharArray();
			int[] intArray = new int[index.length];

			for (int i = 0; i < index.length; i++) {
				intArray[i] = getValueFromAChar(index, i);

			}

			for (int i = 0; i < this.colum; i++) {
			this.matrixFinal[count][i] = intArray[i];
			}
		}
		
		public int[][] getMatrixFinal() {
		return matrixFinal;
		}

		public void setMatrixFinal(int[][] matrixFinal) {
			this.matrixFinal = matrixFinal;
		}

		public int getColum() {
			return colum;
		}

		public void setColum(int colum) {
			this.colum = colum;
		}

		public int getLine() {
			return line;
		}

		public void setLine(int line) {
			this.line = line;
		}
		
	}

