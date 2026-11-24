/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aluno
 */
public class App {
    public static void main(String[] args){
        
        Imovel imovel = new Imovel(1);
        
        imovel.adicConta(new ContaEnergia("01/2026", 900, 1000));
        imovel.adicConta(new ContaEnergia("02/2026", 900, 1000));
        imovel.adicConta(new ContaEnergia("03/2026", 200, 300));
        imovel.adicConta(new ContaEnergia("04/2026", 900, 1000));
        imovel.adicConta(new ContaEnergia("05/2026", 870, 1000));
        imovel.adicConta(new ContaEnergia("06/2026", 1780, 2000));
        imovel.adicConta(new ContaEnergia("07/2026", 200, 300));
        imovel.adicConta(new ContaEnergia("08/2026", 400, 508));
        imovel.adicConta(new ContaEnergia("09/2026", 291, 300));
        imovel.adicConta(new ContaEnergia("10/2026", 400, 500));
        imovel.adicConta(new ContaEnergia("11/2026", 248, 375));
        imovel.adicConta(new ContaEnergia("12/2026", 2400, 2500));
        
        System.out.println("Média: R$ " + String.format("%.2f", imovel.calcularMedia()));
        
        ContaEnergia maisCara = imovel.maisCara();
        
        if(maisCara != null){
            System.out.println("\nConta mais cara: "+maisCara.resumo());
        }
        
        System.out.println("\n"+imovel.relatorioAcima());
        System.out.println("\n"+imovel.resumoAnual());
        
        ContaEnergia marco = imovel.getContas().get(2);
        ContaEnergia abril = imovel.getContas().get(3);
        
        ContaEnergia maior = marco.compararCom(abril);
        
        System.out.println("\nConta mais cara entre março e abril:");
        System.out.println(maior.resumo());
    }
}
