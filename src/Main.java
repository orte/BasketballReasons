
import org.telegram.telegrambots.BotLogger;
import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.TelegramBotsApi;

import presLogic.BBallReasonsHandler;

public class Main {

		
		private static final String LOGTAG = "MAIN";

	    public static void main(String[] args) {

	        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
	        try {
	            telegramBotsApi.registerBot(new BBallReasonsHandler());
	            
	        } catch (TelegramApiException e) {
	            BotLogger.error(LOGTAG, e);
	        }
	    }

//		Menu menus = new Menu();
//		int opcion = 0;
//		Scanner scan = new Scanner(System.in);
//		while(opcion!=4){
//			menus.principalMenu();
//			opcion = scan.nextInt();
//			switch(opcion){
//			case 1: menus.complListMenu(); break;
//			case 2: menus.posListMenu(); break;
//			case 3: menus.searchNameMenu(); break;
//			case 4: System.out.println("Hasta luego!"); break;
//			}
//		}
//		scan.close();
	

}
