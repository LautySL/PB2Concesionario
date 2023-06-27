package dominio;

import java.util.Comparator;

public class OrdenarAutosPorMarcaYModelo implements Comparator <Coche> {

	@Override
	public int compare(Coche coche1, Coche coche2) {
		if(coche1.getMarca().compareTo(coche2.getMarca()) == 0) {
			return coche1.getModelo().compareTo(coche2.getModelo());
		}
		return coche1.getMarca().compareTo(coche2.getMarca());
	}
	

}
