
class Display {
    private static String boatAsciiArt = """
                            __/___           \s
                      _____/______|          \s
              _______/_____\\_______\\_____    \s
              \\              < < <       |   \s
            ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
            """;
    private static String seaBattleAsciiArt = """
            ███████╗███████╗ █████╗ ██████╗  █████╗ ████████╗████████╗██╗     ███████╗
            ██╔════╝██╔════╝██╔══██╗██╔══██╗██╔══██╗╚══██╔══╝╚══██╔══╝██║     ██╔════╝
            ███████╗█████╗  ███████║██████╔╝███████║   ██║      ██║   ██║     █████╗ \s
            ╚════██║██╔══╝  ██╔══██║██╔══██╗██╔══██║   ██║      ██║   ██║     ██╔══╝ \s
            ███████║███████╗██║  ██║██████╔╝██║  ██║   ██║      ██║   ███████╗███████╗
            ╚══════╝╚══════╝╚═╝  ╚═╝╚═════╝ ╚═╝  ╚═╝   ╚═╝      ╚═╝   ╚══════╝╚══════╝
            
            """;


    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void showMainMenu() {
        clearScreen();
        System.out.println(seaBattleAsciiArt);
        System.out.println();
        System.out.println("1. Start New Game");
        System.out.println("2. Exit");
        System.out.println();
    }

    public static void showWinner(String winnerName) {
        clearScreen();
        System.out.println("╔════════════════════════════════╗");
        System.out.println("║      " + winnerName + " WINS!          ║");
        System.out.println("╚════════════════════════════════╝");
        System.out.println("\nAll enemy ships destroyed!");
    }
}