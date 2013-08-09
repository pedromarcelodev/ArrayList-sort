package javax.util.arraylist;

import java.util.ArrayList;

import javax.util.ArrayListInterface;

/**
 * A classe ArrayListInteger é uma subclasse de ArrayList<Integer> e ela
 * implementa métodos de ordenação para a instância de ArrayListInteger.
 * Os métodos utilizam quick sort para ordenação e podem ser ordenados
 * tanto de forma ascendente como de forma descendente.
 * 
 * @author Pedro Marcelo de Sá Alves
 * @since August 9, 2013
 * @see ArrayList
 */
public final class ArrayListInteger extends ArrayList<Integer> implements
		ArrayListInterface<Integer> {

	private static final long serialVersionUID = -2842976440641442488L;
	private transient Integer[] elements;

	public ArrayListInteger() {
		super();
	}
	
	@Override
	public int size(){
		return super.size();
	}

	@Override
	public boolean add(Integer e) {
		super.add(e);
		elements = getArray();
		return true;
	}

	@Override
	public Integer get(int index) {
		return elements[index];
	}

	@Override
	public void orderAsc() {
		quicksortAsc(elements, 0, elements.length - 1);
	}

	@Override
	public void orderDesc() {
		quicksortDesc(elements, 0, elements.length - 1);
	}

	private void quicksortAsc(Integer[] vetor, int p, int r) {
		if (p < r) {
			int q = partitionAsc(vetor, p, r);
			quicksortAsc(vetor, p, q - 1);
			quicksortAsc(vetor, q + 1, r);
		}
	}

	private int partitionAsc(Integer[] vetor, int p, int r) {
		int x = vetor[r];
		int aux;
		int i = p - 1;
		for (int j = p; j <= r - 1; j++) {
			if (vetor[j] <= x) {
				i++;
				aux = vetor[i];
				vetor[i] = vetor[j];
				vetor[j] = aux;
			}
		}
		aux = vetor[i + 1];
		vetor[i + 1] = vetor[r];
		vetor[r] = aux;

		return i + 1;
	}

	private void quicksortDesc(Integer[] vetor, int p, int r) {
		if (p < r) {
			int q = partitionDesc(vetor, p, r);
			quicksortDesc(vetor, p, q - 1);
			quicksortDesc(vetor, q + 1, r);
		}
	}

	private int partitionDesc(Integer[] vetor, int p, int r) {
		Integer x = vetor[r];
		Integer aux;
		int i = p - 1;
		for (int j = p; j <= r - 1; j++) {
			if (vetor[j] >= x) {
				i++;
				aux = vetor[i];
				vetor[i] = vetor[j];
				vetor[j] = aux;
			}
		}
		aux = vetor[i + 1];
		vetor[i + 1] = vetor[r];
		vetor[r] = aux;

		return i + 1;
	}

	@Override
	public Integer[] getArray() {
		Object[] obj = super.toArray();
		Integer[] in = new Integer[obj.length];
		
		for (int i = 0; i < in.length; i++) {
			in[i] = Integer.parseInt(String.valueOf(obj[i]));
		}
		return in;
	}


}
