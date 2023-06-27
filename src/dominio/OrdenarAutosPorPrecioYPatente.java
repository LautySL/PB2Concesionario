package dominio;

import java.util.Comparator;

public class OrdenarAutosPorPrecioYPatente implements Comparator <Coche>{

	@Override
	public int compare(Coche coche1, Coche coche2) {
		if(coche1.getPrecio().compareTo(coche2.getPrecio()) == 0) {
			return coche1.getPatente().compareTo(coche2.getPatente());
		}
		return coche1.getPrecio().compareTo(coche2.getPrecio());
	}

}
