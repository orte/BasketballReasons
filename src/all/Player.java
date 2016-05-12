package all;

public class Player {
	private int id;
	private String name;
	private String position;
	private String team;
	private int age;
	private String height;
	private String weight;
	private int exp;
	private String in;
	private String out;
	private String han;
	private String def;
	private String reb;
	private String pot;
	private int games;
	private double mpg;
	private double ppg;
	private double rpg;
	private double apg;
	private double fgp;
	private double tpp;
	private int loyalty;
	private int greed;
	private int play4w;
	private int birdYrs;
	private String [] abilities = {in, out, han, def, reb, pot};
	private double [] stats ={games, mpg, ppg, rpg, apg, fgp, tpp};
	private int [] contractInfo = {loyalty, greed, play4w, birdYrs};
	
	public Player(int id, String name, String pos, String team, int age, String height, String weight, int exp){
		this.id = id;
		this.name = name;
		this.position = pos;
		this.team = team;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.exp = exp;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public String getIn() {
		return in;
	}
	public void setIn(String in) {
		this.in = in;
	}
	public String getOut() {
		return out;
	}
	public void setOut(String out) {
		this.out = out;
	}
	public String getHan() {
		return han;
	}
	public void setHan(String han) {
		this.han = han;
	}
	public String getDef() {
		return def;
	}
	public void setDef(String def) {
		this.def = def;
	}
	public String getReb() {
		return reb;
	}
	public void setReb(String reb) {
		this.reb = reb;
	}
	public String getPot() {
		return pot;
	}
	public void setPot(String pot) {
		this.pot = pot;
	}
	public int getGames() {
		return games;
	}
	public void setGames(int games) {
		this.games = games;
	}
	public double getMpg() {
		return mpg;
	}
	public void setMpg(double mpg) {
		this.mpg = mpg;
	}
	public double getPpg() {
		return ppg;
	}
	public void setPpg(double ppg) {
		this.ppg = ppg;
	}
	public double getRpg() {
		return rpg;
	}
	public void setRpg(double rpg) {
		this.rpg = rpg;
	}
	public double getApg() {
		return apg;
	}
	public void setApg(double apg) {
		this.apg = apg;
	}
	public double getFgp() {
		return fgp;
	}
	public void setFgp(double fgp) {
		this.fgp = fgp;
	}
	public double getTpp() {
		return tpp;
	}
	public void setTpp(double tpp) {
		this.tpp = tpp;
	}
	public int getLoyalty() {
		return loyalty;
	}
	public void setLoyalty(int loyalty) {
		this.loyalty = loyalty;
	}
	public int getGreed() {
		return greed;
	}
	public void setGreed(int greed) {
		this.greed = greed;
	}
	public int getPlay4w() {
		return play4w;
	}
	public void setPlay4w(int play4w) {
		this.play4w = play4w;
	}
	public int getBirdYrs() {
		return birdYrs;
	}
	public void setBirdYrs(int birdYrs) {
		this.birdYrs = birdYrs;
	}
	public String[] getAbilities() {
		return abilities;
	}
	public void setAbilities(String[] abilities) {
		this.abilities = abilities;
	}
	public double[] getStats() {
		return stats;
	}
	public void setStats(double[] stats) {
		this.stats = stats;
	}
	public int [] getContractInfo() {
		return contractInfo;
	}

	public void setContractInfo(int [] contractInfo) {
		this.contractInfo = contractInfo;
	}
	
	public void addAbilities(String [] abs){
		this.in = abs[0];
		this.out = abs[1];
		this.han = abs[2];
		this.def = abs[3];
		this.reb = abs[4];
		this.pot = abs[5];
	}
	public void addStats(double [] stts){
		this.games = (int) stts[0];
		this.mpg = stts[1];
		this.ppg = stts[2];
		this.rpg = stts[3];
		this.apg = stts[4];
		this.fgp = stts[5];
		this.tpp = stts[6];
	}
	public void addContrInfo(int [] info){
		this.loyalty = info[0];
		this.greed = info[1];
		this.play4w = info[2];
		this.birdYrs = info[3];
	}

	
	
	
	

}
