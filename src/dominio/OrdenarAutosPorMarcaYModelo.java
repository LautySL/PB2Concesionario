package dominio;

import java.util.Comparator;

public class OrdenarAutosPorMarcaYModelo implements Comparator<Coche> {

	@Override
	public int compare(Coche o1, Coche o2) {
		if(o1.getMarca().compareTo(o2.getMarca()) == 0) {
			return o1.getModelo().compareTo(o2.getModelo());
		}
		return o1.getMarca().compareTo(o2.getMarca());
	}
	

}
