public class Verbose {
    public static void ThrowError(String msg, boolean verbose) {
        if (verbose) {
            System.out.println("\u001B[31m" + msg + "\u001B[00m");
        }
    }

    public static void ThrowWarning(String msg, boolean verbose) {
        if (verbose) {
            System.out.println("\033[33m" + msg + "\u001B[00m");
        }
    }

    public static void ThrowSuccess(String msg, boolean verbose) {
        if (verbose) {
            System.out.println("\033[32m" + msg + "\u001B[00m");
        }
    }
}
