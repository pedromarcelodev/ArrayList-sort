package javax.util.arraylist;

import java.util.ArrayList;

import javax.util.ArrayListInterface;

/**
 * 
 * @author Pedro Marcelo de Sá Alves
 *
 */
public final class ArrayListDouble extends ArrayList<Double> implements ArrayListInterface<Double>{

	private static final long serialVersionUID = 4335167440133121274L;
	private transient Double[] elements;
	
	public ArrayListDouble() {
		super();
	}
	
	
	public boolean add(Double e) {
		super.add(e);
		elements = getArray();
		return true;
	}
	
	public Double get(int index) {
		return elements[index];
	}
	
	public int size(){
		return super.size();
	}

	@Override
	public void orderAsc() {
		quickSortAsc(elements, 0, elements.length - 1);
	}

	@Override
	public void orderDesc() {
		quickSortDesc(elements, 0, elements.length - 1);
	}
	
	private void quickSortAsc(Double[] vetor, int p, int r){
		if (p < r) {
			int q = partitionAsc(vetor, p, r);
			quickSortAsc(vetor, p, q - 1);
			quickSortAsc(vetor, q + 1, r);
		}
	}
	
	private int partitionAsc(Double[] vetor, int p, int r){
		double x = vetor[r];
		double aux;
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
	
	private void quickSortDesc(Double[] vetor, int p, int r){
		if (p < r) {
			int q = partitionDesc(vetor, p, r);
			quickSortDesc(vetor, p, q - 1);
			quickSortDesc(vetor, q + 1, r);
		}
	}
	
	private int partitionDesc(Double[] vetor, int p, int r){
		double x = vetor[r];
		double aux;
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
	

	public Double[] getArray(){
		Object[] obj = super.toArray();
		Double[] doub = new Double[obj.length];
		
		for (int i = 0; i < doub.length; i++) {
			doub[i] = Double.parseDouble(String.valueOf(obj[i]));
		}
		return doub;
	}
	
}
