package dominio;

import java.util.Comparator;

public class OrdenarAutosPorPrecioYPatente implements Comparator<Coche>{

	@Override
	public int compare(Coche o1, Coche o2) {
		if(o1.getPrecio().compareTo(o2.getPrecio()) == 0) {
			return o1.getPatente().compareTo(o2.getPatente());
		}
		return o1.getPrecio().compareTo(o2.getPrecio());
	}

}
