//this program is only for 8 team...
//you have to make changes ,if you want to increase/decrease team.
enum month
{
	JAN,FEB,MARCH,APRIL,MAY,JUNE,JULY,AUG,SEP,OCT,NOV,DEC;
}

class Tournament4
{
	static String[] team = {"Australia","England","India","New Zealand","Pakistan","South Africa","Sri lanka","West Indies"};
	static String[] venues = {"Leeds","Manchester","London"};
	static String[] team_comb = new String[28];
	static String[] gnd_name = new String[28];
	static String[] match_date = new String[28];
	static int dd = 30;
	static String mm = month.MAY.toString();
	static int year = 2019;


//########################################################################################################################################
	//Possible team Formation...
	public void team_combination()
	{
		int comb_no = 0;
		for(int i=0;i<8;i++)
			for(int j = i+1;j<8;j++)
				team_comb[comb_no++] = team[i]+" --v/s-- "+team[j];
	}
//---------------------------------------------------------------------------------------------------------------------------------------


//#######################################################################################################################################
	//Assigning Ground to Teams for schedualed match.
	public void Ground_allocation()
	{
		int num = 0;
		for(int i=0;i<28;i++)
		{
			num = num%venues.length;
			gnd_name[i] = venues[num++];
		}
	}
//---------------------------------------------------------------------------------------------------------------------------------------


//######################################################################################################################################
	//Displaying Match Schedule.
	public void displaySchedule()
	{
		for(int i=0;i<28;i++)
			System.out.println(i+1+"  "+team_comb[i]+"    "+gnd_name[i]+"    "+match_date[i]);
	}
//-------------------------------------------------------------------------------------------------------------------------------------


//#####################################################################################################################################
	//Match Date Scheduling
	public int date_scheduling(int i ,String newDate)
	{
		String[] st1 = team_comb[i].split(" --v/s-- ");
		int flag = 0;
		int num = 0;
		int num1 = i;
		String[] st2;
		String[] st3;
		String gndName = gnd_name[i];
		for(int p = 0; p<28;p++)
		{
			if(p != i && match_date[p] == newDate)
			{
				num1 = p;
				gndName = gnd_name[p];
				break;
			}
		}
		
		for(int j = i; j<28;j++)
		{
			if(i != j && !(gnd_name[i].equals(gnd_name[j])) && !(gndName.equals(gnd_name[j])) && match_date[j] == null)
			{
				st2 = team_comb[j].split(" --v/s-- ");
				st3 = team_comb[num1].split(" --v/s-- ");
				if(!(st1[0].equals(st2[0])) && !(st1[0].equals(st2[1])) && !(st1[1].equals(st2[0])) && !(st1[1].equals(st2[1])) && !(st3[0].equals(st2[0])) && !(st3[0].equals(st2[1])) && !(st3[1].equals(st2[0])) && !(st3[1].equals(st2[1])))
				{
					flag = 1;
					num = j;
					break;	
				}
			}
		}
		if(flag == 1)
		{
			match_date[num] = newDate;
		}
		return num;
	}
//------------------------------------------------------------------------------------------------------------------------------------


//###################################################################################################################################
	//checking match_date  array has null or not
	public boolean checkAllNull()
	{
		for(int i =0;i<28;i++)
			if(match_date[i] == null)
				return  true;
		return false;
	}
//----------------------------------------------------------------------------------------------------------------------------------


//###################################################################################################################################
	//checking match_date  array has null or not at particular index.
	public int checkNull()
	{
		for(int i =0;i<28;i++)
			if(match_date[i] == null)
				return  i;
		return 0;
		/*if(match_date[i] == null)
			return  true;
		return false;*/
	}
//----------------------------------------------------------------------------------------------------------------------------------


//####################################################################################################################################
	//count given date is less than or equal to 3.
	public boolean isSameDate(String newdate)
	{
		int count = 0;
		for(int i=0;i<28;i++)
			if(match_date[i] == newdate)
				count++;
		if(count == 3)
			return true;
		return false;
	}
//------------------------------------------------------------------------------------------------------------------------------------


//###################################################################################################################################

	//Main method.
	public static void main(String[] args)
	{
		//creatinf object of tournament class
		Tournament4 t = new Tournament4();

		//formign team combition....
		t.team_combination();

		// Alloting Ground to each scheduled match
		t.Ground_allocation();

		//scheduling match date
		if(t.checkAllNull())
			match_date[0] = dd+"-"+mm+"-"+year;
		
		String newDate = match_date[0];
		int x = 0;
		for(int i = 1;i<20;i++)
		{	
			if(t.isSameDate(newDate))
			{
				dd += 2;
				if(dd > 31)
				{
					dd = dd - 31;
					mm = month.JUNE.toString();
				}
				newDate = dd+"-"+mm+"-"+year;
				x = t.checkNull();
				match_date[x] = newDate;
			}	
			x = t.date_scheduling(x,newDate);
		}
		while(t.checkNull()>0)
		{
			match_date[t.checkNull()] = newDate;
			if(t.isSameDate(newDate)){
				dd = dd+2;
				newDate = dd+"-"+mm+"-"+year;}
		}
		
		//Displaying match Schedule.
		t.displaySchedule();
	}
//------------------------------------------------------------------------------------------------------------------------------------

}

