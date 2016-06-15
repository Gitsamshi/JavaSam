package crazyjava;

public class DecoMode {

	public static void main(String[] args) {
		Sonn son = new Sonn();
		Mother mother = new Mother(son);
		Father father = new Father(mother);
		father.run();
	}

}

interface work
{
	void run();
}
interface play extends work
{
	void playing();
}

class Sonn implements work
{
	work worker;

	@Override
	public void run() {
		System.out.println("drawing");
	}
	
}
class Mother implements play
{
	work worker;
	public Mother(work worker)
	{
		this.worker = worker;
	}
	@Override
	public void run() {
		worker.run();
		System.out.println("melting");
	}
	@Override
	public void playing() {
		// TODO Auto-generated method stub
		
	}
}
class Father implements work
{
	work worker;

	@Override
	public void run() {
		worker.run();
		System.out.println("decorating");		
	}

	public Father(work worker) {
		this.worker = worker;
	}
}