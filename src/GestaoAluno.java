import java.util.Scanner;

import javax.swing.JOptionPane;
 

public class GestaoAluno {
    public static final int MAX_SIZE = 50;

    private int indice;
    private final Aluno[] alunos = new Aluno[MAX_SIZE];

    private final Scanner input = new Scanner(System.in);

    public void criar(){
        System.out.println("Cadastro de novo aluno");
        if (indice < MAX_SIZE) {
            Aluno a = new Aluno();
            System.out.println("Digite o nome do aluno: ");
            a.setNome( input.nextLine() );
            System.out.println("Digite o RA do aluno: ");
            a.setRa( input.nextLine());
            System.out.println("Digite a data de nascimento: ");
            String strDate = input.nextLine();
            a.setNascimento(strDate);
            a.setId(indice);
            alunos[indice] = a;
            indice++;
        } else {
            System.out.println("Não a mais espaço na memoria para guardar aluno");
        }
    }

     public void atualizar() {
        System.out.println("Atualização de aluno");
        System.out.println("Informe o RA do aluno a ser atualizado");
        String ra = input.nextLine();
        int i = pesquisar(ra);
        if (i >= 0) {
            Aluno a = alunos[i];
            System.out.println("Digite o novo nome do aluno: ");
            a.setNome( input.nextLine() );
            System.out.println("Digite o novo RA do aluno: ");
            a.setRa( input.nextLine() );
            System.out.println("Digite a nova data de nascimento: ");
            String strDate = input.nextLine();
            a.setNascimento(strDate);
            a.setId(indice);
        }
    }
    public int pesquisar(String ra){
        for (int i = 0; i < MAX_SIZE; i++){
            Aluno a = alunos[i];
            if (a != null) {
                if (ra.equals(a.getRa())){
                    return i;
                }
            }
        }
        return -1;
    }

    public void excluir(){
        System.out.println("Exclusão de aluno");
        System.out.println("Informe o RA do aluno a ser excluido");
        String ra = input.nextLine();
        int i = pesquisar(ra);
        if (i >= 0){
            alunos[i] = null;
        }
    }

    public void exibir(){
        System.out.println("Exibir detalhes do aluno");
        System.out.println("Informe o RA do aluno a ser exibido");
        String ra = input.nextLine();
        int i = pesquisar(ra);
        if (i >= 0){
            Aluno a = alunos[i];
            System.out.println("ID: "+a.getId());
            System.out.println("RA: "+a.getRa());
            System.out.println("Nome: "+a.getNome());
            System.out.println("Nascimento: "+a.getNascimento());
        } else {
            System.out.println("Aluno não encontrado");
        }
    }

    public void listar(){
        System.out.println("Listagem de alunos");
        for(int i = 0; i < MAX_SIZE; i++){
            Aluno a = alunos[i];
            if(a != null){
                System.out.println(a);
            }
        }
    }

    public void menu() {
		int opc=0;
		while(opc!=9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Criar \\n 2 - Listar \\n 3 - Excluir \\n 4 - Atualizar \\n 5 - Exibir \\n 9 - Finaliza\""));
		    switch (opc) {
		    case 1: criar();
			    break;
		    case 2: listar();
			    break;
		    case 3: excluir();
			    break;
		    case 4: atualizar();
			    break;
		    case 5: exibir();
			    break;
		    case 9:JOptionPane.showMessageDialog(null,"FINALIZADO");
			    break;
		default:JOptionPane.showMessageDialog(null, "OPÇÃO INVALIDA");
		    }
		}
	}
    public static void main(String[] args){
        new GestaoAluno().menu();
    }

}


    

    

