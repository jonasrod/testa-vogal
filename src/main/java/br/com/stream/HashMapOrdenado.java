package br.com.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Classe que sobreescreve o método iterator de HashMap para ordenar os valor de uma Map.
 * @author Jonas R. de Oliveira
 *
 * @param <K>
 * @param <V>
 */
public class HashMapOrdenado<K, V> extends HashMap<K, V> {
	private static final long serialVersionUID = -4973610219136258091L;
	
	/**
	 * Iterator utilizado para ordenar os valores de Map
	 * @return
	 */
	public Iterator<Object> iterator() {
		Collection<V> coll = this.values();// retorna os valores do Map para uma collection
		Object[] array = coll.toArray();// converte a collection para um array
		Arrays.sort(array);// ordena o array
		return Arrays.asList(array).iterator();
	}
}
