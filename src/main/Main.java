package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import all.Player;

public class Main {

	public static void main(String[] args) {

		ArrayList<Integer> allP = new ArrayList<Integer>();
		ArrayList<Player> players = new ArrayList<Player>();
		//Initialize the scraping of the main FA page and get the table with the players
		int count = 11;
		int total = 0;
		String base = "http://basketballreasons.hol.es/html/fa/fa-ht.htm";
		URL url = null;
		InputStream is = null;
		String line = null;
		BufferedReader br = null;
		StringBuffer sb = null;
		try {
			url = new URL(base);
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
	    Element mainTable = doc.select("table").get(1);
	    //Now we have to scrap the data of the individual pages of the players in the table
		while (count<mainTable.select("td").size()){
			//We initialize the scraping of the players' page
			String link = mainTable.select("td").get(count+1).select("a").first().attr("href");
			String changedLink = link.substring(2, link.length());
			String mainBase = "http://basketballreasons.hol.es/html/"+changedLink;
			URL mainUrl = null;
			InputStream is1 = null;
			String line1 = null;
			BufferedReader br1 = null;
			StringBuffer sb1 = null;
			try {
				mainUrl = new URL(mainBase);
				is1 = (InputStream)mainUrl.getContent();
				br1 = new BufferedReader(new InputStreamReader(is1));
			    
			    sb1 = new StringBuffer();
			    while ((line1 = br1.readLine()) != null) {
			        sb1.append(line1);
			    }
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String htmlContent1 = sb1.toString();
		    Document doc1 = Jsoup.parse(htmlContent1);
		    //Check if the player is a free agent
		    String team = doc1.select("table").get(2).select("tr").get(2).select("td").get(2).text();
		    if(team.equals("FA")==false){
		    	count++;
		    } else{
		    	total++;
			    //Get the main data of the player
			    String namePos = doc1.select("td").get(1).text();
			    System.out.println(namePos);
			    String pos = namePos.substring(namePos.length()-2, namePos.length());
			    String name = namePos.substring(0, namePos.length()-2);
			    Element mainData = doc1.select("table").get(2);
			    String height = mainData.select("tr").get(2).select("td").get(6).text();
			    int exp = Integer.parseInt(mainData.select("tr").get(2).select("td").get(14).text());
			    int age = Integer.parseInt(mainData.select("tr").get(3).select("td").get(2).text());
			    String weight = mainData.select("tr").get(3).select("td").get(6).text();
			    //Create the player with the received data
			    Player player = new Player(total, name, pos, team, age, height, weight, exp);
			    allP.add(new Integer(total));
			    players.add(player);
			    //Get the abilities of the player
			    Element abilities = doc1.select("table").get(3);
			    String [] abs = new String [6];
			    for (int i = 0; i<abs.length; i++){
			    	abs[i] = abilities.select("tr").get(i+1).select("td").get(2).text();
			    }
			    player.addAbilities(abs);
		        //Get the stats of the player
			    Element stats = doc1.select("table").get(6);
			    double [] stts = new double[7];
			    for (int i = 0; i<stts.length; i++){
			    	String stat = stats.select("tr").get(i+1).select("td").get(2).text();
			    	String replaced = stat.replace(",", ".");
			    	stts[0] = Double.parseDouble(replaced);
			    }
			    player.addStats(stts);
			    //Finally, get the contract info
			    Element contractInfo = doc1.select("table").get(8);
			    int [] info = new int[4];
			    for (int i = 0; i<info.length; i++){
			    	info[i] = Integer.parseInt(contractInfo.select("tr").get(i+1).select("td").get(2).text());
			    }
		        
		        count+=12;
		        if(count == mainTable.select("td").size()-1){
		        	count++;
		        }
		    }
		}
		System.out.println(total);
	}

}
