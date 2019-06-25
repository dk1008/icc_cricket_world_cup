class Tournament
{
	public static void main(String[] args)
	{
		//formign team combition....
		String[] team = {"Australia","England","India","New Zealand","Pakistan","South Africa","Sri lanka","West Indies"};
		String[] team_comb = new String[28];
		int comb_no = 0;
		for(int i=0;i<team.length;i++)
			for(int j = i+1;j<team.length;j++)
				team_comb[comb_no++] = team[i]+" --v/s-- "+team[j];


	/*	//printing team combinition
		for(int i=0;i<team_comb.length;i++)
			System.out.println(team_comb[i]); */
	

		//Alloting Date to each Team....
		int dd = 30;
		int count = 1;
		String mm ="May";
		String[] match_date = new String[28];
		int c = 0;
		while(c<7)
		{
			for(int j =0;j<4;j++)
			{
				match_date[c+j*7] = dd+"-"+mm+"-"+2019;
				if((count++)%3==0)
					dd +=2;
				if(dd>31)
				{
					dd = dd -30;
					mm = "June";
				}
			}
			c++;
		}


		

	/*	//printing Alloted Date
		for(int i=0;i<match_date.length;i++)
			System.out.println(match_date[i]); */


		// Alloting Ground to each scheduled match
		String[] venues = {"Leeds","Manchester","London"};
		String[] gnd_name = new String[28];
		int num = 0;
		for(int i=0;i<team_comb.length;i++)
		{
			num = num%venues.length;
			gnd_name[i] = venues[num++];
		}


	/*	//printing Alloted ground
		for(int i=0;i<team_comb.length;i++)
			System.out.println(gnd_name[i]); */


		for(int i=0;i<team_comb.length;i++)
			System.out.println(i+"  "+team_comb[i]+"    "+match_date[i]+"    "+gnd_name[i]);
	}
}
