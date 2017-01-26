public class dabbadabba {

    public static void DrawDashes() {
        for (int i = 0; i < 9; i++) {
            System.out.print("-");
        }
    }
    
    public static void DrawWindows() {
        DrawDashes();
        System.out.print("| %");
        for (int i = 0; i < 4; i++) {
            System.out.print(" ");
        }
        System.out.print("% |" );
        DrawDashes();
        System.out.println();
    }

    public static void DrawTop() {
        DrawWindows();
        for (int i = 0; i < 4; i++) {
            System.out.print(" o");
        }
        System.out.print(" | %");
        for (int i = 0; i < 4; i++) {
            System.out.print(" ");
        }
        System.out.print("% | ");
        for (int i = 0; i < 4; i++) {
            System.out.print("o ");
        }
        System.out.println();
        DrawWindows();
    }

    public static void DrawSteps() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4 - i; j++) {
                System.out.print("~^");
            }
            System.out.print("~/");
            for (int j = 0; j < 8 + 4 * i; j++) {
                System.out.print("-");
            }
            System.out.print("\\~");
            for (int j = 0; j < 4 - i; j++) {
                System.out.print("^~");
            }
            System.out.println();
            
            for (int j = 0; j < 4 - i; j++) {
                System.out.print("^~");
            }
            System.out.print("/");
            for (int j = 0; j < 10 + 4 * i; j++) {
                System.out.print("-");
            }
            System.out.print("\\");
            for (int j = 0; j < 4 - i; j++) {
                System.out.print("~^");
            }
            System.out.println();
            
            for (int j = 0; j < 8 - (2 * i); j++) {
                System.out.print(" ");
            }
            System.out.print("|");
            for (int j = 0; j < 10 + 4 * i; j++) {
                System.out.print("=");
            }
            System.out.print("|");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 13 - i; j++) {
                System.out.print(" ");
            }
            System.out.print("/");
            for (int j = 0; j < i; j++) {
                System.out.print("/\\");
            }
            System.out.println("\\");
        }

        DrawTop();

        DrawSteps();

        System.out.print("   /");
        for (int i = 0; i < 20; i++) {
            System.out.print(" ");
        }
        System.out.print("\\");
        System.out.println();

        System.out.print("  /  ");
        for (int i = 0; i < 18; i++) {
            System.out.print("=");
        }
        System.out.print("  \\");
        System.out.println();

        System.out.print(" /  / ");
        for (int i = 0; i < 16; i++) {
            System.out.print("\"");
        }
        System.out.print(" \\  \\");
        System.out.println();
        
        System.out.print("|  | ");
        for (int i = 0; i < 18; i++)
            System.out.print("\"");
        System.out.print(" |  |");
        System.out.println();
        
        System.out.print(" \\  \\ ");
        for (int i = 0; i < 16; i++)
            System.out.print("\"");
        System.out.print(" /  /");
        System.out.println();
        
        System.out.print("  \\  ");
        for (int i = 0; i < 18; i++) {
            System.out.print("=");
        }
        System.out.print("  /");
        System.out.println();
        
        System.out.print("   \\");
        for (int i = 0; i < 20; i++) {
            System.out.print("_");
        }
        System.out.println("/");
    }
}
