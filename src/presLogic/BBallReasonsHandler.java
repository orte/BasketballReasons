package presLogic;

import java.util.ArrayList;

import main.BotConfig;

import org.telegram.telegrambots.TelegramApiException;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import bizLogic.Manager;
import obj.Player;
import presLogic.Menu;

public class BBallReasonsHandler extends TelegramLongPollingBot{
	
	public boolean running;
	public String current="";
	Manager mng = new Manager();
	public ArrayList<Player> playersList = mng.getPlayerList();
	public static int counter = 0;

	@Override
	public String getBotUsername() {
		// TODO Auto-generated method stub
		return BotConfig.USERNAMEMYPROJECT;
	}

	@Override
	public void onUpdateReceived(Update update) {
		// TODO Auto-generated method stub

		Menu menu = new Menu();
		if(update.hasMessage()){
            Message message = update.getMessage();
            System.out.println(message.getText());

            //check if the message has text. it could also  contain for example a location ( message.hasLocation() )
            if (running == true){
            	running = false;
            	String msg = message.getText();
            	String value = "";
            	switch(current){
            	case "/2": value = menu.posListMenu(playersList, msg); break;
            	case "/3": value = menu.searchNameMenu(msg, playersList); 
            	if(value.equals("No existen jugadores con este nombre, inténtalo de nuevo")){
            			running = true;
            		}
            	}
            	sendMsg(value, message);
            } else{
	            if(message.hasText()){
	            	String msg = message.getText();
	            	String value = "";
	            	
	            	switch(msg){
	            	case "/1": value = menu.complListMenu(playersList); current = "/1"; break;
	            	case "/lista" : value = menu.complListMenu(playersList); current = "/1"; break;
	            	case "/2": value = "Qué posición quieres buscar?"; current = "/2";
	            	running = true; break;
	            	case "/posicion": value = "Qué posición quieres buscar?"; current = "/2";
	            	running = true; break;
	            	case "/3": value = "Introduce el nombre del jugador que quieres buscar"; current = "/3";
	            	running = true; break;
	            	case "/buscar": value = "Introduce el nombre del jugador que quieres buscar"; current = "/3";
	            	running = true; break;
	            	default: value = menu.mainMenu(); break;
	            	}
	            	sendMsg(value, message);

	            }
	            
	                    //create a object that contains the information to send back the message
	       }//end if()
            System.out.println(counter);
    }//end  if()
	}
	public void sendMsg(String value, Message message){
		SendMessage sendMessageRequest = new SendMessage();
        sendMessageRequest.setChatId(message.getChatId().toString());
        //who should get the message? the sender from which we got the message...
        sendMessageRequest.setText(value);
        try {
                sendMessage(sendMessageRequest); //at the end, so some magic and send the message ;)
        } catch (TelegramApiException e) {
                //do some error handling
        }//end catch()
	}

	@Override
	public String getBotToken() {
		// TODO Auto-generated method stub
		return BotConfig.TOKENMYPROJECT;
	}

}
