class Application {

	private DotComField dotComField[][];

	private boolean oppenedFields[][];

	private boolean gameOver;

	private GameHelper gh;

	public static void main(String args[]){

		Application app = new Application();

	}

	public Application(){

		this.gameOver = false;

		this.gh = new GameHelper();

		this.dotComField = new DotComField[7][7];
		
		this.oppenedFields = new boolean[7][7];

		for(int i = 0; i < 7; i++){

			for(int j = 0; j < 7; j++){

				this.dotComField[i][j]=null;
				this.oppenedFields[i][j]=false;

			}

		}

		//TODO: make this dinamic
		DotCom d1 = new DotCom("apple.com");
		DotCom d2 = new DotCom("imasters.com.br");
		DotCom d3 = new DotCom("baixeturbo.org");

		this.dotComField[0][2] = new DotComField(d1);
		this.dotComField[0][3] = new DotComField(d1);
		this.dotComField[0][4] = new DotComField(d1);

		this.dotComField[4][4] = new DotComField(d2);
		this.dotComField[4][5] = new DotComField(d2);
		this.dotComField[4][6] = new DotComField(d2);

		this.dotComField[1][3] = new DotComField(d3);
		this.dotComField[2][3] = new DotComField(d3);
		this.dotComField[3][3] = new DotComField(d3);

		String InputLine;

		while(!gameOver){
			int x = -1;
			int y = -1;
			
			while((x < 0 || y < 0) && (x < 8 || y < 8)){

				y = this.getCharPos(this.gh.getUserInput("Insire um palpite (A-G)"));
				x = Integer.parseInt(this.gh.getUserInput("Insire um palpite para o eixo X"))-1;

			}

			if(this.dotComField[x][y]!=null){

				if(this.dotComField[x][y].getStatus()){

					System.out.println("Este campo ja estava aberto!");

				} else {

					this.dotComField[x][y].open();
					System.out.println("Voce acertou "+this.dotComField[x][y].getDotCom().getName());

				}

			} else {

				if(this.oppenedFields[x][y]){

					System.out.println("Este campo ja estava aberto!");

				} else{

					this.oppenedFields[x][y] = true;

				}

			}

			this.printField();

		}

	}

	public int getCharPos(String pos){

		if(pos.compareTo("A") == 0 || pos.compareTo("a") ==0){

			return 0;

		} else if(pos.compareTo("B") == 0 || pos.compareTo("b") == 0){

			return 1;

		} else if(pos.compareTo("C") ==0 || pos.compareTo("c") ==0){

			return 2;

		} else if(pos.compareTo("D") ==0 || pos.compareTo("d") ==0){

			return 3;

		} else if(pos.compareTo("E") ==0 || pos.compareTo("e") ==0){

			return 4;

		} else if(pos.compareTo("F") ==0 || pos.compareTo("f") ==0){

			return 5;

		} else if(pos.compareTo("G") ==0 || pos.compareTo("g") ==0){

			return 6;

		} else {

			return 0;

		}

	}

	public void printField(){

		System.out.println("|  *  |  A  |  B  |  C  |  D  |  E  |  F  |  G  |");

		String lbl = "";

		for(int i = 0; i < 7; i++){

			

				lbl = "|  "+(i+1)+"  |";

			

			for(int j = 0; j < 7; j++){

				if(this.dotComField[i][j]!=null){

					if(this.dotComField[i][j].getStatus()){

						lbl+="  X  |";

					} else {

						lbl+="  -  |";

					}

				} else {

					if(this.oppenedFields[i][j]){

						lbl+="     |";

					} else {

						lbl+="  -  |";

					}

				}

			}

			System.out.println(lbl);

		}

	}

}