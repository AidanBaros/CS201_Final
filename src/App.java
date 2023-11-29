import java.util.Scanner;

public class App {
    public static void main(String [] args){

        Scanner keyboard = new Scanner(System.in);
        String state = "main";
        int choice;
        String userState = "";

        while(!state.equals("exit"))
        {
            if(state.equals("main"))
            {
                mainMenu();
            }

            if(state.equals("addUser"))
            {
                addUserMenu();
            }

            if(state.equals("removeUser"))
            {
                removeUserMenu();
                
            }

            if(state.equals("listUser"))
            {
                //this will list all the users
            }

            if(state.equals("userMenu"))
            {
                userMenu();
            }
        }
    }

    public static int mainMenu()
    {
        System.out.println("Main menu:");
        System.out.println("[1] Add new user");
        System.out.println("[2] Remove user");
        System.out.println("[3] List all users");
        System.out.println("[4] User menu");
        System.out.println("[5] Exit");
        System.out.println("What is your choice?");
        choice = keyboard.nextInt();
        if(choice == 1)
                {
                    state = "addUser";
                }

                if(choice == 2)
                {
                    state = "removeUser";
                }

                if(choice == 3)
                {
                    state = "listUser";
                }

                if(choice == 4)
                {
                    state = "userMenu";
                }

                if(choice == 5)
                {
                    state = "exit";
                }
        return choice;
    }

    public static int addUserMenu()
    {
        //literally nothing give so not sure for now
        return 1;
    }

    public static void removeUserMenu()
    {
        System.out.println("Remove user menu:");
        System.out.println("[1] Remove user by ID");
        System.out.println("[2] Remove user by name");
        System.out.println("[3] Go back to previous menu");
        System.out.println("What is your choice?");
        choice = keyboard.nextInt();
        if(choice == 1)
                {
                    //this finna do sum
                }

                if(choice == 2)
                {
                    //this finna do sum
                }

                if(choice == 3)
                {
                    state = "main";
                }
    }

    public static void userMenu()
    {
        System.out.println("User menu:");
        System.out.println("[1] Add recording");
        System.out.println("[2] Add playlist from file");
        System.out.println("[3] Add playlist from another user");
        System.out.println("[4] Remove recording from playlist");
        System.out.println("[5] Play individual recording");
        System.out.println("[6] Play entire playlist in order ONCE");
        System.out.println("[7] Play entire playlist shuffled ONCE");
        System.out.println("[8] Save playlist to a file");
        System.out.println("[9] Display playlist stats");
        System.out.println("[10] Go back to previous menu");
        System.out.println("What is your choice?");
        choice = keyboard.nextInt();
        if(choice == 1)
                {
                    //code for adding a recording
                }

                if(choice == 2)
                {
                    //code for adding a playlist from a file
                }

                if(choice == 3)
                {
                    //code for adding a playlist from another user
                }

                if(choice == 4)
                {
                    //code for removing a playlist from a user
                    choice = removeRecording();

                    if(choice  == 1)
                    {
                        //code for removing by id
                    }

                    if(choice == 2)
                    {
                        //code for removing by name
                    }

                    if(choice == 3)
                    {
                        state = "userMenu";
                    }

                }
                if(choice == 5)
                {
                    //code for playing an indivduals recording
                    choice = recordingMenu();
                    if(choice = 1)
                    {
                        //code for playing recording id
                    }

                    if(choice == 2)
                    {
                        //code for playing recordin by id
                    }

                    if(choice  == 3)
                    {
                        state = "userMenu";
                    }

                }
                if(choice == 6)
                {
                    //code for playing entire recording once nonshuffled
                }
                if(choice == 7)
                {
                    //code for playing entire recroding shuffled once
                }
                if(choice == 8)
                {
                    //code for saving playlist to file
                }
                if(choice == 9)
                {
                    //code for displaying playlist stats
                    
                }
                if(choice == 10)
                {
                    state = "Main";
                }

    }

    public static void removeRecording()
    {
        System.out.println("Remove recording from playlist menu:");
        System.out.println("[1] Remove recording by id");
        System.out.println("[2] Remove recording by name");
        System.out.println("[3] Go back to previous menu");
        System.out.println("What is your choice?");
        choice = keyboard.nextInt();
    }

    public static void recordingMenu()
    {
        System.out.println("Play individual recording menu:");
        System.out.println("[1] Play recording by id");
        System.out.println("[2] Play recording by name");
        System.out.println("[3] Go back to previous menu");
        System.out.println("What is your choice?");
        choice = keyboard.nextInt();

    }

}
