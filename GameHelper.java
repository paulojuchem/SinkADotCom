import java.io.*;

class GameHelper {
	
	public int getUserInput(String lbl){

		String inputLine = null;
		System.out.println(lbl+" ");

		try {

			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			inputLine = bf.readLine();
			
			if(inputLine.length() != 0){

				try{

					return Integer.parseInt(inputLine);

				} catch (Exception e){

					System.out.println("Falha ao converter dado para inteiro");

				}
				

			}

		} catch(IOException e) {

			System.out.println("Algum pane ao ler o que voce escreveu");

		}

		return 0;

	}

}