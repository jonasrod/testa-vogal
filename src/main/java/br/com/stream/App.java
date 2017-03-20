package br.com.stream;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc = new Scanner(System.in);
    	try {
    		System.out.println("Digite uma String: ");
    		
    		Stream stream = new StreamImpl();
    		stream.setInput(sc.nextLine());
    		
    		char vogal = App.firstChar(stream);
    		
    		System.out.println("O primeiro caracter que não se repete é: " + vogal);
    		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
    }
    
    /**
     * Método que valida uma sequência de caracteres para identificar uma vogal que aparece após 
     * uma volgal e uma consoante e não se repita na sequência de caracteres
     * @param input
     * @return {@link String} caractere selecionado
     */
    public static char firstChar(Stream stream) {
    	String consoantes = "bcdfghjklmnpqrstvxwyz"; // relação de consoantes
		String vogais = "aeiou";// relação de vogais
		
		/*
		 * Map utilizado para controlar quantas incidência uma mesma vogal aparece na sequência de caracteres.
		 * Utilizando como chava o cha a ser validado e o valor um inteiro para acumlar as repetições.
		 */
		Map<String, Integer> mapVogais = new LinkedHashMap<String, Integer>();
		
		while (stream.hasNext()) {
			Character charr = new Character(stream.getNext());
			
			boolean isVogal = vogais.indexOf(charr.toString().toLowerCase()) != -1;
			
			if (isVogal) {
				Integer quantity = null;
				if ((quantity = mapVogais.get(charr.toString().toLowerCase())) == null) {
					mapVogais.put(charr.toString().toLowerCase(), new Integer(1));
				} else {
					mapVogais.put(charr.toString().toLowerCase(), new Integer(quantity + 1));
					continue; // pula o restante da validação pois esta se repetindo
				}
			} 
			
			// testa se é uma vogal prescedida por uma consoante e uma vogal
			if (isVogal && (stream.getPrevious() != 0 && consoantes.indexOf(String.valueOf(stream.getPrevious()).toLowerCase()) != -1)
					&& (stream.getPreviousPrevious() != 0 && vogais.indexOf(String.valueOf(stream.getPreviousPrevious()).toLowerCase()) != -1)) {
				return charr.charValue();
			}
		}
		
    	return 0;
    }
}
