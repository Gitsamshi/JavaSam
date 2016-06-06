
public class EnuIns {
	
	public static void main(String[] args)
	{
		String name = "shizhan";
		Gender sex = Gender.MAN;
		Temper tmp =Temper.BRAVE;
		Person p = new Person(name,sex,tmp);
		System.out.println("name:"+p.getName()+" sex:"+p.getSex()+" temper:"+p.getCha());
		p.getSex().run();
		
		Season sea = Season.Winter;
		switch(sea)
		{
			case Winter: 
				System.out.println("gpgpg"); 
				break;
			default:
				System.out.println("gpgpgss");
		}
	}
	
	

}


class Person{
	String name;
	Gender sex;
	Temper cha;
	public Person(String name, Gender sex,Temper cha) {
		
		this.name = name;
		this.sex = sex;
		this.cha = cha;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Gender getSex() {
		return sex;
	}
	public void setSex(Gender sex) {
		this.sex = sex;
	}
	public Temper getCha() {
		return cha;
	}
	public void setCha(Temper cha) {
		this.cha = cha;
	}
	
	
	
}


enum Gender{
	MAN("man"){

		@Override
		public void run() {
			System.out.println("what a man");			
		}},WOMEN("woman") {
			@Override
			public void run() {
				System.out.println("what a women");				
			}
		};
	
	private String str;
	private Gender(String str)
	{
		this.str=str;
	}
	
	public String getSex()
	{
		return str;
	}
	
	public abstract void run();
}

class Temper{
	private String disp;
	public static Temper STABLE = new Temper("STABLE");
	public static Temper BRAVE = new Temper("BRAVE");
	
	private Temper(String disp){
		this.disp=disp;
		}

	@Override
	public String toString() {
		return disp;
	}	
}

enum Season
{
	Winter,Autumn,Spring,Summer;
}


