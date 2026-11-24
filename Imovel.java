/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aluno
 */

import java.util.ArrayList;
import java.util.List;

public class Imovel {

    private int codCliente;
    private List<ContaEnergia> contas;

    public int getCodCliente() {
        return codCliente;
    }

    public List<ContaEnergia> getContas() {
        return contas;
    }

    public Imovel(int codCliente) {
        this.codCliente = codCliente;
        this.contas = new ArrayList<>();
    }
    
    public void adicConta(ContaEnergia conta){
        
        if(contas.size() < 12){
            contas.add(conta);
        }else{
            System.out.println("Limite de contas atingido.");
        }
    }
    
    public double calcularMedia(){
        
        if(contas.isEmpty()){
            return 0;
        }
        
        double soma = 0;
        
        for(ContaEnergia conta : contas){
            soma += conta.calcularValorTotal();
        }
        
        return soma / contas.size();
    }
    
    public ContaEnergia maisCara(){
        
        if(contas.isEmpty()){
            return null;
        }
        
        ContaEnergia maisCara = contas.get(0);
        
        for(ContaEnergia conta : contas){
            if(conta.calcularValorTotal() > maisCara.calcularValorTotal()){
                maisCara = conta;
            }
        }
        
        return maisCara;
    }
    
    public String relatorioAcima(){
        double media = calcularMedia();
        
        String relatorio = "Contas acima da média\n";
        relatorio += "Imóvel: " + codCliente + "\n";
        relatorio += "Média: R$" + media + "\n\n";
        
        for(ContaEnergia conta : contas){
            
            if(conta.calcularValorTotal() > media){
                relatorio += conta.resumo() + "\n";
            }
        }
        return relatorio;
    }
    
    public String resumoAnual(){
        
        String resumo = "Resumo anual\n";
        resumo += "Imóvel "+ codCliente + "\n\n";
        
        for(ContaEnergia conta : contas){
            resumo += conta.resumo() + "\n";
        }
        
        return resumo;
    }
}
