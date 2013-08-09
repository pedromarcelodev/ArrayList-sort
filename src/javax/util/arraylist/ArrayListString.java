package javax.util.arraylist;

import java.util.ArrayList;
import javax.util.ArrayListInterface;

/**
 * @author Pedro Marcelo de Sá Alves
 * @since August 7, 2013
 */

public final class ArrayListString extends ArrayList<String> implements ArrayListInterface<String> {

	private static final long serialVersionUID = -7708170309614457628L;
	private transient String[] elements;

	public ArrayListString() {
		super();
	}

	@Override
	public boolean add(String str) {
		super.add(str);
		elements = getArray();
		return true;
	}

	@Override
	public String get(int index) {
		return elements[index];
	}

	@Override
	public String set(int index, String element) {
		return super.set(index, element);
	}

	@Override
	public String remove(int index) {
		return super.remove(index);
	}

	@Override
	public int size() {
		return super.size();
	}

	public void orderAsc() {
		for (int i = 0; i < elements.length; i++) {
			for (int j = 0; j < elements.length; j++) {
				recurAsc(elements, 0, i, j);
			}
		}
	}

	public void orderDesc() {
		for (int i = 0; i < elements.length; i++) {
			for (int j = 0; j < elements.length; j++) {
				recurDesc(elements, 0, i, j);
			}
		}
	}
	
	private void recurDesc(String[] vetor, int charAt, int i, int j) {
		String aux = "";
		//quando forem números
		if (isNumber(vetor[i]) && isNumber(vetor[j])) {
			if (vetor[i].length() == vetor[j].length()) {
				int auxi = parse(vetor[i]);
				int auxj = parse(vetor[j]);
				if (auxi > auxj) {
					aux = vetor[i];
					vetor[i] = vetor[j];
					vetor[j] = aux;
					return;
				} else {
					return;
				}
			} else {
				if (vetor[i].length() > vetor[j].length()) {
					aux = vetor[i];
					vetor[i] = vetor[j];
					vetor[j] = aux;
					return;
				} else {
					return;
				}
			}
		}
		//quando forem acentuados
		if (isMarked(vetor[i].charAt(charAt)) == true) {
			if (isMarked(vetor[j].charAt(charAt)) == false
					|| isSameLetterNotMarked(vetor[i].charAt(charAt),
							vetor[j].charAt(charAt)) == true) {
				aux = vetor[i];
				vetor[i] = vetor[j];
				vetor[j] = aux;
			}
		}
		//quando forem maiúsculas
		if (isUpperCase(String.valueOf(vetor[j].charAt(charAt))) == true
				&& isUpperCase(String.valueOf(vetor[i].charAt(charAt))) == false) {
			aux = vetor[i];
			vetor[i] = vetor[j];
			vetor[j] = aux;
		}
		//compara letra por letra
		if (charAt == vetor[i].length() - 1 || charAt == vetor[j].length() - 1) {
			if (takeAccentuation(vetor[i].toUpperCase().charAt(charAt)) == takeAccentuation(vetor[j]
					.toUpperCase().charAt(charAt))) {
				if (vetor[i].length() == vetor[j].length()) {
					return;
				} else {
					if (vetor[i].length() > vetor[j].length()) {
						aux = vetor[i];
						vetor[i] = vetor[j];
						vetor[j] = aux;
					} else {
						return;
					}
				}
			} else {
				if (takeAccentuation(vetor[i].toUpperCase().charAt(charAt)) >= takeAccentuation(vetor[j]
						.toUpperCase().charAt(charAt))) {
					aux = vetor[i];
					vetor[i] = vetor[j];
					vetor[j] = aux;
					return;
				}
			}
		} else {
			if (takeAccentuation(vetor[i].toUpperCase().charAt(charAt)) != takeAccentuation(vetor[j]
					.toUpperCase().charAt(charAt))) {
				if (takeAccentuation(vetor[i].toUpperCase().charAt(charAt)) >= takeAccentuation(vetor[j]
						.toUpperCase().charAt(charAt))) {
					aux = vetor[i];
					vetor[i] = vetor[j];
					vetor[j] = aux;
					return;
				}
			} else {
				recurDesc(vetor, charAt + 1, i, j);
			}
		}
		return;
	}

