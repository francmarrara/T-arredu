package model;

import java.util.Comparator;

public class OrdinaProdottoPerVisibilità implements Comparator<ProdottoConImmagini> {

	
	@Override
	public int compare(ProdottoConImmagini p1, ProdottoConImmagini p2) {
		if (p1.getNumeroVisite() < p2.getNumeroVisite())
			return 1;
		else if (p1.getNumeroVisite() > p2.getNumeroVisite())
			return -1;
		else if (p1.getNumeroVisite() == p2.getNumeroVisite()) {
			if (p1.getNomeProdotto().compareTo(p2.getNomeProdotto()) > 0)
				return 1;
			else if (p1.getNomeProdotto().compareTo(p2.getNomeProdotto()) < 0)
				return -1;
			else if (p1.getNomeProdotto().compareTo(p2.getNomeProdotto()) == 0)
				return 0;
		}

		return 0;
	}


}
