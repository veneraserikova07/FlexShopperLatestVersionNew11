package hooks;

import cucumber.api.java.Before;


public class Hooks {







    @Before("@myLogin")

    public void setUpAndLogin() {

        System.out.println("Land to email screen and login");


    }





}
