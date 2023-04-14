import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class lab7 {
    
    // method to compute the mean of each attribute
    public static double[] computeMeans(double[][] data) {
        double[] means = new double[4];
        for (int col = 0; col < 4; col++) {
            double sum = 0.0;
            for (int row = 0; row < 150; row++) {
                sum += data[row][col];
            }
            means[col] = sum / 150.0;
        }
        return means;
    }
    
    // method to compute the median of each attribute
    public static double[] computeMedians(double[][] data) {
        double[] medians = new double[4];
        for (int col = 0; col < 4; col++) {
            double[] column = new double[150];
            for (int row = 0; row < 150; row++) {
                column[row] = data[row][col];
            }
            Arrays.sort(column);
            if (column.length % 2 == 0) {
                int index1 = column.length / 2 - 1;
                int index2 = column.length / 2;
                medians[col] = (column[index1] + column[index2]) / 2.0;
            } else {
                int index = column.length / 2;
                medians[col] = column[index];
            }
        }
        return medians;
    }
    
    //  method to compute the mode of each
    public static double[] computeModes(double[][] data) {
        double[] modes = new double[4];
        for (int col = 0; col < 4; col++) {
            int[] counts = new int[150];
            for (int row = 0; row < 150; row++) {
                counts[row] = 0;
                for (int otherRow = 0; otherRow < 150; otherRow++) {
                    if (data[row][col] == data[otherRow][col]) {
                        counts[row]++;
                    }
                }
            }
            int maxCount = 0;
            for (int row = 0; row < 150; row++) {
                if (counts[row] > maxCount) {
                    maxCount = counts[row];
                    modes[col] = data[row][col];
                }
            }
        }
        return modes;
    }
    
    // method to compute the minimum of each attribute
    public static double[] computeMins(double[][] data) {
        double[] mins = new double[4];
        for (int col = 0; col < 4; col++) {
            double min = Double.MAX_VALUE;
            for (int row = 0; row < 150; row++) {
                if (data[row][col] < min) {
                    min = data[row][col];
                }
            }
            mins[col] = min;
        }
        return mins;
    }
    
    //  method to compute the maximum of each attribute
    public static double[] computeMaxs(double[][] data) {
        double[] maxs = new double[4];
        for (int col = 0; col < 4; col++) {
            double max = Double.MIN_VALUE;
            for (int row = 0; row < 150; row++) {
                if (data[row][col] > max) {
                    max = data[row][col];
                }
            }
            maxs[col] = max;
        }
        return maxs;
    }
    
    //  method to compute the mean of each attribute for each species
    public static double[][] computeSpeciesMeans(double[][] data) {
        double[][] speciesMeans = new double[3][4];
        int[] speciesCounts = new int[3];
        for (int row = 0; row < 150; row++) {
            int speciesIndex = (int) data[row][4] - 1;
            speciesCounts[speciesIndex]++;
            for (int col = 0; col < 4; col++) {
                speciesMeans[speciesIndex][col] += data[row][col];
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int col = 0; col < 4; col++) {
                speciesMeans[i][col] /= speciesCounts[i];
            }
        }
        return speciesMeans;
    }
    
    // method to compute the median of each attribute for each species
    public static double[][] computeSpeciesMedians(double[][] data) {
        double[][] speciesMedians = new double[3][4];
        double[][] speciesData = new double[50][4];
        for (int i = 0; i < 3; i++) {
            int speciesIndex = i + 1;
            int count = 0;
            for (int row = 0; row < 150; row++) {
                if (data[row][4] == speciesIndex) {
                    speciesData[count] = data[row];
                    count++;
                }
                for (int col = 0; col < 4; col++) {
                    Arrays.sort(speciesData, new Comparator<double[]>() {
                        @Override
                        public int compare(double[] a, double[] b) {
                            return Double.compare(a[col], b[col]);
                        }
                    });
                    int middleIndex = count / 2;
                    if (count % 2 == 0) {
                        speciesMedians[i][col] = (speciesData[middleIndex-1][col] + speciesData[middleIndex][col]) / 2.0;
                    } else {
                        speciesMedians[i][col] = speciesData[middleIndex][col];
                    }
                }
            }
            return speciesMedians;
        }
    }
        // Main method to compute and print the summary statistics
        public static void main(String[] args) {
            // Load the iris dataset
            double[][] data = loadIrisDataset("Iris.csv");
            
            // Compute the summary statistics for the whole dataset
            double[] means = computeMeans(data);
            double[] medians = computeMedians(data);
            double[] modes = computeModes(data);
            double[] mins = computeMins(data);
            double[] maxs = computeMaxs(data);
            
            // Print the summary statistics for the whole dataset
            System.out.println("Summary statistics for the whole dataset:");
            System.out.println("Attribute, Mean, Median, Mode, Min, Max");
            System.out.printf("SepalLengthCm, %.2f, %.2f, %.2f, %.2f, %.2f\n", means[0], medians[0], modes[0], mins[0], maxs[0]);
            System.out.printf("SepalWidthCm, %.2f, %.2f, %.2f, %.2f, %.2f\n", means[1], medians[1], modes[1], mins[1], maxs[1]);
            System.out.printf("PetalLengthCm, %.2f, %.2f, %.2f, %.2f, %.2f\n", means[2], medians[2], modes[2], mins[2], maxs[2]);
            System.out.printf("PetalWidthCm, %.2f, %.2f, %.2f, %.2f, %.2f\n", means[3], medians[3], modes[3], mins[3], maxs[3]);
            
            // Compute the summary statistics for each species
            double[][] speciesMeans = computeSpeciesMeans(data);
            double[][] speciesMedians = computeSpeciesMedians(data);
            
            // Print the summary statistics for each species
            String[] speciesNames = {"Iris-setosa", "Iris-versicolor", "Iris-virginica"};
            for (int i = 0; i < 3; i++) {
                System.out.println("Summary statistics for " + speciesNames[i] + ":");
                System.out.println("Attribute, Mean, Median");
                System.out.printf("SepalLengthCm, %.2f, %.2f\n", speciesMeans[i][0], speciesMedians[i][0]);
                System.out.printf("SepalWidthCm, %.2f, %.2f\n", speciesMeans[i][1], speciesMedians[i][1]);
                System.out.printf("PetalLengthCm, %.2f, %.2f\n", speciesMeans[i][2], speciesMedians[i][2]);
                System.out.printf("PetalWidthCm, %.2f, %.2f\n", speciesMeans[i][3],speciesMedians[i][3]);
            }
        // Write the results to a file
        try {
            PrintWriter writer = new PrintWriter("summary_statistics.txt", "UTF-8");
            
            // Write the summary statistics for the whole dataset
            writer.println("Summary statistics for the whole dataset:");
            writer.println("Attribute, Mean, Median, Mode, Min, Max");
            writer.printf("SepalLengthCm, %.2f, %.2f, %.2f, %.2f, %.2f\n", means[0], medians[0], modes[0], mins[0], maxs[0]);
            writer.printf("SepalWidthCm, %.2f, %.2f, %.2f, %.2f, %.2f\n", means[1], medians[1], modes[1], mins[1], maxs[1]);
            writer.printf("PetalLengthCm, %.2f, %.2f, %.2f, %.2f, %.2f\n", means[2], medians[2], modes[2], mins[2], maxs[2]);
            writer.printf("PetalWidthCm, %.2f, %.2f, %.2f, %.2f, %.2f\n", means[3], medians[3], modes[3], mins[3], maxs[3]);
            
            // Write the summary statistics for each species
            for (int i = 0; i < 3; i++) {
                writer.println("Summary statistics for " + speciesNames[i] + ":");
                writer.println("Attribute, Mean, Median");
                writer.printf("SepalLengthCm, %.2f, %.2f\n", speciesMeans[i][0], speciesMedians[i][0]);
                writer.printf("SepalWidthCm, %.2f, %.2f\n", speciesMeans[i][1], speciesMedians[i][1]);
                writer.printf("PetalLengthCm, %.2f, %.2f\n", speciesMeans[i][2], speciesMedians[i][2]);
                writer.printf("PetalWidthCm, %.2f, %.2f\n", speciesMeans[i][3], speciesMedians[i][3]);
                writer.println();
            }
            
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
    