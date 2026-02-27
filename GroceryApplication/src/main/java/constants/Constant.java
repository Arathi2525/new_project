package constants;

public class Constant
{
	public static final String CONFIGFILE=System.getProperty("user.dir")+"\\src\\main\\resources\\config.property";
			
	public static final String TESTDATA=System.getProperty("user.dir")+"\\src\\test\\resources\\GroceryData.xlsx";
	
    public static final String VALIDCREDENTIALERROR="user is unable to login with valid credentials";
   
    public static final String INVALIDCREDENTIALERROR="user is able to login with invalid credentials";
   
    public static final String VALIDUSERNAMEINVALIDPASSWORDERROR="user is able to login with invalid credentials";
    
    public static final String INVALIDUSERNAMEVALIDPASSWORDERROR="user is able to login with invalid credentials";
    
    public static final String USERISABLETOSUCCESSFULLYLOGGEDOUTERROR="user is unable to login with valid credentials";
    
    public static final String ADDNEWUSERERROR ="user is unable to add new user";
    
    public static final String SEARCHNEWLYADDEDUSERERROR ="user is unable to enter search";
    
    public static final String USERISABLETORESETERROR="user is unable to click reset";
    
    public static final String USERISABLETOADDNEWSERROR="user not able to add news";
    
    public static final String USERISABLETOSEARCHNEWLYADDEDNEWSERROR="user is unable to display search result";
    
}
