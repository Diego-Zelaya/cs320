//package edu.sdsu.cs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import edu.sdsu.cs.datastructures.DirectedGraph;

public class App
{
    public static void main( String[] args ) throws IOException {

        // set file path vars
        String csvFile = "layout.csv"; // path to file
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        // try to open the file and slit each line by ,
        try {

            // create line buffer
            br = new BufferedReader(new FileReader(csvFile));

            int size = 6;
            DirectedGraph.Vertex[] vertices = new DirectedGraph.Vertex[size];

            // while loop each line finding a vertex or a connection entry
            while ((line = br.readLine()) != null) {

                String[] lineSplit = line.split(cvsSplitBy);

                if ( lineSplit.length < 2 ) {
                    System.out.println("Vertex: " + lineSplit[0]);
                }

                if ( lineSplit.length > 1 ) {
                    System.out.println("connectionEntry: " + "sourceVertex: " + lineSplit[0] + " => " + "destinationVertex: " + lineSplit[1] + " => " + "integerMoveCost: " + 0);

                }

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