	private void recurAsc(String[] vetor, int charAt, int i, int j) {
		String aux = "";
		//quando forem números
		if (isNumber(vetor[i]) && isNumber(vetor[j])) {
			if (vetor[i].length() == vetor[j].length()) {
				int auxi = parse(vetor[i]);
				int auxj = parse(vetor[j]);
				if (auxi < auxj) {
					aux = vetor[i];
					vetor[i] = vetor[j];
					vetor[j] = aux;
					return;
				} else {
					return;
				}
			} else {
				if (vetor[i].length() < vetor[j].length()) {
					aux = vetor[i];
					vetor[i] = vetor[j];
					vetor[j] = aux;
					return;
				} else {
					return;
				}
			}
		}
		//quando forem acentuadas
		if (isMarked(vetor[j].charAt(charAt)) == true) {
			if (isMarked(vetor[i].charAt(charAt)) == false
					|| isSameLetterNotMarked(vetor[i].charAt(charAt),
							vetor[j].charAt(charAt)) == true) {
				aux = vetor[i];
				vetor[i] = vetor[j];
				vetor[j] = aux;
			}
		}
		//quando forem maiúsculas
		if (isUpperCase(String.valueOf(vetor[i].charAt(charAt))) == true
				&& isUpperCase(String.valueOf(vetor[j].charAt(charAt))) == false) {
			aux = vetor[i];
			vetor[i] = vetor[j];
			vetor[j] = aux;
		}
		//compara letra por letra
		if (charAt == vetor[i].length() - 1 || charAt == vetor[j].length() - 1) {
			if (takeAccentuation(vetor[i].toUpperCase().charAt(charAt)) == takeAccentuation(vetor[j]
					.toUpperCase().charAt(charAt))) {
				if (vetor[i].length() == vetor[j].length()) {
					return;
				} else {
					if (vetor[i].length() < vetor[j].length()) {
						aux = vetor[i];
						vetor[i] = vetor[j];
						vetor[j] = aux;
					} else {
						return;
					}
				}
			} else {
				if (takeAccentuation(vetor[i].toUpperCase().charAt(charAt)) <= takeAccentuation(vetor[j]
						.toUpperCase().charAt(charAt))) {
					aux = vetor[i];
					vetor[i] = vetor[j];
					vetor[j] = aux;
					return;
				}
			}
		} else {
			if (takeAccentuation(vetor[i].toUpperCase().charAt(charAt)) != takeAccentuation(vetor[j]
					.toUpperCase().charAt(charAt))) {
				if (takeAccentuation(vetor[i].toUpperCase().charAt(charAt)) <= takeAccentuation(vetor[j]
						.toUpperCase().charAt(charAt))) {
					aux = vetor[i];
					vetor[i] = vetor[j];
					vetor[j] = aux;
					return;
				}
			} else {
				recurAsc(vetor, charAt + 1, i, j);
			}
		}
		return;
	}

	public String[] getArray() {
		Object obj[] = super.toArray();
		String str[] = new String[obj.length];

		for (int i = 0; i < str.length; i++) {
			str[i] = String.valueOf(obj[i]);
		}

		return str;
	}

	public char takeAccentuation(char c) {
		if (c >= 193 && c <= 196) {
			return 65;
		} else if (c >= 200 && c <= 203) {
			return 69;
		} else if (c >= 204 && c <= 207) {
			return 73;
		} else if (c >= 210 && c <= 210) {
			return 79;
		} else if (c >= 217 && c <= 220) {
			return 85;
		} else {
			return c;
		}
	}

	public boolean isMarked(char c) {
		if (c >= 97 && c <= 122) {
			return false;
		} else if (c >= 65 && c <= 90) {
			return false;
		} else {
			return true;
		}
	}

	private boolean isSameLetter(char arg0, char arg1) {
		if (arg0 == arg1) {
			return true;
		}
		return false;
	}

	private boolean isSameLetterNotMarked(char arg0, char arg1) {
		return isSameLetter(takeAccentuation(arg0), takeAccentuation(arg1));
	}

	public boolean isUpperCase(String arg0) {
		if (arg0.equals(arg0.toUpperCase())) {
			return true;
		}
		return false;
	}

	public boolean isNumber(String arg0) {
		try {
			Integer.parseInt(arg0);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
	
	private int parse(String arg){
		return Integer.parseInt(arg);
	}
}
