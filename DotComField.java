
class DotComField {
	
	private DotCom dt;
	private boolean status;

	public DotCom getDotCom(){

		return this.dt;

	}

	public DotComField(DotCom dt){

		this.dt = dt;

	}

	public void open(){

		this.status = true;

	}

	public boolean getStatus(){

		return this.status;

	}

}