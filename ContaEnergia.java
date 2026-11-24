/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aluno
 */
public class ContaEnergia {
    
    public static final double tarifa = 0.92;
    public static final double perc = 0.025;
    public static final double aliquotaIcms = 0.22;
    public static final int limite = 90;
    
    private String mesRef;
    private double leituraAnterior;
    private double leituraAtual;

    public String getMesRef() {
        return mesRef;
    }

    public double getLeituraAnterior() {
        return leituraAnterior;
    }

    public double getLeituraAtual() {
        return leituraAtual;
    }

    public ContaEnergia(String mesRef, double leituraAnterior, double leituraAtual) {
        this.mesRef = mesRef;
        this.leituraAnterior = leituraAnterior;
        this.leituraAtual = leituraAtual;
    }
    
    public double calcularConsumo(){
        return leituraAtual - leituraAnterior;
    }
    
    public double calcularValorConsumo(){
        return calcularConsumo() * tarifa;
    }
    
    public double calcularValorTotal(){
        double consumo = calcularConsumo();
        double valorConsumo = calcularValorConsumo();
        
        if(consumo < limite){
            return valorConsumo;
        }
        
        double iluminacao = valorConsumo * perc;
        double subtotal = valorConsumo + iluminacao;
        double icms = subtotal * aliquotaIcms;
        double valorTotal = subtotal + icms;
        
        return valorTotal;
    }
    
    public ContaEnergia compararCom(ContaEnergia comp){
        if(this.calcularValorTotal() >= comp.calcularValorTotal()){
            return this;
        }else{
            return comp;
        }
    }
    
    public String resumo(){
        return "Mês: " + mesRef
                + "; Consumo: " + calcularConsumo() + " kWh"
                + "; Total: R$ "
                + String.format("%.2f", calcularValorTotal());
    }
}
