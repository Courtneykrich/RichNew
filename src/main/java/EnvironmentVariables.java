import java.io.File;

    public class EnvironmentVariables {

        public static void main(String[] args){
            System.out.println("My favorite candy is: " + System.getenv("FAVORITE_CANDY"));

            System.out.println("On this computer, path entries are separated by this character: " + File.pathSeparator);
            String path = System.getenv("PATH");
            String[] pathParts = path.split(File.pathSeparator);

            System.out.println("When this computer is given the name of a command, it checks these directories to look for it:");
            for(int i = 0; i < pathParts.length; i++){
                System.out.println("   " + pathParts[i]);
            }
        }
    }


