import java.util.Scanner;

public class Main {
	
	//1°método
	public static void main(String[] args) {
		int nAlunos = 0;
		float notas1[]= null, notas2[] = null;
		int rms[] = null;
		Object [] infoAlunos = entradaDados(nAlunos, rms, notas1, notas2);
		rms = (int[]) infoAlunos[1];
		notas1 =(float[]) infoAlunos[2];
		notas2 =(float[]) infoAlunos[3];
		nAlunos= (int) infoAlunos[0];
		float[] medias = calculaMedias(nAlunos,notas1, notas2);
		geraListaAprovados(nAlunos, rms, medias);

	}
	//2°método
	public static Object[] entradaDados(int nAlunos,int rms[],float notas1[],float notas2[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite a quantidade de alunos: ");
		nAlunos = sc.nextInt();
		if(nAlunos>0 && nAlunos<=30){
			rms = new int[nAlunos];
			notas1 = new float[nAlunos];
			notas2 = new float[nAlunos];			
		}else{
			nAlunos=0;
			System.out.println("Número de alunos maior do que 30 ou menor do que 0!");
		}

		for (int i = 0; i < nAlunos; i++) {
			System.out.println("Digite o rm do " + (i + 1) + "° aluno");
			rms[i] = sc.nextInt();
			if(rms[i]<0){
				System.out.println("RM negativo!!!!!!");
				nAlunos =0;
				break;
			}
			System.out.println("Digite a primeira nota do " + (i + 1) + "° aluno");
			notas1[i] = sc.nextFloat();
			System.out.println("Digite a segunda nota do " + (i + 1) + "° aluno");
			notas2[i] = sc.nextFloat();
		}
		sc.close();
		
		Object[] infoAlunos = new Object[4];
		infoAlunos[0] = nAlunos;
		infoAlunos[1] = rms;
		infoAlunos[2] = notas1;
		infoAlunos[3] = notas2;
		
		
		return infoAlunos;
	}
	
	//3°método
	public static float[] calculaMedias(int nAlunos, float[] notas1, float[] notas2) {
		
		float medias[] = new float[nAlunos];
		for (int i = 0; i < nAlunos; i++) {
			if ((notas1[i] <= 10 && notas1[i] >= 0) && (notas2[i] <= 10 && notas2[i] >= 0)) {
				medias[i] = (notas1[i] + notas2[i]) / 2;
			} else {
				System.out.println("Essa média foi calculada com nota(s) inválidas!");
				break;
			}
		}
		return medias;
	}
	
	//4°método
	public static void geraListaAprovados(int nAlunos,int rms[],float medias[]) {
		
		int rmsAprovados[] = new int [nAlunos];
		for (int i=0; i<nAlunos ;i++) {
			System.out.println("\n---------------------------------RM E NOTA ALUNO---------------------------------------------");
			System.out.println("RM: " + rms[i] + "\nMédia:" + medias[i]);
			if(medias[i]>= 6){
				rmsAprovados[i] = rms[i];
				System.out.println("Aluno aprovado!!!");
			}
			else{
				System.out.println("Aluno reprovado!!!");
			}
		}

	}

}
