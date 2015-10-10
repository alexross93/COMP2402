package comp2402a2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Iterator;

public class InvestInGrapeJuice {
	
	/**
	 * Read each of the transaction/adjustment lines, one at a time, from r. 
	 * Add or remove elements from a data structure according to these lines.
	 * Output (to w) the capital gain or loss after all of the transactions have
	 * been processed, according to both strategies. To clarify:
	 *
	 * - You must first output the result of a "sell the oldest first" approach
	 *
	 * - You must then output the result of a "sell the freshest first" approach
	 *
	 * These two numbers should be the only output of your program. Round your
	 * numbers to the nearest cent (i.e., use EXACTLY two decimal places).
	 *
	 * @param r the reader to read from
	 * @param w the writer to write to
	 * @throws IOException
	 */
	public static void doIt(BufferedReader r, PrintWriter w) throws IOException {

        for (String line = r.readLine(); line != null; line = r.readLine()) {
			
        }

	}

	/**
	 * The driver.  Open a BufferedReader and a PrintWriter, either from System.in
	 * and System.out or from filenames specified on the command line, then call doIt.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			BufferedReader r;
			PrintWriter w;
			if (args.length == 0) {
				r = new BufferedReader(new InputStreamReader(System.in));
				w = new PrintWriter(System.out);
			} else if (args.length == 1) {
				r = new BufferedReader(new FileReader(args[0]));
				w = new PrintWriter(System.out);				
			} else {
				r = new BufferedReader(new FileReader(args[0]));
				w = new PrintWriter(new FileWriter(args[1]));
			}
			long start = System.nanoTime();
			doIt(r, w);
			w.flush();
			long stop = System.nanoTime();
			System.out.println("Execution time: " + 10e-9 * (stop-start));
		} catch (IOException e) {
			System.err.println(e);
			System.exit(-1);
		}
	}
}
