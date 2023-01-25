/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.mavenprojectprodutos;

import entities.Produto;
import entities.ProdutoImportado;
import entities.ProdutoUsado;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author leandro
 */
public class MavenprojectProdutos {

    public static void main(String[] args) throws ParseException {
        Produto produtoNormal = new Produto("NoteBook", 1100.00);
        System.out.println(produtoNormal.etiquetaPreco());
        Produto produtoImportado = new ProdutoImportado(20.00, "tablet", 260.00);
        System.out.println(produtoImportado.etiquetaPreco());
        SimpleDateFormat spd = new SimpleDateFormat("dd/MM/yyyy");
        Date dataFabricacao = spd.parse("15/03/2019");
        ProdutoUsado produtoUsado = new ProdutoUsado(dataFabricacao, "Iphone", 400.00);
        System.out.println(produtoUsado.etiquetaPreco());
    }
}
