import java.io.IOException;
import java.io.FileNotFoundException;

public class MoveRover {
    String outputPath;
    ReadFile input, testFile;
    WriteFile output;
    boolean testing;
    Rover rover;

    public MoveRover(String inputPath, String outputPath) throws IOException, FileNotFoundException {
        if(inputPath.equals("-t")) {
            testing = true;
            input = new ReadFile("test/input.txt");
        } else {
            testing = false;
            input = new ReadFile(inputPath);    
        }
        this.outputPath = outputPath;
        output = new WriteFile(outputPath);       
    }

    public MoveRover(String inputPath) throws IOException, FileNotFoundException {
        this(inputPath, "output.txt");
    }

    public MoveRover() throws IOException, FileNotFoundException {
        this("input.txt", "output.txt");
    }

    public void test() throws IOException, FileNotFoundException{
        String l1 = null, l2 = null;

        System.out.println("\n\nSTARTING TEST ROUTINE\n");

        input = new ReadFile(outputPath);
        testFile = new ReadFile("test/output.txt");

        while(((l1 = input.get()) != null) & ((l2 = testFile.get()) != null)) {
            if(!l1.equals(l2)) {
                System.out.println("TEST FAILED. The outputted file does not match test output file");
                input.close();
                testFile.close();
                return;
            }
        }
        if((l1 == null) && (l2 != null)) {
            System.out.println("TEST FAILED. The outputted file does not match test output file");
            testFile.close();
            return;
        }
        if((l2 == null) && (l1 != null)) {
            System.out.println("TEST FAILED. The outputted file does not match test output file");
            input.close();
            return;
        }

        System.out.println("TEST SUCCEEDED. The outputted file matches test out put file");
    }

    public void move() throws MoveRoverException{
        String line;
        String[] data;
        int w, h, rn = 0;
        Rover r;

        try {
            line = input.get();
            if(line == null) {
                throw new MoveRoverException("Input file not in expected format!");
            }
            data = line.split(" ");
            if(data.length != 2) {
                throw new MoveRoverException("Input file not in expected format!");
            }
            w = Integer.parseInt(data[0]);
            h = Integer.parseInt(data[1]);
            
            while((line = input.get()) != null) {
                data = line.split(" ");
                if(data.length != 3) {
                    throw new MoveRoverException("Input file not in expected format!");
                }
                rn++;
                System.out.println(String.format("\nMoving rover #%d", rn));
                r = new Rover(w, h, Integer.parseInt(data[0]), Integer.parseInt(data[1]), Cardinal.valueOf(data[2]));

                line = input.get();
                if(line == null) {
                    throw new MoveRoverException("Input file not in expected format!");
                }

                for(int i = 0, n = line.length(); i<n; i++) { 
                    try {
                        r.move(line.charAt(i));
                    } catch (MoveRoverException mre) {
                        System.out.print("A movement was ignored: ");
                        System.out.println(mre.getMessage());
                    }
                }
                output.set(r.getStateString());
            }
            output.close();
            
            if(testing) {
                test();
            }
        } catch (IOException ioe) {
            throw new MoveRoverException(String.format("ERROR in input/output files: %s", ioe.getMessage()));
        }
    }

    public static void main(String[] args) {
        int argc = args.length;
        MoveRover m;

        try {
            switch(args.length) {
                case 0:
                    m = new MoveRover();
                    break;
                case 1:
                    m = new MoveRover(args[0]);
                    break;
                default:
                    m = new MoveRover(args[0], args[1]);
                    break;
            }

            try {
                m.move();
            } catch(MoveRoverException mre) {
                System.out.print("ERROR moving rovers: ");
                System.out.println(mre.getMessage());
            }
        } catch (Exception e) {
            System.out.print("ERROR in the program: ");
            System.out.println(e.getMessage());
        }
    }
}