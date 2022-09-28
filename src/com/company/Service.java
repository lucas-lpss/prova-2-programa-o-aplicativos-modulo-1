package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Service {
    public static List<Clientes> listClient = new ArrayList<>();

    void messagemWhile(){
        System.out.println("digite 0 se deseja encerrar");
        System.out.println("\n");
        System.out.println("digite 1 se deseja Adiciona uma CLiente");
        System.out.println("\n");
        System.out.println("digite 2 se deseja Remover um Cliente");
        System.out.println("\n");
        System.out.println("digite 3 se deseja Atualizar um cliente");
        System.out.println("\n");
        System.out.println("Digite 4 se desdeja mostrar Lista de Clientes");
        System.out.println("\n");
    }

    void metodoMenssagem() {
        System.out.println("######################################");
        System.out.println("\n");
        System.out.println("seja Bem vindo ao mercado do beco");
        System.out.println("\n");
        System.out.println("#######################################");
    }
    void metodoLogic(){
        metodoMenssagem();

        LOOK:
        while(true){
            messagemWhile();
            Scanner decisaoW = new Scanner(System.in);
            int opcaoEscolhida = decisaoW.nextInt();
            if(opcaoEscolhida == 0){
                System.out.println("Programa Executado com sucesso");
                System.out.println("\n");
                System.out.println("Programa Finalizado");
                break LOOK;
            }
            if(opcaoEscolhida == 1){
                metodoAdd();
                continue LOOK;
            }
            if(opcaoEscolhida == 2){
                metodoRemove();
                continue LOOK;
            }
            if(opcaoEscolhida == 3){
                metodoAtualiza();
                continue LOOK;
            }
            if(opcaoEscolhida == 4){
                metodoMostrandoList();
                continue LOOK;
            }

        }
    }
    void metodoMostrandoList(){
        System.out.println("a sua Lista");
        for(Clientes x : listClient){
            System.out.println("o nome do seu Cliente é : "+x.nomeCliente+ "    e seu cpf é: "+x.cpf);
        }
    }

    void metodoAtualiza(){
        Clientes cli = new Clientes();
        System.out.println("insira o cpf do Cliente para Atualizar os dados");
        Scanner cpfC = new Scanner(System.in);
        String cadastroDePessoaFisica = cpfC.nextLine();
        for (int l=0; l>= listClient.size();l++){
            if (cadastroDePessoaFisica.equals(((Clientes)listClient.get(l)).nomeCliente)){
                System.out.println("Digite o novo nome");
                Scanner newName = new Scanner(System.in);
                String newNome = newName.nextLine();
                ((Clientes)listClient.get(l)).nomeCliente=newNome;
                System.out.println("digite o seu cpf agora");
                Scanner newCpf = new Scanner(System.in);
                String cpfNew = newCpf.nextLine();
                ((Clientes)listClient.get(l)).cpf=cpfNew;
                break;
            }
            else{
                System.out.println("Cpf nao encontrado");
            }
        }


    }


    void metodoRemove(){
        Clientes cli = new Clientes();
        System.out.println("Tem certeza que deseja remover uma cliente");
        System.out.println("\n");
        System.out.println("digite o cpf do seu cliente");
        Scanner pv = new Scanner(System.in);
        String ccp = pv.nextLine();
        for (int l=0;l<=listClient.size();l++) {
            if (ccp.equals(((Clientes) listClient.get(l)).cpf)) {
                listClient.remove(l);

                System.out.println("Cliente Removido");
                break;
            }
            else {
                System.out.println("nao Existe cliente");
            }
        }
            for(Clientes x : listClient){
                System.out.println("lista nome"+x.nomeCliente);
            }





    }

    void metodoAdd() {

        Clientes cli = new Clientes();
        Produtos pdtC = new Produtos();
        cli.id=hashCode();
        System.out.println("Digite o seu nome");
        Scanner nM = new Scanner(System.in);
        cli.nomeCliente = nM.nextLine();
        System.out.println("digite o seu cpf");
        Scanner cP = new Scanner(System.in);
        cli.cpf = cP.nextLine();
        System.out.println("Digite quantos produtos deseja comprar");
        Scanner qC = new Scanner(System.in);
        int qqT = qC.nextInt();
        int l = 1;
        for ( l=1 ; l <= qqT; l++) {

                System.out.println("digite o nome dos produtos adquiridos");
                Scanner pL = new Scanner(System.in);
                pdtC.nomeProduto = pL.nextLine();
                 System.out.println("digite o Preço do produto adquirido");
                Scanner pV = new Scanner(System.in);
                pdtC.preçoIndividual = pV.nextDouble();
                System.out.println("Digite a quantidade que gostaria");
                Scanner qT = new Scanner(System.in);
                pdtC.quantidadeProduto = qT.nextInt();
                pdtC.id = hashCode();
                pdtC.precoTotal = (pdtC.quantidadeProduto * pdtC.preçoIndividual);
                System.out.println("o total é: " + pdtC.precoTotal);
                cli.listProd.add(pdtC);
            }
        for(Produtos p : cli.listProd) {
           cli.totalCompra += p.precoTotal;
        }

            if(cli.totalCompra>100){
                System.out.println("voce tem 10% de Desconto");
                double totalDesc = cli.totalCompra*(-0.10);
                double totalLiq = totalDesc+ cli.totalCompra;
                System.out.println("o total da compra é: "+totalLiq);
            }else{
                System.out.println("voce tem desconto de 1%");
                double totalDesc = cli.totalCompra*(-0.01);
                double totalLiq = totalDesc+ cli.totalCompra;
                System.out.println("seu total de produto é: "+totalLiq);
            }
        listClient.add(cli);
    }
}
