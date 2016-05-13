package bizLogic;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import obj.*;

public class Manager {
	
	public ArrayList<Player> getPlayersByPosition(String pos){
		ArrayList<Player> ordered = new ArrayList<Player>();
		ArrayList<Player> players = this.getPlayerList();
		for(int i=0; i<players.size(); i++){
			if(players.get(i).getPosition().equals(pos)){
				ordered.add(players.get(i));
			}
		}
		return ordered;
	}

	public Document getDoc(String link){
		URL url = null;
		InputStream is = null;
		String line = null;
		BufferedReader br = null;
		StringBuffer sb = null;
		try {
			url = new URL(link);
			is = (InputStream)url.getContent();
			br = new BufferedReader(new InputStreamReader(is));
		    
		    sb = new StringBuffer();
		    while ((line = br.readLine()) != null) {
		        sb.append(line);
		    }
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String htmlContent = sb.toString();
	    Document doc = Jsoup.parse(htmlContent);
		return doc;
	}
	public ArrayList<Player> getPlayerList(){
		ArrayList<Player> playerList = new ArrayList<Player>();
		int count = 11;
		int total = 0;
		String base = "http://basketballreasons.hol.es/html/fa/fa-ht.htm";
		
		Document doc = this.getDoc(base);
	    Element mainTable = doc.select("table").get(1);
	    //Now we have to scrap the data of the individual pages of the players in the table
		while (count<mainTable.select("td").size()){
			//We initialize the scraping of the players' page
			String link = mainTable.select("td").get(count+1).select("a").first().attr("href");
			String changedLink = link.substring(2, link.length());
			String mainBase = "http://basketballreasons.hol.es/html/"+changedLink;
		    Document doc1 = this.getDoc(mainBase);
		    //Check if the player is a free agent
		    total++;
			//Get the main data of the player
		    Player player = this.getPlayerInfo(doc1, total);
		    playerList.add(player);
		    count+=12;
		    if(count == mainTable.select("td").size()-1){
		        	count++;
		        }
		    }
		return playerList;
		}
	public Player getPlayerInfo(Document doc, int id){
		String team = doc.select("table").get(2).select("tr").get(2).select("td").get(2).text();
		String namePos = doc.select("td").get(1).text();
	    String p = namePos.substring(namePos.length()-2, namePos.length());
	    String pos = p.replace(" ", "");
	    String n =  namePos.substring(0, namePos.length()-2);
	    String name;
	    if (n.endsWith(" ")){
	    	name = n.substring(0, n.length()-1);
	    } else{
	    	name = n;
	    }
	    Element mainData = doc.select("table").get(2);
	    String height = mainData.select("tr").get(2).select("td").get(6).text();
	    int exp = Integer.parseInt(mainData.select("tr").get(2).select("td").get(14).text());
	    int age = Integer.parseInt(mainData.select("tr").get(3).select("td").get(2).text());
	    String weight = mainData.select("tr").get(3).select("td").get(6).text();
	    //Create the player with the received data
	    Player player = new Player(id, name, pos, team, age, height, weight, exp);
	   
	    //Get the abilities of the player
	    Element abilities = doc.select("table").get(3);
	    String [] abs = new String [6];
	    for (int i = 0; i<abs.length; i++){
	    	abs[i] = abilities.select("tr").get(i+1).select("td").get(2).text();
	    }
	    player.addAbilities(abs);
        //Get the stats of the player
	    Element stats = doc.select("table").get(6);
	    double [] stts = new double[7];
	    for (int i = 0; i<stts.length; i++){
	    	String stat = stats.select("tr").get(i+1).select("td").get(2).text();
	    	String replaced = stat.replace(",", ".");
	    	stts[0] = Double.parseDouble(replaced);
	    }
	    player.addStats(stts);
	    //Finally, get the contract info
	    Element contractInfo = doc.select("table").get(8);
	    int [] info = new int[4];
	    for (int i = 0; i<info.length; i++){
	    	info[i] = Integer.parseInt(contractInfo.select("tr").get(i+1).select("td").get(2).text());
	    }
        return player;
		
	}
	public Player getPlayerByName(String name){
		ArrayList<Player> players = this.getPlayerList();
		Player player = new Player();
		for(Player aux:players){
			if(name.toUpperCase().equals(aux.getName().toUpperCase())){
				player = aux;
			}
		}
		return player;
	}
}
